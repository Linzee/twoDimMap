package me.ienze.twoDimMap;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.lang.UnsupportedOperationException;

/**
 * Created by Ienze
 */
public class CombineMapLayer implements MapLayer<Float> {

    private List<MapLayer> layers = new ArrayList<MapLayer>();
    private CombineMode mode;

    public CombineMapLayer() {
        this(CombineMode.NORMAL);
    }

    public CombineMapLayer(CombineMode mode) {
        this.mode = mode;
    }

    @Override
    public Vec getSize() {
        int width = 0;
        int height = 0;
        for(MapLayer l : layers) {
            width = Math.max(width, l.getWidth());
            height = Math.max(height, l.getHeight());
        }
        return new Vec(width, height);
    }

    @Override
    public int getWidth() {
        return getSize().getX();
    }

    @Override
    public int getHeight() {
        return getSize().getY();
    }

    @Override
    public Float get(int x, int y) {

        if(layers.size() == 0) {
            throw new IllegalArgumentException("Combined layer requires at least one added layer");
        }

        switch (mode) {
            case NORMAL:
                for(MapLayer layer : layers) {
                    float value = general(layer.get(x, y));
                    if (value > 0) {
                        return value;
                    }
                }
                return 0.0f;
            case AVG:
                float avg = 0.0f;
                for(MapLayer layer : layers) {
                    avg += general(layer.get(x, y));
                }
                return avg / layers.size();
            case MIN:
                float min = -Float.MAX_VALUE;
                for(MapLayer layer : layers) {
                    min = Math.min(min, general(layer.get(x, y)) );
                }
                return min;
            case MAX:
                float max = Float.MAX_VALUE;
                for(MapLayer layer : layers) {
                    max = Math.min(max, general(layer.get(x, y)) );
                }
                return max;
            default:
                throw new IllegalArgumentException("Illegal combine mode");
        }
    }

    private float general(Object o) {
        if(o instanceof Float) {
            return (Float) o;
        }
        if(o instanceof Boolean) {
            return ((Boolean) o) ? 1.0f : 0.0f;
        }
        throw new UnsupportedOperationException("Unsupported layer type");
    }

    @Override
    public void set(int x, int y, Float value) {
        throw new UnsupportedOperationException("Modification not supported on combined layer");
    }

    @Override
    public Color getColor(int x, int y) {
        float value = get(x, y);
        return new Color(value, value, value);
    }

    @Override
    public void setColor(int x, int y, Color color) {
        throw new UnsupportedOperationException("Modification not supported on combined layer");
    }

    public void addLayer(MapLayer layer) {
        this.layers.add(layer);
    }

    public void removeLayer(MapLayer layer) {
        this.layers.remove(layer);
    }

    public enum CombineMode {
        NORMAL,
        AVG,
        MIN,
        MAX
    }
}

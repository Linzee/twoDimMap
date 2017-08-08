package me.ienze.twoDimMap;

import java.awt.Color;
import java.util.BitSet;

public class BooleanMapLayer implements MapLayer<Boolean> {

    private Vec size;
    private BitSet data;

    public BooleanMapLayer(int width, int height) {
        this(new Vec(width, height));
    }

    public BooleanMapLayer(Vec size) {
        this.size = size;
        this.data = new BitSet(size.x * size.y);
    }

    public Vec getSize() {
        return size;
    }

    @Override
    public int getWidth() {
        return size.x;
    }

    public void setWidth(int width) {
        this.size.x = width;
    }

    @Override
    public int getHeight() {
        return size.y;
    }

    public void setHeight(int height) {
        this.size.y = height;
    }

    public Boolean get(int x, int y) {
        return data.get(index(x, y));
    }

    private int index(int x, int y) {
        if (x < 0 || x >= size.x || y < 0 || y >= size.y) {
            throw new IllegalArgumentException("Position out of range");
        }
        return y * size.x + x;
    }

    public void set(int x, int y, Boolean value) {
        data.set(index(x, y), value);
    }

    @Override
    public Color getColor(int x, int y) {
        Boolean value = get(x, y);
        return value ? Color.WHITE : Color.BLACK;
    }

    @Override
    public void setColor(int x, int y, Color color) {
        set(x, y, color.equals(Color.WHITE));
    }
}

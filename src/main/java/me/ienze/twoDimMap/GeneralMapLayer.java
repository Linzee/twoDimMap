package me.ienze.twoDimMap;

import java.awt.Color;
import java.util.Arrays;

public class GeneralMapLayer extends ArrayMapLayer<Float> {

    public GeneralMapLayer(int width, int height) {
        this(new Vec(width, height));
    }

    public GeneralMapLayer(Vec size) {
        this.size = size;
        this.data = new Float[size.x][size.y];
        for (int i = 0; i < size.x; i++) {
            Arrays.fill(this.data[i], 0.0f);
        }
    }

    @Override
    public Color getColor(int x, int y) {
        float value = get(x, y);
        return new Color(value, value, value);
    }

    @Override
    public void setColor(int x, int y, Color color) {
        if (color.getRed() != color.getGreen() || color.getGreen() != color.getBlue()) {
            throw new IllegalArgumentException("This reader requires grayscale image");
        }
        set(x, y, color.getRed() / 255.0f);
    }
}

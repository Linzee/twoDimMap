package me.ienze.twoDimMap;

import java.awt.*;

public class GeneralMapLayer implements MapLayer<Float> {

	private Vec size;
	private float[][] data;
	
	public GeneralMapLayer(int width, int height) {
		this(new Vec(width, height));
	}
	
	public GeneralMapLayer(Vec size) {
		this.size = size;
		this.data = new float[size.x][size.y];
	}

	@Override
	public Vec getSize() {
		return this.size;
	}

	@Override
	public int getWidth() {
		return size.x;
	}

	@Override
	public int getHeight() {
		return size.y;
	}

	@Override
	public Float get(int x, int y) {
		if (x < 0 || x >= size.x || y < 0 || y >= size.y) {
			throw new IllegalArgumentException("Position out of range");
		}
		return this.data[x][y];
	}

	@Override
	public void set(int x, int y, Float value) {
		if (x < 0 || x >= size.x || y < 0 || y >= size.y) {
			throw new IllegalArgumentException("Position out of range");
		}
		this.data[x][y] = value;
	}

	@Override
	public Color getColor(int x, int y) {
		float value = get(x, y);
		return new Color(value, value, value);
	}

	@Override
	public void setColor(int x, int y, Color color) {
		if(color.getRed() != color.getGreen() || color.getGreen() != color.getBlue()) {
			throw new IllegalArgumentException("This reader requires grayscale image");
		}
		set(x, y, color.getRed() / 255.0f);
	}
}

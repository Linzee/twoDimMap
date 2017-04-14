package me.ienze.twoDimMap;

import java.awt.*;
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

	@Override
	public int getHeight() {
		return size.y;
	}

	public Boolean get(int x, int y) {
		if (x < 0 || x >= size.x || y < 0 || y >= size.y) {
			throw new IllegalArgumentException("Position out of range");
		}
		int index = y * size.x + x;
		return data.get(index);
	}

	public void set(int x, int y, Boolean value) {
		if (x < 0 || x >= size.x || y < 0 || y >= size.y) {
			throw new IllegalArgumentException("Position out of range");
		}
		int index = y * size.x + x;
		data.set(index, value);
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

	public void setWidth(int width) {
		this.size.x = width;
	}

	public void setHeight(int height) {
		this.size.y = height;
	}
}

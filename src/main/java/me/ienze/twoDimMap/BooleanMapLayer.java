package me.ienze.twoDimMap;

import java.util.BitSet;

public class BooleanMapLayer implements MapLayer<Boolean> {
	
	private Vec size;
	private Vec position;
	private BitSet data;
	
	public BooleanMapLayer(int width, int height) {
		this(new Vec(width, height));
	}
	
	public BooleanMapLayer(Vec size) {
		this.position = new Vec(0, 0);
		this.size = size;
		this.data = new BitSet(size.x * size.y);
	}

    public BooleanMapLayer(int width, int height, int x, int y) {
		this(new Vec(width, height), new Vec(x, y));
    }

	public BooleanMapLayer(Vec size, Vec position) {
		this(size);
		this.position = position;
	}

	public Vec getPosition() {
		return position;
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

	public void setWidth(int width) {
		this.size.x = width;
	}

	public void setHeight(int height) {
		this.size.y = height;
	}
}

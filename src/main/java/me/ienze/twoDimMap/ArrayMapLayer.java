package me.ienze.twoDimMap;

import java.awt.Color;

public abstract class ArrayMapLayer<T> implements MapLayer<T> {

	protected Vec size;
    protected T[][] data;

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
	public T get(int x, int y) {
		if (x < 0 || x >= size.x || y < 0 || y >= size.y) {
			throw new IllegalArgumentException("Position out of range");
		}
		return this.data[x][y];
	}

	@Override
	public void set(int x, int y, T value) {
		if (x < 0 || x >= size.x || y < 0 || y >= size.y) {
			throw new IllegalArgumentException("Position out of range");
		}
		this.data[x][y] = value;
	}
}

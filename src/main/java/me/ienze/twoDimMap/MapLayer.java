package me.ienze.twoDimMap;

import java.awt.Color;

public interface MapLayer<T> {
	
	Vec getSize();

	int getWidth();

	int getHeight();

	T get(int x, int y);

	void set(int x, int y, T value);

	Color getColor(int x, int y);

	void setColor(int x, int y, Color color);
	
}

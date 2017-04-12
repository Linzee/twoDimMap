package me.ienze.twoDimMap;

public interface MapLayer<T> {
	
	Vec getPosition();
	
	Vec getSize();

	int getWidth();

	int getHeight();

	T get(int x, int y);

	void set(int x, int y, T value);
	
}

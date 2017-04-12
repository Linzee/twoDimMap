package me.ienze.twoDimMap;

public class GeneralMapLayer implements MapLayer<Float> {

	private Vec position;
	private Vec size;
	private float[][] data;
	
	public GeneralMapLayer(int width, int height) {
		this(new Vec(width, height));
	}
	
	public GeneralMapLayer(Vec size) {
		this.position = new Vec(0, 0);
		this.size = size;
		this.data = new float[size.x][size.y];
	}

	public GeneralMapLayer(int width, int height, int x, int y) {
		this(new Vec(width, height), new Vec(x, y));
	}

	public GeneralMapLayer(Vec size, Vec position) {
		this(size);
		this.position = position;
	}
	
	
	@Override
	public Vec getPosition() {
		return this.position;
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
		return this.data[x][y];
	}

	@Override
	public void set(int x, int y, Float value) {
		this.data[x][y] = value;
	}

}

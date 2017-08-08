package me.ienze.twoDimMap;

import java.awt.Color;
import java.util.Arrays;

public class DistinctMapLayer extends ArrayMapLayer<Integer> {

	private int distinctValues;

	public DistinctMapLayer(int distinctValues, int width, int height) {
		this(distinctValues, new Vec(width, height));
	}

	public DistinctMapLayer(int distinctValues, Vec size) {

	    if(distinctValues <= 0) {
	        throw new IllegalArgumentException("Not enought distinct values to do anyting");
        }

        this.size = size;
        this.data = new Integer[size.x][size.y];
        for(int i=0; i<size.x; i++) {
            Arrays.fill(this.data[i], 0);
        }
		this.distinctValues = distinctValues;
	}

	public int getDistinctValues() {
		return distinctValues;
	}

    @Override
    public void set(int x, int y, Integer value) {
	    if(value >= distinctValues) {
	        throw new IllegalArgumentException("Value too large");
        }
        super.set(x, y, value);
    }

    @Override
	public Color getColor(int x, int y) {
		Integer value = (int) Math.floor(get(x, y) * (255.0/(distinctValues-1)));
		return new Color(value, value, value);
	}

	@Override
	public void setColor(int x, int y, Color color) {
		if(color.getRed() != color.getGreen() || color.getGreen() != color.getBlue()) {
			throw new IllegalArgumentException("This reader requires grayscale image");
		}
		set(x, y, color.getRed() / distinctValues);
	}
}

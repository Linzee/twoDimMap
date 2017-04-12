package me.ienze.twoDimMap.io;

import me.ienze.twoDimMap.BooleanMapLayer;
import me.ienze.twoDimMap.MapLayer;

import java.awt.*;


public class BooleanMapImageReader extends MapImageReader<Boolean> {

	@Override
	protected Boolean parseColor(Color color) {
		return !Color.BLACK.equals(color);
	}

	@Override
	protected MapLayer<Boolean> newMapLayer(int width, int height) {
		return new BooleanMapLayer(width, height);
	}
}

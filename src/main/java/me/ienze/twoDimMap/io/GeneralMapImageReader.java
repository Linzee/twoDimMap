package me.ienze.twoDimMap.io;

import me.ienze.twoDimMap.GeneralMapLayer;
import me.ienze.twoDimMap.MapLayer;

import java.awt.*;
import java.io.*;

public class GeneralMapImageReader extends MapImageReader<Float> {


	@Override
	protected Float parseColor(Color color) {
		if(color.getRed() != color.getGreen() || color.getGreen() != color.getBlue()) {
			throw new IllegalArgumentException("This reader requires grayscale image");
		}
		return color.getRed() / 255.0f;
	}

	@Override
	protected MapLayer<Float> newMapLayer(int width, int height) {
		return new GeneralMapLayer(width, height);
	}
}

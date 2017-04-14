package me.ienze.twoDimMap.io;

import me.ienze.twoDimMap.GeneralMapLayer;
import me.ienze.twoDimMap.MapLayer;

import java.awt.*;
import java.io.*;

public class GeneralMapImageReader extends MapImageReader<Float> {

	@Override
	protected MapLayer<Float> newMapLayer(int width, int height) {
		return new GeneralMapLayer(width, height);
	}
}

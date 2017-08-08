package me.ienze.twoDimMap.io;

import me.ienze.twoDimMap.GeneralMapLayer;
import me.ienze.twoDimMap.MapLayer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class GeneralMapImageReader extends MapImageReader<GeneralMapLayer> {

	@Override
	protected GeneralMapLayer newMapLayer(BufferedImage image) {
		return new GeneralMapLayer(image.getWidth(), image.getHeight());
	}
}

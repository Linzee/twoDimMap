package me.ienze.twoDimMap.io;

import me.ienze.twoDimMap.MapLayer;

import java.io.*;

public class BooleanMapAsciiWriter {

	public void write(MapLayer<Boolean> layer, File file) throws IOException {
		try(OutputStream out = new FileOutputStream(file)) {
			write(layer, out);
		}
	}

	public void write(MapLayer<Boolean> layer, OutputStream out) throws IOException {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

		for (int y = 0; y < layer.getHeight(); y++) {
			for (int x = 0; x < layer.getWidth(); x++) {
				writer.write(layer.get(x, y) ? "#" : ".");
			}
			writer.newLine();
		}
		
		writer.flush();
	}
}

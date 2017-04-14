package me.ienze.twoDimMap.io;

import me.ienze.twoDimMap.BooleanMapLayer;
import me.ienze.twoDimMap.MapLayer;

import java.io.*;
import java.util.regex.Pattern;

public class BooleanMapAsciiReader {

	private static final Pattern tilePattern = Pattern.compile("(#|.)");

	public MapLayer<Boolean> read(File file) throws IOException {
		try(InputStream in = new FileInputStream(file)) {
			return read(in);
		}
	}

	public MapLayer<Boolean> read(InputStream in) throws IOException {
		BufferedReader innerReader = new BufferedReader(new InputStreamReader(in));

		int x = 0;
		int y = 0;

		BooleanMapLayer layer = new BooleanMapLayer(0, 0);

		String line;
		while ((line = innerReader.readLine()) != null) {

			x = 0;

			layer.setHeight(y + 1);

			if (y == 0) {
				layer.setWidth(line.length());
			} else {
				if (line.length() != layer.getWidth()) {
					throw new IllegalArgumentException("Wrong layer!");
				}
			}
			
			for(int i=0; i<line.length(); i++) {
				layer.set(x, y, line.charAt(i) == '#');
				++x;
			}

			++y;
		}
		
		return layer;
	}

}

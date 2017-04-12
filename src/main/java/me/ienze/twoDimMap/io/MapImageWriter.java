package me.ienze.twoDimMap.io;

import me.ienze.twoDimMap.MapLayer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public abstract class MapImageWriter<T> {

    private String format = "PNG";

	public MapImageWriter() {

	}

    public void write(MapLayer<T> layer, File file) throws IOException {
        try(OutputStream out = new FileOutputStream(file)) {
            write(layer, out);
        }
    }

	public void write(MapLayer<T> layer, OutputStream out) throws IOException {
		BufferedImage image = new BufferedImage(layer.getWidth(), layer.getHeight(), BufferedImage.TYPE_INT_RGB);

		for(int x = 0; x<image.getWidth(); x++) {
			for(int y = 0; y<image.getHeight(); y++) {
				image.setRGB(x, y, encode(layer.get(x, y)).getRGB());
			}
		}

		ImageIO.write(image, format, out);
	}

    protected abstract Color encode(T value);

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
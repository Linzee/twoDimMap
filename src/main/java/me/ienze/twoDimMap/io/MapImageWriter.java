package me.ienze.twoDimMap.io;

import me.ienze.twoDimMap.MapLayer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public abstract class MapImageWriter<T extends MapLayer> {

    private String format = "PNG";

    public void write(T layer, File file) throws IOException {
        try (OutputStream out = new FileOutputStream(file)) {
            write(layer, out);
        }
    }

    public void write(T layer, OutputStream out) throws IOException {
        ImageIO.write(generateImage(layer), format, out);
    }

    public BufferedImage generateImage(T layer) {
        BufferedImage image = new BufferedImage(layer.getWidth(), layer.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                image.setRGB(x, y, layer.getColor(x, y).getRGB());
            }
        }

        return image;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
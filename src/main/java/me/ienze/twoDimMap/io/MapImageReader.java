package me.ienze.twoDimMap.io;

import me.ienze.twoDimMap.GeneralMapLayer;
import me.ienze.twoDimMap.MapLayer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Ienze
 */
abstract public class MapImageReader<T> {

    public MapLayer<T> read(File file) throws IOException {
        try(InputStream in = new FileInputStream(file)) {
            return read(in);
        }
    }

    public MapLayer<T> read(InputStream in) throws IOException {
        BufferedImage image = ImageIO.read(in);

        MapLayer<T> layer = newMapLayer(image.getWidth(), image.getHeight());

        for(int x = 0; x<image.getWidth(); x++) {
            for(int y = 0; y<image.getHeight(); y++) {
                layer.setColor(x, y, new Color(image.getRGB(x, y)));
            }
        }

        return layer;
    }

    protected abstract MapLayer<T> newMapLayer(int width, int height);

}

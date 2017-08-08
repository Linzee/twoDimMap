package me.ienze.twoDimMap.io;

import me.ienze.twoDimMap.GeneralMapLayer;

import java.awt.image.BufferedImage;

public class GeneralMapImageReader extends MapImageReader<GeneralMapLayer> {

    @Override
    protected GeneralMapLayer newMapLayer(BufferedImage image) {
        return new GeneralMapLayer(image.getWidth(), image.getHeight());
    }
}

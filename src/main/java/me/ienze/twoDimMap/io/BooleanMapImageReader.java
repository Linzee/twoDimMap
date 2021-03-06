package me.ienze.twoDimMap.io;

import me.ienze.twoDimMap.BooleanMapLayer;

import java.awt.image.BufferedImage;


public class BooleanMapImageReader extends MapImageReader<BooleanMapLayer> {

    @Override
    protected BooleanMapLayer newMapLayer(BufferedImage image) {
        return new BooleanMapLayer(image.getWidth(), image.getHeight());
    }
}

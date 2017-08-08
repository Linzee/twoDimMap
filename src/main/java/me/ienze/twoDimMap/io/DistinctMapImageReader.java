package me.ienze.twoDimMap.io;

import me.ienze.twoDimMap.DistinctMapLayer;

import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

public class DistinctMapImageReader extends MapImageReader<DistinctMapLayer> {

    @Override
    protected DistinctMapLayer newMapLayer(BufferedImage image) {
        return new DistinctMapLayer(countDistinctColors(image), image.getWidth(), image.getHeight());
    }

    private int countDistinctColors(BufferedImage image) {
        Set<Integer> colors = new HashSet<Integer>();
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int pixel = image.getRGB(x, y);
                colors.add(pixel);
            }
        }
        return colors.size();
    }
}

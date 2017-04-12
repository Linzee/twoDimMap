package me.ienze.twoDimMap.io;

import java.awt.*;

/**
 * @author Ienze
 */
public class GeneralMapImageWriter extends MapImageWriter<Float> {
    @Override
    protected Color encode(Float value) {
        return new Color(value, value, value);
    }
}

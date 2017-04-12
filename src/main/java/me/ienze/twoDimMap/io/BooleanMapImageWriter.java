package me.ienze.twoDimMap.io;

import java.awt.*;

/**
 * @author Ienze
 */
public class BooleanMapImageWriter extends MapImageWriter<Boolean> {
    @Override
    protected Color encode(Boolean value) {
        return value ? Color.WHITE : Color.BLACK;
    }
}

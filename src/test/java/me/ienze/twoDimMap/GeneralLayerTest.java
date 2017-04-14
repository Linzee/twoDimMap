package me.ienze.twoDimMap;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ienze
 */
public class GeneralLayerTest {

    @Test
    public void testEmptyLayer()
    {
        MapLayer layer = new GeneralMapLayer(9,11);

        Assert.assertEquals(9, layer.getWidth());
        Assert.assertEquals(11, layer.getHeight());
        Assert.assertEquals(new Vec(9,11), layer.getSize());

        Assert.assertEquals(0.0f, layer.get(0, 0));
    }

    @Test
    public void testLayerSetAndGet()
    {
        MapLayer layer = new GeneralMapLayer(10, 10);

        Assert.assertEquals(0.0f, layer.get(0,0));

        layer.set(0, 0, 1.0f);

        Assert.assertEquals(1.0f, layer.get(0,0));

        layer.set(0, 0, 0.0f);

        Assert.assertEquals(0.0f, layer.get(0,0));
    }


    @Test
    public void testLayerSetMany()
    {
        MapLayer layer = new GeneralMapLayer(10, 10);

        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(0.0f, layer.get(i,i));
        }

        for (int i = 0; i < 10; i++) {
            layer.set(i, i, i * 0.1f);
        }

        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(i * 0.1f, layer.get(i,i));
        }
        for (int i = 0; i < 8; i++) {
            Assert.assertEquals(0.0f, layer.get(1,0));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMapGetOutOfBounds1()
    {
        MapLayer layer = new GeneralMapLayer(10, 10);
        layer.get(-1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMapGetOutOfBounds2()
    {
        MapLayer layer = new GeneralMapLayer(10, 10);
        layer.get(0, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMapGetOutOfBounds3()
    {
        MapLayer layer = new GeneralMapLayer(10, 10);
        layer.get(0, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMapGetOutOfBounds4()
    {
        MapLayer layer = new GeneralMapLayer(10, 10);
        layer.get(0, 10);
    }

}

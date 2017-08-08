package me.ienze.twoDimMap;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ienze
 */
public class DistinctLayerTest {

    @Test(expected = IllegalArgumentException.class)
    public void testDistinctValuesNonpositive()
    {
        new DistinctMapLayer(0,9,11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDistinctValuesOne()
    {
        MapLayer layer = new DistinctMapLayer(1,9,11);
        Assert.assertEquals(0, layer.get(0, 0));
        layer.set(0, 0, 0);
        Assert.assertEquals(0, layer.get(0, 0));
        layer.set(0, 0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDistinctValuesTwo()
    {
        MapLayer layer = new DistinctMapLayer(2,9,11);
        Assert.assertEquals(0, layer.get(0, 0));
        layer.set(0, 0, 1);
        Assert.assertEquals(1, layer.get(0, 0));
        layer.set(0, 0, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDistinctValuesMany()
    {
        MapLayer layer = new DistinctMapLayer(10,9,11);
        Assert.assertEquals(0, layer.get(0, 0));
        layer.set(0, 0, 9);
        Assert.assertEquals(9, layer.get(0, 0));
        layer.set(0, 0, 10);
    }
    
    @Test
    public void testEmptyLayer()
    {
        MapLayer layer = new DistinctMapLayer(3,9,11);

        Assert.assertEquals(9, layer.getWidth());
        Assert.assertEquals(11, layer.getHeight());
        Assert.assertEquals(new Vec(9,11), layer.getSize());

        Assert.assertEquals(0, layer.get(0, 0));
    }

    @Test
    public void testLayerSetAndGet()
    {
        MapLayer layer = new DistinctMapLayer(10,  10, 10);

        Assert.assertEquals(0, layer.get(0,0));

        layer.set(0, 0, 1);

        Assert.assertEquals(1, layer.get(0,0));

        layer.set(0, 0, 0);

        Assert.assertEquals(0, layer.get(0,0));
    }


    @Test
    public void testLayerSetMany()
    {
        MapLayer layer = new DistinctMapLayer(10, 10, 10);

        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(0, layer.get(i,i));
        }

        for (int i = 0; i < 10; i++) {
            layer.set(i, i, i);
        }

        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(i, layer.get(i,i));
        }
        for (int i = 0; i < 8; i++) {
            Assert.assertEquals(0, layer.get(1,0));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMapGetOutOfBounds1()
    {
        MapLayer layer = new DistinctMapLayer(10, 10, 10);
        layer.get(-1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMapGetOutOfBounds2()
    {
        MapLayer layer = new DistinctMapLayer(10, 10, 10);
        layer.get(0, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMapGetOutOfBounds3()
    {
        MapLayer layer = new DistinctMapLayer(10, 10, 10);
        layer.get(0, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMapGetOutOfBounds4()
    {
        MapLayer layer = new DistinctMapLayer(10, 10, 10);
        layer.get(0, 10);
    }

}

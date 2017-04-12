package me.ienze.twoDimMap;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class MapTest extends TestCase {

    @Test
    public void testEmptyMap()
    {
        Map map = new Map(9, 11);
        Assert.assertEquals(9, map.getWidth());
        Assert.assertEquals(11, map.getHeight());
        Assert.assertEquals(new HashSet<MapLayer<Object>>(), map.getLayers());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testMapWrongSizeX()
    {
        new Map(-1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMapWrongSizeY()
    {
        new Map(0, -1);
    }

    @Test
    public void testMapLayers()
    {
        Map map = new Map(10, 10);

        MapLayer layer = new BooleanMapLayer(10, 10);
        map.addLayer(layer);

        HashSet<MapLayer<Object>> expected = new HashSet<MapLayer<Object>>();
        expected.add(layer);
        Assert.assertEquals(expected, map.getLayers());

        map.removeLayer(layer);

        Assert.assertEquals(new HashSet<MapLayer<Object>>(), map.getLayers());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMapEmpty()
    {
        Map map = new Map(10, 10);
        Assert.assertEquals(0, map.get(5, 5));
    }

    @Test
    public void testMapLayerPositions()
    {
        Map map = new Map(10, 10);

        BooleanMapLayer layer = new BooleanMapLayer(5, 5, 2, 2);
        map.addLayer(layer);

        Assert.assertEquals(0, map.get(0, 0));
        Assert.assertEquals(0, map.get(2, 2));
        Assert.assertEquals(0, map.get(4, 4));

        layer.set(0, 0, true);

        Assert.assertEquals(0, map.get(0, 0));
        Assert.assertEquals(255, map.get(2, 2));
        Assert.assertEquals(0, map.get(4, 4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMapGetOutOfBounds1()
    {
        Map map = new Map(10, 10);
        map.get(-1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMapGetOutOfBounds2()
    {
        Map map = new Map(10, 10);
        map.get(0, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMapGetOutOfBounds3()
    {
        Map map = new Map(10, 10);
        map.get(0, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMapGetOutOfBounds4()
    {
        Map map = new Map(10, 10);
        map.get(0, 10);
    }
}

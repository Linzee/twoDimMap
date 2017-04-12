package me.ienze.twoDimMap;

import java.util.Collections;
import java.util.Set;

public class Map {

	private Vec size;
	private Set<MapLayer<?>> layers;
	
	public Map(int width, int height) {
		this(new Vec(width, height));
	}

	public Map(Vec size) {
		if(size.x < 0) {
			throw new IllegalArgumentException("Map cannot have negative size");
		}
		if(size.y < 0) {
			throw new IllegalArgumentException("Map cannot have negative size");
		}
		this.size = size;
	}

	public void addLayer(MapLayer<?> layer) {
		this.layers.add(layer);
	}
	
	public void removeLayer(MapLayer<?> layer) {
		this.layers.remove(layer);
	}
	
	public Set<MapLayer<?>> getLayers() {
		return Collections.unmodifiableSet(layers);
	}
	
	public int getWidth() {
		return size.x;
	}
	
	public int getHeight() {
		return size.y;
	}
}

package com.egglab.pacman.object;

public class MapItem{

	private int x;
	private int y;
	private int width;
	private int height;
	private MapItemType type;
	
	public MapItem(int x, int y, int width, int height, MapItemType mapItemType) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.type = mapItemType;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public MapItemType getType() {
		return this.type;
	}

}

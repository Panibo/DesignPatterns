package com.mariapori.game.maps;

import com.mariapori.game.tiles.Tile;

// This is the abstract class for the Map objects
public abstract class Map {
    protected int width;
    protected int height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public abstract Tile createTile();

    // Displays the map as a matrix of characters
    public void display() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile = createTile();
                System.out.print(tile.getCharacter() + " ");
            }
            System.out.println();
        }
    }
}

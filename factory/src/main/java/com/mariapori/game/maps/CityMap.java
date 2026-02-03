package com.mariapori.game.maps;

import java.util.Random;

import com.mariapori.game.tiles.BuildingTile;
import com.mariapori.game.tiles.ForestTile;
import com.mariapori.game.tiles.RoadTile;
import com.mariapori.game.tiles.Tile;

public class CityMap extends Map {
    public CityMap(int width, int height) {
        super(width, height);
    }

    @Override
    public Tile createTile() {
        Random random = new Random();
        int tileType = random.nextInt(3); // 0 = Road, 1 = Forest, 2 = Building

        switch (tileType) {
            case 0:
                return new RoadTile();
            case 1:
                return new ForestTile();
            default:
                return new BuildingTile();
        }
    }
}

package com.mariapori.game.maps;

import java.util.Random;

import com.mariapori.game.tiles.ForestTile;
import com.mariapori.game.tiles.SwampTile;
import com.mariapori.game.tiles.Tile;
import com.mariapori.game.tiles.WaterTile;

public class WildernessMap extends Map {
    public WildernessMap(int width, int height) {
        super(width, height);
    }

    @Override
    public Tile createTile() {
        Random random = new Random();
        int tileType = random.nextInt(3); // 0 = Swamp, 1 = Water, 2 = Forest

        switch (tileType) {
            case 0:
                return new SwampTile();
            case 1:
                return new WaterTile();
            default:
                return new ForestTile();
        }
    }
}

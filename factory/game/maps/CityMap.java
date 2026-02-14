package game.maps;

import game.tiles.BuildingTile;
import game.tiles.ForestTile;
import game.tiles.RoadTile;
import game.tiles.Tile;
import java.util.Random;

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

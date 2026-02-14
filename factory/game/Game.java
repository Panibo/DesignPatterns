package game;

import game.maps.CityMap;
import game.maps.Map;
import game.maps.WildernessMap;

public class Game {
    public void run() {
        Map map = createMap("wilderness", 10, 10);
        map.display();
    }

    // Factory method
    public Map createMap(String mapType, int width, int height) {
        if ("city".equalsIgnoreCase(mapType)) {
            return new CityMap(width, height);
        } else if ("wilderness".equalsIgnoreCase(mapType)) {
            return new WildernessMap(width, height);
        } else {
            throw new IllegalArgumentException("Unknown map type: " + mapType);
        }
    }
}

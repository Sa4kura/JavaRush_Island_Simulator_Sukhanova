package config;

import model.AnimalType;

import java.util.HashMap;
import java.util.Map;

public class Config {
    public static final int WIDTH = 50;
    public static final int HEIGHT = 30;
    public static final int TICK_DELAY = 1;
    public static final Map<AnimalType, Integer> MAX_PER_CELL = new HashMap();

    static {
        MAX_PER_CELL.put(AnimalType.WOLF, 30);
        MAX_PER_CELL.put(AnimalType.FOX, 30);
        MAX_PER_CELL.put(AnimalType.BOA, 30);
        MAX_PER_CELL.put(AnimalType.BEAR, 5);
        MAX_PER_CELL.put(AnimalType.EAGLE, 20);
        MAX_PER_CELL.put(AnimalType.HORSE, 20);
        MAX_PER_CELL.put(AnimalType.DEER, 20);
        MAX_PER_CELL.put(AnimalType.RABBIT, 150);
        MAX_PER_CELL.put(AnimalType.MOUSE, 500);
        MAX_PER_CELL.put(AnimalType.GOAT, 140);
        MAX_PER_CELL.put(AnimalType.SHEEP, 140);
        MAX_PER_CELL.put(AnimalType.BOAR, 50);
        MAX_PER_CELL.put(AnimalType.BUFFALO, 10);
        MAX_PER_CELL.put(AnimalType.DUCK, 200);
        MAX_PER_CELL.put(AnimalType.CATERPILLAR, 1000);
    }
}

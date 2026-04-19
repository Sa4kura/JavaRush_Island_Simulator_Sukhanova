package config;

import model.AnimalType;

import java.util.HashMap;
import java.util.Map;

public class AnimalStats {
    public double weight;
    public int maxPerCell;
    public int speed;
    public double foodNeeded;
    public Map<AnimalType, Integer> diet = new HashMap();

    public AnimalStats(double weight, int maxPerCell, int speed, double foodNeeded) {
        this.weight = weight;
        this.maxPerCell = maxPerCell;
        this.speed = speed;
        this.foodNeeded = foodNeeded;
    }
}
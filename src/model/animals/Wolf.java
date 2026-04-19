package model.animals;

import model.AnimalType;
import model.Predator;

public class Wolf extends Predator {
    public Wolf(int x, int y) {
        super(AnimalType.WOLF, x, y);
    }
}

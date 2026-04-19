package model.animals;

import model.AnimalType;
import model.Predator;

public class Fox extends Predator {
    public Fox(int x, int y) {
        super(AnimalType.FOX, x, y);
    }
}

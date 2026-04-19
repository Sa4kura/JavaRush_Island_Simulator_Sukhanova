package model.animals;

import model.AnimalType;
import model.Herbivore;

public class Horse extends Herbivore {
    public Horse(int x, int y) {
        super(AnimalType.HORSE, x, y);
    }
}

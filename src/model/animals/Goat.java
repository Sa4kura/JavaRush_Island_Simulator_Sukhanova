package model.animals;

import model.AnimalType;
import model.Herbivore;

public class Goat extends Herbivore {
    public Goat(int x, int y) {
        super(AnimalType.GOAT, x, y);
    }
}

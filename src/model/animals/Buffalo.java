package model.animals;

import model.AnimalType;
import model.Herbivore;

public class Buffalo extends Herbivore {
    public Buffalo(int x, int y) {
        super(AnimalType.BUFFALO, x, y);
    }
}

package model.animals;

import model.AnimalType;
import model.Herbivore;

public class Caterpillar extends Herbivore {
    public Caterpillar(int x, int y) {
        super(AnimalType.CATERPILLAR, x, y);
    }
}

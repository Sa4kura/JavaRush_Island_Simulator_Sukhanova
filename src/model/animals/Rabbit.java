package model.animals;

import model.AnimalType;
import model.Herbivore;

public class Rabbit extends Herbivore {
    public Rabbit(int x, int y) {
        super(AnimalType.RABBIT, x, y);
    }
}

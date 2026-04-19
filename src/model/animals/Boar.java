package model.animals;

import model.AnimalType;
import model.Herbivore;

public class Boar extends Herbivore {
    public Boar(int x, int y) {
        super(AnimalType.BOAR, x, y);
    }
}

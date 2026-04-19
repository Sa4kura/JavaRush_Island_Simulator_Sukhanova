package model.animals;

import model.AnimalType;
import model.Herbivore;

public class Duck extends Herbivore {
    public Duck(int x, int y) {
        super(AnimalType.DUCK, x, y);
    }
}

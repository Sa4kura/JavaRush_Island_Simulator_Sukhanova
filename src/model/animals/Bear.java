package model.animals;

import model.AnimalType;
import model.Predator;

public class Bear extends Predator {
    public Bear(int x, int y) {
        super(AnimalType.BEAR, x, y);
    }
}

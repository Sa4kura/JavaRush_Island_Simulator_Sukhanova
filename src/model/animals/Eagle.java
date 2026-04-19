package model.animals;

import model.AnimalType;
import model.Predator;

public class Eagle extends Predator {
    public Eagle(int x, int y) {
        super(AnimalType.EAGLE, x, y);
    }
}

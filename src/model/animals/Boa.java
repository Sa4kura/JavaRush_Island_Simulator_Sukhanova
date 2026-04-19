package model.animals;

import model.AnimalType;
import model.Predator;

public class Boa extends Predator {
    public Boa(int x, int y) {
        super(AnimalType.BOA, x, y);
    }
}

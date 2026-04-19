package model.animals;

import model.AnimalType;
import model.Herbivore;

public class Deer extends Herbivore {
    public Deer(int x, int y) {
        super(AnimalType.DEER, x, y);
    }
}

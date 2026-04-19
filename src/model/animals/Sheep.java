package model.animals;

import model.AnimalType;
import model.Herbivore;

public class Sheep extends Herbivore {
    public Sheep(int x, int y) {
        super(AnimalType.SHEEP, x, y);
    }
}

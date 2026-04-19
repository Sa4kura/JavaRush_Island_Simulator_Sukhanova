package model.animals;

import model.AnimalType;
import model.Herbivore;

public class Mouse extends Herbivore {
    public Mouse(int x, int y) {
        super(AnimalType.MOUSE, x, y);
    }
}

package model;

import config.AnimalStats;
import config.StatsRegistry;
import java.util.concurrent.ThreadLocalRandom;

import world.Cell;
import world.Island;

public class Herbivore extends Animal {
    public Herbivore(AnimalType type, int x, int y) {
        super(type, x, y);
    }

    public void eat(Island island) {
        Cell cell = island.getCell(this.x, this.y);
        if (cell.getPlants() > 0) {
            cell.decreasePlants(1);
            this.food += (double)2.0F;
        }

    }

    public void move(Island island) {
        int speed = ((AnimalStats)StatsRegistry.stats.get(this.type)).speed;
        int dx = ThreadLocalRandom.current().nextInt(-speed, speed + 1);
        int dy = ThreadLocalRandom.current().nextInt(-speed, speed + 1);
        int newX = Math.max(0, Math.min(29, this.x + dx));
        int newY = Math.max(0, Math.min(49, this.y + dy));
        island.getCell(this.x, this.y).removeAnimal(this);
        this.x = newX;
        this.y = newY;
        island.getCell(this.x, this.y).addAnimal(this);
    }
}

package model;

import config.AnimalStats;
import config.StatsRegistry;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import world.Cell;
import world.Island;

public class Predator extends Animal {
    public Predator(AnimalType t, int x, int y) {
        super(t, x, y);
    }

    public void eat(Island island) {
        Cell cell = island.getCell(this.x, this.y);
        AnimalStats stats = (AnimalStats)StatsRegistry.stats.get(this.type);

        for(Map.Entry<AnimalType, Integer> entry : stats.diet.entrySet()) {
            List<Animal> prey = cell.getAnimals((AnimalType)entry.getKey());
            if (!prey.isEmpty() && Math.random() * (double)100.0F < (double)(Integer)entry.getValue()) {
                Animal victim = (Animal)prey.get(0);
                cell.removeAnimal(victim);
                this.food += ((AnimalStats)StatsRegistry.stats.get(entry.getKey())).weight;
                return;
            }
        }

    }

    public void move(Island island) {
        int dx = ThreadLocalRandom.current().nextInt(-1, 2);
        int dy = ThreadLocalRandom.current().nextInt(-1, 2);
        int nx = Math.max(0, Math.min(29, this.x + dx));
        int ny = Math.max(0, Math.min(49, this.y + dy));
        island.getCell(this.x, this.y).removeAnimal(this);
        this.x = nx;
        this.y = ny;
        island.getCell(this.x, this.y).addAnimal(this);
    }
}

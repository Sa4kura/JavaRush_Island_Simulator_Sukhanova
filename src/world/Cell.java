package world;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import model.Animal;
import model.AnimalType;

public class Cell {
    private final Map<AnimalType, List<Animal>> animals = new ConcurrentHashMap();
    private int plants = 40;

    public synchronized void addAnimal(Animal animal) {
        ((List)this.animals.computeIfAbsent(animal.type, (k) -> new ArrayList())).add(animal);
    }

    public synchronized void removeAnimal(Animal animal) {
        List<Animal> list = (List)this.animals.get(animal.type);
        if (list != null) {
            list.remove(animal);
        }

    }

    public List<Animal> getAnimals(AnimalType type) {
        return (List)this.animals.getOrDefault(type, new ArrayList());
    }

    public Map<AnimalType, List<Animal>> getAnimalsMap() {
        return this.animals;
    }

    public int getPlants() {
        return this.plants;
    }

    public synchronized void decreasePlants(int amount) {
        this.plants = Math.max(0, this.plants - amount);
    }

    public synchronized void growPlants() {
        if (Math.random() < 0.8) {
            this.plants += 4;
        }

        if (this.plants > 250) {
            this.plants = 250;
        }

    }

    public synchronized boolean hasPlants() {
        return this.plants > 0;
    }

    public synchronized void tickPlants() {
        ++this.plants;
        int rabbits = ((List)this.animals.getOrDefault(AnimalType.RABBIT, List.of())).size();
        this.plants -= rabbits * 2;
        if (this.plants < 0) {
            this.plants = 0;
        }

        if (this.plants > 200) {
            this.plants = 200;
        }

    }
}

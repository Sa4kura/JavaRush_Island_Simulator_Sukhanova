package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import model.Animal;
import model.AnimalType;
import model.animals.*;
import util.AnimalIcons;
import world.Cell;
import world.Island;


public class Simulator {
    private Island island = new Island();
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ExecutorService pool = Executors.newFixedThreadPool(4);
    private int tick = 0;

    public void start() {
        this.init();
        this.scheduler.scheduleAtFixedRate(this::tick, 0L, 1L, TimeUnit.SECONDS);
    }

    private void init() {
        Cell cell = this.island.getCell(0, 0);
        new Random();

        for(int i = 0; i < 30; ++i) {
            this.spawnRandom(new Wolf(0, 0));
            this.spawnRandom(new Boa(0, 0));
            this.spawnRandom(new Fox(0, 0));
            this.spawnRandom(new Bear(0, 0));
            this.spawnRandom(new Eagle(0, 0));
        }

        for(int i = 0; i < 200; ++i) {
            this.spawnRandom(new Rabbit(0, 0));
            this.spawnRandom(new Deer(0, 0));
            this.spawnRandom(new Horse(0, 0));
            this.spawnRandom(new Sheep(0, 0));
            this.spawnRandom(new Goat(0, 0));
            this.spawnRandom(new Buffalo(0, 0));
            this.spawnRandom(new Boar(0, 0));
            this.spawnRandom(new Mouse(0, 0));
            this.spawnRandom(new Duck(0, 0));
            this.spawnRandom(new Caterpillar(0, 0));
        }

    }

    private void spawnRandom(Animal animal) {
        int x = (new Random()).nextInt(30);
        int y = (new Random()).nextInt(50);
        animal.setPosition(x, y);
        this.island.getCell(x, y).addAnimal(animal);
    }

    private void tick() {
        ++this.tick;
        List<Future<?>> futures = new ArrayList();

        for(int i = 0; i < 30; ++i) {
            for(int j = 0; j < 50; ++j) {
                Cell cell = this.island.getCell(i, j);
                futures.add(this.pool.submit(() -> this.processCell(cell)));
            }
        }

        for(Future<?> future : futures) {
            try {
                future.get();
            } catch (ExecutionException | InterruptedException var5) {
            }
        }

        this.printStats();

        for(int i = 0; i < 30; ++i) {
            for(int j = 0; j < 50; ++j) {
                this.island.getCell(i, j).growPlants();
            }
        }

    }

    private void processCell(Cell cell) {
        cell.growPlants();
        Map<AnimalType, List<Animal>> snapshot = new HashMap(cell.getAnimalsMap());

        for (List<Animal> list : snapshot.values()) {
            for (Animal a : new ArrayList<>(list)) {
                a.eat(this.island);
                a.move(this.island);
                a.reproduce(this.island);
                a.starve();
                if (a.isDead()) {
                    cell.removeAnimal(a);
                }
            }
        }

    }

    private void printStats() {
        new HashMap();
        System.out.println("\n=== TICK " + this.tick + " ===");

        for(int i = 0; i < 30; ++i) {
            for(int j = 0; j < 50; ++j) {
                Cell cell = this.island.getCell(i, j);
                Map<AnimalType, List<Animal>> map = cell.getAnimalsMap();
                StringBuilder sb = new StringBuilder();

                for(Map.Entry<AnimalType, List<Animal>> entry : map.entrySet()) {
                    sb.append(AnimalIcons.get((AnimalType)entry.getKey())).append(((List)entry.getValue()).size()).append(" ");
                }

                if (cell.getPlants() > 0) {
                    sb.append("\ud83c\udf3f").append(cell.getPlants());
                }

                System.out.print("[" + String.valueOf(sb) + "] ");
            }

            System.out.println();
        }

    }
}

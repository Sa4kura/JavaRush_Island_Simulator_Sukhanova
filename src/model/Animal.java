package model;

import java.util.ArrayList;
import java.util.List;

import world.Cell;
import world.Island;

public abstract class Animal {
    public AnimalType type;
    protected int x;
    protected int y;
    protected double food = (double)0.0F;

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Animal(AnimalType type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public abstract void eat(Island var1);

    public abstract void move(Island var1);

    public void reproduce(Island island) {
        Cell cell = island.getCell(this.x, this.y);
        List<Animal> list = cell.getAnimals(this.type);
        if (list.size() >= 2) {
            if (list.size() < 8) {
                if (!(Math.random() > (double)0.25F)) {
                    Animal baby = this.createChild();
                    if (baby != null) {
                        cell.addAnimal(baby);
                    }

                    switch (this.type) {
                        case RABBIT:
                        case MOUSE:
                        case GOAT:
                        case SHEEP:
                        case HORSE:
                        case DEER:
                        case BUFFALO:
                            if (cell.getPlants() > 0) {
                                cell.decreasePlants(1);
                                this.food = Math.min(this.food + (double)0.5F, (double)10.0F);
                            }
                            break;
                        case CATERPILLAR:
                            if (cell.getPlants() > 0) {
                                cell.decreasePlants(1);
                                this.food = Math.min(this.food + 0.3, (double)5.0F);
                            }
                            break;
                        case BOAR:
                            if (cell.getPlants() > 0) {
                                cell.decreasePlants(1);
                                this.food += (double)0.5F;
                            }

                            this.eatSmallAnimals(cell);
                            this.eatMediumAnimals(cell);
                            break;
                        case DUCK:
                            if (cell.getPlants() > 0) {
                                cell.decreasePlants(1);
                                this.food += (double)0.5F;
                            }

                            this.eatSmallAnimals(cell);
                            break;
                        case FOX:
                        case WOLF:
                        case BOA:
                        case EAGLE:
                        case BEAR:
                            this.eatAnimals(cell);
                    }

                }
            }
        }
    }

    public Animal createChild() {
        try {
            return (Animal)this.getClass().getConstructor(Integer.TYPE, Integer.TYPE).newInstance(this.x, this.y);
        } catch (Exception var2) {
            return null;
        }
    }

    public void starve() {
        --this.food;
    }

    public boolean isDead() {
        return this.food <= (double)0.0F;
    }

    private void eatAnimals(Cell cell) {
        List<Animal> preyList = new ArrayList();
        switch (this.type) {
            case FOX:
                preyList.addAll(cell.getAnimals(AnimalType.RABBIT));
                break;
            case WOLF:
                preyList.addAll(cell.getAnimals(AnimalType.RABBIT));
                preyList.addAll(cell.getAnimals(AnimalType.DEER));
                preyList.addAll(cell.getAnimals(AnimalType.GOAT));
                preyList.addAll(cell.getAnimals(AnimalType.SHEEP));
                break;
            case BOA:
            case EAGLE:
                preyList.addAll(cell.getAnimals(AnimalType.RABBIT));
                preyList.addAll(cell.getAnimals(AnimalType.MOUSE));
                break;
            case BEAR:
                preyList.addAll(cell.getAnimals(AnimalType.RABBIT));
                preyList.addAll(cell.getAnimals(AnimalType.DEER));
                preyList.addAll(cell.getAnimals(AnimalType.BOAR));
                preyList.addAll(cell.getAnimals(AnimalType.BUFFALO));
        }

        if (!preyList.isEmpty()) {
            Animal prey = (Animal)preyList.get(0);
            cell.removeAnimal(prey);
            this.food += (double)5.0F;
        }

    }

    private void eatSmallAnimals(Cell cell) {
        List<Animal> mice = cell.getAnimals(AnimalType.MOUSE);
        if (!mice.isEmpty()) {
            cell.removeAnimal((Animal)mice.get(0));
            this.food += (double)2.0F;
        }

    }

    private void eatMediumAnimals(Cell cell) {
        List<Animal> prey = new ArrayList();
        prey.addAll(cell.getAnimals(AnimalType.RABBIT));
        prey.addAll(cell.getAnimals(AnimalType.SHEEP));
        prey.addAll(cell.getAnimals(AnimalType.GOAT));
        if (!prey.isEmpty()) {
            cell.removeAnimal((Animal)prey.get(0));
            this.food += (double)3.0F;
        }

    }
}

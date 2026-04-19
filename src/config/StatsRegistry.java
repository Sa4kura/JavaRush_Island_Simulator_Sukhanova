package config;

import model.AnimalType;

import java.util.HashMap;
import java.util.Map;

public class StatsRegistry {
    public static final Map<AnimalType, AnimalStats> stats = new HashMap();

    static {
        stats.put(AnimalType.WOLF, new AnimalStats((double)50.0F, 30, 3, (double)8.0F));
        stats.put(AnimalType.BOA, new AnimalStats((double)15.0F, 30, 1, (double)3.0F));
        stats.put(AnimalType.FOX, new AnimalStats((double)8.0F, 30, 2, (double)2.0F));
        stats.put(AnimalType.BEAR, new AnimalStats((double)500.0F, 5, 2, (double)80.0F));
        stats.put(AnimalType.EAGLE, new AnimalStats((double)6.0F, 20, 3, (double)1.0F));
        stats.put(AnimalType.HORSE, new AnimalStats((double)400.0F, 20, 4, (double)60.0F));
        stats.put(AnimalType.DEER, new AnimalStats((double)300.0F, 20, 4, (double)50.0F));
        stats.put(AnimalType.RABBIT, new AnimalStats((double)2.0F, 150, 2, 0.45));
        stats.put(AnimalType.MOUSE, new AnimalStats(0.05, 500, 1, 0.01));
        stats.put(AnimalType.GOAT, new AnimalStats((double)60.0F, 140, 3, (double)10.0F));
        stats.put(AnimalType.SHEEP, new AnimalStats((double)70.0F, 140, 3, (double)15.0F));
        stats.put(AnimalType.BOAR, new AnimalStats((double)400.0F, 50, 2, (double)50.0F));
        stats.put(AnimalType.BUFFALO, new AnimalStats((double)700.0F, 10, 3, (double)100.0F));
        stats.put(AnimalType.DUCK, new AnimalStats((double)1.0F, 200, 4, 0.15));
        stats.put(AnimalType.CATERPILLAR, new AnimalStats(0.01, 1000, 0, (double)0.0F));
        ((AnimalStats)stats.get(AnimalType.WOLF)).diet.put(AnimalType.HORSE, 10);
        ((AnimalStats)stats.get(AnimalType.WOLF)).diet.put(AnimalType.DEER, 15);
        ((AnimalStats)stats.get(AnimalType.WOLF)).diet.put(AnimalType.RABBIT, 60);
        ((AnimalStats)stats.get(AnimalType.WOLF)).diet.put(AnimalType.MOUSE, 80);
        ((AnimalStats)stats.get(AnimalType.WOLF)).diet.put(AnimalType.GOAT, 60);
        ((AnimalStats)stats.get(AnimalType.WOLF)).diet.put(AnimalType.SHEEP, 70);
        ((AnimalStats)stats.get(AnimalType.WOLF)).diet.put(AnimalType.BOAR, 40);
        ((AnimalStats)stats.get(AnimalType.WOLF)).diet.put(AnimalType.BUFFALO, 10);
        ((AnimalStats)stats.get(AnimalType.WOLF)).diet.put(AnimalType.DUCK, 10);
        ((AnimalStats)stats.get(AnimalType.BOA)).diet.put(AnimalType.FOX, 15);
        ((AnimalStats)stats.get(AnimalType.BOA)).diet.put(AnimalType.RABBIT, 20);
        ((AnimalStats)stats.get(AnimalType.BOA)).diet.put(AnimalType.MOUSE, 40);
        ((AnimalStats)stats.get(AnimalType.BOA)).diet.put(AnimalType.DUCK, 10);
        ((AnimalStats)stats.get(AnimalType.FOX)).diet.put(AnimalType.RABBIT, 70);
        ((AnimalStats)stats.get(AnimalType.FOX)).diet.put(AnimalType.MOUSE, 90);
        ((AnimalStats)stats.get(AnimalType.FOX)).diet.put(AnimalType.BOAR, 15);
        ((AnimalStats)stats.get(AnimalType.FOX)).diet.put(AnimalType.DUCK, 30);
        ((AnimalStats)stats.get(AnimalType.BEAR)).diet.put(AnimalType.BOA, 80);
        ((AnimalStats)stats.get(AnimalType.BEAR)).diet.put(AnimalType.HORSE, 40);
        ((AnimalStats)stats.get(AnimalType.BEAR)).diet.put(AnimalType.DEER, 80);
        ((AnimalStats)stats.get(AnimalType.BEAR)).diet.put(AnimalType.RABBIT, 80);
        ((AnimalStats)stats.get(AnimalType.BEAR)).diet.put(AnimalType.MOUSE, 90);
        ((AnimalStats)stats.get(AnimalType.BEAR)).diet.put(AnimalType.GOAT, 70);
        ((AnimalStats)stats.get(AnimalType.BEAR)).diet.put(AnimalType.SHEEP, 70);
        ((AnimalStats)stats.get(AnimalType.EAGLE)).diet.put(AnimalType.FOX, 10);
        ((AnimalStats)stats.get(AnimalType.EAGLE)).diet.put(AnimalType.RABBIT, 90);
        ((AnimalStats)stats.get(AnimalType.EAGLE)).diet.put(AnimalType.MOUSE, 90);
        ((AnimalStats)stats.get(AnimalType.EAGLE)).diet.put(AnimalType.CATERPILLAR, 40);
        ((AnimalStats)stats.get(AnimalType.HORSE)).diet.put(AnimalType.PLANT, 100);
        ((AnimalStats)stats.get(AnimalType.DEER)).diet.put(AnimalType.PLANT, 100);
        ((AnimalStats)stats.get(AnimalType.RABBIT)).diet.put(AnimalType.PLANT, 100);
        ((AnimalStats)stats.get(AnimalType.MOUSE)).diet.put(AnimalType.PLANT, 100);
        ((AnimalStats)stats.get(AnimalType.GOAT)).diet.put(AnimalType.PLANT, 100);
        ((AnimalStats)stats.get(AnimalType.SHEEP)).diet.put(AnimalType.PLANT, 100);
        ((AnimalStats)stats.get(AnimalType.BOAR)).diet.put(AnimalType.PLANT, 100);
        ((AnimalStats)stats.get(AnimalType.BOAR)).diet.put(AnimalType.MOUSE, 50);
        ((AnimalStats)stats.get(AnimalType.BUFFALO)).diet.put(AnimalType.PLANT, 100);
        ((AnimalStats)stats.get(AnimalType.DUCK)).diet.put(AnimalType.CATERPILLAR, 70);
        ((AnimalStats)stats.get(AnimalType.DUCK)).diet.put(AnimalType.PLANT, 10);
        ((AnimalStats)stats.get(AnimalType.CATERPILLAR)).diet.put(AnimalType.PLANT, 100);
    }
}

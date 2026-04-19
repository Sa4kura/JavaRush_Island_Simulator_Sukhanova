package util;

import java.util.EnumMap;
import java.util.Map;
import model.AnimalType;

public class AnimalIcons {
    private static final Map<AnimalType, String> ICONS = new EnumMap(AnimalType.class);

    public static String get(AnimalType type) {
        return (String)ICONS.getOrDefault(type, "?");
    }

    static {
        ICONS.put(AnimalType.WOLF, "\ud83d\udc3a");
        ICONS.put(AnimalType.BOA, "\ud83d\udc0d");
        ICONS.put(AnimalType.FOX, "\ud83e\udd8a");
        ICONS.put(AnimalType.BEAR, "\ud83d\udc3b");
        ICONS.put(AnimalType.EAGLE, "\ud83e\udd85");
        ICONS.put(AnimalType.HORSE, "\ud83d\udc34");
        ICONS.put(AnimalType.DEER, "\ud83e\udd8c");
        ICONS.put(AnimalType.RABBIT, "\ud83d\udc30");
        ICONS.put(AnimalType.MOUSE, "\ud83d\udc2d");
        ICONS.put(AnimalType.GOAT, "\ud83d\udc10");
        ICONS.put(AnimalType.SHEEP, "\ud83d\udc11");
        ICONS.put(AnimalType.BOAR, "\ud83d\udc17");
        ICONS.put(AnimalType.BUFFALO, "\ud83d\udc03");
        ICONS.put(AnimalType.DUCK, "\ud83e\udd86");
        ICONS.put(AnimalType.CATERPILLAR, "\ud83d\udc1b");
    }
}

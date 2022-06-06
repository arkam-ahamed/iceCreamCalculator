package tetranyde.iceCreamCalculator.utils;

/**
 * Project: iceCreamCalculator
 * Package: tetranyde.iceCreamCalculator.utils
 * User: Arkam
 * Date: 6/6/2022
 * Time: 8:27 PM
 * Created with IntelliJ IDEA
 */
public enum Condiments {
    SPRINKLES("Sprinkles", 50),
    TOASTED_MARSHMALLOW("Toasted Marshmallow", 100),
    TOASTED_ALMOND_FLAKES("Toasted Almond Flakes", 150),
    DASH_OF_PEANUT_BUTTER("Dash of Peanut butter", 50),
    OREO_CRUMBLES("Oreo Crumbles", 60),
    DRIED_APPLES("Dried Apples", 25),
    DRIED_MANGO("Dried Mango", 30),
    DRIED_APRICOT("Dried Apricot", 40),
    DRIED_BLUEBERRY("Dried Blueberry", 45);


    private final String condimentName;
    private final Integer price;

    Condiments(String condimentName, Integer price) {
        this.condimentName = condimentName;
        this.price = price;
    }


    public static Integer getCondimentPrice(String condimentName) {
        for (Condiments condiment : Condiments.values()) {
            if (condiment.condimentName.equalsIgnoreCase(condimentName)) {
                return condiment.getPrice();
            }
        }
        return -1;
    }

    public static Boolean getBaseFlavourForSprinkles(String baseFlavour) {
        return BaseFlavours.RASPBERRY_SLUSHY.getBaseFlavourName().equalsIgnoreCase(baseFlavour) || BaseFlavours.NUTTY_FRUIT.getBaseFlavourName().equalsIgnoreCase(baseFlavour);
    }

    public static Boolean getBaseFlavourForToastedMashMallow(String baseFlavour) {
        return BaseFlavours.RASPBERRY_SLUSHY.getBaseFlavourName().equalsIgnoreCase(baseFlavour) || BaseFlavours.NUTTY_FRUIT.getBaseFlavourName().equalsIgnoreCase(baseFlavour) || BaseFlavours.PISTACHIO_DELIGHT.getBaseFlavourName().equalsIgnoreCase(baseFlavour);
    }

    public static Boolean getBaseFlavourForToastedAlmondFlakes(String baseFlavour) {
        return BaseFlavours.COCO_COFFEE.getBaseFlavourName().equalsIgnoreCase(baseFlavour) || BaseFlavours.NUTTY_FRUIT.getBaseFlavourName().equalsIgnoreCase(baseFlavour) || BaseFlavours.PISTACHIO_DELIGHT.getBaseFlavourName().equalsIgnoreCase(baseFlavour);

    }

    public static Boolean getBaseFlavourForDashOfPeanutButter(String condimentName) {
        return Condiments.DASH_OF_PEANUT_BUTTER.getCondimentName().equalsIgnoreCase(condimentName);
    }

    public static Boolean getBaseFlavourForOreoCrumbles(String condimentName) {
        return Condiments.OREO_CRUMBLES.getCondimentName().equalsIgnoreCase(condimentName);
    }

    public static Boolean getBaseFlavourForDriedFruits(String condimentName) {
        return Condiments.DRIED_MANGO.getCondimentName().equalsIgnoreCase(condimentName) || Condiments.DRIED_APPLES.getCondimentName().equalsIgnoreCase(condimentName)
                || Condiments.DRIED_APRICOT.getCondimentName().equalsIgnoreCase(condimentName) || Condiments.DRIED_BLUEBERRY.getCondimentName().equalsIgnoreCase(condimentName);
    }

    public Integer getPrice() {
        return price;
    }

    public String getCondimentName() {
        return condimentName;
    }
}

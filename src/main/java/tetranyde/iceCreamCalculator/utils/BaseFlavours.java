package tetranyde.iceCreamCalculator.utils;

/**
 * Project: iceCreamCalculator
 * Package: tetranyde.iceCreamCalculator.utils
 * User: Arkam
 * Date: 6/6/2022
 * Time: 8:27 PM
 * Created with IntelliJ IDEA
 */
public enum BaseFlavours {
    RASPBERRY_SLUSHY("Raspberry Slushy", 200),
    COCO_COFFEE("Coco Coffee", 350),
    NUTTY_FRUIT("Nutty Fruit", 150),
    PISTACHIO_DELIGHT("Pistachio Delight", 350);


    private final String baseFlavourName;
    private final Integer price;

    BaseFlavours(String baseFlavourName, Integer price) {
        this.baseFlavourName = baseFlavourName;
        this.price = price;
    }

    public static Integer getBaseFlavourPrice(String baseFlavour) {
        for (BaseFlavours baseFlavours : BaseFlavours.values()) {
            if (baseFlavours.baseFlavourName.equalsIgnoreCase(baseFlavour)) {
                return baseFlavours.getPrice();
            }
        }
        return -1;
    }

    public Integer getPrice() {
        return price;
    }

    public String getBaseFlavourName(){
        return baseFlavourName;
    }
}

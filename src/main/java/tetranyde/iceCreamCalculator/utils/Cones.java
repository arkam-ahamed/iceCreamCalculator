package tetranyde.iceCreamCalculator.utils;

/**
 * Project: iceCreamCalculator
 * Package: tetranyde.iceCreamCalculator.utils
 * User: Arkam
 * Date: 6/6/2022
 * Time: 8:27 PM
 * Created with IntelliJ IDEA
 */
public enum Cones {
    WAFER_CONE("Wafer cone", 20),
    WAFFLE_CONE("Waffle cone", 40),
    WAFFLE_BOWL("Waffle bowl", 50),
    ICE_CREAM_SANDWICH_WAFERS("Ice cream sandwich wafers", 60);


    private final String coneName;
    private final Integer price;

    Cones(String coneName, Integer price) {
        this.coneName = coneName;
        this.price = price;
    }

    public static Integer getConePrice(String coneName) {
        for (Cones cone : Cones.values()) {
            if (cone.coneName.equalsIgnoreCase(coneName)) {
                return cone.getPrice();
            }
        }
        return -1;
    }

    public Integer getPrice() {
        return price;
    }

    public String getName() {
        return coneName;
    }
}

package tetranyde.iceCreamCalculator.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Project: iceCreamCalculator
 * Package: tetranyde.iceCreamCalculator.dto
 * User: Arkam
 * Date: 6/6/2022
 * Time: 7:56 PM
 * Created with IntelliJ IDEA
 */
@Data
public class IceCreamDTO {
    private String id;
    private String baseFlavour;
    private Integer baseFlavourPrice;
    private String condiment;
    private Integer condimentPrice;
    private String cone;
    private Integer conePrice;
    private Integer tableSpoon;
    private Integer cookieQuantity;
    private Integer totalBill;
    private LocalDateTime orderDate;
}

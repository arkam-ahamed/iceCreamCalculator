package tetranyde.iceCreamCalculator.dao;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Project: iceCreamCalculator
 * Package: tetranyde.iceCreamCalculator.model
 * User: Arkam
 * Date: 6/6/2022
 * Time: 7:46 PM
 * Created with IntelliJ IDEA
 */

@Data
@Document("ice_cream_collection")
public class IceCream {
    private ObjectId id;
    private String baseFlavour;
    private Integer baseFlavourPrice;
    private String condiment;
    private Integer condimentPrice;
    private String cone;
    private Integer conePrice;
    private Integer totalBill;
    private LocalDateTime orderDate;
}

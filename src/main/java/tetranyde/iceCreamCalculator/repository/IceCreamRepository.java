package tetranyde.iceCreamCalculator.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tetranyde.iceCreamCalculator.dao.IceCream;

/**
 * Project: iceCreamCalculator
 * Package: tetranyde.iceCreamCalculator.repository
 * User: Arkam
 * Date: 6/6/2022
 * Time: 8:00 PM
 * Created with IntelliJ IDEA
 */
@Repository
public interface IceCreamRepository extends MongoRepository<IceCream, ObjectId> {
}

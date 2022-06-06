package tetranyde.iceCreamCalculator.service;

import tetranyde.iceCreamCalculator.dto.IceCreamDTO;
import tetranyde.iceCreamCalculator.dto.Response;

/**
 * Project: iceCreamCalculator
 * Package: tetranyde.iceCreamCalculator.service.impl
 * User: Arkam
 * Date: 6/6/2022
 * Time: 8:02 PM
 * Created with IntelliJ IDEA
 */
public interface IceCreamService {
    Response addIceCreamOrder(IceCreamDTO iceCreamDTO);

    Response getIceCreamOrders();

    Response getIceCreamOrderById(String id);

    void deleteIceCreamOrderById(String id);
}

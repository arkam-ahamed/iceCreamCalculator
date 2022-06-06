package tetranyde.iceCreamCalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tetranyde.iceCreamCalculator.dto.IceCreamDTO;
import tetranyde.iceCreamCalculator.dto.Response;
import tetranyde.iceCreamCalculator.service.IceCreamService;

/**
 * Project: iceCreamCalculator
 * Package: tetranyde.iceCreamCalculator.controller
 * User: Arkam
 * Date: 6/6/2022
 * Time: 9:16 PM
 * Created with IntelliJ IDEA
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/icecream")
public class IceCreamController {
    private final IceCreamService iceCreamService;

    @Autowired
    public IceCreamController(IceCreamService iceCreamService) {
        this.iceCreamService = iceCreamService;
    }

    @PostMapping
    public Response addIceCreamOrder(@RequestBody IceCreamDTO iceCreamDTO) {
        return iceCreamService.addIceCreamOrder(iceCreamDTO);
    }

    @GetMapping
    public Response getIceCreamOrders() {
        return iceCreamService.getIceCreamOrders();
    }

    @GetMapping("{id}")
    public Response getIceCreamOrderById(@PathVariable String id) {
        return iceCreamService.getIceCreamOrderById(id);
    }

    @DeleteMapping("{id}")
    public void deleteIceCreamOrderById(@PathVariable String id) {
        iceCreamService.deleteIceCreamOrderById(id);
    }

}

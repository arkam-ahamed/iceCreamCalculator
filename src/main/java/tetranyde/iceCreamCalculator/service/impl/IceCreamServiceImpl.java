package tetranyde.iceCreamCalculator.service.impl;

import org.bson.types.ObjectId;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import tetranyde.iceCreamCalculator.dao.IceCream;
import tetranyde.iceCreamCalculator.dto.IceCreamDTO;
import tetranyde.iceCreamCalculator.dto.Response;
import tetranyde.iceCreamCalculator.exceptions.BaseFlavourNotFoundException;
import tetranyde.iceCreamCalculator.exceptions.CondimentNotFoundException;
import tetranyde.iceCreamCalculator.exceptions.ConeNotFoundException;
import tetranyde.iceCreamCalculator.exceptions.OrderNotFoundException;
import tetranyde.iceCreamCalculator.repository.IceCreamRepository;
import tetranyde.iceCreamCalculator.service.IceCreamService;
import tetranyde.iceCreamCalculator.utils.BaseFlavours;
import tetranyde.iceCreamCalculator.utils.Condiments;
import tetranyde.iceCreamCalculator.utils.Cones;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Project: iceCreamCalculator
 * Package: tetranyde.iceCreamCalculator.service.impl
 * User: Arkam
 * Date: 6/6/2022
 * Time: 8:02 PM
 * Created with IntelliJ IDEA
 */
@Service
public class IceCreamServiceImpl implements IceCreamService {
    private final DozerBeanMapper modelMapper;
    private final IceCreamRepository iceCreamRepository;


    public IceCreamServiceImpl(DozerBeanMapper modelMapper, IceCreamRepository iceCreamRepository) {
        this.modelMapper = modelMapper;
        this.iceCreamRepository = iceCreamRepository;
    }

    @Override
    public Response addIceCreamOrder(IceCreamDTO iceCreamDTO) {
        IceCream iceCream = modelMapper.map(iceCreamDTO, IceCream.class);
        if (BaseFlavours.getBaseFlavourPrice(iceCream.getBaseFlavour()) != -1) {
            iceCream.setBaseFlavourPrice(BaseFlavours.getBaseFlavourPrice(iceCream.getBaseFlavour()));
        } else {
            throw new BaseFlavourNotFoundException("Base flavour not found");
        }
        if (Condiments.getBaseFlavourForSprinkles(iceCream.getBaseFlavour()) || Condiments.getBaseFlavourForToastedMashMallow(iceCream.getBaseFlavour())
                || Condiments.getBaseFlavourForToastedAlmondFlakes(iceCream.getBaseFlavour())) {
            iceCream.setCondimentPrice(Condiments.getCondimentPrice(iceCream.getCondiment()));
        } else if (Condiments.getBaseFlavourForDashOfPeanutButter(iceCream.getBaseFlavour()) && iceCreamDTO.getTableSpoon()!= 0) {
            iceCream.setCondimentPrice(Condiments.getCondimentPrice(iceCream.getCondiment()));
        } else if (Condiments.getBaseFlavourForOreoCrumbles(iceCream.getBaseFlavour()) && iceCreamDTO.getCookieQuantity() != 0) {
            iceCream.setCondimentPrice(Condiments.getCondimentPrice(iceCream.getCondiment()) * iceCreamDTO.getCookieQuantity());
        } else {
            throw new CondimentNotFoundException("Sorry " + iceCream.getCondiment() + " cannot be applied to this base flavour");

        }
        if (Cones.getConePrice(iceCream.getCone()) != -1) {
            iceCream.setConePrice(Cones.getConePrice(iceCream.getCone()));
        } else {
            throw new ConeNotFoundException("Sorry " + iceCream.getCone() + "is not available");
        }

        iceCream.setCondimentPrice(iceCream.getCondimentPrice());
        iceCream.setConePrice(iceCream.getConePrice());
        iceCream.setTotalBill(iceCream.getBaseFlavourPrice() + iceCream.getCondimentPrice() + iceCream.getConePrice());
        iceCream.setOrderDate(LocalDateTime.now());
        iceCream = iceCreamRepository.save(iceCream);
        return new Response(modelMapper.map(iceCream, IceCreamDTO.class));
    }

    @Override
    public Response getIceCreamOrders() {
        List<IceCream> iceCreamList = iceCreamRepository.findAll();
        List<IceCreamDTO> iceCreamDTOList = new ArrayList<>();
        for (IceCream iceCream : iceCreamList) {
            iceCreamDTOList.add(modelMapper.map(iceCream, IceCreamDTO.class));
        }
        return new Response(iceCreamDTOList);
    }

    @Override
    public Response getIceCreamOrderById(String id) {
        Optional<IceCream> optionalIceCream = iceCreamRepository.findById(new ObjectId(id));
        if (optionalIceCream.isPresent()) {
            return new Response(modelMapper.map(optionalIceCream.get(), IceCreamDTO.class));
        } else {
            throw new OrderNotFoundException("order not found");
        }
    }

    @Override
    public void deleteIceCreamOrderById(String id) {
        Optional<IceCream> optionalIceCream = iceCreamRepository.findById(new ObjectId(id));
        if (optionalIceCream.isPresent()) {
            iceCreamRepository.delete(optionalIceCream.get());
        } else {
            throw new OrderNotFoundException("order not found");
        }
    }
}

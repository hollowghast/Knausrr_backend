package com.knausrr.Knausrr.services;

import com.knausrr.Knausrr.entities.Address;
import com.knausrr.Knausrr.entities.Local_Product;
import com.knausrr.Knausrr.entities.Store;
import com.knausrr.Knausrr.entities.dtos.DTOBuilder;
import com.knausrr.Knausrr.entities.dtos.ExposureLevel;
import com.knausrr.Knausrr.entities.dtos.StoreDTO;
import com.knausrr.Knausrr.repositories.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.function.Supplier;

@Service
public class StoreService {
    @Autowired
    private StoreRepo storeRepo;

    private StoreDTO buildDto(Store store, ExposureLevel exLvl){
        DTOBuilder<StoreDTO> storeDtoBuilder = null;

        switch (exLvl){
            case EXTENDED:
                storeDtoBuilder = DTOBuilder.of(() -> new StoreDTO(store));
                break;
            case COMPLETE:
                List<Local_Product> localProductIds =
                        store.getLocalProducts().stream()
                                .map(lp -> new Local_Product(lp.getId()))
                                .toList();
                storeDtoBuilder = DTOBuilder.of(() -> new StoreDTO(store))
                        .with(StoreDTO::setLocalProducts, localProductIds);
            case FAST:
            case MINIMAL:
            case STANDARD :
            default: {
                storeDtoBuilder = DTOBuilder.of(() -> new StoreDTO(store))
                        .without(StoreDTO::setLocalProducts)
                        .without(StoreDTO::setAddress);
            }
        }

        return Objects.isNull(storeDtoBuilder) ? null : storeDtoBuilder.build();
    }

    public StoreDTO findStoreById(Long id, ExposureLevel exLvl){
        //return Optional.of(storeRepo.findById(id).get()).orElse(new Store());
        Store reqStore = storeRepo.findById(id).get();
        //return DTOBuilder.of(StoreDTO::new).with(StoreDTO::setName, "new Store").build();

        return buildDto(reqStore, exLvl);
    }
    public StoreDTO findStoreByName(String name, ExposureLevel exLvl){
        return buildDto(storeRepo.findStoreByName(name), exLvl);
    }

    public List<StoreDTO> findStoresByCompanyName(String compName, ExposureLevel exLvl){
        return storeRepo.findByCompanyName(compName).stream().map(s -> this.buildDto(s, exLvl)).toList();
    }


    public List<StoreDTO> findAllStores(ExposureLevel exLvl){
        List<Store> l = storeRepo.findAll();
        return l.stream().map(s -> this.buildDto(s, exLvl)).toList();
    }
}

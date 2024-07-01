package com.knausrr.Knausrr.services;

import com.knausrr.Knausrr.entities.Local_Product;
import com.knausrr.Knausrr.entities.Store;
import com.knausrr.Knausrr.entities.dtos.DTOBuilder;
import com.knausrr.Knausrr.entities.dtos.ExposureLevel;
import com.knausrr.Knausrr.entities.dtos.StoreDTO;
import com.knausrr.Knausrr.repositories.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StoreService {
    @Autowired
    private StoreRepo storeRepo;

    public StoreDTO findStoreById(Long id, ExposureLevel exLvl){
        //return Optional.of(storeRepo.findById(id).get()).orElse(new Store());
        Store reqStore = storeRepo.findById(id).get();
        //return DTOBuilder.of(StoreDTO::new).with(StoreDTO::setName, "new Store").build();

        return Store.buildDto(reqStore, exLvl);
    }
    public StoreDTO findStoreByName(String name, ExposureLevel exLvl){
        return Store.buildDto(storeRepo.findByName(name).get(), exLvl);
    }

    public List<StoreDTO> findStoresByCompanyName(String compName, ExposureLevel exLvl){
        return storeRepo.findByCompanyName(compName).stream()
                .map(s -> Store.buildDto(s, exLvl)).toList();
    }


    public List<StoreDTO> findAllStores(ExposureLevel exLvl){
        List<Store> l = storeRepo.findAll();
        return l.stream().map(s -> Store.buildDto(s, exLvl)).toList();
    }
}

package com.knausrr.Knausrr.controller;


import com.knausrr.Knausrr.entities.Store;
import com.knausrr.Knausrr.entities.dtos.ExposureLevel;
import com.knausrr.Knausrr.entities.dtos.StoreDTO;
import com.knausrr.Knausrr.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/store", produces = "application/json")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping(params = "id")
    public StoreDTO findStoreById(@RequestParam("id") Long id){
        return storeService.findStoreById(id, ExposureLevel.STANDARD);
    }
    @GetMapping(params = "name")
    public StoreDTO findStoreByName(@RequestParam("name") String name){
        return storeService.findStoreByName(name, ExposureLevel.STANDARD);
    }
    @GetMapping(value = "/company", params = "name")
    public List<StoreDTO> findStoresByCompanyName(@RequestParam("name") String compName){
        return storeService.findStoresByCompanyName(compName, ExposureLevel.STANDARD);
    }

    @GetMapping(value = "/all")
    public List<StoreDTO> findAllStores(){
        return storeService.findAllStores(ExposureLevel.STANDARD);
    }
}

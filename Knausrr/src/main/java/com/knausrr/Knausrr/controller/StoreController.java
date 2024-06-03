package com.knausrr.Knausrr.controller;


import com.knausrr.Knausrr.entities.Store;
import com.knausrr.Knausrr.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/store")
    public Store findStoreById(@RequestParam("id") Long id){
        return storeService.findStoreById(id);
    }
    @GetMapping(produces = "application/json")
    public List<Store> findAllStores(){
        return storeService.findAllStores();
    }
}

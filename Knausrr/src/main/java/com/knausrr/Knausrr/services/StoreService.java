package com.knausrr.Knausrr.services;

import com.knausrr.Knausrr.entities.Store;
import com.knausrr.Knausrr.repositories.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    @Autowired
    private StoreRepo storeRepo;

    public Store findStoreById(Long id){
        return Optional.of(storeRepo.findById(id).get()).orElse(new Store());
    }

    public List<Store> findAllStores(){
        List<Store> l =storeRepo.findAll();
        l.stream().forEach(s -> System.out.println(s.getAddress().getCity()));
        return l;
    }
}

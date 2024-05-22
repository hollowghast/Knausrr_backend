package com.knausrr.Knausrr.services;

import com.knausrr.Knausrr.entities.Local_Product;
import com.knausrr.Knausrr.repositories.LocalProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private LocalProductRepo localProductRepo;

    public Local_Product getLocalProductById(Long id){
        return localProductRepo.getLocalProductById(id);
    }
}

package com.knausrr.Knausrr.services;

import com.knausrr.Knausrr.entities.Base_Product;
import com.knausrr.Knausrr.entities.Local_Product;
import com.knausrr.Knausrr.repositories.BaseProductRepo;
import com.knausrr.Knausrr.repositories.LocalProductRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private LocalProductRepo localProductRepo;
    @Autowired
    private BaseProductRepo baseProductRepo;

    public Local_Product getLocalProductById(Long id) {
        return localProductRepo.findLocalProductById(id);
    }

    public Local_Product addLocalProduct(Local_Product product) {
        //if local_product or base_product is null - abort
        if (Objects.isNull(product) || Objects.isNull(product.getBase_product())) {
            return null;
        }

        Base_Product baseProduct = this.addBaseProduct(product.getBase_product());
        if (Objects.isNull(baseProduct)) {
            return null;
        }else{
            return localProductRepo.save(product);
        }
    }

    @Transactional
    public Base_Product addBaseProduct(Base_Product product) {
        return this.baseProductRepo.save(product);
    }

}

package com.knausrr.Knausrr.controller;

import com.knausrr.Knausrr.entities.Base_Product;
import com.knausrr.Knausrr.entities.Local_Product;
import com.knausrr.Knausrr.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public Local_Product getLocalProduct(@RequestParam("id") Long id){
        return productService.getLocalProductById(id);
    }

    /**
     * method used for adding the initial inventory for a store
     * @param product either a json or already converted data from {@link com.knausrr.Knausrr.admin.service.impl.DefaultCsvConverterService}
     * @return the added product or null
     */
    @PostMapping("/addBaseProduct")
    public Base_Product addBaseProduct(@RequestParam("productData") Base_Product product){
        return productService.addBaseProduct(product);
    }

    /**
     * method used for adding the initial inventory for a store and adding of individual products after a store was added
     * @param product already converted data from {@link com.knausrr.Knausrr.admin.service.impl.DefaultCsvConverterService}
     * @return the added product or null
     */
    @PostMapping("/addLocalProduct")
    public Local_Product addLocalProduct(@RequestParam("productData") Local_Product product){
        return productService.addLocalProduct(product);
    }

}

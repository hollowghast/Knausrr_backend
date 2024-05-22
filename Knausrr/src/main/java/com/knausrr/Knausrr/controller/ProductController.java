package com.knausrr.Knausrr.controller;

import com.knausrr.Knausrr.entities.Local_Product;
import com.knausrr.Knausrr.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public Local_Product getLocalProduct(@RequestParam("productId") Long id){
        return productService.getLocalProductById(id);
    }
}

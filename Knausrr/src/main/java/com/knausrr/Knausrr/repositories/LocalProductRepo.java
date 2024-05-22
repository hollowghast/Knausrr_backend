package com.knausrr.Knausrr.repositories;

import com.knausrr.Knausrr.entities.Local_Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalProductRepo extends JpaRepository<Local_Product, Long> {
    Local_Product getLocalProductById(Long id);
}

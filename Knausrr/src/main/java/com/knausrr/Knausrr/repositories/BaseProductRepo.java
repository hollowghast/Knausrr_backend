package com.knausrr.Knausrr.repositories;

import com.knausrr.Knausrr.entities.Base_Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BaseProductRepo extends JpaRepository<Base_Product, Long> {
    Base_Product findBaseProductById(@Param("id") UUID id);
}

package com.knausrr.Knausrr.repositories;

import com.knausrr.Knausrr.entities.Local_Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface LocalProductRepo extends JpaRepository<Local_Product, UUID> {
    @Query("SELECT p FROM Local_Product p WHERE p.id IN :ids")
    List<Local_Product> findLocalProductsByIds(@Param("ids") UUID[] ids);

}

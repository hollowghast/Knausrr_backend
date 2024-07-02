package com.knausrr.Knausrr.repositories;

import com.knausrr.Knausrr.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StoreRepo extends JpaRepository<Store, UUID> {
    List<Store> findByCompanyName(@Param("companyName") String compName);
    Optional<Store> findByName(@Param("name") String name);
}

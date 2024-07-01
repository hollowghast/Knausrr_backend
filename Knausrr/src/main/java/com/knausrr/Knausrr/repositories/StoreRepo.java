package com.knausrr.Knausrr.repositories;

import com.knausrr.Knausrr.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreRepo extends JpaRepository<Store, Long> {
    @Query(value = "select s.* from store s inner join company c on c.id = s.company where c.name = ?1",
        nativeQuery = true)
    List<Store> findByCompanyName(@Param("companyName") String compName);
    @Query(value = "select * from store where name = ?1",
        nativeQuery = true)
    Optional<Store> findByName(@Param("name") String name);
}

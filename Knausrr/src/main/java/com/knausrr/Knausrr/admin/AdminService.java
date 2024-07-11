package com.knausrr.Knausrr.admin;

import com.knausrr.Knausrr.entities.*;
import com.knausrr.Knausrr.solr.service.SolrService;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;

@Service
public class AdminService {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private SolrService solrService;


    /**
     * testing query:
     * select *
     * from address, base_product, brand, company, local_product, opening_hours, price, store;
     */
    public void doStuff(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Address a = new Address("8010", "Graz", "Herrengasse");
        Company c = new Company("Spar");
        Store s = new Store(c, a);
        OpeningHours o = new OpeningHours(s, LocalTime.of(8, 0), LocalTime.of(18, 30));
        Brand b = new Brand("CocaCola Company Ltd");
        Base_Product bp = new Base_Product("Coke", b);
        Local_Product lp = new Local_Product(bp, s);
        Price p = new Price(lp, 0.99f, OffsetDateTime.now(), Price_Type.BASE);

        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.persist(c);
        entityManager.persist(s);
        entityManager.persist(o);
        entityManager.persist(b);
        entityManager.persist(bp);
        entityManager.persist(lp);
        entityManager.persist(p);
        entityManager.getTransaction().commit();

        entityManager.close();

    }

    public void indexProductForCode(Long id) throws SolrServerException, IOException {
        solrService.indexBaseProduct(entityManagerFactory.createEntityManager().find(Base_Product.class, id));
    }
}

package com.knausrr.Knausrr.admin;

import com.knausrr.Knausrr.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;

@Service
public class AdminService {
    @Autowired
    private EntityManagerFactory entityManagerFactory;


    /**
     * testing query:
     * select *
     * from address, base_product, brand, company, local_product, opening_hours, price, store;
     */
    public void doStuff(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Address a = new Address("8010", "Graz", "Herrengasse");
        Company c = new Company("Spar");
        Contact con = new Contact();
        con.setFirstname("Daniel");
        con.setLastname("Deuerlein");
        Store s = new Store("testshop", c, a);
        s.setManager(con);
        //OpeningHours o = new OpeningHours(1l, s, 8., 18.5);
        Brand b = new Brand("CocaCola Company Ltd");
        Base_Product bp = new Base_Product("918262128", "Coke", "some coke", b);
        Local_Product lp = new Local_Product(bp, s);
        Price p = new Price(lp, 0.99, OffsetDateTime.now(), Price_Type.BASE);

        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.persist(c);
        entityManager.persist(s);
        //entityManager.persist(o);
        entityManager.persist(b);
        entityManager.persist(bp);
        entityManager.persist(lp);
        entityManager.persist(p);
        entityManager.getTransaction().commit();

        entityManager.close();

    }
}

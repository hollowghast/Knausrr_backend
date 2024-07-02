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

        Address a = new Address();
        a.setZipcode("8010");
        a.setCity("Graz");
        a.setStreet("Herrengasse");
        a.setCountry("Austria");
        a.setDetails("1");

        Company c = new Company();
        c.setName("Spar");

        Contact con = new Contact();
        con.setFirstname("Daniel");
        con.setLastname("Deuerlein");

        Store s = new Store();
        s.setName("testshop");
        s.setCompany(c);
        s.setAddress(a);
        s.setManager(con);

        //OpeningHours o = new OpeningHours(1l, s, 8., 18.5);

        Brand b = new Brand();
        b.setName("CocaCola Company Ltd");

        Base_Product bp = new Base_Product();
        bp.setBarcode("918262128");
        bp.setName("Coke");
        bp.setBrand(b);

        Local_Product lp = new Local_Product();
        lp.setStore(s);
        lp.setBase_product(bp);

        Price p = new Price();
        p.setLocal_product(lp);
        p.setPrice(0.99);
        p.setStart_date(OffsetDateTime.now());
        p.setType(Price_Type.BASE);

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

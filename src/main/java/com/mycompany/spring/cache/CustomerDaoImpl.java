package com.mycompany.spring.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

    @Cacheable(value = "customerFindCache", key = "#name")
    public Customer findByLastName(final String name) {
        slowQuery(2000L);
        System.out.println("findByLastName is running...");
        return new Customer(1, "John", "Rocky");
    }

    private void slowQuery(final long seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
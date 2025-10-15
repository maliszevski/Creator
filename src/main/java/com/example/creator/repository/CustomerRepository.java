package com.example.creator.repository;

import com.example.creator.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    // JpaRepository daje metody: save(), findAll(), findById(), deleteById()
    
}


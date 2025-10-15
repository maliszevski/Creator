package com.example.creator.repository;

import com.example.creator.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
    // JpaRepository daje metody: save(), findAll(), findById(), deleteById()
}

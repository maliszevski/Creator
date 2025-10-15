package com.example.creator.repository;

import com.example.creator.model.RepairOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairOrderRepository extends JpaRepository<RepairOrder,Integer> {

}

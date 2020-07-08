package com.sync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sync.model.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer>{

}

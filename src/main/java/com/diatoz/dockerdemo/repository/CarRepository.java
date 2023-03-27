package com.diatoz.dockerdemo.repository;

import com.diatoz.dockerdemo.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarModel,Long> {
}

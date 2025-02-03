package com.example.new_cw.Car.repository;

import com.example.new_cw.Car.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrand(String brand);

    List<Car> findByModel(String model);

    List<Car> findByDailyPriceGreaterThan(BigDecimal price);


}

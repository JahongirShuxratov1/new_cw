package com.example.new_cw.Car;

import com.example.new_cw.Car.model.Car;
import com.example.new_cw.Car.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @GetMapping("/brand/{brand}")
    public List<Car> getCarsByBrand(@PathVariable String brand) {
        return carService.getCarsByBrand(brand);
    }

    @GetMapping("/model/{model}")
    public List<Car> getCarsByModel(@PathVariable String model) {
        return carService.getCarsByModel(model);
    }

    @GetMapping("/price-greater-than/{price}")
    public List<Car> getCarsByPriceGreaterThan(@PathVariable BigDecimal price) {
        return carService.getCarsByPriceGreaterThan(price);
    }
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {
        return carService.getCarById(id).orElse(null);
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car updatedCar) {
        return carService.updateCar(id, updatedCar);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCar(@PathVariable Long id) {
        return carService.deleteCar(id);
    }
}

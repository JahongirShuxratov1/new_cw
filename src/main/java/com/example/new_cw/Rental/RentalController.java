package com.example.new_cw.Rental;

import com.example.new_cw.Rental.model.Rental;
import com.example.new_cw.Rental.service.RentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/rentals")
public class RentalController {
    private final RentalService rentalService;
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }
    @GetMapping
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }
    @GetMapping("/{id}")
    public Rental getRentalById(@PathVariable Long id) {
        return rentalService.getRentalById(id).orElse(null);
    }
    @PostMapping
    public Rental addRental(@RequestBody Rental rental) {
        return rentalService.addRental(rental);
    }
    @PutMapping("/{id}")
    public Rental updateRental(@PathVariable Long id, @RequestBody Rental updatedRental) {
        return rentalService.updateRental(id, updatedRental);
    }

    @DeleteMapping("/{id}")
    public boolean deleteRental(@PathVariable Long id) {
        return rentalService.deleteRental(id);
    }
}

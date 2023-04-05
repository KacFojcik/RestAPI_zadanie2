package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarApi {

    private CarManager cars;

    @Autowired
    public CarApi(CarManager cars) {
        this.cars = cars;
    }

    @GetMapping("/all")
    public Iterable<Car> getAll (){
        return cars.findAll();
    }

    @GetMapping
    public Optional<Car> getById(@RequestParam long id) {
       return cars.findAllById(id);
    }

    @PostMapping
    public Car addVideo(@RequestBody Car car) {
        return cars.save(car);
    }

    @PutMapping
    public Car updateVideo(@RequestBody Car car) {
        return cars.save(car);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam long id) {
        cars.delete(id);
    }
}

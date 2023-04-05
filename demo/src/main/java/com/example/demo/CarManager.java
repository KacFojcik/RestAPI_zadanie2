package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginContext;
import java.io.CharArrayReader;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class CarManager {
    private CarRepo carRepo;

    @Autowired
    public CarManager(CarRepo carRepo) {
        this.carRepo = carRepo;
    }
    public Optional<Car> findAllById(Long id) {
        return carRepo.findById(id);
    }
    public Iterable<Car> findAll(){
        return carRepo.findAll();
    }
    public Car save(Car car){
        return carRepo.save(car);
    }
    public void delete(Long id){
        carRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDb(){
        save(new Car(1L, "BMW", "M2", LocalDate.of(2018,1,16)));
        save(new Car(2L, "Mercedes-Benz", "AMG", LocalDate.of(1988,3,3)));
    }
}

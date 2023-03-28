package com.diatoz.dockerdemo.controller;
import com.diatoz.dockerdemo.model.CarModel;
import com.diatoz.dockerdemo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/docker")
    public String Home(){
        return "Welcome to My SpringBoot Docker Home";
    }


    @GetMapping("/all/models")
    public ResponseEntity <List<CarModel>> getAllCars(){
        List<CarModel> all=carService.getAllModel();
        return new ResponseEntity<>(all, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> createModel(@RequestBody CarModel model){
        carService.createModel(model);
        return new ResponseEntity<>("CarModel entity created successfully.", HttpStatus.CREATED);
    }

    @PutMapping("/model")
    public ResponseEntity<?> updateModel(@RequestBody CarModel model){
        carService.update(model);
        return new ResponseEntity<>("CarModel entity updated successfully.", HttpStatus.CREATED);
    }

    @GetMapping("/model{id}")
    public ResponseEntity <?> getById(@RequestParam (value="id") Long id){
        Optional<CarModel> carModel=carService.getCarById(id);
        return new ResponseEntity<>(carModel, HttpStatus.OK);
    }

    @DeleteMapping("/model{id}")
    public ResponseEntity<?> deleteModel(@RequestParam(value="id") Long id){
        carService.deleteById(id);
        return new ResponseEntity<>("CarModel entity Deleted successfully.", HttpStatus.CREATED);
    }
}

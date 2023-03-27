package com.diatoz.dockerdemo.service;
import com.diatoz.dockerdemo.model.CarModel;
import com.diatoz.dockerdemo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {


    @Autowired
    private CarRepository carRepository;

    public List<CarModel> getAllModel(){
        return  carRepository.findAll();
    }

    public Optional<CarModel> getCarById(Long id){
        return carRepository.findById(id);
    }

    public CarModel update(CarModel car) {
        return carRepository.save(car);
    }

    public CarModel createModel(CarModel model){
        return carRepository.save(model);
    }

    public void deleteById(Long id){
        carRepository.deleteById(id);
    }
}

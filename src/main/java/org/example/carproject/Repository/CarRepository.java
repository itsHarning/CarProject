package org.example.carproject.Repository;

import org.example.carproject.Model.Car;
import org.example.carproject.config.InitializedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class CarRepository {

    @Autowired
    InitializedData init;

    public ArrayList<Car> getAllCars() {
        return init.carList;
    }

    public Car getCarById (int id) {
        for (Car car : init.carList) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    public void deleteCarById (int id) {
        Car car = getCarById(id);
        init.carList.remove(car);
    }

    public void save (Car car) {
        ArrayList<Car> carList = init.carList;
        int newId;

        if (carList.isEmpty()) {
            newId = 1;
        } else {
            newId = carList.getLast().getId() + 1;
        }

        car.setId(newId);

        carList.add(car);
    }
}

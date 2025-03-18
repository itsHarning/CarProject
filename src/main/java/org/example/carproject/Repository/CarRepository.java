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
}

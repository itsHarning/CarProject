package org.example.carproject.config;

import org.example.carproject.Model.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class InitData {

    private ArrayList<Car> carList = new ArrayList<>();

    public InitData() {

        // Populate the list with dummy data
        carList.add(new Car(1, "Honda", 1999, "Kei Truck", "White", "ABC123", ""));
        carList.add(new Car(2, "Ford", 1938, "SUV", "Blue", "DEF456", ""));
        carList.add(new Car(3, "VW", 1986, "Coupe", "Black", "GHI789", ""));
        carList.add(new Car(4, "Western Star", 1998, "Hatchback", "White", "JKL012", ""));
        carList.add(new Car(5, "Hyundai", 2002, "Convertible", "Silver", "MNO345", ""));
    }
}

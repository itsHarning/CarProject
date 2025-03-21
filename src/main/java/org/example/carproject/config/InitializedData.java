package org.example.carproject.config;

import org.example.carproject.Model.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class InitializedData {

    public ArrayList<Car> carList = new ArrayList<>();

    public InitializedData() {

        // Populate the list with dummy data
        carList.add(new Car(1, "Honda", 1999, "Kei Truck", "White", "ABC123", "Honda Acty Kei Truck White - 1999.png"));
        carList.add(new Car(2, "Porche", 1993, "Baja", "White", "DEF456", "Baja Porche 911 by TJ Russell.webp"));
        carList.add(new Car(3, "Scania", 2012, "Bus", "Yellow", "GHI789", "Scania Bus.jpg"));
        carList.add(new Car(4, "Lightning McQueen", 2006, "Sentient", "Red", "OWI095", "Power Wheels Lightning McQueen.jpg"));
        carList.add(new Car(5, "Hyundai", 2074, "Concept", "Silver", "MNO345", "Hyundai N Vision 1974.jpg"));
    }
}

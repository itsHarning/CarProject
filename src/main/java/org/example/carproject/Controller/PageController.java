package org.example.carproject.Controller;

import org.example.carproject.Model.Car;
import org.example.carproject.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class PageController {

    @Autowired
    CarRepository carRepository;

    @GetMapping("/")
    public String mainPage (Model model) {
        ArrayList<Car> carList = new ArrayList<>();

        carList.addAll(carRepository.getAllCars());

        model.addAttribute("carList", carList);

        return "index";
    }
}

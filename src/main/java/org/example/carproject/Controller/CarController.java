package org.example.carproject.Controller;

import org.example.carproject.Model.Car;
import org.example.carproject.Repository.CarRepository;
import org.example.carproject.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarService carService;

    @GetMapping("/getUpdateCar")
    public String updateCar(@RequestParam("id") int id, Model model) {
        Car car = carRepository.getCarById(id);
        model.addAttribute(car);
        return "updateCar";
    }

    @PostMapping("/saveUpdateCar")
    public String postUpdateCar (@RequestParam("id") int id,
                                 @RequestParam("brand") String brand,
                                 @RequestParam("modelYear") int modelYear,
                                 @RequestParam("type") String type,
                                 @RequestParam("colour") String colour,
                                 @RequestParam("licensePlate") String licensePlate) {
        String image = carService.getImage(brand, type);
        Car car = new Car(id, brand, modelYear, type, colour, licensePlate, image);
        carRepository.update(car);
        return "redirect:/";
    }

    @GetMapping("/showCar")
    public String showCar (@RequestParam("id") int id, Model model) {
        Car singleCar = carRepository.getCarById(id);
        model.addAttribute(singleCar);

        return "showCar";
    }

    @PostMapping("/deleteCar")
    public String deleteCar (@RequestParam("id") int id) {
        carRepository.deleteCarById(id);

        return "redirect:/";
    }

    @GetMapping("/getCreateCar")
    public String createCar() {
        return "createCar";
    }

    @PostMapping("/saveCreateCar")
    public String saveCar(@RequestParam("brand") String brand,
                          @RequestParam("modelYear") int modelYear,
                          @RequestParam("type") String type,
                          @RequestParam("colour") String colour,
                          @RequestParam("licensePlate") String licensePlate){
        String image = carService.getImage(brand, type);
        Car car = new Car(brand, modelYear, type, colour, licensePlate, image);
        carRepository.save(car);
        return "redirect:/";
    }
}

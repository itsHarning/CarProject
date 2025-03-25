package org.example.carproject.Service;

import org.springframework.stereotype.Service;

@Service
public class CarService {

    public String getImage(String brand, String colour) {
        String image = null;
        if (brand.contains("Honda")) {
            image = "Honda Acty Kei Truck White - 1999.png";
        } else if (brand.contains("Porche")) {
            image = "Baja Porsche 911 by TJ Russell.webp";
        } else {
            image = "generic car image.jpg";
        }
        return image;
    }
}

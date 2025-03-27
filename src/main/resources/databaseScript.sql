
DROP DATABASE IF EXISTS BilProjekt;

CREATE DATABASE BilProjekt;

USE BilProjekt;

CREATE TABLE cars (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      brand VARCHAR(100) NOT NULL,
                      modelYear INT NOT NULL,
                      type VARCHAR(100) NOT NULL,
                      colour VARCHAR(50) NOT NULL,
                      licensePlate VARCHAR(50) NOT NULL,
                      img VARCHAR(255)
);


-- Dummy data, Det er de samme objekter som bruges i InitData.
INSERT INTO cars (brand, modelYear, type, colour, licensePlate, img)VALUES
                    ('Honda', 1999, 'Kei Truck', 'White', 'ABC123', 'Honda Acty Kei Truck White - 1999.png'),
                    ('Porsche', 1993, 'Baja', 'White', 'DEF456', 'Baja Porsche 911 by TJ Russell.webp'),
                    ('Scania', 2021, 'Bus', 'Yellow', 'GHI789', 'Scania Bus.jpg'),
                    ('Lightning McQueen', 2006, 'Sentient', 'Red', 'JKL012', 'Power Wheels Lightning McQueen.jpg'),
                    ('Hyundai', 2074, 'Concept', 'Silver', 'MNO345', 'Hyundai N Vision 1974.jpg');
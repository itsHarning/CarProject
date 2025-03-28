package org.example.carproject.Repository;

import org.example.carproject.Model.Car;
import org.example.carproject.config.InitializedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class CarRepository {

//    @Autowired
//    InitializedData initializedData;

    @Autowired
    DataSource dataSource;

    public ArrayList<Car> getAllCars() {
        ArrayList<Car> carList = new ArrayList<>();
        String sql = "SELECT * FROM cars";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery())  {

            while (resultSet.next()) {
                Car car = new Car(resultSet.getInt("id"),
                        resultSet.getString("brand"),
                        resultSet.getInt("modelYear"),
                        resultSet.getString("type"),
                        resultSet.getString("colour"),
                        resultSet.getString("licensePlate"),
                        resultSet.getString("img"));
                carList.add(car);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carList;
    }


    public Car getCarById (int id) {
        Car car = new Car();
        String sql = "SELECT * FROM cars WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    car.setId(resultSet.getInt("id"));
                    car.setBrand(resultSet.getString("brand"));
                    car.setModelYear(resultSet.getInt("modelYear"));
                    car.setType(resultSet.getString("type"));
                    car.setColour(resultSet.getString("colour"));
                    car.setLicensePlate(resultSet.getString("licensePlate"));
                    car.setImage(resultSet.getString("img"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    public void deleteCarById (int id) {
        String sql = "DELETE FROM cars WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save (Car car) {
        String sql = "INSERT INTO cars (brand, modelYear, type, colour, licensePlate, img) VALUES (?, ?, ?, ?, ?, ?) ";

        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, car.getBrand());
            statement.setInt(2, car.getModelYear());
            statement.setString(3, car.getType());
            statement.setString(4, car.getColour());
            statement.setString(5, car.getLicensePlate());
            statement.setString(6, car.getImage());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update (Car updateCar) {
        String sql = "UPDATE cars SET brand = ?, modelYear = ?, type = ?, colour = ?, licensePlate = ?, img = ? WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, updateCar.getBrand());
            statement.setInt(2, updateCar.getModelYear());
            statement.setString(3, updateCar.getType());
            statement.setString(4, updateCar.getColour());
            statement.setString(5, updateCar.getLicensePlate());
            statement.setString(6, updateCar.getImage());
            statement.setInt(7, updateCar.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

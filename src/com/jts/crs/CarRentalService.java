package com.jts.crs;

import java.util.ArrayList;
import java.util.List;

public class CarRentalService {
    // A private list of Car objects, representing the inventory of cars available in the rental service
    private List<Car> cars;

    // Constructor to initialize the list of cars when a CarRentalService object is created
    public CarRentalService(){
        this.cars = new ArrayList<>();
    }

    // Method to add a Car object to the cars list
    public  void addCar(Car car){
        cars.add(car);
    }
}

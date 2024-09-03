package com.jts.crs;

public class Car {

    //instance variables
    private String carId;
    private String brand;
    private String model;
    private double pricePerDay;
    private int noOfAvailableCar;


    //getters
    public String getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public int getNoOfAvailableCar() {
        return noOfAvailableCar;
    }

    //setters
    public void setCarId(String carId) {
        this.carId = carId;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void setNoOfAvailableCar(int noOfAvailableCar) {
        this.noOfAvailableCar = noOfAvailableCar;
    }
}

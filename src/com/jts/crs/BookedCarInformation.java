package com.jts.crs;

public class BookedCarInformation {
    private Car car;
    private Customer customer;

    private int days;

    public BookedCarInformation(Car car, Customer customer, int days){

    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }
}

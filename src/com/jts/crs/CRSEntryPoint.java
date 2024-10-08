package com.jts.crs;

public class CRSEntryPoint {
    public static void main(String[] args) {

        Car toyotaCar = new Car();
        toyotaCar.setCarId("CAR-1");
        toyotaCar.setBrand("Toyota");
        toyotaCar.setModel("Fortuner");
        toyotaCar.setNoOfAvailableCar(1);
        toyotaCar.setPricePerDay(3000);

        Car bmwCar = new Car();
        bmwCar.setCarId("CAR-2");
        bmwCar.setBrand("BMW");
        bmwCar.setModel("Series 1");
        bmwCar.setNoOfAvailableCar(2);
        bmwCar.setPricePerDay(5000);

        Car mercedesCar = new Car();
        mercedesCar.setCarId("CAR-3");
        mercedesCar.setBrand("Mercedes");
        mercedesCar.setModel("Class A");
        mercedesCar.setNoOfAvailableCar(2);
        mercedesCar.setPricePerDay(4000);

        CarRentalService carRentalService = new CarRentalService();
        carRentalService.addCar(toyotaCar);
        carRentalService.addCar(bmwCar);
        carRentalService.addCar(mercedesCar);

        carRentalService.options();

    }
}

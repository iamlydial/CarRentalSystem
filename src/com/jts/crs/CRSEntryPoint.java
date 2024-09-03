package com.jts.crs;

import java.util.Scanner;

public class CRSEntryPoint {
    public static void main(String[] args) {

        Car toyotaCar = new Car();
        toyotaCar.setBrand("CAR-1");
        toyotaCar.setBrand("Toyota");
        toyotaCar.setModel("Fortuner");
        toyotaCar.setNoOfAvailableCar(1);
        toyotaCar.setPricePerDay(3000);

        Car bmwCar = new Car();
        bmwCar.setBrand("CAR-2");
        bmwCar.setBrand("BMW");
        bmwCar.setModel("Series 1");
        bmwCar.setNoOfAvailableCar(2);
        bmwCar.setPricePerDay(5000);

        Car mercedesCar = new Car();
        mercedesCar.setBrand("CAR-3");
        mercedesCar.setBrand("Mercedes");
        mercedesCar.setModel("Class A");
        mercedesCar.setNoOfAvailableCar(2);
        mercedesCar.setPricePerDay(4000);

        CarRentalService carRentalService = new CarRentalService();
        carRentalService.addCar(toyotaCar);
        carRentalService.addCar(bmwCar);
        carRentalService.addCar(mercedesCar);

        // console menu
        public void options(){
            Scanner sc = new Scanner(System.in);

            //until true
            while (true){

                System.out.println("===== Welcome to Our Car Rental System ======");
                System.out.println("1. Rent a Car");
                System.out.println("2. Return a Car");
                System.out.println("3. Available Car");
                System.out.println("4. Exit");
                System.out.println("Enter your choice: ");

                // Reads an integer input from the user and stores it in the variable choice
                int choice = sc.nextInt();

                // Clears the leftover newline from the input after reading an integer
                sc.nextLine();

                if (choice < 1 || choice > 4) {
                    throw new IllegalArgumentException("Invalid argument");
                }

                if (choice == 1){
                    System.out.println("== For Renting a Car please provide below details ==");
                    System.out.println("Enter your name: ");

                    // Reads a line of text input from the user and stores it in the variable custName
                    String customerName = sc.nextLine();

                    System.out.println("Enter Car ID you want to rent: ");
                    String carID = sc.nextLine();

                    System.out.println("Enter the number of days for rental: ");
                    int days = sc.nextInt();
                } else if (choice == 2) {
                    System.out.println("Choice 2");
                }
                sc.close();
            }
        }

    }
}

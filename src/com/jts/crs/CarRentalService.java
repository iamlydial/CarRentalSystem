package com.jts.crs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CarRentalService {
    // A private list of Car objects, representing the inventory of cars available in the rental service
    private List<Car> cars;
    private List<Customer> customers;
    private List <BookedCarInformation> bookedCarInformations;


    // Constructor to initialize the list of cars when a CarRentalService object is created
    public CarRentalService(){
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.bookedCarInformations = new ArrayList<>();
    }

    public void bookedCar(Car car, Customer customer, int days){
        if(car.getNoOfAvailableCar() >0){
            car.setNoOfAvailableCar(car.getNoOfAvailableCar() -1);
            bookedCarInformations.add(new BookedCarInformation(car, customer, days));

        } else {
            System.out.println("Car is not available for rent.");
        }
    }

    // Method to add a Car object to the cars list
    public  void addCar(Car car){
        cars.add(car);
    }

    public  void returnCar(Car car, BookedCarInformation bookedCarInformation){
        car.setNoOfAvailableCar(car.getNoOfAvailableCar() +1);
        bookedCarInformations.remove(bookedCarInformation);
    }

    // Method to add a Customer object to the customers list
    public  void addCustomer(Customer customer){
        customers.add(customer);
    }

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

                // Creates a new Customer object with a unique ID and the provided customer name
                Customer customer = new Customer("CUSTOMER-" + (customers.size() +1),customerName);
                //add customer to list
                addCustomer(customer);

// Searches for a Car object from the list of cars where the car ID matches the provided carID
                Optional<Car> optionalCar = cars.stream()
                        .filter(car -> car.getCarId().equals(carID) && car.getNoOfAvailableCar() >0)
                        .findAny(); // Finds any car that meets the criteria (car ID matches and is available)

                // Checks if the optionalCar is empty, meaning no car was found with the given ID or availability
                if(!optionalCar.isPresent()){
                    System.out.println("Car is not available. Please try to book another car");
                    // Calls the options() method again to display the menu to the user
                    options();
                    // Exits the current method, effectively returning to the menu
                    return;
                }

                Car selectedCar = optionalCar.get();

                System.out.println("=== Bill Receipt ===");
                System.out.println("Customer ID: " + customer.getId());
                System.out.println("Customer Name: " + customer.getName());
                System.out.println("Car Brand: " + selectedCar.getBrand());
                System.out.println("Rental Days: " + days);
                System.out.println("Total Price: " + selectedCar.calculatePrice(days));

                System.out.println("Confirm rental (Y/N): ");
                String confirmation = sc.next();

                if (confirmation.equalsIgnoreCase("Y")){
                    // booked a car
                    bookedCar(selectedCar, customer, days);
                    System.out.println("Car booking successful.");
                } else {
                    System.out.println("Car booking is canceled");
                }


            } else if (choice == 2) {
                System.out.println("== Return a Car ==");
                System.out.println("== Enter teh car ID you want to return  ==");
                String carId = sc.nextLine();

                Optional<Car> optionalCar = cars.stream()
                        .filter(c -> c.getCarId().equals(carId))
                        .findAny();

                if(!optionalCar.isPresent()){
                    System.out.println("Please provide a valid Car ID");
                    options();
                    return;
                }

                Car carToReturn = optionalCar.get();

                BookedCarInformation bookedCarInfo = bookedCarInformations.stream()
                        .filter(c-> c.getCar() == carToReturn)
                        .findFirst()
                        .orElse(null);

                if(bookedCarInformations == null){
                    System.out.println("Car information not available. Please provide valid details");
                    options();
                    return;
                }

                Customer cust = bookedCarInfo.getCustomer();
                returnCar(carToReturn, bookedCarInfo);
                System.out.println("Car returned successfully by " + cust.getName());
            } else if (choice == 3) {
                System.out.println("== Available cards ==");
                cars.stream()
                        .filter(c -> c.getNoOfAvailableCar() > 0)
                        .forEach(car -> System.out.println(car.getCarId() + " - " + car.getBrand() + " - " + car.getModel() + " available cars = " + car.getNoOfAvailableCar()));
            }  else {
                System.out.println("Thank you for choosing us.");
                break;
            }

        }
        sc.close();
    }
}

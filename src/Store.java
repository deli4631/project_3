import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Store implements Subject{
    private ArrayList<Observer> observers;
    public ArrayList<RentalRecords> records_;
    private int recordsPos_;
    private ArrayList<Car> inventory_;
    double totalProfit;
    int completedRecords;

    public Store(){
        observers = new ArrayList<>();
        inventory_ = new ArrayList<>();
        records_ = new ArrayList<>();
        recordsPos_ = 0;
        createInventory();
        totalProfit = 0;
        completedRecords = 0;
    }

    public void recordLayout(boolean isCompleted){
        DecimalFormat df = new DecimalFormat("#.##");
        for (RentalRecords r : records_) {
            if (r.complete == isCompleted) {

                System.out.println("\t - " + r + ":");
                System.out.println("\t\t - Rented by " + r.customerName);
                for (Car c : r.carsRented) {
                    System.out.println("\t\t - Car type: " + c.getCarType() + " license plate: " + c.getLicensePlate());
                }
                System.out.println("\t\t - Rental Period: " + r.rentalPeriod);
                System.out.println("\t\t - Payment for the rental: $" + df.format(r.Payment));
            }
        }
    }

    public void display(){
        System.out.println("----------");
        System.out.println("Summary: ");
        System.out.println("----------");
        System.out.println(("Number of completed records: " + completedRecords));
        if(completedRecords != 0){
            System.out.println("Completed Records: ");
            recordLayout(true);
        }
        int numActiveRecords = 0;
        for(int i = 0; i < records_.size(); ++i){
            if(!(records_.get(i).complete)){
                numActiveRecords++;
            }
        }
        System.out.println("Number of active records: " + numActiveRecords);
        if(numActiveRecords != 0){
            System.out.println("Active Records: ");
            recordLayout(false);
        }
        System.out.println("Current number of cars in inventory: " + inventory_.size());
        if(inventory_.size() != 0){
            System.out.println("Current cars in inventory: ");
            for(Car c : inventory_){
                System.out.println("\t - Type of car: " + c.getCarType() + " " + c.getLicensePlate());
            }
        }
    }

    public void checkRecords(){
        if(records_.size() != 0) {
            for (RentalRecords record : records_) {
                if(!(record.complete)) {
                    record.xMoreDays--;
                    if (record.xMoreDays == 0) {
                        returnRentals(record.customer);
                        for(RentalRecords r : records_){
                            if(record.customer.getName() == r.customer.getName()){
                                r.complete = true;
                                completedRecords++;
                            }
                        }
                    }
                }
            }
        }
    }

    // With ever action/change to the record, it will notify the logger (observer pattern)
    // the simulation will pass a customer to the store and will help the customers with there
    // if the inventory is 0, if the customer has <= 3 cars, if their is a match + the customer only has 3 cars +
    // the records size of car is < the car request size then we can add the car to the records for the
    // customer to rent it. Will return bool if there was a car found
    // and will update the records
    public boolean helpCustomerFindCar(Customer customer){

        if(inventory_.size() != 0) {
            boolean canRent = false;
            if(customer.getType() == "business" && customer.getRentStatus()){
                return false;
            }
            RentalRecords record = new RentalRecords();
            record.customerName = customer.getName();
            for (int car_index = 0;  car_index < customer.getNumOfRentalRequest(); car_index++) {
                for (int i = 0; i < inventory_.size(); i++) {
                    if(inventory_.get(i).getCarType() == customer.getCarRequest().get(car_index)
                            && customer.getNumOfCarsRented() < 3){
                        Car c = inventory_.remove(i);
                        record.carsRented.add(c);
                        customer.getCarsRented().add(c);
                        canRent = true;
                        break;
                    }
                }
            }
            if(canRent) {
                notifyObserver(customer.getName());
                record.customer = customer;
                records_.add(record);
                customer.setRentStatus(true);
                return true;
            }
        }

        return false;
    }

    // will just update the records, so how long the customer is renting the car observer
    public void rentalTime(Customer customer){
        records_.get(recordsPos_).rentalPeriod = customer.getDays();
        records_.get(recordsPos_).xMoreDays = customer.getDays();
        notifyObserver(customer.getDays());
    }

    // addOn will decorate the car and report it to the reports and will also notify the observer
    public void addOn(Customer customer) {
        List<String> addOns = customer.getAccessories();
        for (Car c : records_.get(recordsPos_).carsRented) {
            CarDecorator carWithAddOns = new CarDecorator(c);
            for (String a : addOns) {
                if (a == "carSeat") {
                    carWithAddOns = new CarSeat(carWithAddOns);
                } else if (a == "GPS") {
                    carWithAddOns = new GPS(carWithAddOns);
                } else if (a == "sat") {
                    carWithAddOns = new SatelliteRadio(carWithAddOns);
                } else {
                    System.out.println("ERROR");
                }
            }
            records_.get(recordsPos_).DecoratedCars.add(carWithAddOns);
        }
        notifyObserver(records_.get(recordsPos_).DecoratedCars, customer.getAccessories());
    }

    // Will calculate how much the user needs to pay upfront and will notify the observer
    public void totalPayment(Customer customer){
        int days = records_.get(recordsPos_).rentalPeriod = customer.getDays();
        double payout = 0.0;

        for(CarDecorator c : records_.get(recordsPos_).DecoratedCars){
            payout += (c.price() * days);
            totalProfit += payout;
        }
        records_.get(recordsPos_).Payment = payout;

        notifyObserver(payout);
        recordsPos_++;
    }

    // Creates all the store inventory
    // makes sure has 2 of everything and randomly generates cars after that
    public void createInventory(){
        List<String> carTypes = Arrays.asList("Economy", "Standard", "Luxury", "SUV", "Minivan");

        for(String c : carTypes){
            for(int i = 0; i < 2; i++){
                inventory_.add(CarFactory.getCar(c));
            }
        }
        while(inventory_.size() < 24){
            inventory_.add(CarFactory.getCar(carTypes.get(ThreadLocalRandom.current().nextInt(0,5))));
        }
    }

    public void returnRentals(Customer customer){
        while(customer.getCarsRented().size() > 0){
            Car c = customer.getCarsRented().remove(0);
            System.out.println(customer.getName() + " has returned " + c.getCarType() + " " + c.getLicensePlate());
            inventory_.add(c);
        }
        customer.setRentStatus(false);
    }

    //getters
    public List<Car> getInventory(){
        return inventory_;
    }

    public double getTotalProfit(){
        return totalProfit;
    }

    public int getCompletedRecords(){
        return completedRecords;
    }

    public List<RentalRecords> getRecords(){
        return records_;
    }

    // creates a recorder which is our observer
    public void construct(Observer o) {
        observers.add(o);
    }

    // deletes a recorder
    public void deconstruct(Observer o) {
        observers.remove(o);
    }

    /***
     * Each time a customer comes into the store, rental records is created that
     * will keep track of what cars they rented and how many nights they will keep the cars
     */
    public void notifyObserver(String customerName) {
        for(Observer o : observers){
            o.update(customerName);
        }
    }

    public void notifyObserver(int rentalPeriod){
        for(Observer o : observers){
            o.update(rentalPeriod);
        }
    }

    public void notifyObserver(ArrayList<CarDecorator> carsRented, List<String> accessories){
        for(Observer o : observers){
            o.update(carsRented, accessories);
        }
    }

    public void notifyObserver(Double final_cost){
        for(Observer o : observers){
            o.update(final_cost);
        }
    }
}

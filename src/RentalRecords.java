import java.util.*;

public class RentalRecords {
    Customer customer;
    String customerName;
    ArrayList<Car> carsRented;
    ArrayList<CarDecorator> DecoratedCars;
    double Payment;
    int rentalPeriod;
    Boolean complete;
    int xMoreDays;

    public RentalRecords(){
        customerName = "";
        carsRented = new ArrayList<>();
        DecoratedCars = new ArrayList<>();
        Payment = 0.0;
        rentalPeriod = 0;
        xMoreDays = 0;
        complete = false;
    }
}

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;


public abstract class Customer {
    protected String type; // the type of the customer

    private String name; // name of the customer
    private List<String> accessories_; // what kind of add-ons
    private List<String> carRequest_; // what kind of cars the customer is requesting
    private List<Car> carsRented; // the cars that are currently rented

    private int days; // number of days the cars are being rented out for
    private int numOfRentalRequest; // number of cars the customer is requesting

    private boolean isRenting;


//    behavior that varies
    public RentalDays rentalType;
    public CarAmount amountType;


    public Customer(String name){
        this.name = name;

        this.accessories_ = new LinkedList<>();
        this.carRequest_ = new LinkedList<>();
        this.carsRented = new LinkedList<>();

        this.days = 0;
        this.numOfRentalRequest = 0;
        this.isRenting = false;


    }

    //getters

    public String getName(){
        return name;
    }

    public int getDays(){ return this.days; }

    public String getType(){
        return this.type;
    }

    public List<String> getCarRequest(){ return carRequest_; }

    public int getNumOfRentalRequest() { return numOfRentalRequest; }

    public List<String> getAccessories(){ return accessories_; }

    public int getNumOfCarsRented (){ return carsRented.size(); }

    public List<Car> getCarsRented(){ return carsRented; }



    public boolean getRentStatus(){ return isRenting; }

    // setters

    // uses the strategy implementation
    public void setDays(){ this.days =  rentalType.rentalDays(); }

    public void setNumOfRentals(){
        this.numOfRentalRequest = amountType.carAmount();
    }



    public void setRentStatus(boolean status) { this.isRenting = status; }

    // sets a specific cars the customer wants
    public void setCarRequest(){
        List<String> carTypes = Arrays.asList("Economy", "Standard", "Luxury", "SUV", "Minivan");
        carRequest_ = new LinkedList<>();
        for (int i = 0; i < numOfRentalRequest; i++) {
            this.carRequest_.add(carTypes.get(ThreadLocalRandom.current().nextInt(0,5)));
        }
    }

    // set a specific accessories the customers wants
    public void addAccessories(){
        List<String> accessories = new LinkedList<>();

        //add child car seats 0-4
        int carSeat = ThreadLocalRandom.current().nextInt(0,5);
        for(int i = 0; i < carSeat; i++){
            accessories.add("carSeat");
        }

        //add GPS module 0-1
        int gps = ThreadLocalRandom.current().nextInt(0, 2);
        for(int i = 0; i < gps; i++){
            accessories.add("GPS");
        }

        //ad satellite radio 0-1
        int sat = ThreadLocalRandom.current().nextInt(0, 2);
        for(int i = 0; i < sat; i++){
            accessories.add("sat");
        }

        accessories_ = accessories;
    }
}

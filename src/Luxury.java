public class Luxury extends Car {

    private String licensePlate;
    private String carType;

    public Luxury(String licensePlate, String carType){

        this.licensePlate = licensePlate;
        this.carType = carType;
    }
    //returns the unique license plate number
    @Override
    public String getLicensePlate(){
        return this.licensePlate;
    }
    //returns the car type
    @Override
    public String getCarType(){
        return this.carType;
    }
    //returns the cost of the Luxury base rental
    @Override
    public double price(){
        return 1100.00;
    }
//    @Override
//    public void assemble() {
//        System.out.print("with");
//    }
}

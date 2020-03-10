public class Minivan extends Car {

    private String licensePlate;
    private String carType;

    public Minivan(String licensePlate, String carType){
        this.licensePlate = licensePlate;
        this.carType = carType;

    }

    //returns the unique license plate number
    @Override
    public String getLicensePlate(){
        return licensePlate;
    }
    //returns the car type
    @Override
    public String getCarType(){
        return carType;
    }
    //returns the cost of the Minivan base rental
    @Override
    public double price(){
        return 500.00;
    }
    //    @Override
//    public void assemble() {
//        System.out.print("Minivan with " + licensePlate);
//    }
}

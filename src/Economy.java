public class Economy extends Car {

    private String licensePlate;
    private String carType;

    public Economy(String licensePlate, String carType){
        this.licensePlate = licensePlate;
        this.carType = carType;
    }

    //get the unique license plate for the car
    @Override
    public String getLicensePlate(){
        return this.licensePlate;
    }
    //returns the car type "Economy"
    @Override
    public String getCarType(){
        return this.carType;
    }
    //returns the cost of the Economy base rental
    @Override
    public double price(){
        return 300.00;
    }

//    @Override
//    public void assemble() {
//        System.out.print("with");
//    }
}

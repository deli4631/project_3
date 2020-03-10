public class SUV extends Car {

    private String licensePlate;
    private String carType;

    public SUV(String licensePlate, String carType){
        this.licensePlate = licensePlate;
        this.carType = carType;
    }

    //returns the car rental type
    @Override
    public String getLicensePlate(){
        return this.licensePlate;
    }
    //returns the car rental type
    @Override
    public String getCarType(){
        return this.carType;
    }
    //returns the cost of the SUV base rental
    @Override
    public double price(){
        return 900.00;
    }
    //    @Override
//    public void assemble() {
//        System.out.print("with");
//    }
}

public class Standard extends Car {

    private String licensePlate;
    private String carType;

    public Standard(String licensePlate, String carType){

        this.licensePlate = licensePlate;
        this.carType = carType;
    }
    //returns the license plate number for the rental
    @Override
    public String getLicensePlate(){
        return this.licensePlate;
    }
    //returns teh car rental type
    @Override
    public String getCarType(){
        return this.carType;
    }
    //returns the cost of the Standard base rental
    @Override
    public double price(){
        return 400.00;
    }
    //    @Override
//    public void assemble() {
//        System.out.print("with");
//    }
}


public abstract class Car implements CarInterface{

    public abstract String getLicensePlate();
    public abstract String getCarType();


    ///LicensePlate
    //returns when rental car is created

    @Override
    public String toString(){
        return "The " + this.getCarType() + " has license plate number " + this.getLicensePlate();
    }
    //basic rental type output with options
    @Override
    public String assemble() {
        return "The " + this.getCarType() + " with license plate " + this.getLicensePlate();
    }
    //standard price for rental
    @Override
    public double price(){
        return 400.00;
    }

}


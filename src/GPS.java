public class GPS extends CarDecorator{

    public GPS(CarInterface car){
        super(car);
    }
    //returns the addition of the GPS package
    public String assemble(){
        return car.assemble() + addGPS();
    }
    private String addGPS(){
        return " GPS package ";
    }

    //returns the cost of adding the GPS to the rental
    public double price(){
        return car.price() + GPS_cost();
    }
    private double GPS_cost(){
        return 20.51;
    }
}

public class CarSeat extends CarDecorator{

    public CarSeat(CarInterface car){
        super(car);
    }

    //returns the type of option "car seat" to the decorator
    public String assemble(){
        return car.assemble() + addCarSeat();
    }
    private String addCarSeat(){
        return " child car seat ";
    }
    //adds the price for the option to the total rental cost
    public double price(){
        return car.price() + carSeat_price();
    }
    private double carSeat_price(){
        return 22.52;
    }

}

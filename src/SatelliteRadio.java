public class SatelliteRadio extends CarDecorator{

    public SatelliteRadio(CarInterface car){
        super(car);
    }
    //returns the radio options for the rental
    public String assemble(){
        return car.assemble() + addRadio();
    }
    private String addRadio(){
        return " satellite radio package ";
    }

    //returns the price of the radio option
    public double price(){
        return car.price() + satelliteRadio_Price();
    }
    private double satelliteRadio_Price(){
        return 20.50;
    }

}

public class CarDecorator implements CarInterface{
    protected CarInterface car;

    public CarDecorator(CarInterface car){
        this.car = car;
    }
    //assembles all the rental options
    @Override
    public String assemble() {
        return car.assemble();
    }
    //return the price of all rental options
    @Override
    public double price(){
        return car.price();
    }
}

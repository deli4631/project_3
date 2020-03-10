public class TestFactory {

    public static void main(String[] args) {
        //creates new rental cars
        //one of each type
        Car economy = CarFactory.getCar("Economy");
        Car standard = CarFactory.getCar("Standard");
        Car luxury = CarFactory.getCar("Luxury");
        Car SUV = CarFactory.getCar("SUV");
        Car minivan = CarFactory.getCar("Minivan");
        //returns a license plate number
        System.out.println("License Plate is " + LicensePlate.licensePlateGen());
        //shows the output from the toString in Car.java
        System.out.println("Factory economy Config::" + economy);
        System.out.println("Factory standard Config::" + standard);
        System.out.println("Factory luxury Config::" + luxury);
        System.out.println("Factory SUV Config::" + SUV);
        System.out.println("Factory minivan Config::" + minivan);

        //the price decorator output is just the cost of the rental with no options
        assert minivan != null;
        System.out.println(minivan.price());
        //assembly with no options returns the assemble string in car.java
        System.out.println(minivan.assemble());
        //example of wrapping two options onto a car, economy is this example
        CarInterface basic = new GPS(new SatelliteRadio(economy));
        System.out.println(basic.assemble() + basic.price());
        //If two car seats are wanted the output will return two strings of car seats (car seat car seat)
        CarDecorator option2 = new CarSeat( new CarSeat( new SatelliteRadio(luxury)));
        System.out.println(option2.assemble() + " rental cost per day " + option2.price());
        CarDecorator option3 = new CarDecorator(luxury);
        option3 = new CarSeat( new CarSeat( new SatelliteRadio(option3)));
        System.out.println(option3.assemble() + " rental cost per day " + option3.price());
        //1165.54
    }

}
public class CarFactory {


    public static Car getCar(String type){
//        if("economy".equalsIgnoreCase(type)) return new Economy(licencePlate);
//        return null;
        //check which car type is being rented
        //passes type and license plate number
        String licensePlate = LicensePlate.licensePlateGen();
        switch(type) {
            case "Economy":
                return new Economy(licensePlate, type);
            case "Standard":
                return new Standard(licensePlate, type);
            case "Luxury":
                return new Luxury(licensePlate, type);
            case "SUV":
                return new SUV(licensePlate, type);
            case "Minivan":
                return new Minivan(licensePlate, type);
            default:
                System.out.println("That car choice is not available at this dealership.");
                return null;
        }

    }
}

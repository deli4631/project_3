public abstract class LicensePlate {


    private static int i = 1;
//    private static String licenseNumber;
    protected static String licensePlateGen() {

        //create a random license plate number
        //the license plate will be in from ABC###
        StringBuilder licensePlate = new StringBuilder();
        //create the ABC part
        for (int i = 0; i < 3; i++){
            char license_letter = (char) (Math.random() * 26 + 'A');
            licensePlate.append(license_letter);
        }

//        String licenseNumber = i.toString();
        //generate the number portion of the license plate the car number
        if (i < 10) {
//            System.out.println(i);
            String licenseNumber = String.format("%03d", i);
            licensePlate.append(licenseNumber);
        }else if (i < 100){
            String licenseNumber = String.format("%03d", i);
            licensePlate.append(licenseNumber);
        }else{
            licensePlate.append(i);
        }
        i = i + 1;
//        for (int i = 0; i < 3; i++){
//            char license_number = (char) (Math.random() * 10 + '0');
//            licensePlate.append(license_number);
//        }
        return licensePlate.toString();
    }
}

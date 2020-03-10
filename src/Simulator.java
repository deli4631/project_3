import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;
import java.text.DecimalFormat;


public class Simulator {
    public static void main(String[] args) throws FileNotFoundException {
        // initializing our customers, making sure that we have 2 of each
        // then randomly picks

        PrintStream o = new PrintStream(new File("sim.out"));
        System.setOut(o);

        List<Customer> customerList = new ArrayList<>();

        List<String> types = Arrays.asList("casual", "regular", "business");
        int names = 0;
        for(int i = 0 ; i < 2; i++){
            customerList.add(new RegularCustomer(new Integer(names++).toString()));
            customerList.add(new CasualCustomer(new Integer(names++).toString()));
            customerList.add(new BusinessCustomer(new Integer(names++).toString()));
        }

        while(customerList.size() < 12){
            int randNum = ThreadLocalRandom.current().nextInt(0,3);
            String choice = types.get(randNum);
//            new Integer(names++).toString();

            if(choice == "casual"){
                customerList.add(new CasualCustomer(new Integer(names++).toString()));
            } else if(choice == "regular"){
                customerList.add(new RegularCustomer(new Integer(names++).toString()));
            } else if(choice == "business"){
                customerList.add(new BusinessCustomer(new Integer(names++).toString()));
            } else {
                System.out.println("INVALID Input");
            }
        }


        Store store = new Store();
        Recorder log = new Recorder(store);
        boolean found;
        for(int day = 1; day <= 35; day++){
            System.out.println("Day: " + day);
            System.out.println("====================================================================================" +
                    "======================================================================");


            store.display();

            if(store.getInventory().size() != 0){
                int randNum = ThreadLocalRandom.current().nextInt(0,12);

                for(int j = 0; j < randNum; j++){
                    int pickCustomer = ThreadLocalRandom.current().nextInt(0,12);
                    Customer chosen = customerList.get(pickCustomer);
                    chosen.setDays();
                    chosen.setNumOfRentals();
                    chosen.setCarRequest();
                    chosen.addAccessories();
                    found = store.helpCustomerFindCar(chosen);
                    if(found){
                        store.rentalTime(chosen);
                        store.addOn(chosen);
                        store.totalPayment(chosen);
                    }
                }
            }
            else{
                System.out.println("Store is currently closed due to empty inventory, please come back again!");
            }
            store.checkRecords();
            System.out.println("====================================================================================" +
                    "======================================================================");
        }
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("----------------------------");
        System.out.println("End Simulation Summary:");
        System.out.println("----------------------------");
        System.out.println("Total number of rentals: " + store.getRecords().size());
        for(RentalRecords r : store.getRecords()){
            System.out.println("Record: " + r + " customer: " + r.customerName + " " + r.customer.getType());
        }
        System.out.println("Total Profit made from the simulation: " + df.format(store.getTotalProfit()));
    }
}

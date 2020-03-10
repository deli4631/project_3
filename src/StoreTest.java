import java.util.*;

public class StoreTest {
    public static void main(String[] args) {
        Customer jimmy = new BusinessCustomer("Jimmy");
        // for loop simulation
        // simulation pick user
        // user will specific state
        jimmy.setDays();
        jimmy.setNumOfRentals();
        jimmy.setCarRequest();
        jimmy.addAccessories();

        // then pass those a

        Store store = new Store();
        Recorder log = new Recorder(store);

        boolean found = store.helpCustomerFindCar(jimmy);
        if(found){
            System.out.println(jimmy.getCarRequest());
            store.rentalTime(jimmy);
            System.out.println(jimmy.getAccessories());
            store.addOn(jimmy);
            store.totalPayment(jimmy);
        }

        jimmy.setDays();
        jimmy.setNumOfRentals();
        jimmy.setCarRequest();
        jimmy.addAccessories();

        found = store.helpCustomerFindCar(jimmy);
        System.out.println("found: " + found);
        if(found){
            System.out.println(jimmy.getCarRequest());
            store.rentalTime(jimmy);
            System.out.println(jimmy.getAccessories());
            store.addOn(jimmy);
            store.totalPayment(jimmy);
        }
        System.out.println(jimmy.getCarsRented());
//        System.out.println("number of cars "+ jimmy.getCarsRented().size());
//        System.out.println(store.getInventory());
//        System.out.println(store.getInventory().size());
////        store.returnRentals(jimmy);
//        System.out.println(store.getInventory());
//        System.out.println(store.getInventory().size());
//        store.checkRecords();
//        store.checkRecords();
//        store.checkRecords();
//        System.out.println(store.records_);
//        store.display();
//        System.out.println(jimmy.getCarsRented().size());

        store.deconstruct(log);
    }
}

public class CustomerTest {
    public static void main(String[] args){
        Customer jan = new CasualCustomer("Jan");
        Customer pat = new BusinessCustomer("Patrick");
        Customer den = new RegularCustomer("Dennis");

        jan.setDays();
        System.out.println("Jan days:" + jan.getDays());
        System.out.println("Jan days:" + jan.getDays());
        System.out.println("Pat days:" + pat.getDays());
        System.out.println("Den days:" + den.getDays());
        System.out.println("Test " + den.getDays());

    }


}

/*
    public Customer customerCreator(String name, String type){
        Customer customer;
        if(type == "casual") {
            customer = new CasualCustomer(name);
        } else if(type == "business") {
            customer = new BusinessCustomer(name);
        } else {
            customer = new RegularCustomer(name);
        }

        customer.getDays();
        customer.getRentalPeriod();

        return customer;
    }
 */
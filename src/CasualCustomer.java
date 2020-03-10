public class CasualCustomer extends Customer{

    public CasualCustomer(String name){
        super(name);
        this.type = "casual";

        rentalType = new ThreeDays();
        amountType = new OneCar();


    }


}

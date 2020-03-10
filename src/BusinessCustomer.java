public class BusinessCustomer extends Customer{

    public BusinessCustomer(String name){
        super(name);
        this.type = "business";
        rentalType = new SevenDays();
        amountType = new ThreeCars();
    }
}

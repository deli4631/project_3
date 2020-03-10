public class RegularCustomer extends Customer{

    public RegularCustomer(String name){
        super(name);
        this.type = "regular";
        rentalType = new FiveDays();
        amountType = new UpToThree();
    }
}

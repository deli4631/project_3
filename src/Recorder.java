import java.text.DecimalFormat;
import java.util.*;


public class Recorder implements Observer{

    private Subject Store;

    public Recorder(Subject Store){
        this.Store = Store;
        this.Store.construct(this);
    }

    public void update(String customer) {
        System.out.println(
                "**************************************************************************************************" +
                        "**************"
        );

        System.out.println("Customer name: " + customer);
    }

    public void update(int rentalPeriod){
        System.out.println("Number of days the customer is going to rent the car(s): " + rentalPeriod);
    }

    public void update(ArrayList<CarDecorator> carsRented, List<String> accessories){
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Accessories: "+ accessories);
        for(CarDecorator c: carsRented){
            System.out.println(c.assemble() + " rental cost per day $" + df.format(c.price()));
        }
    }

    public void update(double final_cost){

        DecimalFormat df = new DecimalFormat("#.##");


        System.out.println("Total Cost: $" +  df.format(final_cost));
        System.out.println(
                "**************************************************************************************************" +
                        "**************"
        );
    }

}

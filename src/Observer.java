import java.util.*;


public interface Observer {
    public void update(String customer);
    public void update(int rentalPeriod);
    public void update(ArrayList<CarDecorator> carsRented, List<String> accessories);
    public void update(double final_cost);
}

// interface for our subject which is the store,
// will have to implement the construct, deconstruct, and notifyObserver
import java.util.*;

public interface Subject {
    public void construct(Observer o);
    public void deconstruct(Observer o);
    public void notifyObserver(String Customer);
    public void notifyObserver(int rentalPeriod);
    public void notifyObserver(ArrayList<CarDecorator> carsRented, List<String> accessories);
    public void notifyObserver(Double final_cost);
}
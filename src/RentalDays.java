import java.util.concurrent.ThreadLocalRandom;


public interface RentalDays {
    int rentalDays();


}

class SevenDays implements RentalDays{
    public int rentalDays(){
        return 7;
    }
}

class ThreeDays implements RentalDays{
    public int rentalDays(){
        return ThreadLocalRandom.current().nextInt(1,4);
    }
}

class FiveDays implements RentalDays{
    public int rentalDays(){
        return ThreadLocalRandom.current().nextInt(3,6);
    }
}
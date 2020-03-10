import java.util.concurrent.ThreadLocalRandom;

public interface CarAmount {
    int carAmount();
}


class OneCar implements CarAmount{
    public int carAmount(){
        return 1;
    }
}

class ThreeCars implements CarAmount{
    public int carAmount(){
        return 3;
    }
}

class UpToThree implements CarAmount{
    public int carAmount(){
        return ThreadLocalRandom.current().nextInt(1,4);
    }
}
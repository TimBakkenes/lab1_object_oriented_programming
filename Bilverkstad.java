import java.util.ArrayList;
import java.util.List;

public class Bilverkstad<T extends Car> {

    public List<T> cars = new ArrayList<T>();
    private final int capacity;

    public Bilverkstad(int capacity){
        this.capacity = capacity;
    }

    public void dropOff(T car){
        if (cars.size() < capacity) {
            cars.add(car);
        } else {
            System.out.println("No capacity");
        }
    }

    public T pickUp(T car){
        if (cars.contains(car)){
            cars.remove(car);
            return car;
        } else {
            return null;
        }
    }
}

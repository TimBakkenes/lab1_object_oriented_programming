package WithComposition;

import WithComposition.Vehicles.Position;
import WithComposition.Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class AutoShop<T extends Vehicle> implements DrawAble {

    public List<T> cars = new ArrayList<>();
    private final int capacity;
    private final String image;
    private final Position pos = new Position(0, 0);


    public AutoShop(int capacity){
        this.capacity = capacity;
        this.image = "pics/VolvoBrand.jpg";
    }

    public String getImage() {
        return image;
    }

    public void setPosition(double x, double y) {
        pos.setPosition(x, y);
    }

    public Position getPosition() {
        return pos;
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

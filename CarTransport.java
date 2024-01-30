import java.awt.*;
import java.util.Stack;

public class CarTransport extends Truck{

    private int capacity;

    private Stack<Car> cargo = new Stack<>();

    public CarTransport(int nrDoors, Color color, double enginePower, String modelName, int capacity){
        super(nrDoors, color, enginePower, modelName);
        this.capacity = capacity;
    }

    public void pivotUp(){

        //använd klassvariabel och max ist
        setPlatformAngle(maxAngle);
    }

    public void pivotDown(){
        if (getCurrentSpeed() == 0){
            setPlatformAngle(minAngle);
        } else {
            System.out.println("Cannot lower ramp while driving");
        }

    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * ((double) (capacity - cargo.size() + 1) / capacity);
    }


    private boolean canLoadCargo(Car car){
        return getPlatformAngle() == 70 && cargo.size() < capacity && !(car instanceof CarTransport)
                && car.getPosition().distance_to_other_position(this.getPosition()) < 10;
    }

    public void loadCargo(Car car){
        if (canLoadCargo(car)) {
            Position carTransportPosition = this.getPosition();
            car.setPosition(carTransportPosition.get_x(), carTransportPosition.get_y());
            cargo.push(car);
        } else {
            System.out.println("Unable to load cargo now");
        }
    }

    public Car unloadCargo(){
        if (getPlatformAngle() == 70) {
            Car car = cargo.pop();
            car.setPosition(this.getPosition().get_x() + 5, this.getPosition().get_y());
            return car;
        } else {
            System.out.println("Unable to unload cargo now");
            return null;
        }
    }

    public int getCargoSize(){
        return cargo.size();
    }

    @Override
    public void move(){
        super.move();
        Position carTransportPos = this.getPosition();
        for (Car car : cargo){
            car.setPosition(carTransportPos.get_x(), carTransportPos.get_y());
        }
    }

}

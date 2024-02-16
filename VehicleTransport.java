import java.awt.*;
import java.util.Stack;

public class VehicleTransport extends TruckI {

    private int capacity;

    private Stack<Vehicle> cargos = new Stack<>();

    public VehicleTransport(int nrDoors, Color color, double enginePower, String modelName, int capacity){
        super(nrDoors, color, enginePower, modelName);
        this.capacity = capacity;
    }

    public void pivotUp(){
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
        return getEnginePower() * 0.01 * ((double) (capacity - cargos.size() + 1) / capacity);
    }


    private boolean canLoadCargo(Vehicle vehicle){
        return getPlatformAngle() == 70 && cargos.size() < capacity && !(vehicle instanceof VehicleTransport)
                && vehicle.getPosition().distanceToOtherPosition(this.getPosition()) < 10;
    }

    public void loadCargo(Vehicle vehicle){
        if (canLoadCargo(vehicle)) {
            Position carTransportPosition = this.getPosition();
            vehicle.setPosition(carTransportPosition.getX(), carTransportPosition.getY());
            cargos.push(vehicle);
        } else {
            System.out.println("Unable to load cargo now");
        }
    }

    public Vehicle unloadCargo(){
        if (getPlatformAngle() == 70) {
            Vehicle vehicle = cargos.pop();
            vehicle.setPosition(this.getPosition().getX() + 5, this.getPosition().getY());
            return vehicle;
        } else {
            System.out.println("Unable to unload cargo now");
            return null;
        }
    }

    public int getCargoSize(){
        return cargos.size();
    }

    @Override
    public void move(){
        super.move();
        Position carTransportPos = this.getPosition();
        // TODO: hur hanterar vi detta med polymorfismen här?
        for (Vehicle vehicle : cargos){
            vehicle.setPosition(carTransportPos.getX(), carTransportPos.getY());
        }
    }

}

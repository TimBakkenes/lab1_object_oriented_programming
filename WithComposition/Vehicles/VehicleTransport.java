package WithComposition.Vehicles;

import java.awt.*;
import java.util.Stack;

public class VehicleTransport implements Truck {

    private final Cargo<Stack<Vehicle>, Integer> cargo;
    private final TruckHelper truckHelper;

    public VehicleTransport(int capacity){
        Stack<Vehicle> cargoType = new Stack<>();
        this.cargo = new Cargo<>(cargoType, capacity);
        this.truckHelper = new TruckHelper(2, 500, Color.blue, "VehicleTransport", 0, 0, 70);
        this.truckHelper.stopEngine();
        this.setImage("pics/Scania.jpg");
    }

    public String getImage() {
        return truckHelper.getImage();
    }

    public void setImage(String path) {
        truckHelper.setImage(path);
    }

    public int getNrDoors(){
        return truckHelper.getNrDoors();
    }

    public String getModelName(){
        return truckHelper.getModelName();
    }

    public double getEnginePower(){
        return truckHelper.getEnginePower();
    }

    public double getCurrentSpeed(){
        return truckHelper.getCurrentSpeed();
    }

    public void setCurrentSpeed(double speed){
        truckHelper.setCurrentSpeed(speed);
    }

    public Color getColor(){
        return truckHelper.getColor();
    }

    public void setColor(Color clr){
        truckHelper.setColor(clr);
    }

    public void startEngine(){
        if (truckHelper.getPlatformAngle() == truckHelper.getMinPlatformAngle()){
            truckHelper.startEngine();
        } else {
            System.out.println("Cannot start engine with platform up");
        }
    }

    public void stopEngine(){
        truckHelper.stopEngine();
    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * ((double) (cargo.capacity - cargo.contents.size() + 1) / cargo.capacity);
    }

    public void incrementSpeed(double amount){
        double new_speed = Math.min(getCurrentSpeed() + speedFactor()*amount, getEnginePower());
        setCurrentSpeed(new_speed);
    }

    public void decrementSpeed(double amount){
        double new_speed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
        setCurrentSpeed(new_speed);
    }

    public void gas(double amount){
        if (truckHelper.getPlatformAngle() == 0){
            if (truckHelper.gasCheck(amount)) {
                incrementSpeed(amount);
            }
        } else {
            System.out.println("Cannot gas with ramp up");
        }
    }

    public void brake(double amount){
        if (truckHelper.brakeCheck(amount)) {
            decrementSpeed(amount);
        }
    }

    public void turnLeft(double degrees){
        truckHelper.turnLeft(degrees);
    }

    public void turnRight(double degrees){
        truckHelper.turnRight(degrees);
    }

    public Position getPosition(){
        return truckHelper.getPosition();
    }

    public double getDirection(){
        return truckHelper.getDirection();
    }

    public void setPosition(double x, double y){
        truckHelper.setPosition(x, y);
    }

    public void pivotUp(){
        truckHelper.cargoBed.setPlatformAngle(truckHelper.getMaxPlatformAngle());
    }

    public void pivotDown(){
        if (getCurrentSpeed() == 0){
            truckHelper.cargoBed.setPlatformAngle(truckHelper.getMinPlatformAngle());
        } else {
            System.out.println("Cannot lower ramp while driving");
        }
    }

    private boolean platformUp() {
        return truckHelper.getPlatformAngle() == truckHelper.getMaxPlatformAngle();
    }

    private boolean canLoadCargo(Vehicle vehicle){
        return platformUp() && cargo.contents.size() < cargo.capacity && !(vehicle instanceof VehicleTransport)
                && vehicle.getPosition().distanceToOtherPosition(this.getPosition()) < 10;
    }

    public void loadCargo(Vehicle vehicle){
        if (canLoadCargo(vehicle)) {
            Position carTransportPosition = this.getPosition();
            vehicle.setPosition(carTransportPosition.getX(), carTransportPosition.getY());
            cargo.contents.push(vehicle);
        } else {
            System.out.println("Unable to load cargo now");
        }
    }

    public Vehicle unloadCargo(){
        if (truckHelper.getPlatformAngle() == truckHelper.getMaxPlatformAngle() && getCargoSize() > 0) {
            Vehicle vehicle = cargo.contents.pop();
            vehicle.setPosition(this.getPosition().getX() + 5, this.getPosition().getY());
            return vehicle;
        } else {
            System.out.println("Unable to unload cargo now");
            return null;
        }
    }

    public int getCargoSize(){
        return cargo.contents.size();
    }

    public double getPlatformAngle() {
        return truckHelper.getPlatformAngle();
    }

    public void setPlatformAngle(double angle) {
        truckHelper.setPlatformAngle(angle);
    }

    public void move(){
        truckHelper.move();
        Position carTransportPos = this.getPosition();
        for (Vehicle vehicle : cargo.contents){
            vehicle.setPosition(carTransportPos.getX(), carTransportPos.getY());
        }
    }
}

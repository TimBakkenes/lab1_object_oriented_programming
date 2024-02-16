package WithComposition;

import java.awt.*;

public class Scania implements Truck, Vehicle{

    private final CargoBed cargoBed;
    private final VehicleHelper vehicleHelper;

    public Scania(){
        this.vehicleHelper = new VehicleHelper(2, 400, Color.blue, "Scania");
        this.cargoBed = new CargoBed(0, 0, 70);
        this.vehicleHelper.stopEngine();
    }

    public int getNrDoors(){
        return vehicleHelper.getNrDoors();
    }

    public String getModelName(){
        return vehicleHelper.getModelName();
    }

    public double getEnginePower(){
        return vehicleHelper.getEnginePower();
    }

    public double getCurrentSpeed(){
        return vehicleHelper.getCurrentSpeed();
    }

    public void setCurrentSpeed(double speed){
        vehicleHelper.setCurrentSpeed(speed);
    }

    public Color getColor(){
        return vehicleHelper.getColor();
    }

    public void setColor(Color clr){
        vehicleHelper.setColor(clr);
    }

    public void startEngine(){
        if (cargoBed.getPlatformAngle() == 0){
            vehicleHelper.startEngine();
        } else {
            System.out.println("Cannot start engine with platform up");
        }
    }

    public void stopEngine(){
        vehicleHelper.stopEngine();
    }

    public double speedFactor(){
        return this.getEnginePower()*0.005;
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
        if (cargoBed.getPlatformAngle() == 0){
            if (vehicleHelper.gasCheck(amount)) {
                incrementSpeed(amount);
            }
        } else {
            System.out.println("Cannot gas with ramp up");
        }
    }

    public void brake(double amount){
        if (vehicleHelper.brakeCheck(amount)) {
            decrementSpeed(amount);
        }
    }

    public void move(){
        vehicleHelper.move();
    }

    public void turnLeft(double degrees){
        vehicleHelper.turnLeft(degrees);
    }

    public void turnRight(double degrees){
        vehicleHelper.turnRight(degrees);
    }

    public Position getPosition(){
        return vehicleHelper.getPosition();
    }

    public double getDirection(){
        return vehicleHelper.getDirection();
    }

    public void setPosition(double x, double y){
        vehicleHelper.setPosition(x, y);
    }

    public void pivotUp(){
        double newAngle = cargoBed.getPlatformAngle() + 10;
        if (newAngle > cargoBed.getMaxAngle()){
            cargoBed.setPlatformAngle(cargoBed.getMaxAngle());
        } else if (getCurrentSpeed() > 0) {
            System.out.println("Cannot pivot up while moving");
        } else{
            cargoBed.setPlatformAngle(newAngle);
        }
    }

    public void pivotDown(){
        double newAngle = cargoBed.getPlatformAngle() - 10;

        if (newAngle < cargoBed.getMinAngle()){
            cargoBed.setPlatformAngle(cargoBed.getMinAngle());
        } else if (getCurrentSpeed() > 0){
            System.out.println("Cannot pivot down while moving");
        } else {
            cargoBed.setPlatformAngle(newAngle);
        }
    }
}

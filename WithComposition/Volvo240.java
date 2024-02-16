package WithComposition;

import java.awt.*;

public class Volvo240 implements Vehicle{

    public final static double trimFactor = 1.25;
    private final VehicleHelper vehicleHelper;

    public Volvo240(){
        this.vehicleHelper = new VehicleHelper(4, 100, Color.black, "Volvo240");
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
        vehicleHelper.startEngine();
    }

    public void stopEngine(){
        vehicleHelper.stopEngine();
    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount){
        double new_speed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
        setCurrentSpeed(new_speed);
    }

    public void decrementSpeed(double amount){
        double new_speed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
        setCurrentSpeed(new_speed);
    }

    public void gas(double amount){
        if (vehicleHelper.gasCheck(amount)) {
            incrementSpeed(amount);
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
}

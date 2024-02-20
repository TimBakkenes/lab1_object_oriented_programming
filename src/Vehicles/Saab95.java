package src.Vehicles;

import java.awt.*;

public class Saab95 implements Vehicle {
    public boolean turboOn;
    private final VehicleHelper vehicleHelper;

    public Saab95(){
        this.vehicleHelper = new VehicleHelper(2, 125, Color.red, "Saab95");
        this.turboOn = false;
        this.setImage("pics/Saab95.jpg");
        this.vehicleHelper.stopEngine();
    }

    public String getImage() {
        return vehicleHelper.getImage();
    }

    public void setImage(String path) {
        vehicleHelper.setImage(path);
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

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return this.getEnginePower() * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        double new_speed = getCurrentSpeed() + speedFactor() * amount;
        setCurrentSpeed(new_speed);
    }

    public void decrementSpeed(double amount){
        double new_speed = getCurrentSpeed() - speedFactor() * amount;
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

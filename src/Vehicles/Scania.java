package src.Vehicles;

import java.awt.*;

public class Scania implements Truck {

    private final TruckHelper truckHelper;

    public Scania(){
        this.truckHelper = new TruckHelper(2, 400, Color.blue, "Scania", 0, 0, 70);
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
        if (truckHelper.getPlatformAngle() == 0){
            truckHelper.startEngine();
        } else {
            System.out.println("Cannot start engine with platform up");
        }
    }

    public void stopEngine(){
        truckHelper.stopEngine();
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
        if (truckHelper.getPlatformAngle() == truckHelper.getMinPlatformAngle()){
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

    public void move(){
        truckHelper.move();
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

    public double getPlatformAngle() {
        return truckHelper.getPlatformAngle();
    }

    public void setPlatformAngle(double angle) {
        truckHelper.setPlatformAngle(angle);
    }

    public void pivotUp(){
        truckHelper.pivotUp();

    }
    public void pivotDown(){
        truckHelper.pivotDown();
    }
}

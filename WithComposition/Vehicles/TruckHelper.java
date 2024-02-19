package WithComposition.Vehicles;

import java.awt.*;

public class TruckHelper{

    CargoBed cargoBed;
    VehicleHelper vehicleHelper;

    public TruckHelper(int nrDoors, double enginePower, Color color, String modelName, double startAngle, double minAngle, double maxAngle) {
        this.vehicleHelper = new VehicleHelper(nrDoors, enginePower, color, modelName);
        this.cargoBed = new CargoBed(startAngle, minAngle, maxAngle);
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

    public double getPlatformAngle() {
        return cargoBed.getPlatformAngle();
    }

    public double getMaxPlatformAngle() {
        return cargoBed.getMaxAngle();
    }

    public double getMinPlatformAngle() {
        return cargoBed.getMinAngle();
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

    public boolean gasCheck(double amount){
        return vehicleHelper.gasCheck(amount);
    }

    public boolean brakeCheck(double amount){
        return vehicleHelper.brakeCheck(amount);
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

    public boolean canPivotUp(double newAngle) {
        if (getCurrentSpeed() > 0) {
            System.out.println("Cannot pivot up while moving");
            return false;
        } else {
            return true;
        }
    }

    public void pivotUp(){
        double newAngle = Math.min(getPlatformAngle() + 10, getMaxPlatformAngle());
        if (canPivotUp(newAngle)) {
            cargoBed.setPlatformAngle(newAngle);
        }
    }


    public boolean canPivotDown(double newAngle) {
        if (getCurrentSpeed() > 0){
            System.out.println("Cannot pivot down while moving");
            return false;
        } else {
            return true;
        }
    }

    public void pivotDown(){
        double newAngle = Math.max(getPlatformAngle() - 10, getMinPlatformAngle());
        if (canPivotDown(newAngle)) {
            cargoBed.setPlatformAngle(newAngle);
        }
    }


}

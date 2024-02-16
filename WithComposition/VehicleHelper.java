package WithComposition;

import java.awt.*;

public class VehicleHelper implements Vehicle{
    private final int nrDoors;
    private final double enginePower;
    private double currentSpeed;
    private Color color;
    private final String modelName;
    private Position position;
    private double direction;

    public VehicleHelper(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;

        this.position = new Position(0, 0);
        this.direction = 0;
        stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public String getModelName(){
        return modelName;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public void setCurrentSpeed(double speed){
        currentSpeed = speed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public void incrementSpeed(double amount){}

    public void decrementSpeed(double amount){}

    public boolean gasCheck(double amount){
        try{
            if (amount >= 0 && amount <= 1){
                return true;
            } else {
                throw new Exception("Invalid gas input");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean brakeCheck(double amount){
        try{
            if (amount >= 0 && amount <= 1){
                return true;
            } else {
                throw new Exception("Invalid brake input");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void move(){
        position.set_position(position.get_x() + currentSpeed * Math.cos(Math.toRadians(direction)),
                position.get_y() + currentSpeed * Math.sin(Math.toRadians(direction)));
    }

    public void turnLeft(double degrees){
        direction = (direction + degrees) % 360;
    }
    public void turnRight(double degrees){
        direction = (direction - degrees) % 360;
    }

    public Position getPosition(){
        return position;
    }

    public double getDirection(){
        return direction;
    }

    public void setPosition(double x, double y){
        position.set_position(x, y);
    }
}

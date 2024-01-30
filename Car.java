import java.awt.*;

abstract class Car implements Movable{
    private final int nrDoors;
    private final double enginePower;
    protected double currentSpeed; // Lägga till set current speed till exempel?
    private Color color;
    private final String modelName;
    private Position position;
    private double direction;


    public Car(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
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

    abstract double speedFactor();

    abstract void incrementSpeed(double amount);

    abstract void decrementSpeed(double amount);

    public void gas(double amount){
        try{
            if (amount >= 0 && amount <= 1){
                incrementSpeed(amount);
            } else {
                throw new Exception("Invalid gas input");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Because gas and break never handles values outside of the range [0,1] gas will never result in a lower speed and vice versa
    public void brake(double amount){
        try{
            if (amount >= 0 && amount <= 1){
                decrementSpeed(amount);
            } else {
                throw new Exception("Invalid brake input");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateSpeed(double new_speed){
        try {
            if (new_speed <= getEnginePower() && new_speed >= 0) {
                currentSpeed = new_speed;

            } else {
                throw new Exception("Invalid Speed");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void move(){
        position.set_position(position.get_x() + currentSpeed * Math.cos(Math.toRadians(direction)),
                              position.get_y() + currentSpeed * Math.sin(Math.toRadians(direction)));
    }

    public double getDirection(){
        return direction;
    }

    public void turnLeft(double degrees){
        direction = (direction + degrees) % 360;
    }
    // Turn radius/angle begränsning
    public void turnRight(double degrees){
        direction = (direction - degrees) % 360;
    }

    public Position getPosition(){
        return position;
    }

    public void setPosition(double x, double y){
        position.set_position(x, y);
    }

}

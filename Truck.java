import java.awt.*;

abstract class Truck extends Car{

    private double platformAngle;
    public Truck(int nrDoors, Color color, double enginePower, String modelName){
        super(nrDoors, color, enginePower, modelName);
        platformAngle = 0;
    }

    public double get_platformAngle(){
        return this.platformAngle;
    }

    public void set_platformAngle(double angle){
        this.platformAngle = angle;
    }

    public void incrementSpeed(double amount){
        this.update_speed(Math.min(getCurrentSpeed() + speedFactor()*amount, getEnginePower()));
    }

    public void decrementSpeed(double amount){
        this.update_speed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    abstract void pivotUp();

    abstract void pivotDown();


}

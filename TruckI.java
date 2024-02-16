import java.awt.*;

abstract class TruckI extends Vehicle {

    private double platformAngle;
    public final double maxAngle = 70;
    public final double minAngle = 0;

    public TruckI(int nrDoors, Color color, double enginePower, String modelName){
        super(nrDoors, color, enginePower, modelName);
        platformAngle = 0;
    }

    public double getPlatformAngle(){
        return this.platformAngle;
    }

    public void setPlatformAngle(double angle){
        this.platformAngle = angle;
    }

    public void incrementSpeed(double amount){
        this.updateSpeed(Math.min(getCurrentSpeed() + speedFactor()*amount, getEnginePower()));
    }

    public void decrementSpeed(double amount){
        this.updateSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }


    @Override
    public void startEngine(){
        if (platformAngle == 0){
            super.startEngine();
        } else {
            System.out.println("Cannot start engine with platform up");
        }
    }

    @Override
    public void gas(double amount){
        if (platformAngle == 0){
            super.gas(amount);
        } else {
            System.out.println("Cannot gas with ramp up");
        }
    }

    abstract void pivotUp();

    abstract void pivotDown();


}

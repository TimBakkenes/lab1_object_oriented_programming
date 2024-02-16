import java.awt.*;

public class Scania extends TruckI {

    public Scania(int nrDoors, Color color, double enginePower, String modelName){
        super(nrDoors, color, enginePower, modelName);
    }

    double speedFactor() {
        return this.getEnginePower()*0.005;
    }

    public void pivotUp(){
        try{
        double newAngle = getPlatformAngle() + 10;
        // Byt plats på dessa två
        if (newAngle > maxAngle){
            setPlatformAngle(maxAngle);
        } else if (getCurrentSpeed() > 0.001) {
            throw new Exception("Can't pivot up while moving");
        } else{
            setPlatformAngle(newAngle);
        }
    } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void pivotDown(){
        try {
        double newAngle = getPlatformAngle() - 10;

        if (newAngle < minAngle){
            setPlatformAngle(0);
        } else if (getCurrentSpeed() > 0.001){
            throw new Exception("Can't pivot down while moving");
        } else {
            setPlatformAngle(newAngle);
        }
    } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

import java.awt.*;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25;

    
    public Volvo240(){
        super(4, Color.black, 100, "Volvo240");
        stopEngine();
    }
    
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount){
	    double new_speed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
        update_speed(new_speed);
    }

    public void decrementSpeed(double amount){
        double new_speed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
        update_speed(new_speed);
    }

}

import java.awt.*;

public class Saab95 extends Car{

    public boolean turboOn;
    
    public Saab95(){
        super(2, Color.red, 125, "Saab95");
	    turboOn = false;
        stopEngine();
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
        update_speed(new_speed);
    }

    public void decrementSpeed(double amount){
        double new_speed = getCurrentSpeed() - speedFactor() * amount;
        update_speed(new_speed);
    }
}

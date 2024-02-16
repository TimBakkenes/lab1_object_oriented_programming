package WithComposition;

import java.awt.*;

public interface Vehicle extends Movable{

    public int getNrDoors();

    public String getModelName();

    public double getEnginePower();

    public double getCurrentSpeed();

    public void setCurrentSpeed(double speed);

    public Color getColor();

    public void setColor(Color clr);

    public void startEngine();

    public void stopEngine();

    public double getDirection();

    public Position getPosition();

    public void setPosition(double x, double y);

}


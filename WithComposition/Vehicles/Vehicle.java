package WithComposition.Vehicles;

import WithComposition.DrawAble;

import java.awt.*;

public interface Vehicle extends Movable, DrawAble {

    String getImage();

    void setImage(String path);
    int getNrDoors();

    String getModelName();

    double getEnginePower();

    double getCurrentSpeed();

    void setCurrentSpeed(double speed);

    Color getColor();

    void setColor(Color clr);

    void startEngine();

    void stopEngine();

    void brake(double amount);

    void gas(double amount);

    double getDirection();

    Position getPosition();

    void setPosition(double x, double y);
}


package WithComposition;


import WithComposition.Vehicles.Saab95;
import WithComposition.Vehicles.Scania;
import WithComposition.Vehicles.Vehicle;
import WithComposition.Vehicles.Volvo240;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Model implements Subject{

    ArrayList<Vehicle> cars = new ArrayList<>();
    ArrayList<AutoShop<Volvo240>> autoShops = new ArrayList<>();

    // Maybe not good to have an array of DrawAble objects in the model
    ArrayList<DrawAble> components = new ArrayList<>();

    private final ArrayList<Observer> observers = new ArrayList<>();

    private final int delay = 50;
    private final Timer timer = new Timer(delay, new TimerListener());

    Dimension dimensions = new Dimension(800, 800);

    public Model() {
        Volvo240 volvo = new Volvo240();
        volvo.setPosition(0, 320);
        cars.add(volvo);
        components.add(volvo);

        Saab95 saab = new Saab95();
        saab.setPosition(0, 390);
        cars.add(saab);
        components.add(saab);

        Scania scania = new Scania();
        scania.setPosition(0, 200);
        cars.add(scania);
        components.add(scania);

        AutoShop<Volvo240> autoShop = new AutoShop<>(2);
        autoShop.setPosition(300, 300);
        autoShops.add(autoShop);
        components.add(autoShop);


    }

    void stopAllCars() {
        for (Vehicle car : cars
        ) {
            car.stopEngine();
        }
    }

    void startAllCars() {
        for (Vehicle car : cars
        ) {
            car.startEngine();
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars
        ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars
        ) {
            car.brake(brake);
        }
    }

    void toggleTurbo(boolean bool) {
        for (Vehicle car : cars
        ) {
            if (car instanceof Saab95 && bool) {
                ((Saab95) car).setTurboOn();
            } else if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }


    void liftBed() {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).pivotUp();
            }
        }
    }
    void lowerBed() {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).pivotDown();
            }
        }
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < cars.size(); i++) {
                Vehicle car = cars.get(i);
                car.move();

                for (AutoShop<Volvo240> autoShop : autoShops) {
                    if (car.getPosition().distanceToOtherPosition(autoShop.getPosition()) < 50 && car instanceof Volvo240) {
                        autoShop.dropOff((Volvo240) car);
                        cars.remove(car);
                        components.remove(car);
                    }
                }

                if (car.getPosition().getX() > dimensions.width - 100){
                    car.setCurrentSpeed(0);
                    car.turnLeft(180);
                    car.setPosition(dimensions.width - 100, car.getPosition().getY());
                    car.startEngine();
                } else if (0 > car.getPosition().getX()){
                    car.setCurrentSpeed(0);
                    car.turnLeft(180);
                    car.setPosition(0, car.getPosition().getY());
                    car.startEngine();
                }
                notifyObservers();
            }
        }
    }

    @Override
    public void register(Observer obj) {
        if(obj == null) throw new NullPointerException("Null Observer");
        observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        for (Observer obj : observers) {
            obj.update();
        }
    }

    public void startTimer() {
        this.timer.start();
    }

}

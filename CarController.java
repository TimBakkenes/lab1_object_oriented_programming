import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    Scania.CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();
    // TODO: kolla hur vi gör detta i UML diagrammet

    ArrayList<AutoShop<Volvo240>> autoShops = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();


        Volvo240 volvo = new Volvo240();
        volvo.setPosition(0, 320);
        cc.cars.add(volvo);

        Saab95 saab = new Saab95();
        saab.setPosition(0, 320);
        cc.cars.add(saab);

        Scania scania = new Scania(2, Color.blue, 300, "Scania");
        scania.setPosition(0, 200);
        cc.cars.add(scania);

        AutoShop<Volvo240> autoShop = new AutoShop<Volvo240>(2);
        autoShop.setPosition(300, 300);

        cc.autoShops.add(autoShop);


        // Start a new view and send a reference of self
        cc.frame = new Scania.CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < cars.size(); i++) {
                Vehicle car = cars.get(i);
                car.move();

                for (AutoShop<Volvo240> autoShop : autoShops) {
                    if (car.getPosition().distanceToOtherPosition(autoShop.pos) < 50 && car instanceof Volvo240) {
                        autoShop.dropOff((Volvo240) car);
                        cars.remove(car);
                    }
                }

                if (car.getPosition().getX() > frame.getViewX() - 100){
                    car.updateSpeed(0);
                    car.turnLeft(180);
                    car.setPosition(frame.getViewX() - 100, car.getPosition().getY());
                    car.startEngine();
                } else if (0 > car.getPosition().getX()){
                    car.updateSpeed(0);
                    car.turnLeft(180);
                    car.setPosition(0, car.getPosition().getY());
                    car.startEngine();
                }
                int x = (int) Math.round(car.getPosition().getX());
                int y = (int) Math.round(car.getPosition().getY());
                frame.drawPanel.moveit(car, x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
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
}

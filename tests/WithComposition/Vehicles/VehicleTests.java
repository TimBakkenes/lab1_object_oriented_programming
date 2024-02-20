package WithComposition.Vehicles;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.Vehicles.Position;
import src.Vehicles.Saab95;
import src.Vehicles.Volvo240;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VehicleTests {

    private Saab95 saab;
    private Saab95 saab2;

    private Volvo240 volvo;
    private Volvo240 volvo2;

    @BeforeEach
    void setUp() {
        saab = new Saab95();
        saab2 = new Saab95();

        volvo = new Volvo240();
        volvo2 = new Volvo240();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getNrDoors() {
        assertEquals(2, saab.getNrDoors());
    }

    @Test
    void getEnginePower() {

        assertEquals(125, saab.getEnginePower());
    }

    @Test
    void getCurrentSpeed() {
        assertEquals(0, saab.getCurrentSpeed());
    }

    @Test
    void getColor() {
        assertEquals(Color.red, saab.getColor());
    }

    @Test
    void setColor() {
        saab.setColor(Color.blue);
        assertEquals(Color.blue, saab.getColor());
    }

    @Test
    void startEngine() {
        saab.stopEngine();
        saab.startEngine();
        Assertions.assertNotEquals(saab.getCurrentSpeed(),0);
    }

    @Test
    void stopEngine() {
        saab.startEngine();
        saab.stopEngine();
        Assertions.assertEquals(saab.getCurrentSpeed(),0);
    }

    @Test
    void gas() {
        int amount = 1;
        saab.incrementSpeed(amount);
        saab2.gas(amount);
        assertEquals(saab.getCurrentSpeed(), saab2.getCurrentSpeed());

    }

    @Test
    void brake() {
        int amount = 1;
        saab.incrementSpeed(amount);
        saab2.gas(amount);

        saab.decrementSpeed(amount);
        saab2.brake(amount);
        Assertions.assertEquals(saab.getCurrentSpeed(), saab2.getCurrentSpeed());
    }

    @Test
    void move() {
        Position positionBeforeMove;
        positionBeforeMove = new Position(saab.getPosition().getX(), saab.getPosition().getY());
        saab.startEngine();

        saab.move();
        assertNotEquals(positionBeforeMove.getX(), saab.getPosition().getX());

        saab.turnLeft(180);
        saab.move();
        assertEquals(positionBeforeMove.getX(), saab.getPosition().getX());

    }

    @Test
    void turnLeft() {
        saab.turnLeft(30);
        assertEquals(30, saab.getDirection());
        saab.turnLeft(390);
        assertEquals(60, saab.getDirection());
    }

    @Test
    void turnRight() {
        saab.turnRight(30);
        assertEquals(-30, saab.getDirection());
        saab.turnRight(390);
        assertEquals(-60, saab.getDirection());
    }

    @Test
    void setTurboOn() {
        assertFalse(saab.turboOn);
        saab.setTurboOff();
        saab.setTurboOn();
        assertTrue(saab.turboOn);

        saab.setTurboOn();
        assertTrue(saab.turboOn);

        int amount = 5;
        saab.setTurboOn();
        saab2.setTurboOff();
        saab.incrementSpeed(amount);
        saab2.setCurrentSpeed(saab2.getCurrentSpeed() + saab2.speedFactor()*amount);
        assertNotEquals(saab.getCurrentSpeed(), saab2.getCurrentSpeed());
    }

    @Test
    void setTurboOff() {
        assertFalse(saab.turboOn);
        saab.setTurboOn();
        saab.setTurboOff();
        assertFalse(saab.turboOn);

        saab.setTurboOff();
        assertFalse(saab.turboOn);
    }

    @Test
    void speedFactor() {
        saab.setTurboOff();
        assertEquals(125*0.01, saab.speedFactor());

        saab.setTurboOn();
        assertEquals(125*0.01*1.3, saab.speedFactor());

        assertEquals(volvo.getEnginePower() * 0.01 * Volvo240.trimFactor, volvo.speedFactor());
    }

    @Test
    void incrementSpeed() {
        int amount = 1;
        saab.incrementSpeed(amount);
        saab2.setCurrentSpeed(saab2.getCurrentSpeed() + saab2.speedFactor()*amount);
        assertEquals(saab.getCurrentSpeed(), saab2.getCurrentSpeed());

        saab.setTurboOn();
        saab.incrementSpeed(amount);
        saab2.setCurrentSpeed(saab2.getCurrentSpeed() + saab2.speedFactor()*amount);
        assertNotEquals(saab.getCurrentSpeed(), saab2.getCurrentSpeed());

        volvo.incrementSpeed(amount);
        volvo2.setCurrentSpeed(volvo2.getCurrentSpeed() + volvo2.speedFactor()*amount);
        assertEquals(volvo.getCurrentSpeed(), volvo2.getCurrentSpeed());


    }

    @Test
    void decrementSpeed() {
        int amount = 20;
        saab.incrementSpeed(amount);
        saab2.incrementSpeed(amount);

        saab.decrementSpeed(0.5);
        saab2.setCurrentSpeed(saab2.getCurrentSpeed() - saab2.speedFactor()*0.5);

        volvo.incrementSpeed(2*amount);
        volvo2.incrementSpeed(2*amount);
        volvo.decrementSpeed(amount);
        volvo2.setCurrentSpeed(Math.max(volvo2.getCurrentSpeed() - volvo2.speedFactor() * amount,0));
        assertEquals(volvo.getCurrentSpeed(), volvo2.getCurrentSpeed());
    }

    @Test
    void getPosition() {
        assertEquals(0, saab.getPosition().getX());
        assertEquals(0, saab.getPosition().getY());
    }

    @Test
    void getDirection() {
        assertEquals(0, saab.getDirection());
    }

    @Test
    void getModelName(){
        assertEquals("Saab95", saab.getModelName());
    }

}
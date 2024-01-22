import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Saab95Test {

    private Saab95 saab;
    private Saab95 saab2;

    @BeforeEach
    void setUp() {
        saab = new Saab95();
        saab2 = new Saab95();
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
    }

    @Test
    void getColor() {
    }

    @Test
    void setColor() {
    }

    @Test
    void startEngine() {
        saab.stopEngine();
        saab.startEngine();
        assertNotEquals(saab.currentSpeed,0);
    }

    @Test
    void stopEngine() {
        saab.startEngine();
        saab.stopEngine();
        assertEquals(saab.currentSpeed,0);
    }

    @Test
    void gas() {
        int amount = 20;
        saab.incrementSpeed(amount);
        saab2.gas(amount);
        assertEquals(saab.getCurrentSpeed(), saab2.getCurrentSpeed());

    }

    @Test
    void brake() {
        int amount = 20;
        saab.incrementSpeed(amount);
        saab2.gas(amount);

        saab.decrementSpeed(amount);
        saab2.decrementSpeed(amount);
        assertEquals(saab.currentSpeed, saab2.currentSpeed);

    }

    @Test
    void move() {
        Position positionBeforeMove;
        positionBeforeMove = new Position(saab.getPosition().get_x(), saab.getPosition().get_y());
        saab.startEngine();

        saab.move();
        assertNotEquals(positionBeforeMove.get_x(), saab.getPosition().get_x());

        saab.turnLeft(180);
        saab.move();
        assertEquals(positionBeforeMove.get_x(), saab.getPosition().get_x());

    }

    @Test
    void turnLeft() {
    }

    @Test
    void turnRight() {
    }

    @Test
    void setTurboOn() {
        assertFalse(saab.turboOn);
        saab.setTurboOff();
        saab.setTurboOn();
        assertTrue(saab.turboOn);

        saab.setTurboOn();
        assertTrue(saab.turboOn);
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

    }

    @Test
    void incrementSpeed() {
        int amount = 20;
        saab.incrementSpeed(amount);
        saab2.currentSpeed = saab2.getCurrentSpeed() + saab2.speedFactor()*amount;
        assertEquals(saab.getCurrentSpeed(), saab2.getCurrentSpeed());

        saab.setTurboOn();
        saab.incrementSpeed(amount);
        saab2.currentSpeed = saab2.getCurrentSpeed() + saab2.speedFactor()*amount;
        assertNotEquals(saab.getCurrentSpeed(), saab2.getCurrentSpeed());
    }

    @Test
    void decrementSpeed() {
        int amount = 50;
        saab.incrementSpeed(amount);
        saab2.incrementSpeed(amount);

        saab.decrementSpeed(20);
        saab2.currentSpeed = saab2.getCurrentSpeed() - saab2.speedFactor()*20;

        saab.setTurboOn();
        saab.decrementSpeed(amount);
        saab2.currentSpeed = saab2.getCurrentSpeed() - saab2.speedFactor()*amount;
        assertNotEquals(saab.getCurrentSpeed(), saab2.getCurrentSpeed());
    }

    @Test
    void getPosition() {
    }

}
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CarTransportTest extends Saab95 {

    CarTransport carTransportA;
    CarTransport carTransportB;
    CarTransport carTransportC;


    @BeforeEach
    void setUp() {
        carTransportA = new CarTransport(2, Color.blue, 400, "X1 Ultra", 4);
        carTransportB = new CarTransport(2, Color.blue, 400, "X1 Ultra", 4);

        carTransportA.pivotUp();
        carTransportB.pivotUp();

        carTransportB.loadCargo(new Saab95());
        carTransportB.loadCargo(new Volvo240());

        carTransportC = new CarTransport(2, Color.blue, 400, "X1 Ultra", 4);
    }

    @Test
    void testStartEngine() {

    }

    @Test
    void testGas() {
        carTransportA.pivotDown();
        carTransportB.pivotDown();

        carTransportA.gas(0.7);
        carTransportB.gas(0.7);

        assertTrue(carTransportA.getCurrentSpeed() > carTransportB.getCurrentSpeed());
    }

    @Test
    void pivotUp() {
        carTransportC.pivotDown();
        carTransportC.pivotUp();
        assertEquals(70, carTransportC.getPlatformAngle());
    }

    @Test
    void pivotDown() {
        carTransportC.pivotUp();
        carTransportC.pivotDown();
        assertEquals(0, carTransportC.getPlatformAngle());
    }

    @Test
    void testSpeedFactor() {
        assertTrue(carTransportA.speedFactor() > carTransportB.speedFactor());
    }

    @Test
    void load_cargo() {
        carTransportA.loadCargo(new Volvo240());
        assertEquals(1, carTransportA.getCargoSize());
    }

    @Test
    void unload_cargo() {
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();

        carTransportA.loadCargo(volvo);
        carTransportA.loadCargo(saab);
        assertEquals(saab, carTransportA.unloadCargo());
    }

    @Test
    void testMove() {
        Saab95 saab = new Saab95();
        carTransportA.pivotUp();
        carTransportA.loadCargo(saab);
        carTransportA.pivotDown();
        carTransportA.gas(0.7);
        carTransportA.gas(0.7);
        carTransportA.move();
        carTransportA.move();
        assertEquals(0, carTransportA.getPosition().distance_to_other_position(saab.getPosition()));

    }
}
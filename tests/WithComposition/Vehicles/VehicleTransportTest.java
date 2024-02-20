package WithComposition.Vehicles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.Vehicles.Saab95;
import src.Vehicles.VehicleTransport;
import src.Vehicles.Volvo240;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTransportTest extends Saab95 {

    VehicleTransport carTransportA;
    VehicleTransport carTransportB;
    VehicleTransport carTransportC;


    @BeforeEach
    void setUp() {
        carTransportA = new VehicleTransport(2);
        carTransportB = new VehicleTransport(2);

        carTransportA.pivotUp();
        carTransportB.pivotUp();

        carTransportB.loadCargo(new Saab95());
        carTransportB.loadCargo(new Volvo240());

        carTransportC = new VehicleTransport(2);
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
        Assertions.assertEquals(70, carTransportC.getPlatformAngle());
    }

    @Test
    void pivotDown() {
        carTransportC.pivotUp();
        carTransportC.pivotDown();
        Assertions.assertEquals(0, carTransportC.getPlatformAngle());
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
        assertEquals(0, carTransportA.getPosition().distanceToOtherPosition(saab.getPosition()));

    }
}
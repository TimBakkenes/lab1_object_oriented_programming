package WithComposition.Vehicles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.Vehicles.Saab95;
import src.Vehicles.Scania;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest extends Saab95 {

    Scania truckA;

    @BeforeEach
    void setUp() {
        truckA = new Scania();
    }

    @Test
    void pivotUp() {
        truckA.setPlatformAngle(0);
        assertEquals(0, truckA.getPlatformAngle());
        truckA.pivotUp();
        assertTrue(truckA.getPlatformAngle() > 0);

        truckA.setPlatformAngle(68);
        truckA.pivotUp();
        assertEquals(70, truckA.getPlatformAngle());
    }

    @Test
    void pivotDown() {
        truckA.setPlatformAngle(50);
        assertEquals(50, truckA.getPlatformAngle());
        truckA.pivotDown();
        assertTrue(truckA.getPlatformAngle() < 50);

        truckA.setPlatformAngle(5);
        truckA.pivotDown();
        assertEquals(0, truckA.getPlatformAngle());
    }
}
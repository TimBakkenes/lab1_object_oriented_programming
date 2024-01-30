import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    Scania truckA;

    @BeforeEach
    void setUp() {
        truckA = new Scania(3, Color.blue, 190, "9000");
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
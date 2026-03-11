import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DividerTest {

    @Test
    void testDivideNormal() {

        Divider divider = new Divider();

        assertEquals(3.0, divider.divide(6.0, 2.0), 0.0001);
        assertEquals(-4.0, divider.divide(-8.0, 2.0), 0.0001);
        assertEquals(2.5, divider.divide(5.0, 2.0), 0.0001);
        assertEquals(5.0, divider.divide(-10.0, -2.0), 0.0001);
    }

    @Test
    void testDivideException() {

        Divider divider = new Divider();

        assertThrows(IllegalArgumentException.class, () -> divider.divide(5.0, 0.0));
        assertThrows(IllegalArgumentException.class, () -> divider.divide(-3.0, 0.0));
        assertThrows(IllegalArgumentException.class, () -> divider.divide(0.0, 0.0));
    }
}
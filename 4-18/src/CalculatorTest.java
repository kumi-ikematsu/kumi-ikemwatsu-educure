import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calculator = new Calculator();

        assertEquals(5, calculator.add(2, 3));
        assertEquals(-4, calculator.add(-1, -3));
        assertEquals(4, calculator.add(0, 4));
    }

    @Test
    void testSubtract() {
        Calculator calculator = new Calculator();

        assertEquals(2, calculator.subtract(5, 3));
        assertEquals(-3, calculator.subtract(-1, 2));
        assertEquals(-4, calculator.subtract(0, 4));
    }
}
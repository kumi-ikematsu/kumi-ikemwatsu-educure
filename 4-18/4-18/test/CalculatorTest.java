import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void testAddPositive() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3), "2 + 3 は 5 になるはずです");
    }

    @Test
    void testAddNegative() {
        Calculator calculator = new Calculator();
        assertEquals(-6, calculator.add(-2, -4), "-2 + -4 は -6 になるはずです");
    }

    @Test
    void testAddZero() {
        Calculator calculator = new Calculator();
        assertEquals(4, calculator.add(0, 4), "0 + 4 は 4 になるはずです");
    }

    @Test
    void testSubtractPositive() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.subtract(5, 3), "5 - 3 は 2 になるはずです");
    }

    @Test
    void testSubtractNegative() {
        Calculator calculator = new Calculator();
        assertEquals(-3, calculator.subtract(-1, 2), "-1 - 2 は -3 になるはずです");
    }

    @Test
    void testSubtractZero() {
        Calculator calculator = new Calculator();
        assertEquals(-4, calculator.subtract(0, 4), "0 - 4 は -4 になるはずです");
    }
}
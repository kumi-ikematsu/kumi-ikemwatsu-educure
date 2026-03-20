import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DividerTest {

    @Test
    void testNormalDivision() {
        Divider divider = new Divider();

        assertEquals(3.0, divider.divide(6.0, 2.0), 0.0001, "6 ÷ 2 は 3 になるはず");
        assertEquals(-4.0, divider.divide(-8.0, 2.0), 0.0001, "-8 ÷ 2 は -4 になるはず");
        assertEquals(2.5, divider.divide(5.0, 2.0), 0.0001, "5 ÷ 2 は 2.5 になるはず");
        assertEquals(0.5, divider.divide(1.0, 2.0), 0.0001, "1 ÷ 2 は 0.5 になるはず");
    }

    @Test
    void testNegativeDivision() {
        Divider divider = new Divider();

        assertEquals(-4.0, divider.divide(-8.0, 2.0), 0.0001, "-8 ÷ 2 は -4 になるはず");
        assertEquals(-4.0, divider.divide(8.0, -2.0), 0.0001, "8 ÷ -2 は -4 になるはず");
        assertEquals(4.0, divider.divide(-8.0, -2.0), 0.0001, "-8 ÷ -2 は 4 になるはず");
    }

    @Test
    void testExceptionDivision() {
        Divider divider = new Divider();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> divider.divide(5.0, 0.0),
                "ゼロ除算で例外が発生するはず"
        );

        assertEquals("ゼロで除算はできません", exception.getMessage(), "例外メッセージが一致するはず");
    }
}

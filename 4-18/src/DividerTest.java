import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DividerTest {

    @Test
    void testDivideNormal() {
        Divider divider = new Divider();

        assertEquals(3.0, divider.divide(6.0, 2.0), 0.0001, "6 ÷ 2 は 3.0 になるはずです");
        assertEquals(-4.0, divider.divide(-8.0, 2.0), 0.0001, "-8 ÷ 2 は -4.0 になるはずです");
        assertEquals(2.5, divider.divide(5.0, 2.0), 0.0001, "5 ÷ 2 は 2.5 になるはずです");
        assertEquals(5.0, divider.divide(-10.0, -2.0), 0.0001, "-10 ÷ -2 は 5.0 になるはずです");
    }

    @Test
    void testDivideException() {
        Divider divider = new Divider();

        IllegalArgumentException e1 =
                assertThrows(IllegalArgumentException.class,
                        () -> divider.divide(5.0, 0.0),
                        "5 ÷ 0 では IllegalArgumentException が発生するはずです");
        assertEquals("ゼロでは除算できません", e1.getMessage(), "例外メッセージが要件と一致するはずです");

        IllegalArgumentException e2 =
                assertThrows(IllegalArgumentException.class,
                        () -> divider.divide(-3.0, 0.0),
                        "-3 ÷ 0 では IllegalArgumentException が発生するはずです");
        assertEquals("ゼロでは除算できません", e2.getMessage(), "例外メッセージが要件と一致するはずです");

        IllegalArgumentException e3 =
                assertThrows(IllegalArgumentException.class,
                        () -> divider.divide(0.0, 0.0),
                        "0 ÷ 0 では IllegalArgumentException が発生するはずです");
        assertEquals("ゼロでは除算できません", e3.getMessage(), "例外メッセージが要件と一致するはずです");
    }
}
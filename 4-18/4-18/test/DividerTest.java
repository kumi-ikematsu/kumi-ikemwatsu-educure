import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DividerTest {

    @Test
    void testDivideNormal() {
        Divider divider = new Divider();
        assertEquals(5, divider.divide(10, 2), "10 ÷ 2 は 5 になるはずです");
    }

    @Test
    void testDivideByZero() {
        Divider divider = new Divider();

        Exception exception = assertThrows(
            IllegalArgumentException.class,
            () -> divider.divide(10, 0),
            "0で割ると例外が発生するはずです"
        );

        assertEquals("0で割ることはできません", exception.getMessage(), "例外メッセージが正しくありません");
    }
}

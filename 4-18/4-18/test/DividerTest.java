import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DividerTest {
    private final Divider divider = new Divider();

    @Test
    public void testDivide() {
        // 小数計算のテスト
        assertEquals(2.5, divider.divide(5.0, 2.0), 0.001);
        assertEquals(1.25, divider.divide(2.5, 2.0), 0.001);
    }

    @Test
    public void testDivideByZero() {
        // 画像2-8, 2-9の要件通りに実装
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            divider.divide(10.0, 0.0);
        }, "ゼロ除算で例外が発生するはず");
        
        assertEquals("ゼロで除算はできません", exception.getMessage());
    }
}

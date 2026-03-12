import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RPGCharacterTest {

    @Test
    void testInitialStatus() {
        RPGCharacter character = new RPGCharacter();

        assertEquals(1, character.getLevel(), "初期レベルは1であるはずです");
        assertEquals(100, character.getHP(), "初期HPは100であるはずです");
        assertEquals(50, character.getMP(), "初期MPは50であるはずです");
    }

    @Test
    void testNormalLevelUp() {
        RPGCharacter character = new RPGCharacter();

        character.levelUp();

        assertEquals(2, character.getLevel(), "レベルアップ後はレベル2になるはずです");
        assertEquals(110, character.getHP(), "レベルアップ後はHPが110になるはずです");
        assertEquals(55, character.getMP(), "レベルアップ後はMPが55になるはずです");
    }

    @Test
    void testBoundaryStatusAtLevel99() {
        RPGCharacter character = new RPGCharacter();

        for (int i = 1; i < 99; i++) {
            character.levelUp();
        }

        assertEquals(99, character.getLevel(), "最大到達レベルは99であるはずです");
        assertEquals(1080, character.getHP(), "レベル99到達時のHPは1080であるはずです");
        assertEquals(540, character.getMP(), "レベル99到達時のMPは540であるはずです");
    }

    @Test
    void testMaxLevelException() {
        RPGCharacter character = new RPGCharacter();

        for (int i = 1; i < 99; i++) {
            character.levelUp();
        }

        IllegalStateException exception =
                assertThrows(IllegalStateException.class,
                        () -> character.levelUp(),
                        "レベル99からのレベルアップでは例外が発生するはずです");

        assertEquals("最大レベルに達しています", exception.getMessage(),
                "例外メッセージが要件と一致するはずです");
    }
}
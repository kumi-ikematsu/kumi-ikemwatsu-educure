import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RPGCharacterTest {

    @Test
    void testInitialStatus() {
        RPGCharacter character = new RPGCharacter();

        assertEquals(1, character.getLevel(), "初期レベルは1のはず");
        assertEquals(100, character.getHp(), "初期HPは100のはず");
        assertEquals(50, character.getMp(), "初期MPは50のはず");
    }

    @Test
    void testNormalLevelUp() {
        RPGCharacter character = new RPGCharacter();

        character.levelUp();

        assertEquals(2, character.getLevel(), "レベルアップ後は2になるはず");
        assertEquals(110, character.getHp(), "HPは10増えるはず");
        assertEquals(55, character.getMp(), "MPは5増えるはず");
    }

    @Test
    void testMaxLevel() {
        RPGCharacter character = new RPGCharacter();

        // レベル99まで上げる
        for (int i = 1; i < 99; i++) {
            character.levelUp();
        }

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> character.levelUp(),
                "最大レベルで例外が発生するはず"
        );

        assertEquals("最大レベルに達しています", exception.getMessage(), "例外メッセージが一致するはず");
    }
}

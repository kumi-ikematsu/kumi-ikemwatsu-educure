import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RPGCharacterTest {

    @Test
    void testInitialStatus() {

        RPGCharacter character = new RPGCharacter();

        assertEquals(1, character.getLevel());
        assertEquals(100, character.getHP());
        assertEquals(50, character.getMP());
    }

    @Test
    void testNormalLevelUp() {

        RPGCharacter character = new RPGCharacter();

        character.levelUp();

        assertEquals(2, character.getLevel());
        assertEquals(110, character.getHP());
        assertEquals(55, character.getMP());
    }

    @Test
    void testMaxLevel() {

        RPGCharacter character = new RPGCharacter();

        for(int i = 1; i < 99; i++){
            character.levelUp();
        }

        assertThrows(IllegalStateException.class, () -> {
            character.levelUp();
        });
    }
}
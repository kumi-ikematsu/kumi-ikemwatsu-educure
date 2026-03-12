import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RPGCharacterTest {

    @Test
    void testTakeDamage() {

        RPGCharacter hero = new RPGCharacter("勇者", 100, 20);

        hero.takeDamage(30);

        assertEquals(70, hero.getHp(), "HPは70になるはずです");
    }

    @Test
    void testAttack() {

        RPGCharacter hero = new RPGCharacter("勇者", 100, 20);
        RPGCharacter monster = new RPGCharacter("スライム", 50, 10);

        hero.attack(monster);

        assertEquals(30, monster.getHp(), "モンスターのHPは30になるはずです");
    }
}
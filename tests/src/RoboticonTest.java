import com.badlogic.gdx.Game;
import com.mygdx.game.Main;
import com.mygdx.game.Player;
import com.mygdx.game.Roboticon;
import com.mygdx.game.Tile;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Kieran Hall KJH532
 * @version 1.0
 * @since 1.0
 */
public class RoboticonTest extends TesterFile {

    private Game game = new Main();
    private Player TestPlayer = new Player(0);
    private Tile TestTile = new Tile(game, 0,0, 0, 0, true, new Runnable() {
        @Override
        public void run() {

        }
    });
    private Roboticon TestRobot = new Roboticon(0, TestPlayer, TestTile);

    /**
     * Tests that the Roboticon.upgrade(String resource) method works as intended for Valid and invalid values.
     */
    @Test
    public void testupgrade() {
        Integer NewLevel[] = {2, 1, 1};
        TestRobot.upgrade("Ore");
        assertArrayEquals(NewLevel, TestRobot.getLevel());
        NewLevel[1] = 2;
        TestRobot.upgrade("Energy");
        assertArrayEquals(NewLevel, TestRobot.getLevel());
        NewLevel[2] = 2;
        TestRobot.upgrade("Food");
        assertArrayEquals(NewLevel, TestRobot.getLevel());
        assertFalse(TestRobot.upgrade("invalid"));
    }

    /**
     * Test confirming the possibleUpgrades method returns the possible upgrades available, as an array.
     */
    @Test
    public void testpossibleUpgrades() {
        Integer TestUpgrades[] = TestRobot.getLevel();
        for (int i = 0; i < 3; i++){
            TestUpgrades[i] += 1;
        }
        assertArrayEquals(TestRobot.possibleUpgrades(), TestUpgrades);
    }

    /**
     * Test confirming productionModifier method works and provides values within a reasonable range
     */
    @Test
    public void testproductionModifier() {
        Integer[] Modifiers;
        for (int j = 0; j < 100; j++) {
            Modifiers = TestRobot.productionModifier();
            for (int i = 0; i < 3; i++) {
                assertTrue(Modifiers[i] < 6);
            }
        }
    }

    /**
     * Test confirming the getUpgradeCost returns the correct array
     */
    @Test
    public void testgetUpgradeCost(){
        Integer TestUpgrades[] = TestRobot.getLevel();
        for (int i = 0; i < 3;i++){
            TestUpgrades[i] = TestUpgrades[i] + (TestUpgrades[i] * 5);
        }
        assertTrue(TestUpgrades == TestRobot.getUpgradeCost());
    }
}


import com.badlogic.gdx.Game;
import com.mygdx.game.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Kieran Hall KJH532
 * @version 1.0
 * @since 1.0
 */
public class MarketTest extends TesterFile{
    private Player TestPlayer = new Player(0);
    private Game testGame;
    private GameEngine testGameEngine;
    private Market TestMarket = new Market(testGame,testGameEngine);

    /**
     * Tests Valid buy conditions for all resources.
     * <p>
     *     Market resources are set to 10,a dn the prices are set to be valid for this test.
     *     Initial values of OreCount, OreSellPrice, OreBuyPrice are set to 10 and Money is set to 100.
     *     Initial values of FoodCount, FoodSellPrice, FoodBuyPrice are set to 10 and Money is set to 100.
     *     Initial values of FoodCount, FoodSellPrice, FoodBuyPrice are set to 10 and Money is set to 100.
     * </p>
     * @throws Exception Thrown when an invalid transaction is attempted.
     */
    @Test
    public void testBuy() throws Exception{

        //Energy
        TestPlayer.setEnergyCount(10);
        TestPlayer.setMoney(100);
        TestMarket.setEnergySellPrice(10);
        TestMarket.setEnergyBuyPrice(10);
        TestMarket.setEnergyStock(10);

        TestMarket.buy("energy", 10, TestPlayer);

        Integer TestEnergyCount = 20;
        assertEquals(TestEnergyCount, TestPlayer.getEnergyCount());
        Integer TestMoney = 0;
        assertEquals(TestMoney, TestPlayer.getMoney());
        Integer TestSellPrice = 200;
        assertEquals(TestSellPrice, TestMarket.getEnergySellPrice());
        Integer TestBuyPrice = 0;
        assertEquals(TestBuyPrice, TestMarket.getEnergyBuyPrice());
        Integer TestFoodStock = 0;
        assertEquals(TestFoodStock, TestMarket.getEnergyStock());

        //Ore
        TestPlayer.setOreCount(10);
        TestPlayer.setMoney(100);
        TestMarket.setOreSellPrice(10);
        TestMarket.setOreBuyPrice(10);
        TestMarket.setOreStock(10);

        TestMarket.buy("ore", 10, TestPlayer);

        Integer TestOreCount = 20;
        assertEquals(TestOreCount, TestPlayer.getOreCount());
        TestMoney = 0;
        assertEquals(TestMoney, TestPlayer.getMoney());
        TestSellPrice = 200;
        assertEquals(TestSellPrice, TestMarket.getOreSellPrice());
        TestBuyPrice = 0;
        assertEquals(TestBuyPrice, TestMarket.getOreBuyPrice());
        Integer TestOreStock = 0;
        assertEquals(TestOreStock, TestMarket.getOreStock());

        //Food
        TestPlayer.setFoodCount(10);
        TestPlayer.setMoney(100);
        TestMarket.setFoodSellPrice(10);
        TestMarket.setFoodBuyPrice(10);
        TestMarket.setFoodStock(10);

        TestMarket.buy("food", 10, TestPlayer);

        Integer TestFoodCount = 20;
        assertEquals(TestFoodCount, TestPlayer.getFoodCount());
        TestMoney = 0;
        assertEquals(TestMoney, TestPlayer.getMoney());
        TestSellPrice = 200;
        assertEquals(TestSellPrice, TestMarket.getFoodSellPrice());
        TestBuyPrice = 0;
        assertEquals(TestBuyPrice, TestMarket.getFoodBuyPrice());
        TestFoodStock = 0;
        assertEquals(TestFoodStock, TestMarket.getFoodStock());
    }

    @Test
    public void testBuyExceptions(){

        //Energy
        TestPlayer.setEnergyCount(10);
        TestPlayer.setMoney(100);
        TestMarket.setEnergySellPrice(10);
        TestMarket.setEnergyBuyPrice(10);
        TestMarket.setEnergyStock(100);

        try {
            TestMarket.buy("energy", 100, TestPlayer);
            fail("Expected an exception to be thrown");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Insufficient money");
        }

        Integer TestEnergyCount = 10;
        assertEquals(TestEnergyCount, TestPlayer.getEnergyCount());
        Integer TestMoney = 100;
        assertEquals(TestMoney, TestPlayer.getMoney());
        Integer TestSellPrice = 10;
        assertEquals(TestSellPrice, TestMarket.getEnergySellPrice());
        Integer TestBuyPrice = 10;
        assertEquals(TestBuyPrice, TestMarket.getEnergyBuyPrice());
        Integer TestEnergyStock = 100;
        assertEquals(TestEnergyStock, TestMarket.getEnergyStock());

        //Ore
        TestPlayer.setOreCount(10);
        TestPlayer.setMoney(100);
        TestMarket.setOreSellPrice(10);
        TestMarket.setOreBuyPrice(10);
        TestMarket.setOreStock(100);

        try {
            TestMarket.buy("ore", 100, TestPlayer);
            fail("Expected an exception to be thrown");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Insufficient money");
        }

        Integer TestOreCount = 10;
        assertEquals(TestOreCount, TestPlayer.getOreCount());
        TestMoney = 100;
        assertEquals(TestMoney, TestPlayer.getMoney());
        TestSellPrice = 10;
        assertEquals(TestSellPrice, TestMarket.getOreSellPrice());
        TestBuyPrice = 10;
        assertEquals(TestBuyPrice, TestMarket.getOreBuyPrice());
        Integer TestOreStock = 100;
        assertEquals(TestOreStock, TestMarket.getOreStock());

        //Food
        TestPlayer.setFoodCount(10);
        TestPlayer.setMoney(100);
        TestMarket.setFoodSellPrice(10);
        TestMarket.setFoodBuyPrice(10);
        TestMarket.setFoodStock(100);

        try {
            TestMarket.buy("food", 100, TestPlayer);
            fail("Expected an exception to be thrown");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Insufficient money");
        }

        Integer TestFoodCount = 10;
        assertEquals(TestFoodCount, TestPlayer.getFoodCount());
        TestMoney = 100;
        assertEquals(TestMoney, TestPlayer.getMoney());
        TestSellPrice = 10;
        assertEquals(TestSellPrice, TestMarket.getFoodSellPrice());
        TestBuyPrice = 10;
        assertEquals(TestBuyPrice, TestMarket.getFoodBuyPrice());
        Integer TestFoodStock = 100;
        assertEquals(TestFoodStock, TestMarket.getFoodStock());
    }

    @Test
    public void testSell(){

    }

    @Test
    public void testSellExceptions(){

    }

    @Test
    public void testGamble(){
        TestPlayer.setMoney(49);

        for (int j = 0; j < 100; j++) {
            if (TestPlayer.getMoney() < 50) {
                assertNull(TestMarket.gamble(100, TestPlayer));
            } else if (TestPlayer.getMoney() >= 50) {
                Boolean current = TestMarket.gamble(50, TestPlayer);
                assertTrue(((current == Boolean.TRUE) || (current == Boolean.FALSE)));
            }
        }
    }

    @Test
    public void testcalculatenewcost(){

    }

    @Test
    public void testBuyRoboticon(){

    }
}

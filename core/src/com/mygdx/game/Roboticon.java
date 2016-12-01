package com.mygdx.game;

import java.util.*;

/**
 * @author Kieran Hall KJH532
 * @version 1.0
 * @since 1.0
 */
public class Roboticon {
    /**
     * Unique numerical identifier of the roboticon.
     */
    private Integer RoboticonID;

    /**
     * Variable holding which player the roboticon belongs to.
     */
    private Player Owner;

    /**
     * Variable holding what tile the roboticon is stored on.
     */
    private Tile CurrentTile;

    /**
     * Integer variable determining the maximum level of roboticons allowed in the game.
     */
    private Integer MaxLevel = 3;

    /**
     * Array of integers holding the current level of the roboticon, stored as: [Ore, Energy, Food]
     * <p>
     * Starts at 1 so as to allow any tile with a roboticon to produce resources.
     * </p>
     */
    private Integer Level[] = {1, 1, 1};

    /**
     * Upgrade array, holds the possible levels of upgrade for the current robot. Stored as [Ore, Energy, Food]
     */
    private Integer Upgrades[] = {0, 0, 0};

    /**
     * Constructor of the class
     *
     * @param ID     An integer uniquely defining the roboticon, starting at 0
     * @param Player A Player object to own the roboticon
     * @param Tile   A Tile object the roboticon is positioned on and therefore belongs to
     */
    public Roboticon(int ID, Player Player, Tile Tile) {
        RoboticonID = ID;
        this.CurrentTile = Tile;
        this.Owner = Player;
    }

    public Integer[] getLevel() {
        return this.Level;
    }

    /**
     * Method to upgrade a single level of the roboticon.
     * <p>
     * The parameter 'Resource' specifies 'Ore', 'Energy' or 'Food' to be upgraded one level.
     * </p>
     *
     * @param Resource String holding the characters 'Ore', 'Energy' or 'Food'
     */
    public String upgrade(String Resource) {
        if (Resource.equals("Ore")) {
            this.Level[0] += 1;
            return "Ore level increased";

        } else if (Resource.equals("Energy")) {
            this.Level[1] += 1;
            return "Energy level increased";

        } else if (Resource.equals("Food")) {
            this.Level[2] += 1;
            return "Food level increased";

        } else
            return "Incorrect parameter passed, must be Ore, Energy or Food";


    }

    /**
     * A method to return an array of all possible upgrades available to the roboticon at its current state
     *
     * @return Upgrades Returns an Integer Array in the form [Ore, Energy, Food]
     */
    public Integer[] possibleUpgrades() {
        if (Level[0] <= MaxLevel) {
            this.Upgrades[0] = this.Level[0] += 1;
        }
        if (Level[1] <= MaxLevel) {
            this.Upgrades[1] = this.Level[1] += 1;
        }
        if (Level[2] <= MaxLevel) {
            this.Upgrades[2] = this.Level[2] += 1;
        }

        return this.Upgrades;
    }

    /**
     * A method to return the production modifier offered by the roboticon.
     * <p>
     * Contains inherent randomness, not just a 1:1 ratio of level to return each phase of production. The modifier is used outside of
     * this class to multiply the inherent resources located on that tile.
     * </p>
     *
     * @return Modifiers Array to return the modifier for resource production, stored [Ore, Energy, Food]
     */
    public Integer[] productionModifier() {
        Integer Modifiers[] = {1, 1, 1};
        Integer Max = 5;
        Integer Min = 1;
        Random rand = new Random();

        for (int i = 0; i < 3; i++) {
            int n = rand.nextInt(Max) + Min;
            Modifiers[i] = this.Level[i] * n;
        }

        return Modifiers;


    }
}
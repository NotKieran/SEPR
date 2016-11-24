package com.mygdx.game;

import java.util.*;

/**
 * @author Martynas MM1544
 * @version 1.0
 * @since 1.0
 */
public class Market {

    private Integer OreStock = 0;

    private Integer FoodStock = 16;

    private Integer EnergyStock = 16;

    private Integer RoboticonStock = 12;

    private Integer OreSellPrice;

    private Integer FoodSellPrice;

    private Integer EnergySellPrice;

    private Integer OreBuyPrice;

    private Integer FoodBuyPrice;

    private Integer EnergyBuyPrice;

    private Integer RoboticonBuyPrice;

    public void buy(String Stock_Type, int Quantity, Player Player) {
        int playersMoney = Player.getMoney();
        switch (Stock_Type) {
            case "ore":
                if (Quantity <= OreStock) {
                    int OrePrice = OreBuyPrice * Quantity;
                    if (playersMoney >= OrePrice) {
                        OreStock -= Quantity;
                        playersMoney -= OrePrice;
                        Player.setMoney(playersMoney);
                        int playersOre = Player.getOreCount;
                        playersOre += Quantity;
                        Player.setOreCount(Quantity);

                        // thies both need to be merged in to one function
                        calculateNewCost(OreStock, OreBuyPrice, "buy");
                        calculateNewCost(OreStock, OreSellPrice, "sell");
                    } else {
                        System.out.println("Insufficient money");
                    }
                } else {
                    System.out.println("Inscufficient resources");
                }
            case "food":
                if (Quantity <= FoodStock) {
                    int FoodPrice = FoodBuyPrice * Quantity;
                    if (playersMoney >= FoodPrice) {
                        FoodStock -= Quantity;
                        playersMoney -= FoodPrice;
                        Player.setMoney(playersMoney);
                        int playersFood = Player.getFoodCount;
                        playersFood += Quantity;
                        Player.setFoodCount(playersFood);
                        calculateNewCost(FoodStock, FoodBuyPrice, "buy");
                        calculateNewCost(FoodStock, FoodSellPrice, "sell");
                    } else {
                        System.out.println("Insufficient money");
                    }

                } else {
                    System.out.println("Inscufficient resources");
                }
            case "energy":
                if (Quantity <= EnergyStock) {
                    int EnergyPrice = EnergyBuyPrice * Quantity;
                    if (playersMoney >= EnergyPrice) {
                        EnergyStock -= Quantity;
                        playersMoney -= EnergyPrice;
                        Player.setMoney(playersMoney);
                        int playersEnergy = Player.getEnergyCount;
                        playersEnergy += Quantity;
                        Player.setEnergyCount(playersEnergy);
                        calculateNewCost(EnergyStock, EnergyBuyPrice, "buy");
                        calculateNewCost(EnergyStock, EnergySellPrice, "sell");
                    } else {
                        System.out.println("Insufficient money");
                    }
                } else {
                    System.out.println("Inscufficient resources");
                }

        }
    }


    public void sell(String Stock_Type, int Quantity) {
        switch (Stock_Type) {
            case "ore":
                if (this.Player.OreCount >= Quantity) {
                    OreStock += Quantity;
                    this.Player.Money += Quantity * OreSellPrice;
                    this.Player.OreCount -= Quantity;
                    calculateNewCost(OreStock, OreSellPrice, "sell");

                } else {
                    System.out.println("Inscufficient resources");
                }
            case "food":
                if (this.Player.FoodCount >= Quantity) {
                    FoodStock += Quantity;
                    this.Player.Money += Quantity * FoodSellPrice;
                    this.Player.FoodCount -= Quantity;

                    calculateNewCost(FoodStock, FoodSellPrice, "sell");

                } else {
                    System.out.println("Inscufficient resources");
                }
            case "energy":
                if (this.Player.EnergyCount >= Quantity) {
                    EnergyStock += Quantity;
                    this.Player.Money += Quantity * EnergySellPrice;
                    this.Player.EnergyCount -= Quantity;

                    calculateNewCost(EnergyStock, EnergySellPrice, "sell");

                } else {
                    System.out.println("Inscufficient resources");
                }

        }
    }

    public void gamble() {
    }

    public void calculateNewCost(int Stock, int costOfResources, String oper) {
        double cost = 0;
        if (Stock == 0 && oper == "buy") {
            costOfResources = 0;
        } else if (Stock == 0 && oper == "sell") {
            costOfResources = 50;
        } else if (oper == "buy") {
            cost = 16 / Stock + 2;
            int costInt = (int) Math.round(cost);
            if (cost < 1) {
                costOfResources = 1;
            } else if (cost > 100) {
                costOfResources = 100;
            } else {
                costOfResources = costInt;
            }

        } else if (oper == "sell") {
            cost = 16 / Stock;
            int costInt = (int) Math.round(cost);
            if (cost < 1) {
                costOfResources = 1;
            } else if (cost > 100) {
                costOfResources = 100;
            } else {
                costOfResources = costInt;
            }
        } else {
            System.out.println("Wrong operator");
        }

    }
    //public Integer getPrice(String Stock_Type){
    //return Stock_Type.Price;
    //}
}





package model;

import model.VillageModelManager;

public class cloverTest
{
  public static void main(String[] args)
  {
    System.out.println("\nCLOVERVILLE");
    Village cloverville = new Village();
    Villager villager1= new Villager("Bátor", "Gábora", 104);
    Villager villager2 = new Villager("Mike", "Lorenzen", 105);
    Villager villager3 = new Villager("Arsenie", "Bilba", 120);
    Villager villager4 = new Villager("Iulian", "Plop", 111);
    Villager villager5 = new Villager("John", "Doe", 130);
    Villager villager6 = new Villager("Laur", "Leon", 105);
    Villager villager7 = new Villager("Sugi", "Pula", 250);
    Villager villager8 = new Villager("Mike", "Suge", 160);
    Villager villager9 = new Villager("ala", "bama", 67);
    Villager villager10 = new Villager("bama", "ala", 76);
    Villager villager11 = new Villager("suga", "mama", 777);
    Villager villager12 = new Villager("mama", "suga", 66);
    Villager villager13= new Villager("Johnny", "bravo", 559);
    Villager villager14 = new Villager("biggie", "Len", 114);
    Villager villager15 = new Villager("bal", "Pua", 112);
    Villager villager16 = new Villager("Mie", "Sue", 113);
    Villager villager17 = new Villager("Liam", "Turner", 121);
    Villager villager18 = new Villager("Emma", "Stone", 132);
    Villager villager19 = new Villager("Noah", "Harper", 140);
    Villager villager20 = new Villager("Olivia", "Brooks", 128);
    Villager villager21 = new Villager("Ava", "Miller", 150);
    Villager villager22 = new Villager("Ethan", "Walker", 119);
    Villager villager23 = new Villager("Lucas", "Hayes", 133);
    Villager villager24 = new Villager("Mason", "Reed", 141);
    Villager villager25 = new Villager("Sophia", "Bennett", 125);
    Villager villager26 = new Villager("Isabella", "Frost", 160);
    Villager villager27 = new Villager("Elijah", "Carter", 118);
    Villager villager28 = new Villager("Henry", "Lawson", 174);
    Villager villager29 = new Villager("Ella", "Dawson", 115);
    Villager villager30 = new Villager("James", "Cooper", 199);
    Villager villager31 = new Villager("Amelia", "King", 143);
    Villager villager32 = new Villager("Harper", "Lane", 109);
    Villager villager33 = new Villager("Alexander", "Gray", 156);
    Villager villager34 = new Villager("Daniel", "Wells", 138);
    Villager villager35 = new Villager("Grace", "Underwood", 127);
    Villager villager36 = new Villager("Chloe", "Hart", 134);
    Villager villager37 = new Villager("Benjamin", "Cole", 147);
    Villager villager38 = new Villager("Scarlett", "Fisher", 152);
    Villager villager39 = new Villager("Matthew", "Knight", 170);
    Villager villager40 = new Villager("Victoria", "Hale", 155);
    Villager villager41 = new Villager("Samuel", "Barton", 122);
    Villager villager42 = new Villager("Evelyn", "Summers", 144);

    cloverville.addVillager(villager1);
    cloverville.addVillager(villager2);
    cloverville.addVillager(villager3);
    cloverville.addVillager(villager4);
    cloverville.addVillager(villager5);
    cloverville.addVillager(villager6);
    cloverville.addVillager(villager7);
    cloverville.addVillager(villager8);
    cloverville.addVillager(villager9);
    cloverville.addVillager(villager10);
    cloverville.addVillager(villager11);
    cloverville.addVillager(villager12);
    cloverville.addVillager(villager13);
    cloverville.addVillager(villager14);
    cloverville.addVillager(villager15);
    cloverville.addVillager(villager16);
    cloverville.addVillager(villager17);
    cloverville.addVillager(villager18);
    cloverville.addVillager(villager19);
    cloverville.addVillager(villager20);
    cloverville.addVillager(villager21);
    cloverville.addVillager(villager22);
    cloverville.addVillager(villager23);
    cloverville.addVillager(villager24);
    cloverville.addVillager(villager25);
    cloverville.addVillager(villager26);
    cloverville.addVillager(villager27);
    cloverville.addVillager(villager28);
    cloverville.addVillager(villager29);
    cloverville.addVillager(villager30);
    cloverville.addVillager(villager31);
    cloverville.addVillager(villager32);
    cloverville.addVillager(villager33);
    cloverville.addVillager(villager34);
    cloverville.addVillager(villager35);
    cloverville.addVillager(villager36);
    cloverville.addVillager(villager37);
    cloverville.addVillager(villager38);
    cloverville.addVillager(villager39);
    cloverville.addVillager(villager40);
    cloverville.addVillager(villager41);
    cloverville.addVillager(villager42);

    TradeOffer trade1 = new TradeOffer(villager4, "peanut butter jelly sandwich", 35, "yum yum");
    TradeOffer trade2 = new TradeOffer(villager3, "world famous hungarian pálinka", 67, "brought from home");
    TradeOffer trade3 = new TradeOffer(villager3, "carrots", 35, "collected from the field");
    TradeOffer trade4 = new TradeOffer(villager3, "pears", 67, "a bit ripe");
    TradeOffer trade5 = new TradeOffer(villager1, "freshly baked bread", 25, "just made this morning");
    TradeOffer trade6 = new TradeOffer(villager1, "homemade wooden spoon", 40, "crafted with care");
    TradeOffer trade7 = new TradeOffer(villager3, "basket of apples", 30, "picked from the village orchard");
    TradeOffer trade8 = new TradeOffer(villager3, "hand-knitted scarf", 55, "keeps you warm in winter");
    TradeOffer trade9 = new TradeOffer(villager2, "jar of organic honey", 45, "harvested from local hives");
    TradeOffer trade10 = new TradeOffer(villager4, "warm wool mittens", 38, "handmade for cold winters");
    TradeOffer trade11 = new TradeOffer(villager1, "vintage pocket watch", 90, "passed down from family");
    TradeOffer trade12 = new TradeOffer(villager2, "bundle of firewood", 28, "perfectly dried");
    TradeOffer trade13 = new TradeOffer(villager3, "herbal healing tea", 33, "made from rare mountain herbs");
    TradeOffer trade14 = new TradeOffer(villager4, "leather-bound notebook", 50, "great for journaling");
    TradeOffer trade15 = new TradeOffer(villager1, "set of gardening tools", 70, "includes gloves, trowel, etc.");
    TradeOffer trade16 = new TradeOffer(villager2, "handcrafted clay mug", 22, "fired in my home kiln");

    cloverville.addTradeOffer(trade1);
    cloverville.addTradeOffer(trade2);
    cloverville.addTradeOffer(trade3);
    cloverville.addTradeOffer(trade4);
    cloverville.addTradeOffer(trade5);
    cloverville.addTradeOffer(trade6);
    cloverville.addTradeOffer(trade7);
    cloverville.addTradeOffer(trade8);
    cloverville.addTradeOffer(trade9);
    cloverville.addTradeOffer(trade10);
    cloverville.addTradeOffer(trade11);
    cloverville.addTradeOffer(trade12);
    cloverville.addTradeOffer(trade13);
    cloverville.addTradeOffer(trade14);
    cloverville.addTradeOffer(trade15);
    cloverville.addTradeOffer(trade16);

    cloverville.addResetPeriod(7);
    cloverville.checkReset();


    GreenActivity activity1 = new GreenActivity("cycling to work", 50);
    GreenActivity activity2 = new GreenActivity("biodegradable kitchen waste", 40);


    GreenGoal goal1 = new GreenGoal("pizza", 150);
    cloverville.addGreenGoal(goal1);

    SharedTask sharedtask1 = new SharedTask(cloverville, "cleaning grupperoom", 300);
    cloverville.addSharedTask(sharedtask1);
    sharedtask1.addPerformer(villager1);
    sharedtask1.addPerformer(villager2);

    SharedTask sharedtask2 = new SharedTask(cloverville, "cooking dinner", 500);
    cloverville.addSharedTask(sharedtask2);
    sharedtask2.addPerformer(villager3);

    System.out.println(cloverville);

    VillageModelManager manage = new VillageModelManager("village.bin");
    manage.saveVillage(cloverville);

  }
}

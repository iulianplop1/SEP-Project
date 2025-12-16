package model;

/**
 * cloverTest class for adding some default values to the village, primarily for testing and also writing to file (.bin)
 * @author GaboraBrave
 */

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
    Villager villager5 = new Villager("John", "Marlow", 130);
    Villager villager6 = new Villager("Laura", "Leonard", 105);
    Villager villager7 = new Villager("Sophie", "Pullen", 250);
    Villager villager8 = new Villager("Michael", "Sugden", 160);
    Villager villager9 = new Villager("Alan", "Barnes", 67);
    Villager villager10 = new Villager("Ben", "Allan", 76);
    Villager villager11 = new Villager("Susan", "Marlow", 777);
    Villager villager12 = new Villager("Maria", "Sutter", 66);
    Villager villager13= new Villager("Johnny", "Branford", 559);
    Villager villager14 = new Villager("Bianca", "Lennox", 114);
    Villager villager15 = new Villager("Bella", "Pugh", 112);
    Villager villager16 = new Villager("Mia", "Sutton", 113);
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

    TradeOffer trade1 = new TradeOffer(villager3, "windows cleaned", 67, "cheap service");
    TradeOffer trade2 = new TradeOffer(villager4, "mend goods or services", 35, "fixing stuff for you");
    TradeOffer trade3 = new TradeOffer(villager3, "guided meditation", 35, "chill guided relaxation session");
    TradeOffer trade4 = new TradeOffer(villager3, "carrots ", 67, "a bit ripe");
    TradeOffer trade5 = new TradeOffer(villager1, "compost bin", 25, "just made this morning");
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

    GreenActivity activity1 = new GreenActivity("cycling to work", 50);
    GreenActivity activity2 = new GreenActivity("eating vegan for a\n" + "week", 40);
    GreenActivity activity3 = new GreenActivity("switching to energy-efficient lighting,", 30);
    GreenActivity activity4 = new GreenActivity("using public transport", 20);
    GreenActivity activity5 = new GreenActivity("recycling plastic bottles", 25);
    GreenActivity activity6 = new GreenActivity("composting garden waste", 35);
    GreenActivity activity7 = new GreenActivity("installing solar panels", 100);
    GreenActivity activity8 = new GreenActivity("reducing water usage", 15);
    GreenActivity activity9 = new GreenActivity("carpooling to work", 40);
    GreenActivity activity10 = new GreenActivity("avoiding single-use plastics", 30);
    GreenActivity activity11 = new GreenActivity("buying local produce", 20);
    GreenActivity activity12 = new GreenActivity("participating in clean-up drives", 50);
    Date date1=new Date(1,12,2025);
    GreenActivity activity13 = new GreenActivity("installing solar panels at home", 50,date1);

    cloverville.addGreenActivity(activity1);
    cloverville.addGreenActivity(activity2);
    cloverville.addGreenActivity(activity3);
    cloverville.addGreenActivity(activity4);
    cloverville.addGreenActivity(activity5);
    cloverville.addGreenActivity(activity6);
    cloverville.addGreenActivity(activity7);
    cloverville.addGreenActivity(activity8);
    cloverville.addGreenActivity(activity9);
    cloverville.addGreenActivity(activity10);
    cloverville.addGreenActivity(activity11);
    cloverville.addGreenActivity(activity12);
    cloverville.addGreenActivity(activity13);


    SharedTask sharedtask1 = new SharedTask("preparing food for communal\n" + "dinners", 300);
    SharedTask sharedtask2 = new SharedTask("tidying the workshop", 500);
    SharedTask sharedtask3 = new SharedTask("taking care of the shared outdoor areas", 150);
    SharedTask sharedtask4 = new SharedTask("garden duties", 200);
    SharedTask sharedtask5 = new SharedTask("organizing books", 250);
    SharedTask sharedtask6 = new SharedTask("washing dishes", 180);
    SharedTask sharedtask7 = new SharedTask("cleaning windows", 220);
    SharedTask sharedtask8 = new SharedTask("mopping floor", 270);
    SharedTask sharedtask9 = new SharedTask("preparing snacks", 160);
    SharedTask sharedtask10 = new SharedTask("sorting recycling", 190);
    cloverville.addSharedTask(sharedtask1);
    cloverville.addSharedTask(sharedtask2);
    cloverville.addSharedTask(sharedtask3);
    cloverville.addSharedTask(sharedtask4);
    cloverville.addSharedTask(sharedtask5);
    cloverville.addSharedTask(sharedtask6);
    cloverville.addSharedTask(sharedtask7);
    cloverville.addSharedTask(sharedtask8);
    cloverville.addSharedTask(sharedtask9);
    cloverville.addSharedTask(sharedtask10);

    GreenGoal goal1 = new GreenGoal("pizza night", 1500, "yeaaah");
    GreenGoal goal2 = new GreenGoal("rainwater collector", 10000, "collects rainwater");
    GreenGoal goal3 = new GreenGoal("new communal wheelbarrow", 5000, "shared community tool");
    GreenGoal goal4 = new GreenGoal("flowers community garden", 1800, "green thumb");
    GreenGoal goal5 = new GreenGoal("compost bin", 2500, "reduce waste");
    GreenGoal goal6 = new GreenGoal("rainwater harvesting barrel", 2000, "save water");
    GreenGoal goal7 = new GreenGoal("tree planting event", 1000, "plant trees");
    GreenGoal goal8 = new GreenGoal("plastic-free week", 1000, "reduce plastic");
    GreenGoal goal9 = new GreenGoal("reusable tote bags for everyone", 4000, "less plastic");
    cloverville.addGreenGoal(goal1);
    cloverville.addGreenGoal(goal2);
    cloverville.addGreenGoal(goal3);
    cloverville.addGreenGoal(goal4);
    cloverville.addGreenGoal(goal5);
    cloverville.addGreenGoal(goal6);
    cloverville.addGreenGoal(goal7);
    cloverville.addGreenGoal(goal8);
    cloverville.addGreenGoal(goal9);

    cloverville.setDescription("Cloverville began as a handful of curious homes around a stream. Green Bob rallied the neighbors  to capture every small act of care—cycling, composting, planting, sharing—and turn it into common  green points. The points remind us that every helpful gesture counts toward a thriving place. The goal is simple: make the invisible visible. We log the work, celebrate contributors, and reinvest points into community rewards that keep the cycle alive.");

    cloverville.addResetPeriod(20);
    cloverville.checkReset();
    cloverville.setActiveGreenGoal(goal3);
    //cloverville.setActiveGreenGoal(goal4);

    VillageModelManager manage = new VillageModelManager("village.bin");
    manage.saveVillage(cloverville);
  }
}

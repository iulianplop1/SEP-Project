package model;

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
    cloverville.addVillager(villager1);
    cloverville.addVillager(villager2);
    cloverville.addVillager(villager3);
    cloverville.addVillager(villager4);

    System.out.println(cloverville);


    TradeOffer trade1 = new TradeOffer(villager4, "peanut butter jelly sandwich", 35);
    cloverville.addTradeOffer(trade1);

    System.out.println(cloverville);

    cloverville.finishTradeOffer(trade1, villager2);
    cloverville.removeVillager(villager3);
    TradeOffer trade2 = new TradeOffer(villager4, "world famous hungarian pálinka", 67);
    cloverville.addTradeOffer(trade2);
    cloverville.finishTradeOffer(trade2, villager1);

    System.out.println(cloverville);

    int dayoftoday = Date.today().getDay();
    int monthoftoday = Date.today().getMonth();
    int yearoftoday = Date.today().getYear();
    Date dater = new Date();
    dater.setPeriod(0);
    dater.checkDate(cloverville, dayoftoday, monthoftoday, yearoftoday);

    System.out.println(cloverville);

    GreenActivity activity1 = new GreenActivity("cycling to work", 50);
    GreenActivity activity2 = new GreenActivity("biodegradable kitchen waste", 40);

    System.out.println(cloverville);

    cloverville.editGreenActivity(activity1, activity2); //now both should be activity2

    GreenGoal goal1 = new GreenGoal("pizza", 150);
    GreenGoal goal2 = new GreenGoal("spaghetti", 200);
    cloverville.addGreenGoal(goal1);

    cloverville.editGreenActivity(activity1, activity2); //now both should be activity2

    System.out.println(cloverville);

    cloverville.finishGreenGoal(goal2);

    System.out.println(cloverville);

    SharedTask sharedtask1 = new SharedTask(cloverville, "cleaning grupperoom", 300);
    cloverville.addSharedTask(sharedtask1);
    sharedtask1.addPerformer(villager1);
    sharedtask1.addPerformer(villager2);

    System.out.println(cloverville);


    cloverville.finishSharedTask(sharedtask1);

    System.out.println(cloverville);


    SharedTask sharedtask2 = new SharedTask(cloverville, "cleaning grupperoom", 5000);

    sharedtask2.addPerformer(villager3);
    cloverville.addSharedTask(sharedtask2);


    System.out.println(cloverville);

  }
}

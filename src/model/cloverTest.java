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
    dater.setPeriod(7);
    dater.checkDate(cloverville, dayoftoday, monthoftoday, yearoftoday);

    System.out.println(cloverville);
    System.out.println(dater);
  }
}

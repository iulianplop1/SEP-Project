package model;

public class cloverTest
{
  public static void main(String[] args)
  {
    Village cloverville = new Village();
    Villager villager1= new Villager(cloverville, "Bátor", "Gábora", 104);
    Villager villager2 = new Villager(cloverville,"Mike", "Lorenzen", 105);
    Villager villager3 = new Villager(cloverville,"Arsenie", "Bilba", 120);
    Villager villager4 = new Villager(cloverville,"Iulian", "Plop", 111);
    cloverville.addVillager(villager1);
    cloverville.addVillager(villager2);
    cloverville.addVillager(villager3);
    cloverville.addVillager(villager4);

    System.out.println(cloverville);

    TradeOffer trade1 = new TradeOffer(cloverville, villager4, "peanut butter jelly sandwich", 5);
    cloverville.addTradeOffer(trade1);

    System.out.println(cloverville);

    cloverville.finishTradeOffer(trade1, villager2);
    cloverville.removeVillager(villager3);
    TradeOffer trade2 = new TradeOffer(cloverville, villager4, "world famous hungarian pálinka", 100);
    cloverville.addTradeOffer(trade2);
    cloverville.finishTradeOffer(trade2, villager1);

    System.out.println(cloverville);

    int dayoftoday = Date.today(cloverville).getDay();
    int monthoftoday = Date.today(cloverville).getMonth();
    int yearoftoday = Date.today(cloverville).getYear();
    Date dater = new Date(cloverville);
    dater.setPeriod(0);
    dater.checkDate(dayoftoday, monthoftoday, yearoftoday);

    System.out.println(cloverville);
  }
}

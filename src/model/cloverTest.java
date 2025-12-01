package model;

public class cloverTest
{
  public static void main(String[] args)
  {
    Village cloverville = new Village();
    Villager villager1= new Villager(cloverville, "Bátor", "Gábora", 200);
    Villager villager2 = new Villager(cloverville,"Mike", "Lorenzen", 10);
    Villager villager3 = new Villager(cloverville,"Arsenie", "Bilba", 100);
    Villager villager4 = new Villager(cloverville,"Iulian", "Plop", 90);
    cloverville.addVillager(villager1);
    cloverville.addVillager(villager2);
    cloverville.addVillager(villager3);
    cloverville.addVillager(villager4);
    System.out.println(villager1);
    System.out.println(villager2);
    System.out.println(villager3);
    System.out.println(villager4);

    TradeOffer trade1 = new TradeOffer(cloverville, villager4, "balls", 100);
    cloverville.addTradeOffer(trade1);
    cloverville.finishTradeOffer(trade1, villager2);

    System.out.println(villager1);
    System.out.println(villager2);
    System.out.println(villager3);
    System.out.println(villager4);

    cloverville.removeVillager(villager3);
    TradeOffer trade2 = new TradeOffer(cloverville, villager4, "balls", 100);
    cloverville.addTradeOffer(trade2);
    cloverville.finishTradeOffer(trade2, villager2);

    System.out.println(villager1);
    System.out.println(villager2);
    System.out.println(villager3);
    System.out.println(villager4);

    int dayoftoday = Date.today(cloverville).getDay();
    int montoftoday = Date.today(cloverville).getMonth();
    int yearoftoday = Date.today(cloverville).getYear();
    Date dater = new Date(cloverville);
    dater.setPeriod(5);
    dater.checkDate(dayoftoday, montoftoday, yearoftoday);
  }
}

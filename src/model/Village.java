package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Village implements Serializable {
  private int greenpoints;
  private ArrayList<Villager> villagers;
  private ArrayList<TradeOffer> trades;

  public Village() {
    this.villagers = new ArrayList<>();
    this.trades = new ArrayList<>();
  }
  public void addVillager(Villager villager) {
    villagers.add(villager);
  }
  public void removeVillager(Villager villager) {
    villagers.remove(villager);
  }
  public List<Villager> getVillagers() {
    return villagers;
  }

  public void addTradeOffer(TradeOffer tradeOffer)
  {
    trades.add(tradeOffer);
  }
  public void removeTradeOffer(TradeOffer tradeOffer) {
    trades.remove(tradeOffer);
  }
  public void finishTradeOffer(TradeOffer tradeOffer)
  {
    if(trades.contains(tradeOffer)){
      ArrayList<Villager> possiblebuyers = tradeOffer.getPossibleBuyers();
      System.out.println(possiblebuyers);
      tradeOffer.setBuyer(villagers.get(0));
      tradeOffer.finish();

    }
  }
}
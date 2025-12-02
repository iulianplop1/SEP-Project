package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Village implements Serializable {
  private int greenpoints;
  private ArrayList<Villager> villagers;
  private ArrayList<TradeOffer> trades;
  private ArrayList<GreenActivity> catalogueofideas;
  private ArrayList<SharedTask> sharedTasks = new ArrayList<>();



    public Village() {
    this.villagers = new ArrayList<>();
    this.trades = new ArrayList<>();
    this.catalogueofideas = new ArrayList<>();
    greenpoints = 0;
    this.sharedTasks = new ArrayList<>();
  }
  public void addVillager(Villager villager) {
    villagers.add(villager);
  }
  public void removeVillager(Villager villager) {
    villagers.remove(villager);
  }
  public ArrayList<Villager> getVillagers() {
    return villagers;
  }

  public void addTradeOffer(TradeOffer tradeOffer)
  {
    trades.add(tradeOffer);
    System.out.println("TRADE OFFER ADDED --> " + tradeOffer);
    ArrayList<Villager> possiblebuyers = tradeOffer.getPossibleBuyers();
    System.out.println("POSSIBLE BUYERS --> " + possiblebuyers);
  }
  public void removeTradeOffer(TradeOffer tradeOffer) {
    trades.remove(tradeOffer);
  }
  public void finishTradeOffer(TradeOffer tradeOffer, Villager buyer) {
    if(trades.contains(tradeOffer)){
      tradeOffer.setBuyer(buyer);
      tradeOffer.finish();
      trades.remove(tradeOffer);
    }
  }

  public int getAveragePoints(){
    int sum = 0;
    for(Villager villager : villagers){
      sum += villager.getPoints();
    }
    return Math.round(sum/villagers.size());
  }

  public void Reset(){
    for (Villager villager : villagers) {
      greenpoints += villager.getPoints();
      villager.setPoints(0);
    }
    System.out.println("RESET HAPPENING --> " + villagers);
  }

  public String toString(){
    return "\nvillagers: " + villagers.toString() + "\ngreen points:" + greenpoints
        + "\ntrades:" + trades.toString() + "\ncatalogue of ideas:" + catalogueofideas.toString()
        + "\naverage points:" + getAveragePoints() + "\n";
  }
    SharedTask sharedtask1 =new SharedTask("Ben Dover",67);

    public void finishSharedTask(){
      sharedTasks.add(sharedtask1);
      int revenue=(int) Math.floor(sharedtask1.getPoints()/ sharedtask1.NrPerformers());
      for (int i = 0; i <sharedtask1.NrPerformers() ; i++) {
          sharedtask1.getPerformer(i).addPoints(revenue);
      }

      for (int i = 0; i <sharedTasks.size() ; i++) {
            if (sharedTasks.get(i).equals(sharedtask1))
                sharedTasks.remove(i);

        }

  }

}
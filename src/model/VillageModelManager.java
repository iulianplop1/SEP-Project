package model;
import utils.MyFileHandler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class VillageModelManager
{
  private String fileName;

  public VillageModelManager(String fileName) {
    this.fileName = fileName;
  }

  public Village getVillage() {
    Village village=new Village();
    try
      {
         village = (Village)MyFileHandler.readFromBinaryFile(fileName);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
        System.out.println(e.getMessage());
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }
      return village;
  }
  public void saveVillage(Village village) {
      try
      {
         MyFileHandler.writeToBinaryFile(fileName, village);
        System.out.println("writte to " +  fileName);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error writing to file");
      }
   }

  public ArrayList<Villager> getVillagers(){
    Village cloverville = getVillage();
    return cloverville.getVillagers();
  }
  public ArrayList<TradeOffer> getTrades() {
    Village cloverville = getVillage();
    return cloverville.getTrades();
  }

  public void addVillager(Villager villager) {
    Village cloverville = getVillage();
    cloverville.addVillager(villager);
    saveVillage(cloverville);
  }
  public void removeVillager(Villager villager){
    Village cloverville = getVillage();
    ArrayList<Villager> villagers = cloverville.getVillagers();
    cloverville.removeVillager(villager);
    saveVillage(cloverville);
  }
  public void changeVillager(Villager old, Villager villager) {
    Village cloverville = getVillage();
    cloverville.changeVillager(old, villager);
    saveVillage(cloverville);
  }

  public void addTrade(TradeOffer trade){
    Village cloverville = getVillage();
    cloverville.addTradeOffer(trade);
    saveVillage(cloverville);
  }
  public void removeTrade(TradeOffer trade) {
    if (trade == null){
      throw new IllegalArgumentException("trade offer is null");
    }
    Village cloverville = getVillage();
    ArrayList<TradeOffer> trades = cloverville.getTrades();
    cloverville.removeTradeOffer(trade);
    saveVillage(cloverville);
  }
  public void changeTrade(TradeOffer old, TradeOffer trade){
    if(old == null || trade == null){
      throw new IllegalArgumentException("old trade or new trade is null");
    }
    else{
      Village cloverville = getVillage();
      cloverville.editTradeOffer(old, trade);
      saveVillage(cloverville);
    }
  }
  public void finishTrade(TradeOffer trade, Villager buyer) {
    if (trade == null || buyer == null){
      throw new IllegalArgumentException("Trade or buyer is null");
    }
    else{
      Village cloverville = getVillage();
      cloverville.finishTradeOffer(trade, buyer);
      System.out.println("finished tradeoffer");
      saveVillage(cloverville);
    }
  }

  public void addResetDay(int days){
    Village cloverville = getVillage();
    cloverville.addResetPeriod(days);
    saveVillage(cloverville);
  }
  public void resetNow(){
    Village cloverville = getVillage();
    cloverville.resetnow();
    saveVillage(cloverville);
  }
 }

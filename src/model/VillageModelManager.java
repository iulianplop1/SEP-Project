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
        System.out.println("Done");
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
    ArrayList<Villager> villagers = cloverville.getVillagers();
    villagers.add(villager);
    saveVillage(cloverville);
  }
  public void removeVillager(Villager villager){
    Village cloverville = getVillage();
    ArrayList<Villager> villagers = cloverville.getVillagers();

    for(int i=0;i<villagers.size();i++){
      if(villagers.get(i).equals(villager)){
        villagers.remove(villagers.get(i));
      }
    }

    saveVillage(cloverville);
  }
  public void changeVillager(Villager old, Villager villager) {
    String first = villager.getFirstname();
    String last = villager.getLastname();
    int points = villager.getPoints();
    Village cloverville = getVillage();
    ArrayList<Villager> villagers = cloverville.getVillagers();
    for (int i = 0; i < villagers.size(); i++)
    {
      if (villagers.get(i).equals(old))
      {
        villagers.get(i).setFirstName(first);
        villagers.get(i).setLastName(last);
        villagers.get(i).setPoints(points);
      }
    }
    saveVillage(cloverville);
  }

  public void addTrade(TradeOffer trade){
    Village cloverville = getVillage();
    ArrayList<TradeOffer> trades = cloverville.getTrades();
    trades.add(trade);
    saveVillage(cloverville);
  }

 }

package model;
import utils.MyFileHandler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class VillageModelManager
{
  private String fileName;

  public VillageModelManager(String fileName)
  {
    this.fileName = fileName;
  }

  public Village getVillage()
  {
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
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }
      return village;
  }

  public void saveVillage(Village village)
   {
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
  public void addVillager(Villager villager)
  {
    Village cloverville = getVillage();
    ArrayList<Villager> villagers = cloverville.getVillagers();
    villagers.add(villager);
    saveVillage(cloverville);
  }
  public void removeVillager(Villager villager){
    Village cloverville = getVillage();
    ArrayList<Villager> villagers = cloverville.getVillagers();
    if (villagers.contains(villager)){
      villagers.remove(villager);
    }
    saveVillage(cloverville);
  }



  public void changeVillagerPoints(Villager villager, int points)
   {
      Village cloverville = getVillage();
      ArrayList<Villager> villagers = cloverville.getVillagers();

      for (int i = 0; i < villagers.size(); i++)
      {
        if (villagers.get(i)==villager){    //if we found our villager
          villagers.get(i).setPoints(points);
        }
      }
      saveVillage(cloverville);
   }


 }

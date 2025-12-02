package model;
import utils.MyFileHandler;
import java.io.FileNotFoundException;
import java.io.IOException;
public class VillageModelManager
{
  private String fileName;
  public VillageModelManager(String filename)
  {
    this.fileName = fileName;
  }
  /*public Village getAllVillagers()
  {
    Village village=new Village();
    try
      {
         getvillagerList = (Village)MyFileHandler.readFromBinaryFile(fileName);
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
      return villagerList;
  }
  public void saveVillagers(Village villagerList)
   {
      try
      {
         MyFileHandler.writeToBinaryFile(fileName, villagerList);
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
  /* public void changeVillagerPoints(String firstName, String lastName, int points)
   {
      Village village = getAllVillagers();

      for (int i = 0; i < villagerList.getVillagers().size(); i++)
      {
         Village villager = villagerList.getVillagers().get(i);

         if (villager.getVillagerFirstName().equals(firstName) && villager.getVillagerLastName().equals(lastName))
         {
            villager.setPoints(points);
         }
      }

      saveVillagers(villagerList);


      try
      {
         MyFileHandler.writeToBinaryFile("village.bin", villager);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("Error opening file ");
      }
      catch (IOException e)
      {
         System.out.println("IO Error writing to file ");
      }

      System.out.println("Done");
   } */
 }

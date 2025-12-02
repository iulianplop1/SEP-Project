package model;

import utils.MyFileHandler;
import java.io.FileNotFoundException;
import java.io.IOException;

/*public class VillageModelManager
{
  private String filename;
  public VillageModelManager(String filename)
  {
    this.filename = filename;
  }
  public Village getAllVillagers()
  {
    Village villagerList=new Village();
    try
      {
         villagerList = (Village)MyFileHandler.readFromBinaryFile(fileName);
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
   public void changeVillagerPoints(String firstName, String lastName, int points)
   {
      Village villagerList = getAllVillagers();

      for (int i = 0; i < villagerList.size(); i++)
      {
         Village villager = villagerList.get(i);

         if (villager.getFirstName().equals(firstName) && villager.getLastName().equals(lastName))
         {
            villager.setPoints(points);
         }
      }

      saveStudents(allStudents);
   }
 }*/

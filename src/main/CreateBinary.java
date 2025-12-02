/*package main;

import model.Village;
import utils.MyFileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CreateBinary
{
  public static void main(String[] args)
  {
    Village village = new Village();
    String[] villageArray=null;
    try
    {
      villageArray = MyFileHandler.readFromBinaryFile("students.bin");

      for(int i = 0; i<villageArray.length; i++)
      {
        String temp = villageArray[i];
        String[] tempArr = temp.split(",");
        String firstName = tempArr[0];
        String lastName = tempArr[1];
        String country = tempArr[2];

        village.add(new village(firstName, lastName, points));
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File was not found, or could not be opened");
    }

    try
    {
      MyFileHandler.writeToBinaryFile("students.bin", village);
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
  }
  }
}*/

package main;

import model.Village;
import model.Villager;
import utils.MyFileHandler;


import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadInitialData
{
  public static void main(String[] args)
  {
    Village village = new Village();
    try
    {
      village = (Village) MyFileHandler.readFromBinaryFile("village.bin");

      System.out.println(village);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File was not found, or could not be opened");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file ");
    }
    catch (ClassNotFoundException e){
      System.out.println("Class not found");
    }

    try
    {
      MyFileHandler.writeToBinaryFile("village.bin", village);
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

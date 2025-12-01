package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Village implements Serializable
{
  private static ArrayList<Villager> villagers;

  public Village()
  {
    villagers = new ArrayList<>();
  }
  public void addVillager(Villager villager){
    villagers.add(villager);
  }
  public void removeVillager(Villager villager){
    villagers.remove(villager);
  }

  public static ArrayList<Villager> getVillagers(){
    return villagers;
  }

}

package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Village implements Serializable {
  private int greenpoints;
  private final List<Villager> villagers;

  public Village() {
    this.villagers = new ArrayList<>();
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
}
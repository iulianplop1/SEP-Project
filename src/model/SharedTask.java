package model;

import java.io.Serializable;
import java.util.ArrayList;

public class SharedTask implements Serializable
{
  private String taskName;
  private int points;
  private ArrayList<Villager> performers;

  public SharedTask(String taskName, int points) {
    this.taskName = taskName;
    this.points = points;
    performers = new ArrayList<>();//nigga
  }


}

//Bátor here, the villager.isAboveAverage() now works if you need to check with that, village is now also connected to villager as well this way

package model;

import java.io.Serializable;
import java.util.ArrayList;

public class SharedTask implements Serializable {
  private ArrayList<Villager> performers;
  private int points;
  private String taskName;


  public SharedTask(String taskName, int points) {
    this.performers = new ArrayList<>();
    this.taskName = taskName;
    this.points=points;
  }



  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  public int getPoints() {
    return points;
  }

  public String getTaskName() {
    return taskName;
  }

  public void addPerformer(Villager vilagger) {
    performers.add(vilagger);
  }

  public void resetPerformers()
  {
    performers.removeAll(performers);
  }


  public int NrPerformers() {
    return performers.size();
  }

  public String toString() {
    return  taskName + "["+ points +"] ";
  }


  public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass())
      return false;
    SharedTask other = (SharedTask) obj;
    return this.taskName.equals(other.taskName) &&
        points == other.points;
  }

  public SharedTask copy() {
    return new SharedTask(taskName, points);
  }

  public Villager getPerformer(int i) {
    return performers.get(i);

  }

}





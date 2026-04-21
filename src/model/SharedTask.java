package model;

import java.io.Serializable;
import java.util.ArrayList;
/**
 *  Class for modifying and completing the shared tasks
 */

public class SharedTask implements Serializable {
  private ArrayList<Villager> performers;
  private int points;
  private String taskName;

  /**
   * Two-argument constructor;
   * @param taskName Shared Task's name
   * @param points the Shared Task's points
   */
  public SharedTask(String taskName, int points) {
    this.performers = new ArrayList<>();
    this.taskName = taskName;
    this.points=points;
  }


  /**
   * Sets the Name of this Shared Task
   * @param taskName Shared Task's Name
   */
  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }
  /**
   * Sets the Points of this Shared Task
   * @param points Shared Task's Points
   */
  public void setPoints(int points) {
    this.points = points;
  }

  /**
   * Gets the Shared Task's points.
   * @return the Shared Tasks points.
   */

  public int getPoints() {
    return points;
  }
  /**
   * Gets the Shared Task's name.
   * @return the Shared Tasks name.
   */
  public String getTaskName() {
    return taskName;
  }
  /**
   * Gets the villager performing the shared task at a specific index
    * @param i the index of the villager
   * @return the villager.
   */
  public Villager getPerformer(int i) {
    return performers.get(i);

  }
  /**
   * Adds a villager who will perform the shared task.
   * @param vilagger the object that is added
   */


  public void addPerformer(Villager vilagger) {
    performers.add(vilagger);
  }
  /**
   * Resets the list of villagers who perform a shared task.
   */

  public void resetPerformers()
  {
    performers.removeAll(performers);
  }

  /**
   * @return the number of villagers completing the shared task
   */
  public int NrPerformers() {
    return performers.size();
  }

  /**
   * @return the name of the shared task along with its points
   */

  public String toString() {
    return  taskName + "["+ points +"] ";
  }

  /**
   * Compares Shared Task name and points
   * @param obj the object to compare with
   * @return true if the given object is equal to this Shared Task
   */

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



}





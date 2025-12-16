package model;

import java.io.Serializable;
/**
 *  Class for modifying the GreenGoal class
 */
public class GreenGoal implements Serializable
{
  private int requiredPoints;
  private String goalName;
  private String greenDescriptions;

  /**
   * Three-argument constructor;
   * @param goalName the GreenGoal's name
   * @param requiredPoints the GreenGoal's required points
   * @param greenDescriptions GreenGoal's description
   */

  public GreenGoal(String goalName, int requiredPoints, String greenDescriptions)
  {
    this.goalName = goalName;
    this.requiredPoints = requiredPoints;
    this.greenDescriptions = greenDescriptions;
  }

  /**
   * Gets the GreenGoal's goalName.
   * @return the GreenGoal's goalName.
   */
  public String getGoalName()
  {
    return goalName;
  }

  /**
   * Sets the  goalName of this GreenGoal
   * @param goalName the GreenGoal's goalName
   */
  public void setGoalName(String goalName)
  {
    this.goalName = goalName;
  }
  /**
   * Gets the GreenGoal's requiredPoints.
   * @return the GreenGoal's requiredPoints.
   */
  public int getRequiredPoints()
  {
    return requiredPoints;
  }

  /**
   * Sets the  requiredPoints of this GreenGoal
   * @param requiredPoints the GreenGoal's requiredPoints
   */
  public void setRequiredPoints(int requiredPoints)
  {
    this.requiredPoints = requiredPoints;
  }

  /**
   * Gets the GreenGoal's greenDescription.
   * @return the GreenGoal's greenDescriptions.
   */
  public String getGreenDescription()
  {
    return greenDescriptions;
  }

  /**
   * Sets the greenDescription of this GreenGoal
   * @param greenDescriptions the GreenGoal's greenDescriptions
   */
  public void setGreenDescription(String greenDescriptions)
  {
    this.greenDescriptions = greenDescriptions;
  }

  /**
   * Compares goalName, requiredPoints, and greenDescriptions of two GreenGoal.
   * @param obj the object to compare with
   * @return true if the given object is equal to this GreenGoal
   */
  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
      return false;
    GreenGoal other = (GreenGoal) obj;
    return this.goalName.equals(other.goalName)
        && requiredPoints == other.requiredPoints && this.greenDescriptions.equals(other.greenDescriptions);
  }

  /**
   *
   * @return a string representation of this GreenGoal
   */
  public String toString()
  {
    return ""+goalName+" ["+ requiredPoints + "]" + greenDescriptions;
  }


  public GreenGoal copy()
  {
    return new GreenGoal(goalName, requiredPoints, greenDescriptions);
  }
}


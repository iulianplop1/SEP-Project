package model;

import java.io.Serializable;

public class GreenGoal implements Serializable
{
  private int requiredPoints;
  private String goalName;
  private String greenDescriptions;

  public int getRequiredPoints()
  {
    return requiredPoints;
  }

  public void setRequiredPoints(int requiredPoints)
  {
    this.requiredPoints = requiredPoints;
  }

  public String getGoalName()
  {
    return goalName;
  }
  public void setGoalName(String goalName)
  {
    this.goalName = goalName;
  }
  public String getGreenDescription()
  {
    return greenDescriptions;
  }
  public void setGreenDescription(String greenDescription)
  {
    this.greenDescriptions = greenDescriptions;
  }
  public GreenGoal(String goalName, int requiredPoints, String greenDescription)
  {
    this.goalName = goalName;
    this.requiredPoints = requiredPoints;
    this.greenDescriptions = greenDescription;
  }

  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
      return false;
    GreenGoal other = (GreenGoal) obj;
    return this.goalName.equals(other.goalName)
        && requiredPoints == other.requiredPoints;
  }
  public String toString()
  {
    return goalName+" ["+ requiredPoints + "] '" + greenDescriptions + "'";
  }
  public GreenGoal copy()
  {
    return new GreenGoal(goalName, requiredPoints, greenDescriptions);
  }
}
//lol

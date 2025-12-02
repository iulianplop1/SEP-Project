package model;

import java.io.Serializable;

public class GreenGoal implements Serializable
{
  private int requiredPoints;
  private String goalName;

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
  public GreenGoal(String goalName, int requiredPoints)
  {
    this.goalName = goalName;
    this.requiredPoints = requiredPoints;
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
    return ""+goalName+" ["+ requiredPoints + "]";
  }
  public GreenGoal copy()
  {
    return new GreenGoal(goalName, requiredPoints);
  }
}
//lol

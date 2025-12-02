package model;

import java.io.Serializable;

public class GreenActivity implements Serializable
{
  private String activityName;
  private int points;

  public GreenActivity(String activityName, int points)
  {
    this.activityName = activityName;
    this.points = points;
  }

  public void setActivityName(String activityName)
  {
    this.activityName = activityName;
  }

  public void setPoints(int points)
  {
    this.points = points;
  }

  public int getPoints()
  {
    return points;
  }

  public String getActivityName()
  {
    return activityName;
  }

  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
      return false;
    GreenActivity other = (GreenActivity) obj;
    return this.activityName.equals(other.activityName) && points == other.points;
  }

  public String toString()
  {
    return "The activity " + activityName + " has " + points + " points";
  }

  public GreenActivity copy()
  {
    return new GreenActivity(activityName, points);
  }
}

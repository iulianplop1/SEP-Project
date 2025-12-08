package model;

import java.io.Serializable;

public class GreenActivity implements Serializable
{
  private String activityName;
  private int points;
  private Date date;

  public GreenActivity(String activityName, int points)
  {
    this.activityName = activityName;
    this.points = points;
    date = Date.today();
  }

  public GreenActivity(String activityName, int points, Date date) {
    this.activityName = activityName;
    this.points = points;
    this.date = date;
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

  public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass())
      return false;
    GreenActivity other = (GreenActivity) obj;
    return this.activityName.equals(other.activityName) && points == other.points &&
        date.equals(other.date);
  }

  public String toString()
  {
    return activityName + " " + points + " points - " + date.toString();
  }
  public GreenActivity copy()
  {
    return new GreenActivity(activityName, points, date);
  }
}

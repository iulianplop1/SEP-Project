
package model;
import java.io.Serializable;

/**
 *  Class for modifying the Green Activities class
 */


public class GreenActivity implements Serializable
{
  private String activityName;
  private int points;
  private Date date;

  /**
   * Two-argument constructor;
   * @param activityName the GreenActivity's name
   * @param points the GreenActivity's points
   */
  public GreenActivity(String activityName, int points)
  {
    this.activityName = activityName;
    this.points = points;
    date = Date.today();
  }

  /**
   * Three-argument constructor;
   * @param activityName the GreenActivity's name
   * @param points the GreenActivity's points
   * @param date GreenActivity's date
   */
  public GreenActivity(String activityName, int points, Date date) {
    this.activityName = activityName;
    this.points = points;
    this.date = date;
  }

  /**
   * Sets the activityName of this GreenActivity
   * @param activityName the GreenActivity's activityName
   */
  public void setActivityName(String activityName)
  {
    this.activityName = activityName;
  }


  /**
   * Sets the points of this GreenActivity
   * @param points the GreenActivity's points
   */
  public void setPoints(int points)
  {
    this.points = points;
  }

  /**
   * Gets the GreenActivity's points.
   * @return the GreenActivity's points.
   */
  public int getPoints()
  {
    return points;
  }

  /**
   * Gets the GreenActivity's activityName.
   * @return the GreenActivity's activityName.
   */
  public String getActivityName()
  {
    return activityName;
  }

  /**
   * Compares activityName, points, and date of creation of two GreenActivity.
   * @param obj the object to compare with
   * @return true if the given object is equal to this GreenActivity
   */
  public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass())
      return false;
    GreenActivity other = (GreenActivity) obj;
    return this.activityName.equals(other.activityName) && points == other.points &&
        date.equals(other.date);
  }

  /**
   *
   * @return a string representation of this GreenActivity
   */
  public String toString()
  {
    return activityName + " " + points + " points - " + date.toString();
  }


  public GreenActivity copy()
  {
    return new GreenActivity(activityName, points, date);
  }
}

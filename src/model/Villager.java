package model;

import java.io.Serializable;

/**
 * Villager class for taking care of villagers in the village
 * @author GaboraBrave
 */

public class Villager implements Serializable
{
  private String firstname;
  private String lastname;
  private int personalpoints;
  /**
   * 2 argument constructor;
   * @param firstname Villager first name
   * @param lastname Villager last name
   */
  public Villager(String firstname, String lastname){
    this.firstname = firstname;
    this.lastname = lastname;
    personalpoints = 0;
  }
  /**
   * 3 argument constructor;
   * @param firstname Villager's first name (String)
   * @param lastname Villager's last name (String)
   * @param personalpoints Villager's personal points (int)
   */
  public Villager(String firstname, String lastname,  int personalpoints){
    this.firstname = firstname;
    this.lastname = lastname;
    this.personalpoints = personalpoints;
  }

  /**
   * Gets the Villager's points.
   * @return the Villager points.
   */
  public int getPoints(){
    return personalpoints;
  }
  /**
   * Gets the Villager's first name.
   * @return the Villager first name.
   */
  public String getFirstname()
  {
    return firstname;
  }
  /**
   * Gets the Villager's last name.
   * @return the Villager last name.
   */
  public String getLastname()
  {
    return lastname;
  }
  /**
   * Sets the first name of the selected Villager
   * @param firstname the Villager's first name
   */
  public void setFirstName(String firstname)
  {
    this.firstname = firstname;
  }
  /**
   * Sets the last name of the selected Villager
   * @param lastname the Villager's last name
   */
  public void setLastName(String lastname)
  {
    this.lastname = lastname;
  }
  /**
   * Sets the points of the selected Villager, overwriting the past set points
   * @param points the Villager's first name
   */


  public void setPoints(int points)
  {
    personalpoints = points;
  }
  /**
   * adds points to the curent amount of point of the selected villager
   * @param points the number of points that will be added
   */
  public void addPoints(int points)
  {
    personalpoints += points;
  }
  /**
   * removes points from the curent amount of point of the selected villager
   * @param points the number of points that will be removed
   */
  public void subtractPoints(int points)
  {
    personalpoints -= points;
  }

  /**
   * checks if the Villager has more personal points than the parameter requiredpoints --> for trade offers
   * @param required required points (to finish a trade) (int)
   * @return ture or false
   */
  public boolean checkPoints(int required){
    return personalpoints >= required;
  }
  /**
   * checks if the Villager' personal points are below or above all the villagers' personal point average
   * @param averagepoints required points (to finish a trade) (int)
   * @return ture or false
   */
  public boolean isAboveAverage(int averagepoints){
    return personalpoints >= averagepoints;
  }
  /**
   * checks if two Villager objects are the same or not
   * @return true or false
   */
  public boolean equals(Object obj){
    if(obj == null || obj.getClass() != this.getClass()){
      return false;
    }
    Villager other = (Villager)obj;
    return other.firstname.equals(firstname) && other.lastname.equals(lastname);
  }

  /**
   * creates and returns an identical Villager object
   * @return identical Villager object
   */
  public Villager copy(){
    return new Villager(firstname, lastname, personalpoints);
  }

  /**
   * @return String value of the concatenated fields
   * "[" +  personalpoints + "] " + firstname + " " + lastname
   */
  public String toString()
  {
    return "[" +  personalpoints + "] " + firstname + " " + lastname;
  }
}

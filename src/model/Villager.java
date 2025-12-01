package model;

import java.io.Serializable;

public class Villager implements Serializable
{
  private String firstname;
  private String lastname;
  private int personalpoints;

  private Village cloverville;


  public Villager(Village village, String firstname, String lastname){
    this.cloverville = village;
    this.firstname = firstname;
    this.lastname = lastname;
    personalpoints = 0;
  }
  public Villager(Village village, String firstname, String lastname,  int personalpoints){
    this.cloverville = village;
    this.firstname = firstname;
    this.lastname = lastname;
    this.personalpoints = personalpoints;
  }

  public int getPoints(){
    return personalpoints;
  }
  public String getFirstname()
  {
    return firstname;
  }
  public String getLastname()
  {
    return lastname;
  }
  public void setFirstName(String firstname)
  {
    this.firstname = firstname;
  }
  public void setLastName(String lastname)
  {
    this.lastname = lastname;
  }


  public void setPoints(int points)
  {
    personalpoints = points;
  }
  public void addPoints(int points)
  {
    personalpoints += points;
  }
  public void subtractPoints(int points)
  {
    personalpoints -= points;
  }

  public boolean checkPoints(int required){
    return personalpoints >= required;
  }
  public boolean isAboveAverage(){
    return personalpoints >= cloverville.getAveragePoints();
  }

  public boolean equals(Object obj){
    if(obj == null || obj.getClass() != this.getClass()){
      return false;
    }
    Villager other = (Villager)obj;
    return other.firstname.equals(firstname) && other.lastname.equals(lastname) && other.personalpoints == personalpoints;
  }

  public Villager copy(){
    return new Villager(cloverville, firstname, lastname, personalpoints);
  }

  public String toString()
  {
    return firstname + " " + lastname + " - " +  personalpoints;
  }
}

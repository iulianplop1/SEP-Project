package model;

public class GreenPoint
{
  private int green_pool = 0;

  public void addpoints(int points){
    green_pool += points;
  }
  public void usepoints(){
    green_pool = 1;
    //something
    //6 or 7
  }
}

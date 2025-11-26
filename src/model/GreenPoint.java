package model;

public class GreenPoint
{
  private int green_pool = 0;

  public void addpoints(int points){
    green_pool += points;
  }
  public void usepoints(){
    green_pool = 0;
    //something
  }

  public static void main(String[] args)
  {
    System.out.println("Kiss");
  }
}

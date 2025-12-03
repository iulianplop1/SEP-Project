package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TradeOffer implements Serializable {
  private String tradename;
  private int points;
  private Villager seller;
  private String description;
  private ArrayList<Villager> possiblebuyers;


  public TradeOffer(Villager seller, String tradename, int points, String description) {
    this.seller = seller;
    this.tradename = tradename;
    this.points = points;
    this.description = description;
    this.possiblebuyers = new ArrayList<>();
  }

  public void setTradeName(String tradename) {
    this.tradename = tradename;
  }
  public void setPoints(int points) {
    this.points = points;
  }
  public void setSeller(Villager seller) {
    this.seller = seller;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public String getTradeName() {
    return tradename;
  }
  public int getPoints() {
    return points;
  }
  public Villager getSeller() {
    return seller;
  }
  public String getDescription()
  {
    return description;
  }

  public ArrayList<Villager> getPossibleBuyers(ArrayList<Villager> villagers) {
    possiblebuyers.clear();
    for (Villager v : villagers) {
      if (v.checkPoints(this.points)) {
        possiblebuyers.add(v);
      }
    }
    return possiblebuyers;
  }

  public TradeOffer copy(){
    return new TradeOffer(seller, tradename, points, description);
  }

  public String toString()
  {
    return tradename +  " '" + description + "' [" + points + "] by " + seller;
  }

  @Override public boolean equals(Object obj)
  {
    if(obj == null || obj.getClass() != this.getClass()) {return false;}
    TradeOffer other = (TradeOffer)obj;
    return other.tradename.equals(this.tradename) && other.points == this.points && other.description.equals(this.description);
  }
}
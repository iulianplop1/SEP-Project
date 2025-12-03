package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TradeOffer implements Serializable {
  private String tradename;
  private int points;
  private Villager seller;
  private Villager buyer;
  private String description;
  private ArrayList<Villager> possiblebuyers;


  public TradeOffer(Villager seller, String tradename, int points, String description) {
    this.seller = seller;
    this.tradename = tradename;
    this.points = points;
    this.buyer = null;
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
    for (Villager villager : villagers) {
      if (villager.checkPoints(this.points)) {
        possiblebuyers.add(villager);
      }
    }
    return possiblebuyers;
  }

  public void setBuyer(Villager buyer) {
    this.buyer = buyer;
  }

  public void finish() {
    if (buyer != null) {
      System.out.println("TRADE OFFER HAPPENING --> " + buyer + " bought for [" + points + "] from " + seller + " -- " + tradename + " for [" + points + "]");

      buyer.subtractPoints(this.points);
      seller.addPoints(this.points);
    }
  }

  public TradeOffer copy(){
    return new TradeOffer(seller, tradename, points, description);
  }

  public String toString()
  {
    return tradename + " [" + points + "] by " + seller + " '" + description + "'";
  }

  @Override public boolean equals(Object obj)
  {
    if(obj == null || obj.getClass() != this.getClass()){return false;}
    TradeOffer other = (TradeOffer)obj;
    return other.tradename.equals(this.tradename) && other.points == this.points  && other.seller.equals(this.seller) && other.description.equals(this.description);
  }
}
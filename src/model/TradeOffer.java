package model;

import java.io.Serializable;
import java.util.ArrayList;

public class TradeOffer implements Serializable
{
  private String tradename;
  private int points;
  private Villager seller;
  private Villager buyer;
  private ArrayList<Villager> possiblebuyers;

  public TradeOffer(Villager seller, String tradename, int points)
  {
    this.seller = seller;
    this.tradename = tradename;
    this.points = points;
    this.buyer = null;
    this.possiblebuyers = new ArrayList<>();
  }

  public void setTradeName(String tradename)
  {
    this.tradename = tradename;
  }

  public void setPoints(int points)
  {
    this.points = points;
  }

  public void setSeller(Villager seller)
  {
    this.seller = seller;
  }

  public String getTradename()
  {
    return tradename;
  }

  public int getPoints()
  {
    return points;
  }

  public Villager getSeller()
  {
    return seller;
  }

  public ArrayList<Villager> showPossibleBuyers()
  {
    possiblebuyers.clear();
    for (Villager villager : Village.getVillagers())
    {
      if (villager.checkPoints(this.points))
      {
        possiblebuyers.add(villager);
      }
    }
    return possiblebuyers;
  }

  public void setBuyer(Villager buyer){
    this.buyer = buyer;
  }
  public void finish(Villager buyer)
  {
    if (buyer.checkPoints(this.points))
    {
      this.buyer = buyer;
    }
  }
}

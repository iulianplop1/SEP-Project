package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * TradeOffer class for taking care of trades happening in the village
 * @author GaboraBrave
 */

public class TradeOffer implements Serializable {
  private String tradename;
  private int points;
  private Villager seller;
  private String description;
  private ArrayList<Villager> possiblebuyers;

  /**
   * 4 argument constructor
   * @param seller - what to set the seller field to (Villager)
   * @param tradename - what to set the tradename field to (String)
   * @param points - what to set the points field to (int)
   * @param description - what to set the description field to (String)
   */
  public TradeOffer(Villager seller, String tradename, int points, String description) {
    this.seller = seller;
    this.tradename = tradename;
    this.points = points;
    this.description = description;
    this.possiblebuyers = new ArrayList<>();
  }

  /**
   * setTradeName() method
   * @param tradename - trade name to set the tradename field to (String)
   */
  public void setTradeName(String tradename) {
    this.tradename = tradename;
  }
  /**
   * setPoints() method
   * @param points - point value to set the points field to (int)
   */
  public void setPoints(int points) {
    this.points = points;
  }
  /**
   * setSeller() method
   * @param seller - villager to set the seller field to (Villager)
   */
  public void setSeller(Villager seller) {
    this.seller = seller;
  }
  /**
   * setSeller() method
   * @param description - description to set the description field to (String)
   */
  public void setDescription(String description) {
    this.description = description;
  }
  /**
   * getTradeName() method
   * @return trade name - the tradename field of the class (String)
   */
  public String getTradeName() {
    return tradename;
  }
  /**
   * getPoints() method
   * @return point value - the points field of the class (int)
   */
  public int getPoints() {
    return points;
  }
  /**
   * getSeller() method
   * @return seller - the seller field of the class (Villager)
   */
  public Villager getSeller() {
    return seller;
  }
  /**
   * getDescription() method
   * @return description - the description field of the class (String)
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * getPossibleBuyers() method
   * @param villagers - the list of all villagers in the village (Cloverville)
   * @return possiblebuyers - the ArrayList of Villagers who have enough points to complete the trade
   * using the Villager.checkPoints(int points) method
   */
  public ArrayList<Villager> getPossibleBuyers(ArrayList<Villager> villagers) {
    possiblebuyers.clear();
    for (Villager v : villagers) {
      if (v.checkPoints(this.points)) {
        possiblebuyers.add(v);
      }
    }
    return possiblebuyers;
  }

  /**
   * copy() method
   * creates and returns an identical TradeOffer object
   * @return identical TradeOffer object
   */
  public TradeOffer copy(){
    return new TradeOffer(seller, tradename, points, description);
  }
  /**
   * copywithoutpos() method
   * creates and returns an identical Date object only without the ArrayList of possiblebuyers --> used for JSON later
   * @return identical TradeOffer object just without possiblebuyers
   */
  public TradeOffer copywithoutpos(){
    TradeOffer trade = new TradeOffer(seller, tradename, points, description);
    trade.possiblebuyers = null;
    return trade;
  }

  /**
   * toString() method
   * @return String value of the concatenated fields
   * tradename +  " '" + description + "' [" + points + "] by " + seller
   */
  public String toString()
  {
    return tradename +  " '" + description + "' [" + points + "] by " + seller;
  }

  /**
   * equals() method
   * checks if two TradeOffer objects are the same or not
   * @return true or false
   */
  @Override public boolean equals(Object obj)
  {
    if(obj == null || obj.getClass() != this.getClass()) {return false;}
    TradeOffer other = (TradeOffer)obj;
    return other.tradename.equals(this.tradename) && other.points == this.points && other.description.equals(this.description);
  }
}
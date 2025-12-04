package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Village implements Serializable {
  private int greenpoints;
  private ArrayList<Villager> villagers;
  private ArrayList<TradeOffer> trades;
  private ArrayList<SharedTask> sharedTasks;
  private ArrayList<String> catalogueOfIdeas;
  private ArrayList<GreenActivity> greenActivities;
  private GreenGoal greengoal;

  public Village() {
    this.villagers = new ArrayList<>();
    this.trades = new ArrayList<>();
    this.catalogueOfIdeas = new ArrayList<>();
    greenpoints = 0;
    this.sharedTasks = new ArrayList<>();
    this.greengoal = null;
    this.greenActivities=new ArrayList<>();
  }
  public int VillageSize()
  {
    return villagers.size();
  }

  public void addVillager(Villager villager) {
    boolean in = false;
    for(Villager v : villagers){
      if (v.equals(villager)) {
        in = true;
      }
    } if (!in) {
      villagers.add(villager);
    }
  }
  public void removeVillager(Villager villager) {
    boolean in = false;
    for(Villager v : villagers){
      if (v.equals(villager)) {
        in = true;
      }
    } if (in) {
      villagers.remove(villager);
    }
  }
  public void changeVillager(Villager old, Villager villager) {
    String first = villager.getFirstname();
    String last = villager.getLastname();
    int points = villager.getPoints();;
    for(Villager v : villagers){
      if (v.equals(old))
      {
        v.setFirstName(first);
        v.setLastName(last);
        v.setPoints(points);
      }
    }
  }

  public ArrayList<Villager> getVillagers() {
    return villagers;
  }
  public ArrayList<TradeOffer> getTrades() {
    return trades;
  }

  public void addTradeOffer(TradeOffer tradeOffer) {
    boolean in = false;
    for(TradeOffer t : trades){
      if (t.equals(tradeOffer))
        in = true;
    }
    if(!in){
      trades.add(tradeOffer);
      System.out.println("TRADE OFFER ADDED --> " + tradeOffer);
      ArrayList<Villager> possiblebuyers = tradeOffer.getPossibleBuyers(villagers);
      System.out.println("POSSIBLE BUYERS --> " + possiblebuyers);
    }
    else{
      System.out.println("already in list");
    }

  }
  public void removeTradeOffer(TradeOffer tradeOffer) {
    trades.remove(tradeOffer);
  }
  public void editTradeOffer(TradeOffer old, TradeOffer trade) {
    String name = trade.getTradeName();
    Villager seller = trade.getSeller();
    int points = trade.getPoints();
    String description = trade.getDescription();

    for(TradeOffer t : trades){
      if (t.equals(old))
      {
        t.setTradeName(name);
        t.setSeller(seller);
        t.setPoints(points);
        t.setDescription(description);
      }
    }
  }
  public void finishTradeOffer(TradeOffer tradeOffer, Villager buyer) {
    TradeOffer target = null;
    Villager sellerVillager = tradeOffer.getSeller();

    for (TradeOffer t : trades) {
      if (t.equals(tradeOffer)) {
        target = t;
        break;
      }
    }
    if (target != null) {
      trades.remove(target);
      System.out.println("TRADE OFFER FINISHED --> " + target + " " + buyer);
    }

    for (Villager v : villagers) {
      if (v.equals(buyer)) {
        System.out.println(v);
        v.subtractPoints(tradeOffer.getPoints());
        System.out.println(tradeOffer.getPoints() + " subtracted from " + v);
      }
      if (v.equals(sellerVillager)) {
        System.out.println(v);
        v.addPoints(tradeOffer.getPoints());
        System.out.println(tradeOffer.getPoints() + " added to " + v);
      }
    }
  }

  public int getAveragePoints(){
    int sum = 0;
    for(int i = 0; i < villagers.size(); i++){
      sum += villagers.get(i).getPoints();
    }
    return Math.round(sum/villagers.size());
  }

  public void Reset(){
    for(int i = 0; i < villagers.size(); i++){
      greenpoints += villagers.get(i).getPoints();
      villagers.get(i).setPoints(0);
    }
    System.out.println("RESET HAPPENING --> " + villagers + "\n");
  }

  public void addGreenActivity(GreenActivity greenactivity) {
    System.out.println("GREEN ACTIVITY ADDED --> " + greenactivity);
    greenActivities.add(greenactivity);
    String name = greenactivity.getActivityName();
    int points = greenactivity.getPoints();
    if (!catalogueOfIdeas.contains(name)){
      catalogueOfIdeas.add(name);
    }
    greenpoints += points;
  }
  public void removeGreenActivity(GreenActivity greenactivity) {
    String name = greenactivity.getActivityName();
    int points = greenactivity.getPoints();
    if (catalogueOfIdeas.contains(name)){
      catalogueOfIdeas.remove(name);
    }
    greenpoints -= points;
  }

  public void editGreenActivity(GreenActivity greenactivityOld,  GreenActivity greenactivityNew) {
    String nameOld = greenactivityOld.getActivityName();
    String nameNew = greenactivityNew.getActivityName();
    int pointsOld = greenactivityOld.getPoints();
    int pointsNew = greenactivityNew.getPoints();

    if (catalogueOfIdeas.contains(nameOld)){
      catalogueOfIdeas.remove(nameOld);
      catalogueOfIdeas.add(nameNew);
    }
    greenpoints -= pointsOld;
    greenpoints += pointsNew;

    System.out.println("\nGREEN ACTIVTY EDITED --> from " + nameOld + " to " + nameNew + "\n");
  }

  public ArrayList<GreenActivity> getGreenActivities()
  {
    return greenActivities;
  }

  public void addSharedTask(SharedTask sharedtask)
  {

    for (SharedTask existingTask : sharedTasks) {
      if (existingTask.getTaskName().equals(sharedtask.getTaskName())) {


        existingTask.resetPerformers();

        for (int i = 0; i < sharedtask.NrPerformers(); i++) {
          existingTask.addPerformer(sharedtask.getPerformer(i));
        }

        existingTask.setPoints(sharedtask.getPoints());
        System.out.println("UPDATED SHARED TASK --> " + existingTask);
        return;
      }
    }

    System.out.println("ADDING SHARED TASK --> " + sharedtask);
    sharedTasks.add(sharedtask);
  }
  public void finishSharedTask(SharedTask sharedtask1){
    System.out.println("SHARED TASK HAPPENING --> " + sharedtask1);
    double revenue = sharedtask1.getPoints() / sharedtask1.NrPerformers();
    for (int i = 0; i <sharedtask1.NrPerformers() ; i++) {
      if (!sharedtask1.getPerformer(i).isAboveAverage(getAveragePoints())){
        revenue = revenue * 1.2;
        sharedtask1.getPerformer(i).addPoints((int) Math.floor(revenue));
      }
      else {sharedtask1.getPerformer(i).addPoints((int) revenue);}

      System.out.println(sharedtask1.getPerformer(i) + " recieved " + revenue + " points");

    }

  }

  public void addGreenGoal(GreenGoal greengoal)
  {
    if (greengoal != null){
      this.greengoal = greengoal;
      System.out.println("\nGREEN GOAL ADDED --> " + greengoal +"\n");
    }
  }
  public void finishGreenGoal(GreenGoal greengoalNew)
  {
    if (greengoalNew == null){
      System.out.println("\nNEED A SECOND GOAL TO FINISH GREEN GOAL\n");
      return;
    }
    int required = greengoal.getRequiredPoints();
    //subtract the greenpoints from the goal if enough.//
    if (greenpoints>=required)
    {
      greenpoints = greenpoints-required;
      greengoal = greengoalNew;
      System.out.println("\nGOAL WAS FINISHED -->  required points: " + required + " where subtracted from the greenpoints, and a new goal was set: " + greengoalNew + "\n");
    }
    else
    {
      System.out.println("\nNOT ENOUGH POINTS TO FINISH " + greengoal + "\n");
    }
  }

  public String toString(){
    return "\nvillagers: " + villagers.toString() + "\ngreen points:" + greenpoints
        + "\ntrades:" + trades.toString() + "\ncatalogue of ideas:" + catalogueOfIdeas.toString()
        + "\nshared tasks: " + sharedTasks + "\naverage points:"
        + getAveragePoints() + "\ngreen goal: " + greengoal + "\n";
  }
}
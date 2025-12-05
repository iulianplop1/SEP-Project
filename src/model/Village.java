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
  private ArrayList<GreenGoal> goals;
  private int period;
  private String description;

  public Village() {
    this.villagers = new ArrayList<>();
    this.trades = new ArrayList<>();
    this.catalogueOfIdeas = new ArrayList<>();
    greenpoints = 0;
    this.sharedTasks = new ArrayList<>();
    this.goals = new ArrayList<>();
    period = 10;
    this.greenActivities=new ArrayList<>();
  }
  public int VillageSize()
  {
    return villagers.size();
  }

  public int getGreenpoints(){
    return greenpoints;
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
      removeTradesWithVillager(villager);
      villagers.remove(villager);
    }
  }
  private void removeTradesWithVillager(Villager villager) {
    ArrayList<TradeOffer> toRemove = new ArrayList<>();
    for (TradeOffer t : trades)
    {
      Villager tradeseller = t.getSeller();
      if (tradeseller.equals(villager))
      {
        toRemove.add(t);
      }
    }
    for (TradeOffer t : toRemove)
    {
      trades.remove(t);
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

  public void setDescription(String description) {
    this.description = description;
    System.out.println("DESCRIPTION SET --> " + description);
  }
  public String getDescription()
  {
    return description;
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

  public void addResetPeriod(int period) {
    this.period = period;
    System.out.println("PERIOD CHANGED --> " + period);
  }
  public int checkReset(){
    Date today = Date.today();
    Date reset = today.copy();
    reset.nextDay(period);        //reset day found

    if (today.equals(reset)) {
      System.out.println("\nTODAY IS THE DAY OF THE RESET");
      resetnow();

      return -1;        //returns -1 if reset happened
    }
    else{
      System.out.println("RESET ON ----------- " + reset);
      int counter = 0;
      Date today1 = Date.today();
      while(!today1.equals(reset)){
        today1.nextDay(1);
        counter++;
      }
      return counter;       //returns days until reset if it did not happen
    }
  }
  public void resetnow(){
    for(int i = 0; i < villagers.size(); i++){
      greenpoints += villagers.get(i).getPoints();
      villagers.get(i).setPoints(0);
    }
    System.out.println("GREENPOINTS: " + greenpoints);
  }

  public void addGreenGoal(GreenGoal goal){
    boolean in = false;
    for(GreenGoal g : goals){
      if (g.equals(goal)) {
        in = true;
      }
    } if (!in) {
      goals.add(goal);
    }
    System.out.println("\nGREEN GOAL ADDED --> " + goal + "\n");
  }

  public ArrayList<GreenActivity> getGreenActivities()
  {
    return greenActivities;
  }
  public void addGreenActivity(GreenActivity greenactivity) {
    System.out.println("GREEN ACTIVITY ADDED --> " + greenactivity);
    greenActivities.add(greenactivity);
    String name = greenactivity.getActivityName();
    int points = greenactivity.getPoints();
    if (!catalogueOfIdeas.contains(name)){
      catalogueOfIdeas.add(name);
    }
    //greenpoints += points;
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

    if (sharedtask1.NrPerformers() == 0) { // guard
      System.out.println("No performers for shared task, skipping.");
      return;
    }

    double revenue = (double) sharedtask1.getPoints() / sharedtask1.NrPerformers();
    for (int i = 0; i < sharedtask1.NrPerformers(); i++) {
      if (!sharedtask1.getPerformer(i).isAboveAverage(getAveragePoints())) {
        double bonus = revenue * 1.2;
        sharedtask1.getPerformer(i).addPoints((int) Math.floor(bonus));
      } else {
        sharedtask1.getPerformer(i).addPoints((int) revenue);
      }
    }
  }

  public ArrayList<GreenGoal> getGoals()
  {
    return goals;
  }

  public void removeGreenGoal(GreenGoal greengoal)
  {
    goals.remove(greengoal);
  }

  public void finishGreenGoal(GreenGoal greengoalNew)
  {
    if (greengoalNew == null)
    {
      System.out.println("\nNEED A SECOND GOAL TO FINISH GREEN GOAL\n");
      return;
    }
    for (int i = 0; i < goals.size(); i++)
    {
      int required = goals.get(i).getRequiredPoints();

      //subtract the greenpoints from the goal if enough.//
      if (greenpoints >= goals.get(i).getRequiredPoints())
      {
        greenpoints = greenpoints - required;
        goals.get(i++);
        System.out.println(
            "\nGOAL WAS FINISHED -->  required points: " + required
                + " where subtracted from the greenpoints, and a new goal was set: "
                + greengoalNew + "\n");
      }
      else
      {
        System.out.println("\nNOT ENOUGH POINTS TO FINISH " + goals + "\n");
      }
    }
  }

  public String toString(){
    return "\nvillagers: " + villagers.toString() + "\ngreen points:" + greenpoints
        + "\ntrades:" + trades.toString() + "\ncatalogue of ideas:" + catalogueOfIdeas.toString()
        + "\nshared tasks: " + sharedTasks + "\naverage points:"
        + getAveragePoints() + "\ngreen goal: " + goals + "\n";
  }

  public ArrayList<SharedTask> getSharedTasks() {
    return sharedTasks;
  }
}
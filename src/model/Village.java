package model;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Village class for taking care of all ArrayLists and basically connecting everything in model
 */

public class Village implements Serializable
{
  private int greenpoints;
  private ArrayList<Villager> villagers;
  private ArrayList<TradeOffer> trades;
  private ArrayList<SharedTask> sharedTasks;
  private ArrayList<String> catalogueOfIdeas;
  private ArrayList<GreenActivity> greenActivities;
  private ArrayList<GreenGoal> goals;
  private GreenGoal activeGreenGoal;
  private int period;
  private Date setdate;
  private String description;

  /**
   * no-argument constructor;
   * that is meant to initialize all the data
   * with greenpoints set to 0 and reset period set to 10;
   */
  public Village()
  {
    this.villagers = new ArrayList<>();
    this.trades = new ArrayList<>();
    this.catalogueOfIdeas = new ArrayList<>();
    greenpoints = 0;
    this.sharedTasks = new ArrayList<>();
    this.goals = new ArrayList<>();
    period = 10;
    this.greenActivities = new ArrayList<>();
  }


  /**
   * copies trades without their associated possiblebuyers
   * @return toreturn - ArrayList<TradeOffer>
   * goes through trades and uses the TradeOffer.copywithoutpos() for each trade and returns those values
   * --> used for JSON
   */
  public ArrayList<TradeOffer> copytradeswithoutpos(){
    ArrayList<TradeOffer> toreturn = new ArrayList<>();
    for(TradeOffer t : this.trades){
      t = t.copywithoutpos();
      toreturn.add(t);
    }
    return toreturn;
  }

  /**
   * Gets the Village's greenPoints.
   * @return the Village's greenPoints.
   */
  public int getGreenpoints()
  {
    return greenpoints;
  }

  /**
   * Gets the Village's activeGreenGoal.
   * @return the Village's activeGreenGoal.
   */
  public GreenGoal getActiveGreenGoal()
  {
    return activeGreenGoal;
  }
  /**
   * Sets the activeGreenGoal to this GreenGoal
   * @param activeGreenGoal - the Village's activeGreenGoal
   */
  public void setActiveGreenGoal(GreenGoal activeGreenGoal)
  {
    this.activeGreenGoal = activeGreenGoal;
  }
  /**
   * adds villager to village
   * @param villager - what villager to add
   * check if villager is inside the ArrayList of villagers
   * if not --> add villager
   */
  public boolean addVillager(Villager villager)
  {
    boolean in = false;
    for (Villager v : villagers)
    {
      if (v.equals(villager))
      {
        in = true;
      }
    }
    if (!in)
    {
      villagers.add(villager);
      return true;
    }
    return false;
  }
  /**
   * removes villager (and it's associated trades through the removeTradesWithVillager() helper method) from village
   * @param villager - what villager to remove
   * check if villager is inside the ArrayList of villagers
   * if so --> remove villager and associated trades
   */
  public boolean removeVillager(Villager villager)
  {
    boolean in = false;
    for (Villager v : villagers)
    {
      if (v.equals(villager))
      {
        in = true;
      }
    }
    if (in)
    {
      removeTradesWithVillager(villager);
      villagers.remove(villager);
      return true;
    }
    return false;
  }
  /**
   * removes all trades associated with a villager
   * @param villager - what villager's trades to remove
   * checks every trade in ArrayList of trades and if the trade's seller is the villager it removes it from the list of active trades
   * private helper method for removeVillager
   */
  private void removeTradesWithVillager(Villager villager)
  {
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

  /**
   * @param old - villager to edit
   * @param villager - what to change it to
   * finds villager (old) in ArrayList of villagers and changes its values to the new one's
   */
  public void changeVillager(Villager old, Villager villager)
  {
    String first = villager.getFirstname();
    String last = villager.getLastname();
    int points = villager.getPoints();

    for (Villager v : villagers)
    {
      if (v.equals(old))
      {
        v.setFirstName(first);
        v.setLastName(last);
        v.setPoints(points);
      }
    }
  }

  /**
   * @param description (String)
   * sets description field
   */
  public void setDescription(String description)
  {
    this.description = description;
    System.out.println("DESCRIPTION SET --> " + description);
  }

  /**
   * returns description of the village
   * @return description field (String)
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * returns list of villagers in village
   * @return villagers field (ArrayList<Villager>)
   */
  public ArrayList<Villager> getVillagers()
  {
    return villagers;
  }

  /**
   * returns list of active trades
   * @return trades field (ArrayList<TradeOffer>)
   */
  public ArrayList<TradeOffer> getTrades()
  {
    return trades;
  }

  /**
   * @param - trade to add
   * checks if trade is in ArrayList of trades and if not adds it
   * also logs in console the ArrayList of possiblebuyers
   */
  public boolean addTradeOffer(TradeOffer tradeOffer)
  {
    boolean in = false;
    for (TradeOffer t : trades)
    {
      if (t.equals(tradeOffer))
        in = true;
    }
    if (!in)
    {
      trades.add(tradeOffer);

      System.out.println("TRADE OFFER ADDED --> " + tradeOffer);
      ArrayList<Villager> possiblebuyers = tradeOffer.getPossibleBuyers(
          villagers);
      System.out.println("POSSIBLE BUYERS --> " + possiblebuyers);
      return true;
    }
    else
    {
      System.out.println("already in list");
      return false;
    }

  }

  /**
   * @param tradeOffer - trade to remove
   * checks if trade is in ArrayList of trades and if so removes it
   */
  public boolean removeTradeOffer(TradeOffer tradeOffer)
  {
    boolean in = false;
    for (TradeOffer t : trades)
    {
      if (t.equals(tradeOffer))
        in = true;
    }
    if (in){
      trades.remove(tradeOffer);
      return true;
    }
    else{
      return false;
    }
  }

  /**
   * @param old - trade to edit
   * @param trade - what to change it to
   * finds trade (old) in ArrayList of trades and changes its values to the new one's
   */
  public boolean editTradeOffer(TradeOffer old, TradeOffer trade)
  {
    boolean isitin = false;
    String name = trade.getTradeName();
    Villager seller = trade.getSeller();
    int points = trade.getPoints();
    String description = trade.getDescription();

    for (TradeOffer t : trades)
    {
      if (t.equals(old))
      {
        t.setTradeName(name);
        t.setSeller(seller);
        t.setPoints(points);
        t.setDescription(description);
        isitin = true;
      }
    }
    return isitin;
  }

  /**
   * @param tradeOffer - trade to finish
   * @param buyer - buyer to finish the trade
   * finds trade in ArrayList of active trades and removes it
   * finds buyer and seller villager in ArrayList of villagers and does the point exchange
   */
  public void finishTradeOffer(TradeOffer tradeOffer, Villager buyer)
  {
    TradeOffer target = null;
    Villager sellerVillager = tradeOffer.getSeller();

    for (TradeOffer t : trades)
    {
      if (t.equals(tradeOffer))
      {
        target = t;
        break;
      }
    }
    if (target != null)
    {
      trades.remove(target);
      System.out.println("TRADE OFFER FINISHED --> " + target + " " + buyer);
    }

    for (Villager v : villagers)
    {
      if (v.equals(buyer))
      {
        System.out.println(v);
        v.subtractPoints(tradeOffer.getPoints());
        System.out.println(tradeOffer.getPoints() + " subtracted from " + v);
      }
      if (v.equals(sellerVillager))
      {
        System.out.println(v);
        v.addPoints(tradeOffer.getPoints());
        System.out.println(tradeOffer.getPoints() + " added to " + v);
      }
    }
  }

  /**
   * return the average of the personalpoints of all villagers
   * used in Villager clas to check if a villager is above or below average
   * --> used in SharedTask class to check if a bonus is needed
   */
  public int getAveragePoints(){
    int sum = 0;
    for(int i = 0; i < villagers.size(); i++){
      sum += villagers.get(i).getPoints();
    }
    return Math.round(sum/villagers.size());
  }
  /**
   * sets period to the period field (int)
   * and also stores the day of the calling (using Date.today()) to the setdate field (Date)
   */
  public void addResetPeriod(int period) {
    this.period = period;
    setdate = Date.today();
    System.out.println("PERIOD CHANGED --> " + period);
  }
  /**
   * checks if today is the day of the reset
   * if it is --> it calls resetNow() and resets the villagers --> also returns -1
   * if it isn't --> checks how many days are left until reset and returns the value
   */
  public int checkReset(){
    Date today = Date.today();
    Date reset = setdate.copy();
    reset.nextDay(period);          //reset day found

    if (today.equals(reset)) {
      System.out.println("\nTODAY IS THE DAY OF THE RESET");
      resetnow();

      return -1;                    //returns -1 if reset happened
    }
    else{
      System.out.println("RESET ON ----------- " + reset);
      int counter = 0;
      Date today1 = Date.today();
      while(!today1.equals(reset)){
        today1.nextDay(1);
        counter++;
      }
      return counter;                //returns days until reset if it did not happen
    }
  }
  /**
   * adds the villagers' personal points to the green pool (greenpoints) and sets the personal points to 0
   */
  public void resetnow(){
    for(int i = 0; i < villagers.size(); i++){
      greenpoints += villagers.get(i).getPoints();
      villagers.get(i).setPoints(0);
    }
    System.out.println("GREENPOINTS: " + greenpoints);
  }
  /**
   * Add a greenGoal to the goals
   * It also checks if the added goal is in the goals to make sure for no copies
   * @param goal GreenGoal
   */
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

  /**
   * Add a greenActivity to CatalogueOfIdeas
   * It also checks if the addedGreen activity is not in the catalogueOfIdeas
   * The points of the activity are added to the GreenGoal
   * @param greenactivity GreenActivity
   */

  public void addGreenActivity(GreenActivity greenactivity) {
    System.out.println("GREEN ACTIVITY ADDED --> " + greenactivity);
    greenActivities.add(greenactivity);
    String name = greenactivity.getActivityName();
    int points = greenactivity.getPoints();
    if (!catalogueOfIdeas.contains(name)){
      catalogueOfIdeas.add(name);
    }
    System.out.println("Old"+ greenpoints);
    greenpoints += points;
    System.out.println("New"+greenpoints);
  }

  /**
   * Remove a greenActivity from the GreenActivityList and CatalogueOfIdeas
   * It also checks if the addedGreen activity is in the catalogueOfIdeas and removes it if it is
   * @param greenactivity GreenActivity
   */
  public void removeGreenActivity(GreenActivity greenactivity) {
    String name = greenactivity.getActivityName();
    int points = greenactivity.getPoints();
    if (catalogueOfIdeas.contains(name)){
      catalogueOfIdeas.remove(name);
    }
  }

  /**
   * Edit a greenActivity from the GreenActivityList
   * @param greenactivityOld GreenActivity
   * @param greenactivityNew GreenActivity
   *It takes the values of greenactivityNew and replace them with greenactivityOld
   */
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
  /**
   * Adds or updates a SharedTask in the list.
   * If a task with the same name already exists, its performers and pointsare updated instead of adding a duplicate entry.
   * @param sharedtask the SharedTask to add or update
   */
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

  /**
   * Finalizes a SharedTask by distributing its points among all performers.
   * Each performer receives an equal share of the task's points, but those who are below the current average receive a 20% bonus.
   * If the task has no performers, the method exits without making changes.
   * @param sharedtask1 the SharedTask to finalize and award points for
   */


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


  /**
   * Gets the ArrayList goals from Village
   * @return the ArrayList goals
   */
  public ArrayList<GreenGoal> getGoals()
  {
    return goals;
  }


  /**
   * Remove a GreenGoal from the goals
   * @param greengoal GreenGoal
   */
  public void removeGreenGoal(GreenGoal greengoal)
  {
    goals.remove(greengoal);
  }
  /**
   * Sets the greenDescription of this GreenGoal
   */
  public void finishGreenGoal(GreenGoal greengoal)
  {
    for (int i = 0; i < goals.size(); i++)
    {
      int required = goals.get(i).getRequiredPoints();

      //subtract the greenpoints from the goal if enough.//
      if (greenpoints >= goals.get(i).getRequiredPoints())
      {
        greenpoints = greenpoints - required;
        System.out.println(
            "\nGOAL WAS FINISHED -->  required points: " + required
                + " where subtracted from the greenpoints\n");
      }
      else
      {
        System.out.println("\nNOT ENOUGH POINTS TO FINISH " + goals + "\n");
      }
    }
  }
  /**
   * Sets the greenpoints of this GreenGoal
   * @param greenpoints the Village's greenPoints
   */
  public void setGreenpoints(int greenpoints)
  {
    this.greenpoints = greenpoints;
  }


  /**
   * Finish a greenActivity from the GreenActivityList
   * @param greenActivity GreenActivity's
   * Adds the points to the GreenGoal
   */

  public void finishGreenActivity(GreenActivity greenActivity) {
    if (greenActivity == null) {
      System.out.println("GREEN ACTIVITY IS NULL");
      return;
    }

    String name = greenActivity.getActivityName();
    int points = greenActivity.getPoints();



    /*System.out.println("OldCatalogue"+catalogueOfIdeas);
    if (!catalogueOfIdeas.contains(name)) {
      catalogueOfIdeas.add(name);
      System.out.println("NewCatalogue"+catalogueOfIdeas);
    }*/


    System.out.println("OldPoints"+greenpoints);
    greenpoints+= points;
    System.out.println("NewPoints"+greenpoints);
    System.out.println("FINISHED GREEN ACTIVITY → " + name
        + " | +" + points + " points");
  }

  public ArrayList<SharedTask> getSharedTasks() {
    return sharedTasks;
  }

  /**
   *
   * @return a string representation of Village
   * It will return a string of the ArrayList of Villagers,
   * return the total amount of greenPoints
   * a string of the ArrayList of Trades,
   * a string of the ArrayList of CatalogueOfIdeas
   * a string of the ArrayList of SharedTask
   * a string of the ArrayList of  AvailableGoals
   */
  public String toString(){
    return "\nvillagers: " + villagers.toString() + "\ngreen points:" + greenpoints
        + "\ntrades:" + trades.toString() + "\ncatalogue of ideas:" + catalogueOfIdeas.toString()
        + "\nshared tasks: " + sharedTasks + "\naverage points:"
        + getAveragePoints() + "\ngreen goal: " + goals + "\n";
  }


}
package model;

import utils.MyFileHandler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import parser.XmlJsonParser;
import parser.ParserException;

/**
 *  Class for modifying village by adding villagers , shared tasks , trades ,green activites and modifying them
 */
public class VillageModelManager
{
  private String fileName;
  private XmlJsonParser parser;


  /**
   * One-argument constructor;
   * The constructor initializez filename and the JSON parser
   * @param fileName the VillageModelManager fileName
   */
  public VillageModelManager(String fileName) {
    this.fileName = fileName;
    parser = new XmlJsonParser();
  }

  /**
   * Reads the Village from binary
   * @return village
   * using MyFileHandler class
   */

  public Village getVillage() {
    Village village = new Village();
    try
    {
      village = (Village)MyFileHandler.readFromBinaryFile(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
      System.out.println(e.getMessage());
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return village;
  }

  /**
   * Saves the village to binary
   * @param village the Village's village
   * using MyFileHandler class
   */

  public void saveVillage(Village village) {
    try
    {
      MyFileHandler.writeToBinaryFile(fileName, village);
      System.out.println("written to " +  fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
  }

  /**
   * Gets the Village villagers
   * @return the ArrayList of Villagers from village
   * calls Village.getVillagers()
   */

  public ArrayList<Villager> getVillagers(){
    Village cloverville = getVillage();
    return cloverville.getVillagers();
  }

  /**
   * Adds a villager to the Village
   * @param villager Village villager
   * calls Village.addVillager()
   */
  public boolean addVillager(Villager villager) {
    boolean isitin = false;
    Village cloverville = getVillage();
    if(cloverville.addVillager(villager)){
      isitin = true;
    }
    saveVillage(cloverville);
    return isitin;
  }

  /**
   * Removes a villager from the Village
   * @param villager Village villager
   * calls Village.removeVillager()
   */
  public boolean removeVillager(Villager villager){
    boolean isitin = false;
    Village cloverville = getVillage();
    // Using Code 1 logic here as it delegates to the Village class
    if(cloverville.removeVillager(villager)){
      isitin = true;
    }
    saveVillage(cloverville);
    return isitin;
  }

  /**
   * Changes a villager from the Village
   * @param old Village villager
   * @param villager Village villager
   * Method takes the parameters of the villager and replace the old villager parameters
   * calls Village.changeVillager()
   */
  public void changeVillager(Villager old, Villager villager) {
    Village cloverville = getVillage();
    cloverville.changeVillager(old, villager);
    saveVillage(cloverville);
  }

  /**
   * @return  an arraylist of all shared tasks
   * calls Village.getSharedTasks()
   */
  public ArrayList<SharedTask> getSharedTasks()
  {
    Village cloverville = getVillage();
    return cloverville.getSharedTasks();
  }
  /**
   * Adds a shared task to the arraylist of shared tasks
   * @param sharedtask shared task to be added to the list
   * calls Village.addSharedTask()
   */
  public void addSharedTask(SharedTask sharedtask)
  {
    Village cloverville = getVillage();
    cloverville.addSharedTask(sharedtask);
    saveVillage(cloverville);
  }

  /**
   * Set a Village description
   * @param description (String)
   * calls Village.setDescription()
   */
  public void setVillageDescription(String description){
    Village cloverville = getVillage();
    cloverville.setDescription(description);
    saveVillage(cloverville);
  }

  /**
   * Gets all the available trades present in the village
   * @return an arraylist of all the available trades present in the village
   * calls Village.getTrades()
   */
  public ArrayList<TradeOffer> getTrades() {
    Village cloverville = getVillage();
    return cloverville.getTrades();
  }

  /**
   * Adds a trade to the arraylist of trades present in the village
   * @param trade the trade that is added
   * calls Village.addTradeOffer()
   * also reads from JSON and appends new trade to it and saves it
   */
  public boolean addTrade(TradeOffer trade){
    if (trade == null){
      throw new IllegalArgumentException("There is not an available trade");
    }
    else {
      Village cloverville = getVillage();
      if(cloverville.addTradeOffer(trade)){
        saveVillage(cloverville);

        trade = trade.copywithoutpos();
        try {
          ArrayList<TradeOffer> list;
          try {
            list = parser.fromJsonFile("docs/json/tradesList.json", ArrayList.class);
          }
          catch (ParserException ex) {
            list = new ArrayList<>();
          }
          list.add(trade);
          parser.toJsonFile(list, "docs/json/tradesList.json");
          System.out.println("finished and saved to tradesList.json.");
        }
        catch (ParserException e) {
          e.printStackTrace();
        }
        return true;
      }
      else{
        return false;
      }
    }
  }

  /**
   * Removes a trade from the arraylist of trades present in the village
   * @param trade the trade that is Removed
   * calls Village.removeTrade()
   */
  public boolean removeTrade(TradeOffer trade) {
    if (trade == null){
      throw new IllegalArgumentException("trade offer is null");
    }
    boolean isitin = false;
    Village cloverville = getVillage();
    if(cloverville.removeTradeOffer(trade)){
      isitin = true;
    }
    saveVillage(cloverville);
    return isitin;
  }

  /**

   * Replaces an existing trade offer with an updated one
   * Validates that neither the old nor the new trade is null then updates the trade in the village and saves the changes
   * @param old the trade that is seleceted to be edited
   * @param trade the trade after the changes
   * calls Village.editTradeOffer()
   */
  public boolean changeTrade(TradeOffer old, TradeOffer trade){
    if(old == null || trade == null){
      throw new IllegalArgumentException("old trade or new trade is null");
    }
    boolean isitin = false;
    Village cloverville = getVillage();
    if(cloverville.editTradeOffer(old, trade)){
      isitin = true;
    };
    saveVillage(cloverville);
    return isitin;
  }

  /**
   * Finalizes a trade by giving the required trades point to the villager offering it and by removing  the required trades points from the villager buying it
   * @param trade the trade to finalize and do the points exchange
   * @param buyer the village who buys the trade and from whom the points will be substracted
   * calls Village.finishTradeOffer()
   */
  public void finishTrade(TradeOffer trade, Villager buyer) {
    if (trade == null || buyer == null){
      throw new IllegalArgumentException("There is not any available trade or buyer");
    }
    else {
      Village cloverville = getVillage();
      cloverville.finishTradeOffer(trade, buyer);
      System.out.println("finished tradeoffer");
      saveVillage(cloverville);
    }
  }

  /**
   * Adds a period of time in days when all the vilagers personal points will be reseted
   * @param days the interval of time set
   * calls Village.addResetPeriod()
   */

  public void addResetDay(int days){
    Village cloverville = getVillage();
    cloverville.addResetPeriod(days);
    saveVillage(cloverville);
  }

  /**
   * Resets the personal points of all the villagers and transfers them in the community green pool
   * calls Village.resetnow()
   */
  public void resetNow(){
    Village cloverville = getVillage();
    cloverville.resetnow();
    saveVillage(cloverville);
  }

  /**
   * Gets the ArrayList of goals from Village
   * @return the ArrayList of goals from Village
   */
  public ArrayList<GreenGoal> getGoals() {
    Village cloverville = getVillage();
    return cloverville.getGoals();
  }
  /**
   * Adds a goal to the Village
   * @param goal GreenGoal goal
   */
  public void addGoal(GreenGoal goal) {
    Village cloverville = getVillage();
    cloverville.addGreenGoal(goal);
    saveVillage(cloverville);
  }
  /**
   * removes a goal to the Village
   * @param goal GreenGoal goal
   */
  public void removeGreenGoal(GreenGoal goal){
    Village cloverville = getVillage();
    ArrayList<GreenGoal> goals = cloverville.getGoals();
    cloverville.removeGreenGoal(goal);
    saveVillage(cloverville);
  }
  /**
   * Changes a GreenGoal from goals
   * @param old Village GreenGoal
   * @param goal Village GreenGoal
   * Method takes a GreenGoal and replace the old GreenGoal parameters
   */
  public void changeGreenGoal(GreenGoal old, GreenGoal goal) {
    String goalName = goal.getGoalName();
    String greenDescription = goal.getGreenDescription();
    int greenrequiredPoints = goal.getRequiredPoints();
    Village cloverville = getVillage();
    ArrayList<GreenGoal> goals = cloverville.getGoals();
    for (int i = 0; i < goals.size(); i++)
    {
      if (goals.get(i).equals(old))
      {
        goals.get(i).setGoalName(goalName);
        goals.get(i).setGreenDescription(greenDescription);
        goals.get(i).setRequiredPoints(greenrequiredPoints);
      }
    }
    saveVillage(cloverville);
  }

  /**
   * Get the ArrayList of GreenActivities
   * @return allGreenActivities
   */
  public ArrayList<GreenActivity> getActivities() {
    Village cloverville= getVillage();
    return cloverville.getGreenActivities();
  }

  /**
   * Add a GreenActivity to the ArrayList of GreenActivities
   * @param greenActivity GreenActivity
   */
  public void addGreenActivity(GreenActivity greenActivity) {
    System.out.println("Manager: adding activity: " + greenActivity);

    Village cloverville = getVillage();
    ArrayList<GreenActivity> greenActivities = cloverville.getGreenActivities();
    greenActivities.add(greenActivity);

    saveVillage(cloverville);
  }

  /**
   * Add a GreenActivity to the ArrayList of GreenActivities
   * @param greenActivity GreenActivity
   */
  public void removeGreenActivity(GreenActivity greenActivity){
    Village cloverville = getVillage();
    ArrayList<GreenActivity> greenActivities = cloverville.getGreenActivities();

    for(int i=0;i<greenActivities.size();i++){
      if(greenActivities.get(i).equals(greenActivity)){
        greenActivities.remove(greenActivities.get(i));
        break;
      }
    }
    saveVillage(cloverville);
  }

  /**
   * Changes a GreenActivity from GreenActivities
   * @param old Village greenActivity
   * @param greenActivity Village greenActivity
   * Method takes a GreenActivity and replace the old GreenActivity parameters
   */

  public void changeGreenActivity(GreenActivity old, GreenActivity greenActivity) {
    String name = greenActivity.getActivityName();
    int points = greenActivity.getPoints();
    Village cloverville = getVillage();
    ArrayList<GreenActivity> greenActivities = cloverville.getGreenActivities();
    for (int i = 0; i < greenActivities.size(); i++)
    {
      if (greenActivities.get(i).equals(old))
      {
        greenActivities.get(i).setActivityName(name);
        greenActivities.get(i).setPoints(points);
      }
    }
    saveVillage(cloverville);
  }

  /**
   * Finish a GreenActivity from GreenActivities
   * @param greenActivity Village greenActivity
   * Method takes a GreenActivity's points and adds the points to the Goal
   */
  public void finishGreenActivity(GreenActivity greenActivity) {
    if (greenActivity == null){
      throw new IllegalArgumentException("There is not any available green activity");
    }
    else {
      XmlJsonParser parser = new XmlJsonParser();
      Village cloverville = getVillage();
      cloverville.finishGreenActivity(greenActivity);
      System.out.println("website/json/greenActivityList.json");
      saveVillage(cloverville);
      try {
        ArrayList<GreenActivity> list;
        try {
          list = parser.fromJsonFile("docs/json/greenActivityList.json", ArrayList.class);
        }
        catch (ParserException ex) {
          list = new ArrayList<>();
        }
        list.add(greenActivity);
        parser.toJsonFile(list, "docs/json/greenActivityList.json");
        System.out.println("Finished + saved updated JSON list.");
      }
      catch (ParserException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * LoadsGreenActivityList to JSON
   */
  public void loadGreenActivityListJson() {
    ArrayList<GreenActivity> greenActivityList = getActivities();
    try {
      parser.toJsonFile(greenActivityList, "docs/json/greenActivityList.json");
      System.out.println("Green activity list written to JSON.");
      Village cloverville = getVillage();
      cloverville.getGreenActivities().clear();
      cloverville.getGreenActivities().addAll(greenActivityList);
      System.out.println("Green activity list updated in memory.");
    }
    catch (ParserException e) {
      e.printStackTrace();
    }
  }

  /**
   * LoadsTradeOfferList to JSON
   */
  public void loadTradeOfferListJson() {
    Village cloverville = getVillage();
    ArrayList<TradeOffer> tradesnopos = cloverville.copytradeswithoutpos();
    try {
      parser.toJsonFile(tradesnopos, "docs/json/tradesList.json");
      System.out.println("Trade offers list written to JSON.");
    }
    catch (ParserException e) {
      e.printStackTrace();
    }
  }

  /**
   * Method removes the GreenGoal from the JsonFile
   * @param greenGoal the GreenGoal to save
   */
  public void finishGreenGoal(GreenGoal greenGoal) {
    if (greenGoal == null){
      throw new IllegalArgumentException("There is not any available green activity");
    }
    else {
      XmlJsonParser parser = new XmlJsonParser();
      Village cloverville = getVillage();
      cloverville.finishGreenGoal(greenGoal);
      System.out.println("docs/json/greenGoalList.json");
      saveVillage(cloverville);
      try {
        ArrayList<GreenGoal> list;
        try {
          list = parser.fromJsonFile("docs/json/greenGoalList.json", ArrayList.class);
        }
        catch (ParserException ex) {
          list = new ArrayList<>();
        }
        list.add(greenGoal);
        parser.toJsonFile(list, "docs/json/greenGoalList.json");
        System.out.println("Finished + saved updated JSON list.");
      }
      catch (ParserException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * LoadsGreenGoalList to JSON
   */
  public void loadGreenGoalListJson() {
    ArrayList<GreenGoal> greenGoalList = getGoals();
    try {
      parser.toJsonFile(greenGoalList, "docs/json/greenGoalList.json");
      System.out.println("Green goal list written to JSON.");
      Village cloverville = getVillage();
      cloverville.getGoals().clear();
      cloverville.getGoals().addAll(greenGoalList);
      System.out.println("Green goal list updated in memory.");
    }
    catch (ParserException e) {
      e.printStackTrace();
    }
  }

  /**
   * LoadsSavedGoalList to JSON
   * Method puts in a JSON file just the active GreenGoal
   * @param activeGoal the GreenGoal to save
   */
  public void loadSavedGreenGoalJson(GreenGoal activeGoal)
  {
    try {
      ArrayList<GreenGoal> singleGoalList = new ArrayList<>();

      if (activeGoal != null) {
        singleGoalList.add(activeGoal);
      } else {
        return;
      }

      parser.toJsonFile(singleGoalList, "docs/json/SavedGreenGoalList.json");
      Village cloverville = getVillage();
      cloverville.setActiveGreenGoal(activeGoal);

    } catch (ParserException e) {
      e.printStackTrace();
    }
  }


  /**
   * LoadsVillage Description to JSON
   */
  public void loadVillageDescription() {
    try {
      Village cloverville = getVillage();
      String description = cloverville.getDescription();
      ArrayList<String> list = new ArrayList<>();
      list.add(description);
      parser.toJsonFile(list, "docs/json/VillageDescription.json");
      System.out.println("Village description written to JSON.");
    } catch (ParserException e) {
      e.printStackTrace();
    }
  }

  /**
   * LoadsGreenPointsList to JSON
   */
  public void loadGreenPoints() {
    try {
      Village cloverville = getVillage();
      String greenpoints = String.valueOf(cloverville.getGreenpoints());
      ArrayList<String> list = new ArrayList<>();
      list.add(greenpoints);
      parser.toJsonFile(list, "docs/json/greenPoints.json");
      System.out.println("Green points written to JSON.");
    } catch (ParserException e) {
      e.printStackTrace();
    }
  }
}
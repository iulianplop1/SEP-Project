package model;

import utils.MyFileHandler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import parser.XmlJsonParser;
import parser.ParserException;

public class VillageModelManager
{
  private String fileName;
  private XmlJsonParser parser;

  public VillageModelManager(String fileName) {
    this.fileName = fileName;
    parser = new XmlJsonParser();
  }

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


  public ArrayList<Villager> getVillagers(){
    Village cloverville = getVillage();
    return cloverville.getVillagers();
  }

  public void addVillager(Villager villager) {
    Village cloverville = getVillage();
    cloverville.addVillager(villager);
    saveVillage(cloverville);
  }

  public void removeVillager(Villager villager){
    Village cloverville = getVillage();
    // Using Code 1 logic here as it delegates to the Village class
    cloverville.removeVillager(villager);
    saveVillage(cloverville);
  }

  public void changeVillager(Villager old, Villager villager) {
    Village cloverville = getVillage();
    cloverville.changeVillager(old, villager);
    saveVillage(cloverville);
  }


  public void changeVillagerPoints(Villager villager, int points)
  {
    Village cloverville = getVillage();
    ArrayList<Villager> villagers = cloverville.getVillagers();

    for (int i = 0; i < villagers.size(); i++)
    {
      if (villagers.get(i) == villager){    // if we found our villager
        villagers.get(i).setPoints(points);
      }
    }
    saveVillage(cloverville);
  }


  public ArrayList<SharedTask> getSharedTasks()
  {
    Village cloverville = getVillage();
    return cloverville.getSharedTasks();
  }

  public void addSharedTask(SharedTask sharedtask)
  {
    Village cloverville = getVillage();
    cloverville.addSharedTask(sharedtask);
    saveVillage(cloverville);
  }

  public void setVillageDescription(String description){
    Village cloverville = getVillage();
    cloverville.setDescription(description);
    saveVillage(cloverville);
  }


  public ArrayList<TradeOffer> getTrades() {
    Village cloverville = getVillage();
    return cloverville.getTrades();
  }

  public void addTrade(TradeOffer trade){
    if (trade == null){
      throw new IllegalArgumentException("There is not an available trade");
    }
    else {
      Village cloverville = getVillage();
      cloverville.addTradeOffer(trade);
      saveVillage(cloverville);
      trade = trade.copywithoutpos();
      try {
        ArrayList<TradeOffer> list;
        try {
          list = parser.fromJsonFile("website/json/tradesList.json", ArrayList.class);
        }
        catch (ParserException ex) {
          list = new ArrayList<>();
        }
        list.add(trade);
        parser.toJsonFile(list, "website/json/tradesList.json");
        System.out.println("finished and saved to tradesList.json.");
      }
      catch (ParserException e) {
        e.printStackTrace();
      }
    }
  }

  public void removeTrade(TradeOffer trade) {
    if (trade == null){
      throw new IllegalArgumentException("trade offer is null");
    }
    Village cloverville = getVillage();
    cloverville.removeTradeOffer(trade);
    saveVillage(cloverville);
  }

  public void changeTrade(TradeOffer old, TradeOffer trade){
    if(old == null || trade == null){
      throw new IllegalArgumentException("old trade or new trade is null");
    }
    else{
      Village cloverville = getVillage();
      cloverville.editTradeOffer(old, trade);
      saveVillage(cloverville);
    }
  }
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

  public void addResetDay(int days){
    Village cloverville = getVillage();
    cloverville.addResetPeriod(days);
    saveVillage(cloverville);
  }
  public void resetNow(){
    Village cloverville = getVillage();
    cloverville.resetnow();
    saveVillage(cloverville);
  }


  public ArrayList<GreenGoal> getGoals() {
    Village cloverville = getVillage();
    return cloverville.getGoals();
  }
  public void addGoal(GreenGoal goal) {
    Village cloverville = getVillage();
    cloverville.addGreenGoal(goal);
    saveVillage(cloverville);
  }
  public void removeGreenGoal(GreenGoal goal){
    Village cloverville = getVillage();
    ArrayList<GreenGoal> goals = cloverville.getGoals();
    cloverville.removeGreenGoal(goal);
    saveVillage(cloverville);
  }
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

  public ArrayList<GreenActivity> getActivities() {
    Village cloverville= getVillage();
    return cloverville.getGreenActivities();
  }
  public void addGreenActivity(GreenActivity greenActivity) {
    System.out.println("Manager: adding activity: " + greenActivity);

    Village cloverville = getVillage();
    ArrayList<GreenActivity> greenActivities = cloverville.getGreenActivities();
    greenActivities.add(greenActivity);

    saveVillage(cloverville);
  }
  public void removeGreenActivity(GreenActivity greenActivity){
    Village cloverville = getVillage();
    ArrayList<GreenActivity> greenActivities = cloverville.getGreenActivities();

    for(int i=0;i<greenActivities.size();i++){
      if(greenActivities.get(i).equals(greenActivity)){
        greenActivities.remove(greenActivities.get(i));
        // Added break to stop after finding the item
        break;
      }
    }
    saveVillage(cloverville);
  }
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
          list = parser.fromJsonFile("website/json/greenActivityList.json", ArrayList.class);
        }
        catch (ParserException ex) {
          list = new ArrayList<>();
        }
        list.add(greenActivity);
        parser.toJsonFile(list, "website/json/greenActivityList.json");
        System.out.println("Finished + saved updated JSON list.");
      }
      catch (ParserException e) {
        e.printStackTrace();
      }
    }
  }
  public void loadGreenActivityListJson() {
    ArrayList<GreenActivity> greenActivityList = getActivities();
    try {
      parser.toJsonFile(greenActivityList, "website/json/greenActivityList.json");
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


  public void loadTradeOfferListJson() {
    Village cloverville = getVillage();
    ArrayList<TradeOffer> trades = getTrades();
    ArrayList<TradeOffer> tradesnopos = cloverville.copytradeswithoutpos();
    try {
      parser.toJsonFile(tradesnopos, "website/json/tradesList.json");
      System.out.println("Trade offers list written to JSON.");
      cloverville.getTrades().clear();
      cloverville.getTrades().addAll(trades);
      System.out.println("Trade offer list updated in memory.");
    }
    catch (ParserException e) {
      e.printStackTrace();
    }
  }
  public void finishGreenGoal(GreenGoal greenGoal) {
    if (greenGoal == null){
      throw new IllegalArgumentException("There is not any available green activity");
    }
    else {
      XmlJsonParser parser = new XmlJsonParser();
      Village cloverville = getVillage();
      cloverville.finishGreenGoal(greenGoal);
      System.out.println("website/json/greenGoalList.json");
      saveVillage(cloverville);
      try {
        ArrayList<GreenGoal> list;
        try {
          list = parser.fromJsonFile("website/json/greenGoalList.json", ArrayList.class);
        }
        catch (ParserException ex) {
          list = new ArrayList<>();
        }
        list.add(greenGoal);
        parser.toJsonFile(list, "website/json/greenGoalList.json");
        System.out.println("Finished + saved updated JSON list.");
      }
      catch (ParserException e) {
        e.printStackTrace();
      }
    }
  }
  public void loadGreenGoalListJson() {
    ArrayList<GreenGoal> greenGoalList = getGoals();
    try {
      parser.toJsonFile(greenGoalList, "website/json/greenGoalList.json");
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
  public void loadSavedGreenGoalJson(GreenGoal activeGoal) {
    try {
      ArrayList<GreenGoal> singleGoalList = new ArrayList<>();
      if (activeGoal != null) {
        singleGoalList.add(activeGoal);
      } else {
        ArrayList<GreenGoal> allGoals = getGoals();
        if (!allGoals.isEmpty()) {
          singleGoalList.add(allGoals.get(0));
        }
      }
      parser.toJsonFile(singleGoalList, "website/json/SavedGreenGoalList.json");
      Village cloverville = getVillage();
      cloverville.getGoals().clear();
      cloverville.getGoals().addAll(singleGoalList);
      System.out.println("Green goal loaded: " + (singleGoalList.isEmpty() ? "none" : singleGoalList.get(0).getGoalName()));
    } catch (ParserException e) {
      e.printStackTrace();
    }
  }
  public void loadVillageDescription() {
    try {
      Village cloverville = getVillage();
      String description = cloverville.getDescription();
      ArrayList<String> list = new ArrayList<>();
      list.add(description);
      parser.toJsonFile(list, "website/json/VillageDescription.json");
      System.out.println("Village description written to JSON.");
    } catch (ParserException e) {
      e.printStackTrace();
    }
  }
}
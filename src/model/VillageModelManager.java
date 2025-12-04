package model;

import utils.MyFileHandler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class VillageModelManager
{
  private String fileName;

  public VillageModelManager(String fileName) {
    this.fileName = fileName;
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
    Village cloverville = getVillage();
    cloverville.addTradeOffer(trade);
    saveVillage(cloverville);
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
      throw new IllegalArgumentException("Trade or buyer is null");
    }
    else{
      Village cloverville = getVillage();
      cloverville.finishTradeOffer(trade, buyer);
      System.out.println("finished tradeoffer");
      saveVillage(cloverville);
    }
  }


  public ArrayList<GreenActivity> getActivities()
  {
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

  public ArrayList<GreenGoal> getGoals() {
    Village cloverville = getVillage();
    return cloverville.getGoals();
  }

  public void addGoal(GreenGoal goal) {
    Village cloverville = getVillage();
    cloverville.addGreenGoal(goal);
    saveVillage(cloverville);
  }

  public void removeGoal(GreenGoal goal) {
    Village cloverville = getVillage();
    ArrayList<GreenGoal> goals = cloverville.getGoals();
    goals.remove(goal);
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
}
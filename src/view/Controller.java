package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;
import javafx.scene.*;
import javafx.event.*;

import java.util.ArrayList;

public class Controller
{
  @FXML private TextField firstName;
  @FXML private TextField lastName;
  @FXML private TextField personalPoints;
  @FXML private TextField firstName1;
  @FXML private TextField lastName1;
  @FXML private Button updateVillager;
  @FXML private TextArea listVillagers;
  @FXML private ComboBox chooseVillagers;



  @FXML private TextField totalCounter;
  @FXML private TextField taskNameTrade;


  @FXML private TextField greenGoalName;
  @FXML private TextField greenRequiredPoints;
  @FXML private TextArea greenDescription;
  @FXML private Button addGreenGoal;
  @FXML private ComboBox chooseGreenGoal;
  @FXML private TextField greenGoalName1;
  @FXML private TextField greenRequiredPoints1;
  @FXML private TextArea greenDescription1;
  @FXML private Button upDateGreenGoal;
  @FXML private Button removeGreenGoal;
  @FXML private TextArea listGreenGoals;
  @FXML private ComboBox chooseGreenGoal2;
  @FXML private ComboBox chooseGreenGoal3;

  @FXML private TextArea listTrades;
  @FXML private ComboBox chooseTradeSeller;
  @FXML private TextField tradeName;
  @FXML private TextField tradeRequiredPoints;
  @FXML private TextArea tradeDescription;

  @FXML ComboBox chooseTrade;
  @FXML ComboBox chooseTradeSellerEdit;
  @FXML ComboBox chooseTradeFinish;
  @FXML ComboBox chooseTradeBuyer;
  @FXML private TextField tradeNameEdit;
  @FXML private TextField tradeRequiredPointsEdit;
  @FXML private TextArea tradeDescriptionEdit;
  @FXML private Button removeTrade;
  @FXML private Button updateTrade;
  @FXML private Button finishTrade;

  @FXML private TextField greenActivityName;
  @FXML private TextField greenActivityPoints;
  @FXML private TextArea listGreenActivity;
  @FXML private Button addGreenActivity;
  @FXML private TextField greenActivityName1;
  @FXML private TextField greenActivityPoints1;
  @FXML private Button updateGreenActivity;
  @FXML private Button removeGreenActivity;
  @FXML private ComboBox chooseGreenActivity;
  @FXML private ComboBox chooseGreenActivity1;
  @FXML private Button completeGreenActivity;


  @FXML private TextField resetDay;
  @FXML private TextField resetDayEdit;

  @FXML private TextArea villageDescription;

  @FXML private TextField sharedTaskName;
  @FXML private TextField pointsRequired;
  @FXML private ListView<SharedTask> listSharedTasks;
  @FXML private ComboBox<SharedTask> availableSharedTasks;
  @FXML private TextField sharedTaskName1;
  @FXML private TextField pointsRequired1;
  @FXML private Button updateSharedTaskButton;
  @FXML private Button removeSharedTaskButton;
  @FXML private ComboBox<SharedTask> completeSharedTasks;
  @FXML private ComboBox<Villager> completeVillagersList;
  @FXML private ListView<Villager> selectedVillagers;
  @FXML private Button addSelectedVillager;


  @FXML private TextField numberOfVillagers;
  @FXML private TextField greenPointNumber;
  @FXML private TextArea descriptionVillage;
  @FXML private TextField nextGreenGoal;
  @FXML private TextField numberOfSharedTasks;
  @FXML private TextField numberOfTrades;
  @FXML private TextField dateOfReset;




  Alert alert = new Alert(Alert.AlertType.INFORMATION);

  private VillageModelManager manager = new VillageModelManager("village.bin");

  public void initialize()
  {
    manager.loadGreenActivityListJson();
    everything();
    loadResetDay();
  }
  public void everything(){
    loadVillagerBox();
    loadVillagers();

    loadTrades();
    loadTradeSellerBox();
    loadTradesBox();
    loadTradeSellerEditBox();
    loadTradeFinal();

    loadGreenActivity();
    loadGreenActivityBox();
    loadGreenActivityBox1();

    loadGoals();
    loadGoalsBox();
    loadGoalBox1();
    loadGoalBox2();

    loadSharedTasks();

    loadInfoPage();
  }

  @FXML public void loadGoals() {
    listGreenGoals.clear();

    ArrayList<GreenGoal> goals = manager.getGoals();
    for (GreenGoal greengoal : goals)
    {
      String line = "";
      line += greengoal.getGoalName() + " " + "-" + greengoal.getRequiredPoints() + "\n";
      listGreenGoals.appendText(line);
    }
    listGreenGoals.setEditable(false);
  }
  @FXML public void loadGoalsBox() {
    {
      chooseGreenGoal.getItems().clear();
      ArrayList<GreenGoal> goals = manager.getGoals();
      for (GreenGoal greengoal : goals)
      {
        String line = "";
        line +=
            greengoal.getGoalName() + " " + "-" + greengoal.getRequiredPoints()
                + "\n";
        chooseGreenGoal.getItems().add(greengoal);
      }
      int currentIndex = chooseGreenGoal.getSelectionModel()
          .getSelectedIndex();  //gets index of selected villager in the box

      GreenGoal selectedGreenGoal = null;

      if (currentIndex == -1 && chooseGreenGoal.getItems().size() > 0)
      {   //no selection (no index) and there are villagers
        chooseGreenGoal.getSelectionModel()
            .select(0);              //show first villager in the box

        selectedGreenGoal = (GreenGoal) chooseGreenGoal.getValue();          //this will be the villager to fill up the textboxes

      }
      else
      {
        chooseGreenGoal.getSelectionModel().select(
            currentIndex);         //there is a selected villager (not -1 index)

        selectedGreenGoal = (GreenGoal) chooseGreenGoal.getValue();

        //this wil be the villager to fill up the textboxes
      }

      if (selectedGreenGoal != null)
      {                                   //filling up textboxes
        greenGoalName1.setText(selectedGreenGoal.getGoalName());
        greenDescription1.setText(selectedGreenGoal.getGreenDescription());
        greenRequiredPoints1.setText(
            String.valueOf(selectedGreenGoal.getRequiredPoints()));

      }
    }
  }
  @FXML public void loadGoalBox1() {
    int greenbox1 = chooseGreenGoal2.getSelectionModel().getSelectedIndex();
    chooseGreenGoal2.getItems().clear();

    ArrayList<GreenGoal> goals = manager.getGoals();
    for (GreenGoal greengoal : goals)
    {
      String line = "";
      line +=
          greengoal.getGoalName() + " " + greengoal.getRequiredPoints() + "\n";

      chooseGreenGoal2.getItems().add(greengoal);
    }

    if (greenbox1 == -1 && chooseGreenGoal2.getItems().size() > 0)
    {
      chooseGreenGoal.getSelectionModel().select(0);
    }
    else
    {
      chooseGreenActivity1.getSelectionModel().select(greenbox1);
    }
  }
  @FXML public void loadGoalBox2() {
    int greenbox2 = chooseGreenGoal3.getSelectionModel().getSelectedIndex();
    chooseGreenGoal3.getItems().clear();

    ArrayList<GreenGoal> goals = manager.getGoals();
    for (GreenGoal greengoal : goals)
    {
      String line = "";
      line +=
          greengoal.getGoalName() + " " + greengoal.getRequiredPoints() + "\n";

      chooseGreenGoal3.getItems().add(greengoal);
    }

    if (greenbox2 == -1 && chooseGreenGoal3.getItems().size() > 0)
    {
      chooseGreenGoal.getSelectionModel().select(0);
    }
    else
    {
      chooseGreenGoal3.getSelectionModel().select(greenbox2);
    }
  }
  @FXML public void loadVillagers() {
    ArrayList<Villager> villagers = manager.getVillagers();

    listVillagers.clear();

    for (Villager villager : villagers)
    {
      String line = "";
      line += villager.getFirstname() + " " + villager.getLastname() + " - "
          + villager.getPoints() + "\n";
      listVillagers.appendText(line);
    }

    listVillagers.setEditable(false);
  }
  @FXML public void loadTrades() {
    ArrayList<TradeOffer> trades = manager.getTrades();

    listTrades.clear();

    for (TradeOffer trade : trades)
    {
      String line = "";
      line += "[" + trade.getPoints() + "] " + trade.getTradeName() + "\n\t'"
          + trade.getDescription() + "'\n\t by " + trade.getSeller() + "\n";
      listTrades.appendText(line);
    }

    listTrades.setEditable(false);
  }
  @FXML public void loadVillagerBox() {
    chooseVillagers.getItems().clear();

    ArrayList<Villager> villagers = manager.getVillagers();
    for (Villager villager : villagers)
    {
      chooseVillagers.getItems().add(villager);       //add villagers to box
    }
    int currentIndex = chooseVillagers.getSelectionModel().getSelectedIndex();  //gets index of selected villager in the box

    Villager selectedVillager = null;

    if (currentIndex == -1 && chooseVillagers.getItems().size() > 0)
    {   //no selection (no index) and there are villagers
      chooseVillagers.getSelectionModel().select(0);              //show first villager in the box

      selectedVillager = (Villager) chooseVillagers.getValue();          //this will be the villager to fill up the textboxes
    }
    else
    {
      chooseVillagers.getSelectionModel().select(
          currentIndex);         //there is a selected villager (not -1 index)

      selectedVillager = (Villager) chooseVillagers.getValue();           //this wil be the villager to fill up the textboxes
    }

    if (selectedVillager != null)
    {                                   //filling up textboxes
      firstName1.setText(selectedVillager.getFirstname());
      lastName1.setText(selectedVillager.getLastname());
      personalPoints.setText(String.valueOf(selectedVillager.getPoints()));
    }
  }
  @FXML public void loadTradeSellerBox() {
    chooseTradeSeller.getItems().clear();

    ArrayList<Villager> villagers = manager.getVillagers();
    for (Villager villager : villagers)
    {
      chooseTradeSeller.getItems().add(villager);       //add villagers to box
    }
    int currentIndex = chooseTradeSeller.getSelectionModel().getSelectedIndex();  //gets index of selected villager in the box

    if (currentIndex == -1 && chooseTradeSeller.getItems().size() > 0)
    {   //no selection (no index) and there are villagers
      chooseTradeSeller.getSelectionModel()
          .select(0);              //show first villager in the box
    }
    else
    {
      chooseTradeSeller.getSelectionModel().select(
          currentIndex);         //there is a selected villager (not -1 index)
    }
  }
  @FXML public void loadTradeSellerEditBox() {
    chooseTradeSellerEdit.getItems().clear();

    ArrayList<Villager> villagers = manager.getVillagers();
    for (Villager villager : villagers)
    {
      chooseTradeSellerEdit.getItems().add(villager);       //add villagers to box
    }
    int currentIndex = chooseTradeSellerEdit.getSelectionModel().getSelectedIndex();  //gets index of selected villager in the box

    if (currentIndex == -1 && chooseTradeSellerEdit.getItems().size() > 0)
    {   //no selection (no index) and there are villagers
      chooseTradeSellerEdit.getSelectionModel()
          .select(0);              //show first villager in the box
    }
    else
    {
      chooseTradeSellerEdit.getSelectionModel().select(
          currentIndex);         //there is a selected villager (not -1 index)
    }
  }
  @FXML public void loadTradesBox() {
    chooseTrade.getItems().clear();

    ArrayList<TradeOffer> trades = manager.getTrades();
    for (TradeOffer trade : trades)
    {
      chooseTrade.getItems().add(trade);       //add trades to box
    }
    int currentIndex = chooseTrade.getSelectionModel().getSelectedIndex();  //gets index of selected trade in the box

    TradeOffer selectedTrade = null;

    if (currentIndex == -1 && chooseTrade.getItems().size() > 0)
    {   //no selection (no index) and there are villagers
      chooseTrade.getSelectionModel().select(0);              //show first trade in the box

      selectedTrade = (TradeOffer) chooseTrade.getValue();
    }
    else
    {
      chooseTrade.getSelectionModel().select(currentIndex);         //there is a selected trade (not -1 index)

      selectedTrade = (TradeOffer) chooseTrade.getValue();
    }

    if (selectedTrade != null)
    {
      chooseTradeSellerEdit.setValue(selectedTrade.getSeller());
      tradeNameEdit.setText(selectedTrade.getTradeName());
      tradeRequiredPointsEdit.setText(String.valueOf(selectedTrade.getPoints()));
      tradeDescriptionEdit.setText(selectedTrade.getDescription());
    }
  }
  @FXML public void loadTradeFinal() {
    chooseTradeFinish.getItems().clear();

    TradeOffer updatebuyerbox = null;
    ArrayList<TradeOffer> trades = manager.getTrades();
    for (TradeOffer t : trades)
    {
      chooseTradeFinish.getItems().add(t);
    }
    int currentIndex = chooseTradeFinish.getSelectionModel().getSelectedIndex();

    if (currentIndex == -1 && chooseTradeFinish.getItems().size() > 0) {
      chooseTradeFinish.getSelectionModel()
          .select(0);
      updatebuyerbox = (TradeOffer)chooseTradeFinish.getValue();
    }
    else {
      chooseTradeFinish.getSelectionModel().select(
          currentIndex);
      updatebuyerbox = (TradeOffer)chooseTradeFinish.getValue();
    }
    if (updatebuyerbox != null){
      loadBuyerBox(updatebuyerbox);
    }
  }
  @FXML public void loadBuyerBox(TradeOffer trade) {
    chooseTradeBuyer.getItems().clear();

    ArrayList<Villager> villagers = manager.getVillagers();
    ArrayList<Villager> possiblebuyers = trade.getPossibleBuyers(villagers);
    for (Villager buyer : possiblebuyers){
      if (buyer.checkPoints(trade.getPoints()) && !buyer.equals(trade.getSeller())){
        chooseTradeBuyer.getItems().add(buyer);
      }
    }
    int currentIndex = chooseTradeBuyer.getSelectionModel().getSelectedIndex();

    if (currentIndex == -1 && chooseTradeBuyer.getItems().size() > 0) {
      chooseTradeBuyer.getSelectionModel()
          .select(0);
    }
    else {
      chooseTradeBuyer.getSelectionModel().select(
          currentIndex);
    }
  }
  @FXML public void loadInfoPage(){
    Village cloverville = manager.getVillage();
    ArrayList<Villager> villagers = manager.getVillagers();
    Date reset =  new Date();
    reset.nextDay(cloverville.checkReset());

    numberOfVillagers.setText(String.valueOf(villagers.size()));
    greenPointNumber.setText(String.valueOf(cloverville.getGreenpoints()));
    descriptionVillage.setText("'" + cloverville.getDescription() + "'");

    //nextGreenGoal.setText(cloverville.getGoals().get(0).toString());

    numberOfSharedTasks.setText(String.valueOf(cloverville.getSharedTasks().size()));
    numberOfTrades.setText(String.valueOf(cloverville.getTrades().size()));
    dateOfReset.setText(reset.toString());
  }

  @FXML public void loadGreenActivity() {
    ArrayList<GreenActivity> greenActivities = manager.getActivities();

    listGreenActivity.clear();

    for (GreenActivity greenActivity : greenActivities)
    {
      String line = "";
      line += greenActivity.getActivityName() + " " + greenActivity.getPoints()+"\n";
      listGreenActivity.appendText(line);
    }

    listGreenActivity.setEditable(false);
  }
  @FXML public void loadGreenActivityBox1() {
    int currentIndex = chooseGreenActivity1.getSelectionModel()
        .getSelectedIndex();
    chooseGreenActivity1.getItems().clear();

    ArrayList<GreenActivity> greenActivities = manager.getActivities();
    for (GreenActivity greenActivity : greenActivities)
    {
      String line = "";
      line += greenActivity.getActivityName() + " " + greenActivity.getPoints()
          + "\n";

      chooseGreenActivity1.getItems().add(greenActivity);
    }

    if (currentIndex == -1 && chooseGreenActivity1.getItems().size() > 0)
    {
      chooseGreenActivity1.getSelectionModel().select(0);
    }
    else
    {
      chooseGreenActivity1.getSelectionModel().select(currentIndex);
    }
  }
  @FXML public void loadGreenActivityBox() {
    chooseGreenActivity.getItems().clear();

    ArrayList<GreenActivity> greenActivities = manager.getActivities();
    for (GreenActivity greenActivity: greenActivities)
    {
      String line = "";
      line += greenActivity.getActivityName() + " " + greenActivity.getPoints()+ "\n";

      chooseGreenActivity.getItems().add(greenActivity);      //add villagers to box
    }
    int currentIndex = chooseGreenActivity.getSelectionModel().getSelectedIndex();  //gets index of selected villager in the box

    GreenActivity selectedGreenActivity = null;

    if (currentIndex == -1 && chooseGreenActivity.getItems().size() > 0)
    {   //no selection (no index) and there are villagers
      chooseGreenActivity.getSelectionModel().select(0);              //show first villager in the box

      selectedGreenActivity = (GreenActivity) chooseGreenActivity.getValue();          //this will be the villager to fill up the textboxes
    }
    else
    {
      chooseGreenActivity.getSelectionModel().select(
          currentIndex);         //there is a selected villager (not -1 index)

      selectedGreenActivity = (GreenActivity) chooseGreenActivity.getValue();           //this wil be the villager to fill up the textboxes
    }

    if (selectedGreenActivity != null)
    {                                   //filling up textboxes
      greenActivityName1.setText(selectedGreenActivity.getActivityName());
      greenActivityPoints1.setText(String.valueOf(selectedGreenActivity.getPoints()));
    }
  }

  @FXML public void loadSharedTasks() {
    if (listSharedTasks == null
        || availableSharedTasks == null
        || completeSharedTasks == null
        || completeVillagersList == null) {
      return;
    }

    listSharedTasks.getItems().clear();
    availableSharedTasks.getItems().clear();
    completeSharedTasks.getItems().clear();
    completeVillagersList.getItems().clear();

    ArrayList<SharedTask> tasks = manager.getSharedTasks();

    if (tasks != null && !tasks.isEmpty()) {
      listSharedTasks.getItems().addAll(tasks);
      availableSharedTasks.getItems().addAll(tasks);
      completeSharedTasks.getItems().addAll(tasks);
    }

    completeVillagersList.getItems().addAll(manager.getVillagers());
  }
  @FXML private void loadSelectedPerformers() {
    selectedVillagers.getItems().clear();

    SharedTask selectedTask = (SharedTask) completeSharedTasks
        .getSelectionModel()
        .getSelectedItem();
    if (selectedTask == null) return;

    Village village = manager.getVillage();
    ArrayList<SharedTask> tasks = village.getSharedTasks();

    int indexTask = tasks.indexOf(selectedTask);
    if (indexTask < 0) return;

    SharedTask task = tasks.get(indexTask);

    for (int i = 0; i < task.NrPerformers(); i++) {
      Villager v = task.getPerformer(i);
      selectedVillagers.getItems().add(v);
    }
  }

  @FXML public void setVillageDescription(){
    manager.setVillageDescription(villageDescription.getText());
    villageDescription.clear();
  }

  @FXML public void loadResetDay(){
    resetDay.clear();
    Village cloverville =  manager.getVillage();
    int daystil = cloverville.checkReset();
    if (daystil == -1){
      resetDay.setText("N/A");
    }
    else{
      resetDay.setText(String.valueOf(daystil));
    }
    manager.saveVillage(cloverville);
    everything();
  }
  @FXML public void saveResetDay() {
    int days = Integer.parseInt(resetDayEdit.getText());
    manager.addResetDay(days);
    initialize();
  }
  @FXML public void resetNow() {
    manager.resetNow();
    initialize();
  }


  @FXML public void addVillager() {
    String first = firstName.getText();
    String last = lastName.getText();

    if (!firstName.getText().equals("") && !lastName.getText().equals(""))
    {
      Villager villager = new Villager(first, last);
      manager.addVillager(villager);

      initialize();
    }
    else {
      showAlert("Please enter a first name and alast name to add villager");
    }
  }
  @FXML public void editVillager(ActionEvent e) {
    Villager selectedVillager = (Villager) chooseVillagers.getValue();
    // When a villager is selected in the ComboBox
    if (e.getSource() == chooseVillagers)
    {
      if (selectedVillager != null)
      {
            firstName1.setText(selectedVillager.getFirstname());
            lastName1.setText(selectedVillager.getLastname());
            personalPoints.setText(String.valueOf(selectedVillager.getPoints()));
      }
    }
    // When the Update button is clicked
    else if (e.getSource() == updateVillager)
    {
      if (selectedVillager != null)
      {
        try{
          if (!firstName1.getText().equals("") && !lastName1.getText().equals(""))
          {
            Villager newVillager = new Villager(firstName1.getText(),
                lastName1.getText(), Integer.parseInt(personalPoints.getText()));
            manager.changeVillager(selectedVillager, newVillager);
          }
          else {
            showAlert("Please enter a first name and a last name to update villager");
          }
        }
        catch (NumberFormatException event) {
          showAlert("Points must be a number to update villager");
        }
        catch (IllegalArgumentException event) {
          showAlert(event.getMessage());
        }
      }
      initialize();
    }
  }
  @FXML public void removeVillager() {
    try{

      if (!firstName1.getText().equals("") && !lastName1.getText().equals(""))
      {
        String first = firstName1.getText();
        String last = lastName1.getText();
        int points = Integer.parseInt(personalPoints.getText());
        Villager villager = new Villager(first, last, points);
        manager.removeVillager(villager);
      }
      else {
        showAlert("Please enter a first name, a last name, and personal points to remove villager");
      }
    }
    catch (NumberFormatException event) {
      showAlert("Points must be a number to remove villager!");
    }
    catch (IllegalArgumentException event) {
      showAlert(event.getMessage());
    }
    initialize();
  }

  @FXML public void addGreenGoal() {
    String GoalName = greenGoalName.getText();
    int RequiredPoints = Integer.parseInt(greenRequiredPoints.getText());
    String greenDescriptions = greenDescription.getText();
    GreenGoal greengoal = new GreenGoal(GoalName, RequiredPoints, greenDescriptions);
    manager.addGoal(greengoal);

    initialize();
  }
  @FXML public void removeGreenGoal() {
    if (greenGoalName1.getText() != "" && greenRequiredPoints1.getText() != "" && greenDescription1.getText() != "")
    {
      String goalName1 = greenGoalName1.getText();
      String greenDescription1 = greenDescription.getText();
      int greenrequiredPoints1 = Integer.parseInt(greenRequiredPoints1.getText());
      GreenGoal greengoal = new GreenGoal(goalName1, greenrequiredPoints1, greenDescription1);
      manager.removeGreenGoal(greengoal);

      initialize();
    }
  }

  @FXML void addTadeOffer() {
    try{
      if (!tradeName.getText().equals("") && !tradeDescription.getText().equals(""))
      {
        Villager seller = (Villager) chooseTradeSeller.getValue();
        String tradename = tradeName.getText();
        int requiredpoints = Integer.parseInt(tradeRequiredPoints.getText());
        String description = tradeDescription.getText();
        TradeOffer trade = new TradeOffer(seller, tradename, requiredpoints, description);
        System.out.println("ADDING TRADE --> " + trade);
        manager.addTrade(trade);
      }
      else {
        showAlert("Please enter a trade name, a description, and a value to add trade offer");
      }
    }
    catch (NumberFormatException event) {
      showAlert("Points must be a number to add a trade!");
    }
    catch (IllegalArgumentException event) {
      showAlert(event.getMessage());
    }

    initialize();
  }
  @FXML void editTradeOffer(ActionEvent e) {
    TradeOffer selectedTrade = (TradeOffer) chooseTrade.getValue();

    if (e.getSource() == chooseTrade)
    {
      if (selectedTrade != null)
      {
        chooseTradeSellerEdit.setValue(selectedTrade.getSeller());
        tradeNameEdit.setText(selectedTrade.getTradeName());
        tradeRequiredPointsEdit.setText(String.valueOf(selectedTrade.getPoints()));
        tradeDescriptionEdit.setText(selectedTrade.getDescription());
      }
    }
    else if (e.getSource() == removeTrade || e.getSource()==updateTrade)
    {

      try{
        if (!tradeNameEdit.getText().equals("") && !tradeDescriptionEdit.getText().equals("") && chooseTradeSeller.getValue() != null)
        {
          Villager editedSeller = (Villager) chooseTradeSellerEdit.getValue();
          String editedTradeName = tradeNameEdit.getText();
          int editedPoints = Integer.parseInt(tradeRequiredPointsEdit.getText());
          String editedDescription = tradeDescriptionEdit.getText();
          if(e.getSource()==removeTrade){
            TradeOffer toRemove = new TradeOffer(editedSeller, editedTradeName, editedPoints, editedDescription);
            manager.removeTrade(toRemove);
          }
          else if(e.getSource()==updateTrade){
            TradeOffer newTrade = new TradeOffer(editedSeller, editedTradeName, editedPoints, editedDescription);
            manager.changeTrade(selectedTrade, newTrade);
          }
        }
        else {
          showAlert("Please enter a trade name, a description and a value to update or remove trade offer");
        }
      }
      catch (NumberFormatException event) {
        showAlert("Points must be a number to edit or remove a trade!");
      }
      catch (IllegalArgumentException event) {
        showAlert(event.getMessage());
      }




      initialize();
    }
  }
  @FXML void finishTradeOffer(ActionEvent e) {
    TradeOffer selectedTrade = (TradeOffer) chooseTradeFinish.getValue();
    Villager finalbuyer = (Villager) chooseTradeBuyer.getValue();

    if (e.getSource() == chooseTradeFinish)
    {
      if (selectedTrade != null)
      {
        loadBuyerBox(selectedTrade);
      }
    }
    if(e.getSource() == chooseTradeBuyer){
      finalbuyer = (Villager) chooseTradeBuyer.getValue();
    }
    if (e.getSource()==finishTrade && finalbuyer != null)
    {
      manager.finishTrade(selectedTrade, finalbuyer);

      initialize();
    }
  }

  @FXML public void editGreenGoal(ActionEvent e) {
    GreenGoal selectedGreenGoal = (GreenGoal) chooseGreenGoal.getValue();
    if (e.getSource() == chooseGreenGoal)
    {
      if (selectedGreenGoal != null)
      {
        greenGoalName1.setText(selectedGreenGoal.getGoalName());
        greenRequiredPoints1.setText(
            String.valueOf(selectedGreenGoal.getRequiredPoints()));
        greenDescription1.setText(selectedGreenGoal.getGreenDescription());
      }
    }
    // When the Update button is clicked
    else if (e.getSource() == upDateGreenGoal)
    {
      if (selectedGreenGoal != null)
      {
        GreenGoal newGoal = new GreenGoal(greenGoalName1.getText(),
            Integer.parseInt(greenRequiredPoints1.getText()),
            greenDescription1.getText());
        manager.changeGreenGoal(selectedGreenGoal, newGoal);
      }
      initialize();
    }
  }
  @FXML public void addGreenActivity() {
    String name = greenActivityName.getText();
    String pointsText = greenActivityPoints.getText();

    if (!name.isEmpty() && !pointsText.isEmpty()) {
      try {
        if (!name.matches("[a-zA-Z ]+"))
        {
          throw new IllegalArgumentException("Name must contain only letters!");
        }
        int points = Integer.parseInt(pointsText);
        GreenActivity greenActivity = new GreenActivity(name, points);
        manager.addGreenActivity(greenActivity);
        loadGreenActivity();
        loadGreenActivityBox();
        loadGreenActivityBox1();

      }
      catch (NumberFormatException e) {
        System.out.println("Points must be a NUMBER!");


        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("Points must be a NUMBER!");
        alert.showAndWait();
      }
      catch (IllegalArgumentException e) {

        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(e.getMessage()); // "Name must contain only letters!"
        alert.showAndWait();
      }
    }
    else
    {
      System.out.println("Fields cannot be empty");

      alert.setHeaderText(null);
      alert.setTitle("Error");
      alert.setContentText("Fields cannot be empty!");
      alert.showAndWait();
    }

  }
  @FXML public void editGreenActivity(ActionEvent e) {
    GreenActivity selectedGreenActivity = (GreenActivity) chooseGreenActivity.getValue();
    // When a villager is selected in the ComboBox
    if (e.getSource() == chooseGreenActivity)
    {

      if (selectedGreenActivity != null) {
        greenActivityName1.setText(selectedGreenActivity.getActivityName());
        greenActivityPoints1.setText(String.valueOf(selectedGreenActivity.getPoints()) );
      }
    }
    // When the Update button is clicked
    else if (e.getSource() == updateGreenActivity)
    {
      if (selectedGreenActivity!= null)
      {
        selectedGreenActivity.setActivityName(greenActivityName.getText());
        selectedGreenActivity.setPoints(Integer.parseInt(greenActivityPoints.getText()));

        try
        {
          if (!greenActivityName1.getText().matches("[a-zA-Z ]+"))
          {
            throw new IllegalArgumentException("Name must contain only letters!");
          }
          int points = Integer.parseInt(greenActivityPoints1.getText());
          GreenActivity newGreenActivity = new GreenActivity(greenActivityName1.getText(), Integer.parseInt(greenActivityPoints1.getText()));
          manager.changeGreenActivity(selectedGreenActivity,newGreenActivity);

        }
        catch (NumberFormatException event) {
          System.out.println("Points must be a NUMBER!");

          showAlert("Points must be a NUMBER!");
        }
        catch (IllegalArgumentException event) {

          showAlert("Name must contain only letters!");
        }
      }
      else
      {
        System.out.println("Fields cannot be empty");

        showAlert("Fields cannot be empty or there is no activity to edit!");
      }
      everything();
    }
  }
  public void removeGreenActivity() {
    if (!(greenActivityName.getText().isEmpty() && greenActivityPoints.getText().isEmpty()))
    {
      String name = greenActivityName1.getText();
      int points = Integer.parseInt(greenActivityPoints1.getText());
      GreenActivity greenActivity = new GreenActivity(name,points);
      manager.removeGreenActivity(greenActivity);
      //try catch for when the list is empty
      everything();
    }
    else
    {
      showAlert("There is no activity to remove");
    }
  }
  @FXML void completeGreenActivity(ActionEvent e) {
    GreenActivity selectedGreenActivity = (GreenActivity) chooseGreenActivity1.getValue();
    manager.finishGreenActivity(selectedGreenActivity);
    showAlert(((GreenActivity) chooseGreenActivity1.getValue()).getPoints()+" points where added to the Green Goal because of the activity "+((GreenActivity) chooseGreenActivity1.getValue()).getActivityName());
    everything();
  }


  @FXML public void addSharedTask() {
    String name = sharedTaskName.getText();
    int points;
    try {
      points=  Integer.parseInt(pointsRequired.getText());
    }  catch (NumberFormatException event) {
      System.out.println("Points must be a NUMBER!");
      alert.setHeaderText(null);
      alert.setTitle("Hoppá");
      alert.setContentText("Points must be a NUMBER and not EMPTY!");
      alert.showAndWait();
      return;
    }

    Village village = manager.getVillage();


    SharedTask task = new SharedTask(name, points);
    int j = 0;
    for (int i = 0; i < manager.getSharedTasks().size(); i++) {

      if (task.getTaskName().equals(manager.getSharedTasks().get(i).getTaskName()))
        j++;
    }


    if (name.equals("")){
      alert.setHeaderText(null);
      alert.setTitle("Hoppá");
      alert.setContentText("Name cant be empty");
      alert.showAndWait();
      return;

    }
    if (j == 0 && !name.equals("") ) {
      manager.addSharedTask(task);
    }





    loadSharedTasks();
    sharedTaskName.clear();
    pointsRequired.clear();


  }
  @FXML public void updateSelectedTask(){
    SharedTask task = (SharedTask) availableSharedTasks.getSelectionModel().getSelectedItem();
    if (task == null) return;

    sharedTaskName1.setText(availableSharedTasks.getSelectionModel().getSelectedItem().getTaskName());
    pointsRequired1.setText(String.valueOf(availableSharedTasks.getSelectionModel().getSelectedItem().getPoints()));
  }
  @FXML public void updateSharedTask() {
    SharedTask selectedTask = availableSharedTasks.getSelectionModel().getSelectedItem();
    if (selectedTask == null) {
      alert.setHeaderText(null);
      alert.setTitle("Hoppá");
      alert.setContentText("Please select a task to update!");
      alert.showAndWait();
      return;
    }

    int index = availableSharedTasks.getSelectionModel().getSelectedIndex();
    if (index < 0) {
      alert.setHeaderText(null);
      alert.setTitle("Hoppá");
      alert.setContentText("Invalid selection!");
      alert.showAndWait();
      return;
    }

    String name = sharedTaskName1.getText();
    if (name.equals("")) {
      alert.setHeaderText(null);
      alert.setTitle("Hoppá");
      alert.setContentText("Name cant be empty");
      alert.showAndWait();
      return;
    }

    int points;
    try {
      points = Integer.parseInt(pointsRequired1.getText());
    } catch (NumberFormatException event) {
      System.out.println("Points must be a NUMBER!");
      alert.setHeaderText(null);
      alert.setTitle("Hoppá");
      alert.setContentText("Points must be a NUMBER and not EMPTY!");
      alert.showAndWait();
      return;
    }

    Village village = manager.getVillage();
    ArrayList<SharedTask> tasks = village.getSharedTasks();
    SharedTask task = tasks.get(index);
    task.setTaskName(name);
    task.setPoints(points);

    manager.saveVillage(village);
    loadSharedTasks();

    sharedTaskName1.clear();
    pointsRequired1.clear();
  }
  @FXML public void removeSharedTask(){
    SharedTask selectedTask = availableSharedTasks.getSelectionModel().getSelectedItem();
    if (selectedTask == null) {
      alert.setHeaderText(null);
      alert.setTitle("Hoppá");
      alert.setContentText("No task selected!");
      alert.showAndWait();
      return;
    }

    int index = availableSharedTasks.getSelectionModel().getSelectedIndex();
    if (index < 0) {
      alert.setHeaderText(null);
      alert.setTitle("Hoppá");
      alert.setContentText("Invalid selection!");
      alert.showAndWait();
      return;
    }

    Village village = manager.getVillage();
    ArrayList<SharedTask> tasks = village.getSharedTasks();



    tasks.remove(index);

    manager.saveVillage(village);
    loadSharedTasks();

    sharedTaskName1.clear();
    pointsRequired1.clear();
  }
  @FXML private void startCompletingSharedTask() {
    selectedVillagers.getItems().clear();

    SharedTask selectedTask = (SharedTask) completeSharedTasks.getSelectionModel().getSelectedItem();
    if (selectedTask == null) return;

    Village village = manager.getVillage();
    ArrayList<SharedTask> tasks = village.getSharedTasks();
    int indexTask = tasks.indexOf(selectedTask);
    if (indexTask < 0) return;

    SharedTask task = tasks.get(indexTask);


    task.resetPerformers();
    manager.saveVillage(village);


  }
  @FXML public void addPerformer() {
    SharedTask selectedTask = (SharedTask) completeSharedTasks.getSelectionModel().getSelectedItem();
    Villager selectedVillager = (Villager) completeVillagersList.getSelectionModel().getSelectedItem();
    if (selectedTask == null || selectedVillager == null) return;

    Village village = manager.getVillage();
    ArrayList<SharedTask> tasks = village.getSharedTasks();
    int indexTask = tasks.indexOf(selectedTask);
    if (indexTask < 0) return;


    Villager villagerInVillage = null;
    for (Villager v : village.getVillagers()) {
      if (v.equals(selectedVillager)) {
        villagerInVillage = v;
        break;
      }
    }
    if (villagerInVillage == null) return;

    SharedTask task = tasks.get(indexTask);

    boolean alreadyPerformer = false;
    for (int i = 0; i < task.NrPerformers(); i++) {
      if (villagerInVillage.equals(task.getPerformer(i))) {
        alreadyPerformer = true;
        break;
      }
    }

    if (!alreadyPerformer) {
      task.addPerformer(villagerInVillage);
      manager.saveVillage(village);
    }

    loadSelectedPerformers();
  }
  @FXML public void completeSharedTask() {
    SharedTask selectedTask = (SharedTask) completeSharedTasks.getSelectionModel().getSelectedItem();
    if (selectedTask == null) {
      alert.setHeaderText(null);
      alert.setTitle("Hoppá");
      alert.setContentText("Please select a task to complete!");
      alert.showAndWait();
      return;
    }

    Village village = manager.getVillage();
    ArrayList<SharedTask> tasks = village.getSharedTasks();

    int indexTask = tasks.indexOf(selectedTask);
    if (indexTask < 0) {
      alert.setHeaderText(null);
      alert.setTitle("Hoppá");
      alert.setContentText("Task not found in village!");
      alert.showAndWait();
      return;
    }

    SharedTask task = tasks.get(indexTask);

    if (task.NrPerformers() == 0) {
      alert.setHeaderText(null);
      alert.setTitle("Hoppá");
      alert.setContentText("Cannot complete task: No performers assigned!");
      alert.showAndWait();
      return;
    }

    village.finishSharedTask(task);
    manager.saveVillage(village);

    everything();
  }



  public void showAlert(String input)
  {
    System.out.println("ERROR --> " + input);

    alert.setHeaderText(null);
    alert.setTitle("Error");
    alert.setContentText(input);
    alert.showAndWait();
  }
}


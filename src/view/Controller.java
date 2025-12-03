package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.TradeOffer;
import model.Village;
import model.VillageModelManager;
import model.Villager;
import javafx.scene.*;
import javafx.event.*;
import model.GreenGoal;
import java.util.ArrayList;

public class Controller
{
  @FXML private TextField firstName;
  @FXML private TextField lastName;
  @FXML private TextField personalPoints;
  @FXML private TextField firstName1;
  @FXML private TextField lastName1;
  @FXML private Button updateVillager;
  @FXML private Button removeVillager;
  @FXML private Button addVillager;
  @FXML private TextArea listVillagers;
  @FXML private ComboBox chooseVillagers;
  @FXML private TextField sharedTaskName;
  @FXML private TextField pointsGiven;
  @FXML private TextField sharedTaskName1;
  @FXML private TextField pointsGiven1;
  @FXML private Button addSharedTask;
  @FXML private Button upDateSharedTask;
  @FXML private Button removeSharedTask;
  @FXML private TextField totalCounter;
  @FXML private TextField taskNameTrade;
  @FXML private ComboBox chooseSharedTask;
  @FXML private Button completeButton;
  @FXML private ComboBox chooseSharedtask1;
  @FXML private ComboBox chooseSharedTask2;
  @FXML private TextField greenGoalName;
  @FXML private TextField greenRequiredPoints;
  @FXML private TextField greenDiscription;
  @FXML private Button addGreenGoal;
  @FXML private ComboBox chooseGreenGoal;
  @FXML private TextField greenGoalName1;
  @FXML private TextField greenRequiredPoints1;
  @FXML private TextField greenDiscription1;
  @FXML private Button upDateGreenGoal;
  @FXML private Button removeGreenGoal;

  @FXML private TextArea listTrades;

  private VillageModelManager manager = new VillageModelManager("village.bin");

  public void initialize()
  {
    loadVillagerBox();
    loadVillagers();

    loadTrades();
  }

  @FXML public void loadVillagers()
  {
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

  @FXML public void loadVillagerBox()
  {
    chooseVillagers.getItems().clear();

    ArrayList<Villager> villagers = manager.getVillagers();
    for (Villager villager : villagers)
    {
      chooseVillagers.getItems().add(villager);       //add villagers to box
    }
    int currentIndex = chooseVillagers.getSelectionModel()
        .getSelectedIndex();  //gets index of selected villager in the box

    Villager selectedVillager = null;

    if (currentIndex == -1 && chooseVillagers.getItems().size() > 0)
    {   //no selection (no index) and there are villagers
      chooseVillagers.getSelectionModel()
          .select(0);              //show first villager in the box

      selectedVillager = (Villager) chooseVillagers.getValue();          //this will be the villager to fill up the texboxes
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

  @FXML public void loadTrades()
  {
    ArrayList<TradeOffer> trades = manager.getTrades();

    listTrades.clear();

    for (TradeOffer trade : trades)
    {
      String line = "";
      line += trade.getTradeName() + " for [" + trade.getPoints() + "]\n\tby"
          + trade.getSeller() + "\n";
      listTrades.appendText(line);
    }

    listTrades.setEditable(false);
  }

  @FXML public void addVillager()
  {
    if (firstName.getText() != "" && lastName.getText() != "")
    {
      String first = firstName.getText();
      String last = lastName.getText();
      Villager villager = new Villager(first, last);
      manager.addVillager(villager);

      loadVillagers();
      loadVillagerBox();
    }
  }

  @FXML public void editVillager(ActionEvent e)
  {
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
        Villager newVillager = new Villager(firstName1.getText(),
            lastName1.getText(), Integer.parseInt(personalPoints.getText()));
        manager.changeVillager(selectedVillager, newVillager);
      }
      loadVillagers();
      loadVillagerBox();
    }
  }

  public void removeVillager()
  {
    if (firstName1.getText() != "" && lastName1.getText() != "")
    {
      String first = firstName1.getText();
      String last = lastName1.getText();
      int points = Integer.parseInt(personalPoints.getText());
      Villager villager = new Villager(first, last, points);
      manager.removeVillager(villager);

      loadVillagers();
      loadVillagerBox();
    }
  }

  public void setTotalCounter()
  {
    int number = manager.getVillagers().size();
    totalCounter.setText(Integer.toString(number));
  }

  public void intializeGreenGoal()
  {
    loadGreenGoalBox();
    loadGreenGoal();
  }

  public void loadGreenGoal()
  {
    ArrayList<String> catalogueOfIdeas = manager.getcatalogueOfIdeas();

    for (String greengoal : catalogueOfIdeas)
    {
      String line = "";
      line += greengoal.getgreenGoalName() + " " + greengoal.getgreenRequiredPoints() + " - "
          + greengoal.getgreenDescription() + "\n";
      listCatalogueOfIdeas.appendText(line);
    }

    listCatalogueOfIdeas.setEditable(false);
  }
}


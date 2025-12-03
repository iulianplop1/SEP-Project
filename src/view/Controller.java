package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Village;
import model.VillageModelManager;
import model.Villager;
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


  private VillageModelManager manager = new VillageModelManager("village.bin");

  public void initialize()
  {
    loadVillagerBox();
    loadVillagers();

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

    int currentIndex = chooseVillagers.getSelectionModel().getSelectedIndex();  //gets index of selected

    ArrayList<Villager> villagers = manager.getVillagers();
    for (Villager villager : villagers)
    {
      chooseVillagers.getItems().add(villager);
    }

    Villager selectedVillager = null;

    if (currentIndex == -1 && chooseVillagers.getItems().size() > 0){
      chooseVillagers.getSelectionModel().select(0);

      selectedVillager = (Villager)chooseVillagers.getValue();
    }
    else{
      chooseVillagers.getSelectionModel().select(currentIndex);

      selectedVillager = (Villager)chooseVillagers.getValue();
    }

    if (selectedVillager != null) {
      firstName1.setText(selectedVillager.getFirstname());
      lastName1.setText(selectedVillager.getLastname());
      personalPoints.setText(String.valueOf(selectedVillager.getPoints()));
    }


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
    Villager selectedVillager = (Villager)chooseVillagers.getValue();

    // When a villager is selected in the ComboBox
    if (e.getSource() == chooseVillagers)
    {

      if (selectedVillager != null) {
        firstName1.setText(selectedVillager.getFirstname());
        lastName1.setText(selectedVillager.getLastname());
        personalPoints.setText(String.valueOf(selectedVillager.getPoints()));
      }
    }

    // When the Update button is clicked
    else if (e.getSource() == updateVillager)
    {
      if (selectedVillager != null) {
        Villager newVillager = new Villager(firstName1.getText(), lastName1.getText(), Integer.parseInt(personalPoints.getText()));
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
      int  points = Integer.parseInt(personalPoints.getText());
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
}



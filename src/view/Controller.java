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


  private VillageModelManager manager = new VillageModelManager("village.bin");

  public void initialize()
  {
    loadVillagers();
    loadVillagerBox();
  }

  @FXML public void loadVillagers()
  {
    ArrayList<Villager> villagers = manager.getVillagers();

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
    int currentIndex = chooseVillagers.getSelectionModel().getSelectedIndex();
    chooseVillagers.getItems().clear();

    ArrayList<Villager> villagers = manager.getVillagers();
    for (Villager villager : villagers)
    {
      String line = "";
      line += villager.getFirstname() + " " + villager.getLastname() + " - "
          + villager.getPoints() + "\n";

      chooseVillagers.getItems().add(villager);
    }

    if (currentIndex == -1 && chooseVillagers.getItems().size() > 0){
      chooseVillagers.getSelectionModel().select(0);
    }
    else{
      chooseVillagers.getSelectionModel().select(currentIndex);
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
        selectedVillager.setFirstName(firstName1.getText());
        selectedVillager.setLastName(lastName1.getText());
        selectedVillager.setPoints(Integer.parseInt(personalPoints.getText()));
      }
      loadVillagers();
    }
  }


  public void removeVillager()
  {
    if (firstName1.getText() != "" && lastName1.getText() != "")
    {
      String first = firstName1.getText();
      String last = lastName1.getText();
      Villager villager = new Villager(first, last);
      manager.removeVillager(villager);
      loadVillagers();
    }
  }

  public void setTotalCounter()
  {
    int number = manager.getVillagers().size();
    totalCounter.setText(Integer.toString(number));
  }
}


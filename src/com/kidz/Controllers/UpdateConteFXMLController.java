/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidz.Controllers;

import com.kidz.entities.Conte;
import com.kidz.services.ConteService;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class UpdateConteFXMLController implements Initializable {

    @FXML
    public ChoiceBox<String> minage;
    @FXML
    public ChoiceBox<String> maxage;
    @FXML
    public TextField titre;
    @FXML
    public TextArea resume;
    @FXML
    public TextField contenu;
    @FXML
    public TextField image;
    @FXML
    public TextField maison;
    @FXML
    public TextField aute;
    @FXML
    public ChoiceBox<String> categorie;
    @FXML
    public Button benregistrer;
    public Stage dialogStage;
    
    private boolean okClicked = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         minage.setItems(FXCollections.observableArrayList(
            "3", "4","5","6", "7","8","9", "10","11","12","13","14","15","16","17")
        );
        minage.setTooltip(new Tooltip("select age minimal"));
        maxage.setItems(FXCollections.observableArrayList(
            "3", "4","5","6", "7","8","9", "10","11","12","13","14","15","16","17")
        );
        maxage.setTooltip(new Tooltip("select age maximal"));
        categorie.setItems(FXCollections.observableArrayList(
            "Conte bébé", "Conte noel","Conte arabe","Conte ecole","Conte histoire","Conte amour","Conte fantastique"
        ,"Conte fabuleuse ","Conte Humour","Conte Aventure et enquête"));
        categorie.setTooltip(new Tooltip("select categorie"));     

            

    }    
  

    /**
     * Sets
     *
     * @param conte
     */
    public void setConte(Conte conte) {
       
        System.out.println(conte);
        
        contenu.setText(conte.getContenu());
        resume.setText(conte.getResume());
        aute.setText(conte.getAuteur());
        categorie.getValue();
        minage.getValue();
        maxage.getValue();
        maison.setText(conte.getMaison_ed());
        
    }
    
    

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    /*@FXML
    private void handleOk() {
        if (isInputValid()) {
            conte.setTitreC(titre.getText());
            conte.setCatC(categorie.getValue());
            conte.setContenu(contenu.getText());
            conte.setMaison_ed(contenu.getText());
            conte.setAuteur(aute.getText());
            conte.setMinage(Integer.parseInt(minage.getValue()));
            conte.setMaxage(Integer.parseInt(maxage.getValue()));
            conte.setImage(image.getText());
            

            okClicked = true;
            dialogStage.close();
        }
    }*/

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    /*private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if (streetField.getText() == null || streetField.getText().length() == 0) {
            errorMessage += "No valid street!\n";
        }

        if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
            errorMessage += "No valid postal code!\n";
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(postalCodeField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n";
            }
        }

        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "No valid city!\n";
        }

        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        } else {
            if (!DateUtil.validDate(birthdayField.getText())) {
                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}*/
 
}

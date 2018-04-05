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
    private ChoiceBox<String> minage;
    @FXML
    private ChoiceBox<String> maxage;
    @FXML
    private TextField titre;
    @FXML
    private TextArea resume;
    @FXML
    private TextField contenu;
    @FXML
    private TextField image;
    @FXML
    private TextField maison;
    @FXML
    private TextField aute;
    @FXML
    private ChoiceBox<String> categorie;
    @FXML
    private Button benregistrer;
    private Stage dialogStage;
    private Conte conte;
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
        /*ConteService conte = new ConteService();
        Conte c = new Conte();
        //conte = ConteService.consulterPersonne(Conte.);
        //System.out.println(Conte.toString());
        titre.setText(c.getTitreC());        
        resume.setText(c.getResume());
        contenu.setText(c.getContenu());
        aute.setText(c.getAuteur());*/   
    }    
   public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    public void setConte(Conte conte) {
        this.conte = conte;
        titre.setText(conte.getTitreC());
        resume.setText(conte.getResume());
        aute.setText(conte.getAuteur());
        contenu.setText(conte.getContenu());
        maison.setText(conte.getContenu());
        
        //minage.setText(conte.getMinage());
        
        
        
    }
     /*public boolean isOkClicked() {
        return okClicked;
    }*/

    /*public void recuperer(Conte C) {
       
     
    
}*/
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidz.Controllers;

import com.kidz.entities.Conte;
import com.kidz.services.ConteService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AddConteController implements Initializable {

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
    private TextField maison;
    @FXML
    private TextField aute;
    @FXML
    private ChoiceBox<String> categorie;
    @FXML
    private Button ajout;
    @FXML
    private TextField image;

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

    @FXML
    private void AjoutConte(ActionEvent event) {
         ConteService conte = new ConteService();
        Conte c = new Conte();
        //String min = minage.getValue();
       // String max = maxage.getValue();
        
        c.setTitreC(titre.getText());
        c.setResume(resume.getText());
        c.setContenu(contenu.getText());
        c.setImage(image.getText());
        c.setMinage(Integer.parseInt(minage.getValue()));
        c.setMaxage(Integer.parseInt(maxage.getValue()));
        c.setMaison_ed(maison.getText());
        c.setCatC(categorie.getValue());
        c.setAuteur(aute.getText());
        conte.createConte(c);
        titre.clear();
        resume.clear();
        contenu.clear();
        image.clear();
        maison.clear();
        aute.clear();
       
       System.out.println("Ajouter effectue avec succes");
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidz.Controllers;

import com.kidz.Controllers.AddConteController;
import com.kidz.entities.Conte;
import com.kidz.services.ConteService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ShowConteFXMLController implements Initializable {

    @FXML
    private TableView<Conte> tableconte;
    
    @FXML
    private TableColumn<Conte,String> ctitre;
    @FXML
    private TableColumn<Conte,String> ccategorie;
    @FXML
    private TableColumn<Conte,String> contenu;
    @FXML
    private TableColumn<Conte,Integer> miage;
    @FXML
    private TableColumn<Conte,Integer> maage;
    @FXML
    private TableColumn<Conte,String> maison;
    @FXML
    private TableColumn<Conte,String> auteur;
    @FXML
    private AnchorPane FConte;
    @FXML
    private Label ltitrec;
    @FXML
    private Label lcontenu;
    @FXML
    private Label lage;
    @FXML
    private Label lcategorie;
    @FXML
    private Label lmaison;
    @FXML
    private Label lauteur;
    @FXML
    private Label lresume;
    @FXML
    private Button bnouveau;
    @FXML
    private Button bmodifier;
    @FXML
    private Button bsupprimer;
    ConteService listService = new ConteService();
    ObservableList<Conte> listconte;
    @FXML
    private SplitPane split;
    @FXML
    private AnchorPane modif;
    @FXML
    private AnchorPane mainmain;
    @FXML
    private ChoiceBox<String> tminage;
    @FXML
    private ChoiceBox<String> tmaxage;
    @FXML
    private TextField ttitre;
    @FXML
    private TextArea tresume;
    @FXML
    private TextField tcontenu;
    @FXML
    private TextField tmaison;
    @FXML
    private TextField tauteur;
    @FXML
    private ChoiceBox<String> tcategorie;
    @FXML
    private TextField timage;
    @FXML
    private Button tmodifier;
    @FXML
    private AnchorPane ajoutconte;
    @FXML
    private Button ajout;
    @FXML
    private ChoiceBox<String> aminage;
    @FXML
    private ChoiceBox<String> amaxage;
    @FXML
    private TextField atitre;
    @FXML
    private TextArea aresume;
    @FXML
    private TextField acontenu;
    @FXML
    private TextField amaison;
    @FXML
    private TextField aauteur;
    @FXML
    private ChoiceBox<String> acategorie;
    @FXML
    private TextField aimage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         System.out.println("Gestion Conte");
         // TODO
         tminage.setItems(FXCollections.observableArrayList(
            "3", "4","5","6", "7","8","9", "10","11","12","13","14","15","16","17")
        );
        tminage.setTooltip(new Tooltip("select age minimal"));
        tmaxage.setItems(FXCollections.observableArrayList(
            "3", "4","5","6", "7","8","9", "10","11","12","13","14","15","16","17")
        );
        tmaxage.setTooltip(new Tooltip("select age maximal"));
        tcategorie.setItems(FXCollections.observableArrayList(
            "Conte bébé", "Conte noel","Conte arabe","Conte ecole","Conte histoire","Conte amour","Conte fantastique"
        ,"Conte fabuleuse ","Conte Humour","Conte Aventure et enquête"));
        tcategorie.setTooltip(new Tooltip("select categorie"));     

        aminage.setItems(FXCollections.observableArrayList(
            "3", "4","5","6", "7","8","9", "10","11","12","13","14","15","16","17")
        );
        aminage.setTooltip(new Tooltip("select age minimal"));
        amaxage.setItems(FXCollections.observableArrayList(
            "3", "4","5","6", "7","8","9", "10","11","12","13","14","15","16","17")
        );
        amaxage.setTooltip(new Tooltip("select age maximal"));
        acategorie.setItems(FXCollections.observableArrayList(
            "Conte bébé", "Conte noel","Conte arabe","Conte ecole","Conte histoire","Conte amour","Conte fantastique"
        ,"Conte fabuleuse ","Conte Humour","Conte Aventure et enquête"));
        tcategorie.setTooltip(new Tooltip("select categorie"));     

       listconte = FXCollections.observableArrayList(listService.consulterListeConteAvecId());
       
       //idc.setCellValueFactory(new PropertyValueFactory<>("idCon"));
       ctitre.setCellValueFactory(new PropertyValueFactory<>("TitreC"));
       ccategorie.setCellValueFactory(new PropertyValueFactory<>("catC"));
       contenu.setCellValueFactory(new PropertyValueFactory<>("contenu"));
       miage.setCellValueFactory(new PropertyValueFactory<>("minage"));
       maage.setCellValueFactory(new PropertyValueFactory<>("maxage"));
       maison.setCellValueFactory(new PropertyValueFactory<>("Maison_ed"));
       auteur.setCellValueFactory(new PropertyValueFactory<>("auteur"));
       tableconte.setItems(listconte);
       Conte conte= tableconte.getSelectionModel().getSelectedItem();
       // Clear person details.
       
        showConteDetails(conte);


    // Listen for selection changes and show the person details when changed.
      tableconte.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> showConteDetails(newValue));
       
    
    
    } 
    private void showConteDetails(Conte conte) {
    if (conte != null) {
        // Fill the labels with info from the person object.
        ltitrec.setText(conte.getTitreC());
        ccategorie.setText(conte.getCatC());
        lcontenu.setText(conte.getContenu());
        lage.setText(Integer.toString(conte.getMaxage()));
        lcategorie.setText(conte.getCatC());
        lresume.setText(conte.getResume());
        lauteur.setText(conte.getAuteur());
        lmaison.setText(conte.getMaison_ed());
       
        bmodifier.setOnAction(new EventHandler<ActionEvent>() {
     
            public void handle(ActionEvent e) {
  
        //split.setOpacity(0);
        System.out.println(conte.getContenu());
        modif.setOpacity(1);
        ttitre.setText(conte.getTitreC());
        tcontenu.setText(conte.getContenu());
        tresume.setText(conte.getResume());
        tauteur.setText(conte.getAuteur());
        tcategorie.setValue(conte.getCatC());
        tminage.setValue(Integer.toString(conte.getMinage()));
        tmaxage.setValue(Integer.toString(conte.getMaxage()));
        tmaison.setText(conte.getMaison_ed());
        mainmain.getChildren().remove(ajoutconte);
     mainmain.getChildren().remove(split);
    }
    });
                tmodifier.setOnAction(new EventHandler<ActionEvent>() {
     
            public void handle(ActionEvent e) {
                ConteService cs =new ConteService();
                conte.setAuteur(tauteur.getText());
                conte.setCatC(tcategorie.getValue());
                conte.setTitreC(ttitre.getText());
                conte.setContenu(tcontenu.getText());
                conte.setResume(tresume.getText());
                conte.setMaison_ed(tmaison.getText());
                conte.setMinage(Integer.parseInt(tminage.getValue()));
                conte.setMaxage(Integer.parseInt(tmaxage.getValue()));
                conte.setImage(timage.getText());
                
                cs.update(conte);
            }
  
         });      
         
       
        
       
        //cityLabel.setText(person.getCity());

        // TODO: We need a way to convert the birthday into a String!
        // birthdayLabel.setText(...);
    } else {
        // Person is null, remove all the text.
        ltitrec.setText("");
        ccategorie.setText("");
        lcontenu.setText("");
        lresume.setText("");
        lauteur.setText("");
        lmaison.setText("");
        lage.setText("");
        lcategorie.setText("");
        
    }
     bnouveau.setOnAction(new EventHandler<ActionEvent>() {
     
            public void handle(ActionEvent e) {
        split.setOpacity(0);
        modif.setOpacity(0);
        ajoutconte.setOpacity(1);
        
         mainmain.getChildren().remove(modif);
     mainmain.getChildren().remove(split);
         
            }});
      bsupprimer.setOnAction(new EventHandler<ActionEvent>() {
     
            public void handle(ActionEvent e) {
        int selectedIndex = tableconte.getSelectionModel().getSelectedIndex();
        tableconte.getItems().remove(selectedIndex);
        
        ConteService css=new ConteService();
        css.delete(conte.getIdCon());
    
         
            }});
     
    
    } 
   

     @FXML
    private void AjoutConte(ActionEvent event) {
        
        ConteService conte = new ConteService();
        Conte c = new Conte();
        //String min = minage.getValue();
       // String max = maxage.getValue();
        
        c.setTitreC(atitre.getText());
        c.setResume(aresume.getText());
        c.setContenu(contenu.getText());
        c.setImage(aimage.getText());
        c.setMinage(Integer.parseInt(aminage.getValue()));
        c.setMaxage(Integer.parseInt(amaxage.getValue()));
        c.setMaison_ed(amaison.getText());
        c.setCatC(acategorie.getValue());
        c.setAuteur(aauteur.getText());
        conte.createConte(c);
        atitre.clear();
        aresume.clear();
        acontenu.clear();
        aimage.clear();
        amaison.clear();
        aauteur.clear();
       
       System.out.println("Ajouter effectue avec succes");
    }
}
    


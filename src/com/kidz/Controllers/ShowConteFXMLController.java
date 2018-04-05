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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private TableColumn<Conte,Integer> idc;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         System.out.println("Gestion Conte");
       
       listconte = FXCollections.observableArrayList(listService.consulterListeConteAvecId());
       
       idc.setCellValueFactory(new PropertyValueFactory<>("idCon"));
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
        showConteDetails(null);

    // Listen for selection changes and show the person details when changed.
      tableconte.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> showConteDetails(newValue));
       
    
        //showConteDetails(conte);*/
    bnouveau.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent e) {
  
      
          Stage primaryStage = new Stage();													
		Parent root = null; 
         try {
             root = FXMLLoader.load(getClass().getResource("/com/kidz/Presentations/AddConte.fxml"));
         } catch (IOException ex) {
             Logger.getLogger(ShowConteFXMLController.class.getName()).log(Level.SEVERE, null, ex);
         }
		Scene scene = new Scene(root,650,480);											 
		primaryStage.setScene(scene);
		primaryStage.show();
                
                AddConteController AConte=new AddConteController();
              
        
    }
    });
     bmodifier.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent e) {
  
      
          Stage primaryStage = new Stage();													
		Parent root = null; 
         try {
             root = FXMLLoader.load(getClass().getResource("/com/kidz/Presentations/UpdateConteFXML.fxml"));
         } catch (IOException ex) {
             Logger.getLogger(ShowConteFXMLController.class.getName()).log(Level.SEVERE, null, ex);
         }
		Scene scene = new Scene(root,650,480);											 
		primaryStage.setScene(scene);
		primaryStage.show();
                
                UpdateConteFXMLController UConte=new UpdateConteFXMLController();
              
        
    }
    });
    } 
    private void showConteDetails(Conte conte) {
    if (conte != null) {
        // Fill the labels with info from the person object.
        ltitrec.setText(conte.getTitreC());
        ccategorie.setText(conte.getCatC());
        lcontenu.setText(conte.getContenu());
        lcategorie.setText(conte.getCatC());
        lresume.setText(conte.getResume());
        lauteur.setText(conte.getAuteur());
        lmaison.setText(conte.getMaison_ed());
        
        lage.setText(Integer.toString(conte.getMaxage()));
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
    } 
    @FXML
    private void handleDeleteConte() {
    int selectedIndex = tableconte.getSelectionModel().getSelectedIndex();
    tableconte.getItems().remove(selectedIndex);
    }
}
    


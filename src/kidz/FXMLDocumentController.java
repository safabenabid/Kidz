/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kidz;

import com.kidz.entities.Conte;
import com.kidz.services.ConteService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author ASUS
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        ConteService conte= new ConteService();
        //conte.createConte(new Conte("test1","test1", "test1", "test1",3,4,"test1","test1","test1", true));
        //conte.update(new Conte(4,"test1","test1", "test1", "test1",3,6,"test1","test1","test1", true));
        //conte.delete(4);
        //conte.getAll().forEach(System.out::println);
        conte.consulterListeConteAvecId().forEach(System.out::println);
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

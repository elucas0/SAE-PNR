package controller;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import org.kordamp.ikonli.javafx.FontIcon;

public class Formulaire_nid_gci_controller {

    @FXML
    private ComboBox natureObs;
    
    public void setItems(String[] args){

        ArrayList<String> contenu = new ArrayList<String>();
        contenu.add("Poussin");
        contenu.add("Oeuf");
        contenu.add("Nid");
        natureObs.getItems().addAll();
    }
    
}

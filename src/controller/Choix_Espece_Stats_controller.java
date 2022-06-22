package controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import org.kordamp.ikonli.javafx.FontIcon;

public class Choix_Espece_Stats_controller {

    @FXML
    private FontIcon arreter;
    
    @FXML
    private Button nom_compte;
    
    @FXML
    private MenuButton prospec;
    
    @FXML
    private MenuButton prospec1;
    
    @FXML
    private MenuButton prospec2;
    
    @FXML
    private MenuButton prospec3;
    
    @FXML
    private MenuButton prospec4;
    
    @FXML
    private Button retour;
    
    @FXML
    private MenuItem stat1batracien;
    
    @FXML
    private MenuItem stat1chouette;
    
    @FXML
    private MenuItem stat1gci;
    
    @FXML
    private MenuItem stat1hippocampe;
    
    @FXML
    private MenuItem stat1loutre;
        
    @FXML
    public void toMainPage(){

        Stage actuel = (Stage)nom_compte.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        if(ReadInfos.estAdmin() == true){

            change.go_to("../view/Accueil_Admin.fxml");
        }else{

            change.go_to("../view/Accueil_Utilisateur.fxml");
        }
    }

    /**
    * Event to do when the button retour is pressed.
    * Switch to the page Accueil_Utilisateur.fxml
    */
    @FXML
    public void retour(){
        Stage actuel = (Stage)nom_compte.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Accueil_Utilisateur.fxml");
    }

    @FXML
    void toStatBatracien1(ActionEvent event) {
        Stage actuel = (Stage)nom_compte.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Stats_Batracien_1.fxml");
    }

    @FXML
    void toStatChouette1(ActionEvent event) {
        Stage actuel = (Stage)nom_compte.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Stats_Chouette_1.fxml");
    }

    @FXML
    void toStatGci1(ActionEvent event) {

    }

    @FXML
    void toStatHippocampe1(ActionEvent event) {
        Stage actuel = (Stage)nom_compte.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Stats_Hippocampe_1.fxml");
    }

    @FXML
    void toStatLoutre1(ActionEvent event) {

    }

}

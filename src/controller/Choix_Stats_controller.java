package controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;

public class Choix_Stats_controller {

    @FXML
    private Button user;

    
    @FXML
    /**
     * The content to do when the page linked to is started
     */
    private void initialize(){}

    @FXML
    public void toMainPage(){

        Stage actuel = (Stage)user.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Accueil_Utilisateur.fxml");
    }

    public void toObs(){

        Stage actuel = (Stage)user.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Affichage.fxml");
    }

    public void toStat(){

        Stage actuel = (Stage)user.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        //change.go_to("../src/formulaires/ConsultCompte.fxml");
    }
    
}

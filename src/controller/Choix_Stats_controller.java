package controller;
import controller.utilitaires.ChangerPage;
import controller.utilitaires.ReadInfos;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Choix_Stats_controller {

    @FXML
    /**
     * The account button in the fxml file
     */
    private Button user;

    
    @FXML
    /**
     * The content to do when the page linked to is started
     */
    private void initialize(){

        user.setText(ReadInfos.getStatus());

    }

    @FXML
    /**
     * Event to do when the button retour is pressed.    
     * Switch to the page Accueil_Utilisateur.fxml
    */
    public void toMainPage(){

        Stage actuel = (Stage)user.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        if(ReadInfos.estAdmin()){

            change.go_to("../view/Accueil_Admin.fxml");
        }else{

            change.go_to("../view/Accueil_Utilisateur.fxml");
        }
    }

    /**
     * When a button linked to "toObs" is pressed
     * Switch to the page Affichage.fxml to display the table selection menu
     */
    public void toObs(){

        Stage actuel = (Stage)user.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Affichage.fxml");
    }

    /**
     * When a button linked to "toGraphics" is pressed
     * Switch to the page Choix_espece_stats.fxml to display the choice of the animal
     */
    public void toGraphics(){

        Stage actuel = (Stage)user.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Choix_espece_stats.fxml");
    }


    /**
    * Event to do when the button retour is pressed.
    * Switch to the page Accueil_Utilisateur.fxml
    */
    public void retour(){

        Stage actuel = (Stage)this.user.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        if(ReadInfos.estAdmin()){

            change.go_to("../view/Accueil_Admin.fxml");
        }else{

            change.go_to("../view/Accueil_Utilisateur.fxml");
        }
    }
    
}

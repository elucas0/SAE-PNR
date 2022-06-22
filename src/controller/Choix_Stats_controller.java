package controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Choix_Stats_controller {

    @FXML
    private Button user;

    
    @FXML
    /**
     * The content to do when the page linked to is started
     */
    private void initialize(){

        user.setText(ReadInfos.getStatus());

    }

    @FXML
    public void toMainPage(){

        Stage actuel = (Stage)user.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        if(ReadInfos.estAdmin()){

            change.go_to("../view/Accueil_Admin.fxml");
        }else{

            change.go_to("../view/Accueil_Utilisateur.fxml");
        }
    }

    public void toObs(){

        Stage actuel = (Stage)user.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Affichage.fxml");
    }

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

package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;


/**
 * The controller of the page Accueil_Utilisateur.fxml. It manages it.
 * @version 1.0
 */
public class Accueil_Utilisateur_controller {

    @FXML
    private Button deco;

    @FXML
    private Button vue;

    @FXML
    private MenuButton prospec;



    /**
     * The content to do when the page linked to is started
     */
    private void initialize(){

        
    }


    @FXML
    public void toLogin(){

        Stage actuel = (Stage)prospec.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/page_login.fxml");
    }

    public void toData(){

        Stage actuel = (Stage)prospec.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/choix_stat_liste.fxml");
    }

    
    public void formulaire_obs_batracien(){

        Stage actuel = (Stage)prospec.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_obs_batracien.fxml");

    }

    public void formulaire_obs_loutre(){

        Stage actuel = (Stage)prospec.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_obs_loutre.fxml");

    }

    public void formulaire_obs_gci(){

        Stage actuel = (Stage)prospec.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_obs_gci.fxml");

    }

    public void formulaire_obs_hippocampe(){

        Stage actuel = (Stage)prospec.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_obs_hippocampe.fxml");

    }

    public void formulaire_obs_chouette(){

        Stage actuel = (Stage)prospec.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_obs_chouette.fxml");
    }
    
}
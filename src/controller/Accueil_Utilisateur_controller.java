package controller;

import controller.utilitaires.ChangerPage;
import controller.utilitaires.ReadInfos;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * The controller of the page Accueil_Utilisateur.fxml. It manages it.
 * @version 1.0
 */
public class Accueil_Utilisateur_controller {

    @FXML
    /**
     * Button to disconnect from account
     */
    private Button deco;

    @FXML
    /**
     * Button to acess all the observation in the database
     */
    private Button vue;

    @FXML
    /**
     * Button to manage the account
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
     * When a button linked to "toLogin" is pressed
     * Switch to the page page_login.fxml
     */
    public void toLogin(){

        Stage actuel = (Stage)deco.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/Page_Login.fxml");
    }

    /**
     * When a button linked to "toData" is pressed
     * Switch to the page choix_stat_liste.fxml
     */
    public void toData(){

        Stage actuel = (Stage)deco.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/choix_stat_liste.fxml");
    }

    /**
     * When a button linked to "toManage" is pressed
     * Switch to the page ConsultCompte.fxml
     */
    public void toManage(){

        Stage actuel = (Stage)deco.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../src/ConsultCompte.fxml");
    }

    /**
     * When a button linked to "formulaire_obs_batracien" is pressed
     * Switch to the page Formulaire_obs_batracien.fxml
     */
    public void formulaire_obs_batracien(){

        Stage actuel = (Stage)deco.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/formulaires/Formulaire_obs_batracien.fxml");

    }

    /**
     * When a button linked to "formulaire_obs_loutre" is pressed
     * Switch to the page Formulaire_obs_loutre.fxml
     */
    public void formulaire_obs_loutre(){

        Stage actuel = (Stage)deco.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/formulaires/Formulaire_obs_loutre.fxml");

    }

    /**
     * When a button linked to "formulaire_obs_gci" is pressed
     * Switch to the page Formulaire_obs_gci.fxml
     */
    public void formulaire_obs_gci(){

        Stage actuel = (Stage)deco.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/formulaires/Formulaire_obs_gci.fxml");

    }

    /**
     * When a button linked to "formulaire_obs_hippocampe" is pressed
     * Switch to the page Formulaire_obs_hippocampe.fxml
     */
    public void formulaire_obs_hippocampe(){

        Stage actuel = (Stage)deco.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/formulaires/Formulaire_obs_hippocampe.fxml");

    }

    /**
     * When a button linked to "formulaire_obs_chouette" is pressed
     * Switch to the page Formulaire_obs_chouette.fxml
     */
    public void formulaire_obs_chouette(){

        Stage actuel = (Stage)deco.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/formulaires/Formulaire_obs_chouette.fxml");
    }

    /**
     * When a button linked to "formulaire_a_observe" is pressed
     * Switch to the page Formulaire_a_observe.fxml
     */
    public void formulaire_a_observe(){

        Stage actuel = (Stage)deco.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/formulaires/Formulaire_a_observe.fxml");
    }

    /**
     * When a button linked to "formulaire_a_observe" is pressed
     * Switch to the page Formulaire_a_observe.fxml
     */
    public void formulaire_lieu(){

        Stage actuel = (Stage)deco.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/formulaires/Formulaire_lieu.fxml");
    }

    /**
     * When a button linked to "formulaire_zone_humide" is pressed
     * Switch to the page Formulaire_zone_humide.fxml
     */
    public void formulaire_zone_humide(){

        Stage actuel = (Stage)deco.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/formulaires/Formulaire_zone_humide.fxml");
    }

    /**
     * When a button linked to "formulaire_vegetation" is pressed
     * Switch to the page Formulaire_vegetation.fxml
     */
    public void formulaire_vegetation(){

        Stage actuel = (Stage)deco.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/formulaires/Formulaire_vegetation.fxml");
    }
    
}

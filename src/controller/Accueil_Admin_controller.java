package controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * The controller of the page Accueil_Admin.fxml. It manages it.
 * @version 1.0
 */
public class Accueil_Admin_controller {
    /**
     * Button to disconnect from the application
     */
    @FXML
    private Button deco;

    /**
     * Button to acess all the observation in the database
     */
    @FXML
    private Button vue;

    /**
     * Button to create an observation 
     */
    @FXML
    private MenuButton prospec;

    /**
     * Button to manage the users account 
     */
    @FXML
    private Button gestion;

    /**
     * Button to acess information about of the user account
     */
    @FXML
    private Button user;
    
    @FXML
    /**
     * The content to do when the page it's linked to is started
     */
    private void initialize(){

        user.setText(ReadInfos.getStatus());
    }

    /**
    * When a button linked to "toLogin" is pressed   
    * Switch to the page page_login.fxml
    */
    @FXML
    public void toLogin(){

        Stage actuel = (Stage)gestion.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/page_login.fxml");
    }

    /**
    * When a button linked to "toData" is pressed   
    * Switch to the page choix_stat_liste.fxml
    */
    public void toData(){

        Stage actuel = (Stage)gestion.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/choix_stat_liste.fxml");
    }
    
    /**
    * When a button linked to "toManage" is pressed   
    * Switch to the page ConsulteCompte.fxml
    */
    public void toManage(){

        Stage actuel = (Stage)gestion.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/ConsulteCompte.fxml");
    }
    
    /**
    * When a button linked to "formulaire_obs_batracien" is pressed   
    * Switch to the page Formulaire_obs_batracien.fxml
    */
    public void formulaire_obs_batracien(){

        Stage actuel = (Stage)gestion.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_obs_batracien.fxml");

    }

    /**
    * When a button linked to "formulaire_obs_loutre" is pressed   
    * Switch to the page Formulaire_obs_loutre.fxmll
    */
    public void formulaire_obs_loutre(){

        Stage actuel = (Stage)gestion.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_obs_loutre.fxml");

    }
    
    /**
    * When a button linked to "formulaire_obs_loutre" is pressed   
    * Switch to the page Formulaire_obs_loutre.fxmll
    */
    public void formulaire_obs_gci(){

        Stage actuel = (Stage)gestion.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_obs_gci.fxml");

    }

    public void formulaire_obs_hippocampe(){

        Stage actuel = (Stage)gestion.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_obs_hippocampe.fxml");

    }

    public void formulaire_obs_chouette(){

        Stage actuel = (Stage)gestion.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_obs_chouette.fxml");
    }
    public void formulaire_a_observe(){

        Stage actuel = (Stage)gestion.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_a_observe.fxml");
    }
    public void formulaire_lieu(){

        Stage actuel = (Stage)gestion.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_lieu.fxml");
    }
    public void formulaire_zone_humide(){

        Stage actuel = (Stage)gestion.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_zone_humide.fxml");
    }
    public void formulaire_vegetation(){

        Stage actuel = (Stage)gestion.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_vegetation.fxml");
    }
}

package controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * The controller of the page Affichage_Historique.fxml. It manages it.
 * @version 1.0
 */
public class Affichage_Historique_controller {

    /**
     * The page's home button
     */
    @FXML
    private Button home;

    /**
     * The page's home button
     */
    @FXML
    private Button user;

    /**
     * The page's go back button
     */
    @FXML
    private Button retour; 
    

    /**
     * The content to do when the page linked to is started
     */
    @FXML
    private void initialize() 
    {

    }

    /**
    * Event to do when the button retour is pressed.    
    * Switch to the page choix_stat_liste.fxml
    */
    public void retour(){
        Stage actuel = (Stage)home.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/exempleCompte.fxml");
    }

    /**
    * Event to do when the button retour is pressed.    
    * Switch to the page Accueil_Utilisateur.fxml
    */
    public void home(){
        Stage actuel = (Stage)home.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/Accueil_Admin.fxml");
    }
    
}

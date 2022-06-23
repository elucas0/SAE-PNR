package controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import org.kordamp.ikonli.javafx.FontIcon;

import controller.utilitaires.ChangerPage;
import controller.utilitaires.ReadInfos;

public class Choix_Espece_Stats_controller {

    @FXML
    /**
     * The retour icon in the fxml file
     */
    private FontIcon arreter;
    
    @FXML
    /**
     * The account button in the fxml file
     */
    private Button nom_compte;
    
    @FXML
    /**
     * The button to display the list of available stats for the chosen animal
     */
    private MenuButton prospec;
    
    @FXML
    /**
     * The button to display the list of available stats for the chosen animal
     */
    private MenuButton prospec1;
    
    @FXML
    /**
     * The button to display the list of available stats for the chosen animal
     */
    private MenuButton prospec2;
    
    @FXML
    /**
     * The button to display the list of available stats for the chosen animal
     */
    private MenuButton prospec3;
    
    @FXML
    /**
     * The button to display the list of available stats for the chosen animal
     */
    private MenuButton prospec4;
    
    @FXML
    /**
     * The retour button in the fxml file
     */
    private Button retour;
    
    @FXML
    /**
     * The button to access to first stat available for the chosen animal
     */
    private MenuItem stat1batracien;
    
    @FXML
    /**
     * The button to access to first stat available for the chosen animal
     */
    private MenuItem stat1chouette;
    
    @FXML
    /**
     * The button to access to first stat available for the chosen animal
     */
    private MenuItem stat1gci;
    
    @FXML
    /**
     * The button to access to first stat available for the chosen animal
     */
    private MenuItem stat1hippocampe;
    
    @FXML
    /**
     * The button to access to first stat available for the chosen animal
     */
    private MenuItem stat1loutre;
        
    @FXML
    /**
     * Event to do when the button retour is pressed.    
     * Switch to the page Accueil_Utilisateur.fxml
    */
    public void toMainPage(){

        Stage actuel = (Stage)nom_compte.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        if(ReadInfos.estAdmin()){

            change.go_to("../../view/Accueil_Admin.fxml");
        }else{

            change.go_to("../../view/Accueil_Utilisateur.fxml");
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
        if(ReadInfos.estAdmin()){

            change.go_to("../../view/Accueil_Admin.fxml");
        }else{

            change.go_to("../../view/Accueil_Utilisateur.fxml");
        }
    }

    @FXML
    /**
     * When a button linked to "toStatBatracien" is pressed
     * Switch to the page stats_batracien_1.fxml
     * @param event the event that is triggered
     */
    void toStatBatracien1(ActionEvent event) {
        Stage actuel = (Stage)nom_compte.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/statistiques/Stats_Batracien_1.fxml");
    }

    @FXML
    /**
     * When a button linked to "toStatChouette1" is pressed
     * Switch to the page stats_chouette_1.fxml
     * @param event the event that is triggered
     */
    void toStatChouette1(ActionEvent event) {
        Stage actuel = (Stage)nom_compte.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/statistiques/Stats_Chouette_1.fxml");
    }

    @FXML
    /**
     * When a button linked to "toStatGci1" is pressed
     * Switch to the page stats_gci_1.fxml
     * @param event the event that is triggered
     */
    void toStatGci1(ActionEvent event) {
        Stage actuel = (Stage)nom_compte.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/statistiques/Stats_Gci_1.fxml");
    }

    @FXML
    /**
     * When a button linked to "toStatHippocampe1" is pressed
     * Switch to the page stats_hippocampe_1.fxml
     * @param event the event that is triggered
     */
    void toStatHippocampe1(ActionEvent event) {
        Stage actuel = (Stage)nom_compte.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/statistiques/Stats_Hippocampe_1.fxml");
    }

    @FXML
    /**
     * When a button linked to "toStatLoutre1" is pressed
     * Switch to the page stats_loutre_1.fxml
     * There is no stat for loutre so the user is redirected to the same page
     * @param event the event that is triggered
     */
    void toStatLoutre1(ActionEvent event) {

    }

}

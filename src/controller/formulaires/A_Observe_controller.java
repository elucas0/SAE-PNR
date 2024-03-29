package controller.formulaires;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.utilitaires.ChangerPage;
import controller.utilitaires.ReadInfos;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;


/**
 * The controller of the page Accueil_Utilisateur.fxml. It manages it.
 * @version 1.0
 */
public class A_Observe_controller {

    @FXML
    /**
     * TextField to enter the id of the observator
     */
    private TextField lobservateur;

    @FXML
    /**
     * TextField to enter the id of the observation
     */
    private TextField lobservation;

    @FXML
    /**
     * Button to add the observation
     */
    private Button effectuer;

    /**
    * When a button linked to "toLogin" is pressed   
    * Switch to the page page_login.fxml
    */
    @FXML
    /**
     * When a button linked to "toLogin" is pressed
     */
    public void toLogin(){

        Stage actuel = (Stage)lobservateur.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/page_login.fxml");
    }
    
    /**
    * When a button linked to "toData" is pressed   
    * Switch to the page choix_stat_liste.fxml
    */
    public void toData(){

        Stage actuel = (Stage)lobservateur.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/choix_stat_liste.fxml");
    }

    /**
    * When a button linked to "public void formulaire_obs_batracien" is pressed   
    * Switch to the page Formulaire_obs_batracien.fxml
    */
    public void formulaire_obs_batracien(){

        Stage actuel = (Stage)lobservateur.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/formulaires/Formulaire_obs_batracien.fxml");

    }

    /**
    * When a button linked to "formulaire_obs_loutre" is pressed   
    * Switch to the page Formulaire_obs_loutre.fxml
    */
    public void formulaire_obs_loutre(){

        Stage actuel = (Stage)lobservateur.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/formulaires/Formulaire_obs_loutre.fxml");

    }

    /**
    * When a button linked to "formulaire_obs_gci" is pressed   
    * Switch to the page Formulaire_obs_gci.fxml
    */
    public void formulaire_obs_gci(){

        Stage actuel = (Stage)lobservateur.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/formulaires/Formulaire_obs_gci.fxml");

    }

    /**
    * When a button linked to "formulaire_obs_hippocampe" is pressed   
    * Switch to the page Formulaire_obs_hippocampe.fxml
    */
    public void formulaire_obs_hippocampe(){

        Stage actuel = (Stage)lobservateur.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/formulaires/Formulaire_obs_hippocampe.fxml");

    }

     /**
    * When a button linked to "formulaire_obs_chouette" is pressed   
    * Switch to the page Formulaire_obs_chouette.fxml
    */
    public void formulaire_obs_chouette(){

        Stage actuel = (Stage)lobservateur.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/formulaires/Formulaire_obs_chouette.fxml");
    }


    /**
    * Event to do when the button retour is pressed.    
    * Switch to the page Formulaire_nid_gci.fxml
    */
    public void retour(){

        Stage actuel = (Stage)lobservateur.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        if(ReadInfos.estAdmin()){

            change.go_to("../../view/Accueil_Admin.fxml");
        }else{

            change.go_to("../../view/Accueil_Utilisateur.fxml");
        }
    }


    @FXML
    /**
     * Method to create a insert querry to the database
     * @throws SQLException
     */
    private void insert() throws SQLException{
        Window owner = effectuer.getScene().getWindow();
        //test : textfield vide
        if (lobservation.getText() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "S'il vous plaît, veuillez entrer un id d'observateur valide");

        }
        //test : textfield vide
        else if (lobservation.getText() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "S'il vous plaît, veuillez entrer un id d'observation valide");

        }
        else{

        
            //création de l'insert
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");

                PreparedStatement testAObserve = c.prepareStatement("SELECT * FROM aobserve WHERE lobservateur = ? AND lobservation = ?");
                testAObserve.setString(1, lobservateur.getText());
                testAObserve.setString(2, lobservation.getText());
                ResultSet resultatAObserve = testAObserve.executeQuery();

                if(resultatAObserve.next()){
                    showAlert(Alert.AlertType.ERROR, owner, "Observation", "Observateur déjà rentré pour cette observation!");
                }
                else{
                    PreparedStatement querry1 = c.prepareStatement("INSERT INTO aobserve VALUES('"+ lobservateur.getText() +"', '" + lobservation.getText() + "');");
                    querry1.executeUpdate();
                    showAlert(Alert.AlertType.CONFIRMATION, owner, "Observation", "rentré!");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method who create the message and show it in the screen
     * @param alertType Type of the Alert (CONFIRMATION OR ERROR)
     * @param owner Window who create the alert
     * @param title Title of the message screen
     * @param message Message who appear in screen
     */
    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    
}


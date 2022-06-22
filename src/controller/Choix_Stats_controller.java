package controller;
import java.io.IOException;
import java.sql.SQLException;

import org.kordamp.ikonli.javafx.FontIcon;

import controller.utilitaires.ChangerPage;
import controller.utilitaires.ExportData;
import controller.utilitaires.ReadInfos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class Choix_Stats_controller {

    @FXML
    /**
     * The account button in the fxml file
     */
    private Button user;

    @FXML
    /**
     * The MenuItem button in the fxml file
     */
    private MenuItem Hippocampe;

    @FXML
    /**
     * The MenuItem button in the fxml file
     */
    private MenuItem batracien;

    @FXML
    /**
     * The MenuItem button in the fxml file
     */
    private MenuItem chouette;

    @FXML
    /**
     * The MenuItem button in the fxml file
     */
    private MenuItem gci;

    @FXML
    /**
     * The MenuItem button in the fxml file
     */
    private MenuItem lieu;

    @FXML
    /**
     * The MenuItem button in the fxml file
     */
    private Button liste;

    @FXML
    /**
     * The MenuItem button in the fxml file
     */
    private MenuItem loutre;

    @FXML
    /**
     * The MenuItem button in the fxml file
     */
    private MenuItem observateur;

    @FXML
    /**
     * The MenuItem button in the fxml file
     */
    private FontIcon retour;

    @FXML
    /**
     * The MenuItem button in the fxml file
     */
    private Button stat;


    @FXML
    /**
     * The MenuItem button in the fxml file
     */
    private MenuItem vegetation;

    @FXML
    /**
     * The MenuItem button in the fxml file
     */
    private MenuItem zonehumide;

    @FXML
    /**
     * Exports the data of the "a_observe" table to a csv file
     * @param event the event
     * @throws SQLException if there is a problem with the SQL
     * @throws ClassNotFoundException if the class is not found
     * @throws IOException if there is a problem with the IO
     */
    void exportation_a_observe(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        ExportData.writeCSV("a_observe");
    }

    @FXML
    /**
     * Exports the data of the "lieu" table to a csv file
     * @param event the event
     * @throws SQLException if there is a problem with the SQL
     * @throws ClassNotFoundException if the class is not found
     * @throws IOException if there is a problem with the IO
     */
    void exportation_lieu(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        ExportData.writeCSV("lieu");
    }

    @FXML
    /**
     * Exports the data of the "obs_batracien" table to a csv file
     * @param event the event
     * @throws SQLException if there is a problem with the SQL
     * @throws ClassNotFoundException if the class is not found
     * @throws IOException if there is a problem with the IO
     */
    void exportation_obs_batracien(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        ExportData.writeCSV("obs_batracien");
    }

    @FXML
    /**
     * Exports the data of the "obs_chouette" table to a csv file
     * @param event the event
     * @throws SQLException if there is a problem with the SQL
     * @throws ClassNotFoundException if the class is not found
     * @throws IOException if there is a problem with the IO
     */
    void exportation_obs_chouette(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        ExportData.writeCSV("obs_chouette");
    }

    @FXML
    /**
     * Exports the data of the "obs_gci" table to a csv file
     * @param event the event
     * @throws SQLException if there is a problem with the SQL
     * @throws ClassNotFoundException if the class is not found
     * @throws IOException if there is a problem with the IO
     */
    void exportation_obs_gci(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        ExportData.writeCSV("obs_gci");
    }

    @FXML
    /**
     * Exports the data of the "obs_hippocampe" table to a csv file
     * @param event the event
     * @throws SQLException if there is a problem with the SQL
     * @throws ClassNotFoundException if the class is not found
     * @throws IOException if there is a problem with the IO
     */
    void exportation_obs_hippocampe(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        ExportData.writeCSV("obs_hippocampe");
    }

    @FXML
    /**
     * Exports the data of the "obs_loutre" table to a csv file
     * @param event the event
     * @throws SQLException if there is a problem with the SQL
     * @throws ClassNotFoundException if the class is not found
     * @throws IOException if there is a problem with the IO
     */
    void exportation_obs_loutre(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        ExportData.writeCSV("obs_loutre");
    }

    @FXML
    /**
     * Exports the data of the "vegetation" table to a csv file
     * @param event the event
     * @throws SQLException if there is a problem with the SQL
     * @throws ClassNotFoundException if the class is not found
     * @throws IOException if there is a problem with the IO
     */
    void exportation_vegetation(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        ExportData.writeCSV("vegetation");
    }

    @FXML
    /**
     * Exports the data of the "zone_humide" table to a csv file
     * @param event the event
     */
    void exportation_zone_humide(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        ExportData.writeCSV("zone_humide");
    }

    
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

            change.go_to("../../view/Accueil_Admin.fxml");
        }else{

            change.go_to("../../view/Accueil_Utilisateur.fxml");
        }
    }

    /**
     * When a button linked to "toObs" is pressed
     * Switch to the page Affichage.fxml to display the table selection menu
     */
    public void toObs(){

        Stage actuel = (Stage)user.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/affichage/Affichage.fxml");
    }

    /**
     * When a button linked to "toGraphics" is pressed
     * Switch to the page Choix_espece_stats.fxml to display the choice of the animal
     */
    public void toGraphics(){

        Stage actuel = (Stage)user.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/Choix_espece_stats.fxml");
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

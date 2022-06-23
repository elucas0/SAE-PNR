package controller.formulaires;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Time;

import controller.utilitaires.ChangerPage;
import controller.utilitaires.ReadInfos;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;



/**
 * The controller of the page Formulaire_obs_batracien.fxml. It manages it.
 * @version 1.2
 */
public class Obs_Batracien_espece_controller{
    

    @FXML
    /**
     * Button from the fxml file to send the observation to the database
     */
    private Button effectuer;

    @FXML
    /**
     * The combobox that contains the information about the sky's weather in the fxml file.
     */
    private ComboBox<String> espece;


    /**
     * An ObservableList<String> that will contain the list of elements to add to the
     * different combobx.
     */
    private ObservableList<String> liste;

    @FXML
    /**
     * Button access the account page
     */
    private Button user;

    @FXML
    /**
     * text field for the number of fly
     */
    private TextField nbPonte;

    @FXML
    /**
     * text field for the number of reproduction
     */
    private TextField nbAmplexus;

    @FXML
    /**
     * text field for the number of adults
     */
    private TextField nbAdultes;

    @FXML
    /**
     * text field for the number of juveniles
     */
    private TextField nbTetards;

    /**
     * X coordinate of the observation
     */
    private double lambertX;

    /**
     * Y coordinate of the observation
     */
    private double lambertY;

    /**
     * The time of the observation
     */
    private Time heureObs;

    /**
     * The date of the observation
     */
    private Date date;

    /**
     * List of the different weather conditions
     */
    private String[] temps;

    /**
     * Id of the wetland
     */
    private int zoneHumide;

    /**
     * Id of the vegetation
     */
    private int vegetation;

    /**
     * Temperature
     */
    private int temperature;

    /**
     * id of the observation
     */
    private int numObs;


    @FXML
    /**
     * Initialize elements when the fxml file is dilpayed
     */
    private void initialize(){
        liste = FXCollections.observableArrayList("calamite", "pelodyte");
        espece.setItems(liste);
        numObs = -1;
        this.readBatracien();
        user.setText(ReadInfos.getStatus());

        

    }


    /**
    * Event to do when the button retour is pressed.
    * Switch to the page Accueil_Utilisateur.fxml
    */
    public void retour(){

        Stage actuel = (Stage)espece.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../../view/formulaires/Formulaire_obs_batracien.fxml");
        
        try {

            FileWriter file = new FileWriter("infosCompte.txt");
            BufferedWriter b = new BufferedWriter(file);
            PrintWriter out = new PrintWriter(b);
            out.println("");
            out.close();
            b.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    /**
     * Method to create a insert querry to the database
     * @throws SQLException if the querry is not well written
     */
    private void insert() throws SQLException{
        Window owner = effectuer.getScene().getWindow();
        //test : textfield vide
        if (espece.getValue() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        //test : textfield vide
        else if (this.nbAdultes.getText() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        
        else if (this.nbAmplexus.getText() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else if (this.nbTetards.getText() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else if (this.nbPonte.getText() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        else{
            //création de l'insert
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
                Statement obsBatracienEspeceController = c.createStatement();
                if(this.numObs == -1){
                    PreparedStatement testBatracien = c.prepareStatement("SELECT * FROM lieu WHERE coord_Lambert_X = ? AND coord_Lambert_Y = ?");
                    testBatracien.setDouble(1, lambertX);
                    testBatracien.setDouble(2, lambertY);
                    ResultSet resultatBatracien = testBatracien.executeQuery();

                    if(resultatBatracien.next()){}
                    else{
                        String querry1 = "INSERT INTO lieu VALUES(" + lambertX + "," + lambertY + ");";
                        obsBatracienEspeceController.executeUpdate(querry1);
                    }

                    PreparedStatement querry2 = c.prepareStatement("INSERT INTO observation(dateObs, heureObs, lieu_Lambert_X, lieu_Lambert_Y) VALUES('" + date + "','" + heureObs +"', " + lambertX + ", " + lambertY + ");");
        
        
                    PreparedStatement idBatracien = c.prepareStatement("SELECT MAX(idObs) FROM Observation;");
                    ResultSet requete2 = idBatracien.executeQuery();
                    requete2.next();
                    numObs = requete2.getInt("Max(idObs)");
        
        
                    String querry3 = "INSERT INTO obs_batracien VALUES(" + numObs + ", '" + espece.getValue() + "', '" + nbAdultes.getText() + "', '" + nbAmplexus.getText() +  "', '" + nbPonte.getText() + "', '" + nbTetards.getText() + "', '" +  temperature + "', '" + temps[0] + "', '" + temps[1] + "', '" + temps[2] + "', '" + temps[3] + "', " + zoneHumide + ", " + vegetation+");";
                    String querry4 = "INSERT INTO aobserve VALUES(" + ReadInfos.getId() + ", " + numObs + ");";
                    querry2.executeUpdate();
                    obsBatracienEspeceController.executeUpdate(querry3);
                    obsBatracienEspeceController.executeUpdate(querry4);
                    System.out.println("test");

                }else if (numObs >= 0){
                    System.out.println("passe");

                    PreparedStatement testBatracien2 = c.prepareStatement("SELECT obsB FROM obs_batracien WHERE obsB = ? AND espece = ?");
                    testBatracien2.setDouble(1, numObs);
                    testBatracien2.setString(2, espece.getValue());
                    ResultSet resultatBatracien2 = testBatracien2.executeQuery();

                    if(resultatBatracien2.next()){
                        showAlert(Alert.AlertType.ERROR, owner, "Observation", "Espece déjà rentré pour cette observation!");
                    }
                    else{
                        String querry3 = "INSERT INTO obs_batracien VALUES(" + numObs + ", '" + espece.getValue() + "', '" + nbAdultes.getText() + "', '" + nbAmplexus.getText() +  "', '" + nbPonte.getText() + "', '" + nbTetards.getText() + "', '" +  temperature + "', '" + temps[0] + "', '" + temps[1] + "', '" + temps[2] + "', '" + temps[3] + "', " + zoneHumide + ", " + vegetation+");";
                        obsBatracienEspeceController.executeUpdate(querry3);
                        showAlert(Alert.AlertType.CONFIRMATION, owner, "Observation", "rentré!");
                    }
                }


                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Method who create the message and show it in the screen
     * @param alertType Type of the Alert (CONFIRMATION OR ERROR)
     * @param owner Window where the message is shown
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

    /**
     * Reads the batracien text file containing the previous informations
     */
    private void readBatracien(){

        try {

            FileReader file = new FileReader("obsBatracien.txt");
            BufferedReader in = new BufferedReader(file);
            this.date = Date.valueOf(in.readLine());
            this.heureObs = Time.valueOf(in.readLine());
            this.lambertX = Double.parseDouble(in.readLine());
            this.lambertY = Double.parseDouble(in.readLine());
            this.temperature = Integer.parseInt(in.readLine());
            this.temps = new String[]{in.readLine(), in.readLine(), in.readLine(), in.readLine()};
            this.zoneHumide = Integer.parseInt(in.readLine());
            this.vegetation = Integer.parseInt(in.readLine());

            in.close();


        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



    
}

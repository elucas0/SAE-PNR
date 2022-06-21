package controller;

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
     * text field for the number of fly
     */
    private TextField nbPonte;

    @FXML
    private TextField nbAmplexus;

    @FXML
    private TextField nbAdultes;

    @FXML
    private TextField nbTetards;

    private double lambertX;
    private double lambertY;
    private Time heureObs;
    private Date date;
    private String[] temps;
    private int zoneHumide;
    private int vegetation;
    private int temperature;

    


    @FXML
    /**
     * Initialize elements when the fxml file is dilpayed
     */
    private void initialize(){
        liste = FXCollections.observableArrayList("calamite", "pelodyte");
        espece.setItems(liste);
        this.readBatracien();

    }


    /**
    * Event to do when the button retour is pressed.
    * Switch to the page Accueil_Utilisateur.fxml
    */
    public void retour(){

        Stage actuel = (Stage)espece.getScene().getWindow();
        ChangerPage change = new ChangerPage(actuel);
        change.go_to("../view/formulaires/Formulaire_obs_batracien.fxml");
        
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
     * @throws SQLException
     */
    private void insert() throws SQLException{
        Window owner = effectuer.getScene().getWindow();
        //test : textfield vide
        if (espece.getValue() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        //test : textfield vide
        if (this.nbAdultes.getText() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }
        
        if (this.nbAmplexus.getText() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        if (this.nbTetards.getText() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }

        if (this.nbPonte.getText() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "OBS Error!",
                "Please enter good coordonnée");

        }


        //création de l'insert
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            String querry1 = "INSERT INTO lieu VALUES(" + lambertX + "," + lambertY + ");";


            PreparedStatement querry2 = c.prepareStatement("INSERT INTO observation(dateObs, heureObs, lieu_Lambert_X, lieu_Lambert_Y) VALUES('" + date + "','" + heureObs +"', " + lambertX + ", " + lambertY + ");");


            PreparedStatement idBatracien = c.prepareStatement("SELECT MAX(idObs) FROM Observation;");
            ResultSet requete2 = idBatracien.executeQuery();
            requete2.next();
            int idB = requete2.getInt("Max(idObs)");


            String querry3 = "INSERT INTO obs_batracien VALUES(" + idB + ", '" + espece.getValue() + "', '" + nbAdultes.getText() + "', '" + nbAmplexus.getText() +  "', '" + nbPonte.getText() + "', '" + nbTetards.getText() + "', " +  temperature + "', '" + temps[0] + "', '" + temps[1] + "', '" + temps[2] + "', '" + temps[3] + "', " + zoneHumide + ", " + vegetation+");";
            String querry4 = "INSERT INTO aobserve VALUES(" + ReadInfos.getId() + ", " + idB + ");";
            s.executeUpdate(querry1);
            querry2.executeUpdate();
            s.executeUpdate(querry3);
            s.executeUpdate(querry4);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        showAlert(Alert.AlertType.CONFIRMATION, owner, "Observation", "rentré!");
    }


    /**
     * Method who create the message and show it in the screen
     * @param alertType Type of the Alert (CONFIRMATION OR ERROR)
     * @param owner
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


    private void readBatracien(){

        try {

            FileReader file = new FileReader("infosCompte.txt");
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

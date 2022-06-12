package modele;
import java.util.*;
import java.sql.*;

/**
 * Class that represents a request to get the top of a species
 */
public class RequeteLieu {

    /**
     * Main method 
     * @param args the arguments
     */
    public static void main(String[] args) {
        try {
            //Les ArrayList = au colonne de la table
            ArrayList<String> coordLambertX = new ArrayList<String>();
            ArrayList<String> coordLambertY = new ArrayList<String>();
            

            //Création de la requête SQL
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            String query = "SELECT * FROM Lieu";
            ResultSet r = s.executeQuery(query);

            //Remplissage des ArrayList
            while (r.next()) {
                coordLambertX.add(r.getString("coord_Lambert_X"));
                coordLambertY.add(r.getString("coord_Lambert_Y"));
                
            }
            //Suppression des virgules
            coordLambertX.toString().replaceAll(",", " ");
            coordLambertY.toString().replaceAll(",", " ");

            //Affichage de la ligne 1
            System.out.println(coordLambertX.get(0));
            System.out.println(coordLambertY.get(0));

            r.close();
            s.close();
            c.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}

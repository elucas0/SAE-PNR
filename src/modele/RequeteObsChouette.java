package modele;

import java.util.*;
import java.sql.*;

/**
 * Class that represents a request to get the top of a species
 */
public class RequeteObsChouette {

    /**
     * Main method 
     * @param args the arguments
     */
    public static void main(String[] args) {
        try {
            //Les ArrayList = au colonne de la table
            ArrayList<String> protocole = new ArrayList<String>();
            ArrayList<String> typeObs = new ArrayList<String>();
            ArrayList<String> numIndividu = new ArrayList<String>();
            ArrayList<String> numObs = new ArrayList<String>();

            //Création de la requête SQL
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            String query = "SELECT * FROM obs_chouette";
            ResultSet r = s.executeQuery(query);

            //Remplissage des ArrayList
            while (r.next()) {
                protocole.add(r.getString("protocole"));
                typeObs.add(r.getString("typeObs"));
                numIndividu.add(r.getString("leNumIndividu"));
                numObs.add(r.getString("numObs"));
                
            }
            //Suppression des virgules
            protocole.toString().replaceAll(",", " ");
            typeObs.toString().replaceAll(",", " ");
            numIndividu.toString().replaceAll(",", " ");
            numObs.toString().replaceAll(",", " ");

            //Affichage de la ligne 2
            System.out.println(protocole.get(1));
            System.out.println(typeObs.get(1));
            System.out.println(numIndividu.get(1));
            System.out.println(numObs.get(1));

            r.close();
            s.close();
            c.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}

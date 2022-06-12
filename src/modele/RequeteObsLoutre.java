package modele;

import java.util.*;
import java.sql.*;

/**
 * Class that represents a request to get the top of a species
 */
public class RequeteObsLoutre {

    /**
     * Main method
     * @param args the arguments
     */
    public static void main(String[] args) {
        try {
            //Les ArrayList = au colonne de la table
            ArrayList<String> obsL = new ArrayList<String>();
            ArrayList<String> commune = new ArrayList<String>();
            ArrayList<String> lieuDit = new ArrayList<String>();
            ArrayList<String> indice = new ArrayList<String>();

            //Création de la requête SQL
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            String query = "SELECT * FROM obs_loutre";
            ResultSet r = s.executeQuery(query);

            //Remplissage des ArrayList
            while (r.next()) {
                obsL.add(r.getString("obsL"));
                commune.add(r.getString("commune"));
                lieuDit.add(r.getString("lieuDit"));
                indice.add(r.getString("indice"));
                
            }
            //Suppression des virgules
            obsL.toString().replaceAll(",", " ");
            commune.toString().replaceAll(",", " ");
            lieuDit.toString().replaceAll(",", " ");
            indice.toString().replaceAll(",", " ");

            //Affichage de la ligne 2
            System.out.println(obsL.get(1));
            System.out.println(commune.get(1));
            System.out.println(lieuDit.get(1));
            System.out.println(indice.get(1));

            r.close();
            s.close();
            c.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
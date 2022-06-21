package modele;

import java.util.*;
import java.sql.*;

/**
 * Create one top for an observation
 */
public class RequeteObservation {

    ArrayList<String> idObs;
    ArrayList<String> dateObs;
    ArrayList<String> heureObs;
    ArrayList<String> lieu_Lambert_X;
    ArrayList<String> lieu_Lambert_Y;

    /**
     * Main method
     * @param args the arguments
     */
    public RequeteObservation() {
        try {
            //Les ArrayList = au colonne de la table
            ArrayList<String> idObs = new ArrayList<String>();
            ArrayList<String> dateObs = new ArrayList<String>();
            ArrayList<String> heureObs = new ArrayList<String>();
            ArrayList<String> lieu_Lambert_X = new ArrayList<String>();
            ArrayList<String> lieu_Lambert_Y = new ArrayList<String>();

            //Création de la requête SQL
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            String query = "SELECT * FROM observation";
            ResultSet r = s.executeQuery(query);

            //Remplissage des ArrayList
            while (r.next()) {
                idObs.add(r.getString("idObs"));
                dateObs.add(r.getString("dateObs"));
                heureObs.add(r.getString("heureObs"));
                lieu_Lambert_X.add(r.getString("lieu_Lambert_X"));
                lieu_Lambert_Y.add(r.getString("lieu_Lambert_Y"));

                
            }


            //Affichage de la ligne 2
            System.out.println(idObs.get(1));
            System.out.println(dateObs.get(1));
            System.out.println(heureObs.get(1));
            System.out.println(lieu_Lambert_X.get(1));
            System.out.println(lieu_Lambert_Y.get(1));

            r.close();
            s.close();
            c.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}

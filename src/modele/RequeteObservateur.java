package modele;
import java.util.*;
import java.sql.*;

/**
 * Create one top for an observation
 */
public class RequeteObservateur {
    
    /**
     * Main method
     * @param args the arguments
     */
    public static void main(String[] args) {
        try {
            //Les ArrayList = au colonne de la table
            ArrayList<String> idObservateur = new ArrayList<String>();
            ArrayList<String> nom = new ArrayList<String>();
            ArrayList<String> prenom = new ArrayList<String>();

            //Création de la requête SQL
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            String query = "SELECT * FROM observateur";
            ResultSet r = s.executeQuery(query);

            //Remplissage des ArrayList
            while (r.next()) {
                idObservateur.add(r.getString("idObservateur"));
                nom.add(r.getString("nom"));
                prenom.add(r.getString("prenom"));
                
            }
            //Suppression des virgules
            idObservateur.toString().replaceAll(",", " ");
            nom.toString().replaceAll(",", " ");
            prenom.toString().replaceAll(",", " ");

            //Affichage de la ligne 2
            System.out.println(idObservateur.get(1));
            System.out.println(nom.get(1));
            System.out.println(prenom.get(1));

            r.close();
            s.close();
            c.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
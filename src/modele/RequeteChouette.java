package modele;
import java.util.*;
import java.sql.*;

/**
 * Class that represents a request to get the top of a species
 */
public class RequeteChouette {

    /**
     * Main method 
     * @param args the arguments
     */
    public static void main(String[] args) {
        try {
            //Les ArrayList = au colonne de la table
            ArrayList<String> numIndividu = new ArrayList<String>();
            ArrayList<String> espece = new ArrayList<String>();
            ArrayList<String> sexe = new ArrayList<String>();

            //Création de la requête SQL
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            String query = "SELECT * FROM Chouette";
            ResultSet r = s.executeQuery(query);

            //Remplissage des ArrayList
            while (r.next()) {
                numIndividu.add(r.getString("numIndividu"));
                espece.add(r.getString("espece"));
                sexe.add(r.getString("sexe"));
                
            }
            //Suppression des virgules
            numIndividu.toString().replaceAll(",", " ");
            espece.toString().replaceAll(",", " ");
            sexe.toString().replaceAll(",", " ");

            //Affichage de la ligne 2
            System.out.println(numIndividu.get(1));
            System.out.println(espece.get(1));
            System.out.println(sexe.get(1));

            r.close();
            s.close();
            c.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}

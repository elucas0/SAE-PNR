import java.util.*;
import java.sql.*;

public class RequeteVegetation {
    public static void main(String[] args) {
        try {
            //Les ArrayList = au colonne de la table
            ArrayList<String> idVege = new ArrayList<String>();
            ArrayList<String> natureVege = new ArrayList<String>();
            ArrayList<String> vegetation = new ArrayList<String>();
            ArrayList<String> decrit_LieuVege = new ArrayList<String>();

            //Création de la requête SQL
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            String query = "SELECT * FROM vegetation";
            ResultSet r = s.executeQuery(query);

            //Remplissage des ArrayList
            while (r.next()) {
                idVege.add(r.getString("idVege"));
                natureVege.add(r.getString("natureVege"));
                vegetation.add(r.getString("vegetation"));
                decrit_LieuVege.add(r.getString("decrit_LieuVege"));
                
            }
            //Suppression des virgules
            idVege.toString().replaceAll(",", " ");
            natureVege.toString().replaceAll(",", " ");
            vegetation.toString().replaceAll(",", " ");
            decrit_LieuVege.toString().replaceAll(",", " ");

            //Affichage de la ligne 2
            System.out.println(idVege.get(1));
            System.out.println(natureVege.get(1));
            System.out.println(vegetation.get(1));
            System.out.println(decrit_LieuVege.get(1));

            r.close();
            s.close();
            c.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}

package modele;
import java.util.*;
import java.sql.*;
public class RequeteLieu_vegetation {



    public static void main(String[] args) {
        try {
            //Les ArrayList = au colonne de la table
            ArrayList<String> idVegeLieu = new ArrayList<String>();
            

            //Création de la requête SQL
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            String query = "SELECT * FROM lieu_vegetation";
            ResultSet r = s.executeQuery(query);

            //Remplissage des ArrayList
            while (r.next()) {
                idVegeLieu.add(r.getString("idVegeLieu"));
                
            }
            //Suppression des virgules
            idVegeLieu.toString().replaceAll(",", " ");

            //Affichage de la ligne 1
            System.out.println(idVegeLieu.get(0));

            r.close();
            s.close();
            c.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}

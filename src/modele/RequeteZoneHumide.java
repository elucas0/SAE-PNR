package modele;

import java.util.*;
import java.sql.*;

public class RequeteZoneHumide {
    public static void main(String[] args) {
        try {
            //Les ArrayList = au colonne de la table
            ArrayList<String> zh_id = new ArrayList<String>();
            ArrayList<String> zh_temporaire = new ArrayList<String>();
            ArrayList<String> zh_profondeur = new ArrayList<String>();
            ArrayList<String> zh_surface = new ArrayList<String>();
            ArrayList<String> zh_typeMare = new ArrayList<String>();
            ArrayList<String> zh_pente = new ArrayList<String>();
            ArrayList<String> zh_ouverture = new ArrayList<String>();

            //Création de la requête SQL
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            String query = "SELECT * FROM zonehumide";
            ResultSet r = s.executeQuery(query);

            //Remplissage des ArrayList
            while (r.next()) {
                zh_id.add(r.getString("zh_id"));
                zh_temporaire.add(r.getString("zh_temporaire"));
                zh_profondeur.add(r.getString("zh_profondeur"));
                zh_surface.add(r.getString("zh_surface"));
                zh_typeMare.add(r.getString("zh_typeMare"));
                zh_pente.add(r.getString("zh_pente"));
                zh_ouverture.add(r.getString("zh_ouverture"));
                
            }
            //Suppression des virgules
            zh_id.toString().replaceAll(",", " ");
            zh_temporaire.toString().replaceAll(",", " ");
            zh_profondeur.toString().replaceAll(",", " ");
            zh_surface.toString().replaceAll(",", " ");
            zh_typeMare.toString().replaceAll(",", " ");
            zh_pente.toString().replaceAll(",", " ");
            zh_ouverture.toString().replaceAll(",", " ");

            //Affichage de la ligne 2
            System.out.println(zh_id.get(1));
            System.out.println(zh_temporaire.get(1));
            System.out.println(zh_profondeur.get(1));
            System.out.println(zh_surface.get(1));
            System.out.println(zh_typeMare.get(1));
            System.out.println(zh_pente.get(1));
            System.out.println(zh_ouverture.get(1));

            r.close();
            s.close();
            c.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}

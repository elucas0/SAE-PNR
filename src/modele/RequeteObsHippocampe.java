package modele;

import java.util.*;
import java.sql.*;

/**
 * Class that represents a request to get the top of a species
 */
public class RequeteObsHippocampe {

    /**
     * Main method
     * @param args the arguments
     */
    public static void main(String[] args) {
        try {
            //Les ArrayList = au colonne de la table
            ArrayList<String> obsH = new ArrayList<String>();
            ArrayList<String> espece = new ArrayList<String>();
            ArrayList<String> sexe = new ArrayList<String>();
            ArrayList<String> temperatureEau = new ArrayList<String>();
            ArrayList<String> typePeche = new ArrayList<String>();
            ArrayList<String> taille = new ArrayList<String>();
            ArrayList<String> gestant = new ArrayList<String>();

            //Création de la requête SQL
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            String query = "SELECT * FROM obs_hippocampe";
            ResultSet r = s.executeQuery(query);

            //Remplissage des ArrayList
            while (r.next()) {
                obsH.add(r.getString("obsH"));
                espece.add(r.getString("espece"));
                sexe.add(r.getString("sexe"));
                temperatureEau.add(r.getString("temperatureEau"));
                typePeche.add(r.getString("typePeche"));
                taille.add(r.getString("taille"));
                gestant.add(r.getString("gestant"));
                
            }
            //Suppression des virgules
            obsH.toString().replaceAll(",", " ");
            espece.toString().replaceAll(",", " ");
            sexe.toString().replaceAll(",", " ");
            temperatureEau.toString().replaceAll(",", " ");
            typePeche.toString().replaceAll(",", " ");
            taille.toString().replaceAll(",", " ");
            gestant.toString().replaceAll(",", " ");

            //Affichage de la ligne 2
            System.out.println(obsH.get(1));
            System.out.println(espece.get(1));
            System.out.println(sexe.get(1));
            System.out.println(temperatureEau.get(1));
            System.out.println(typePeche.get(1));
            System.out.println(taille.get(1));
            System.out.println(gestant.get(1));

            r.close();
            s.close();
            c.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}


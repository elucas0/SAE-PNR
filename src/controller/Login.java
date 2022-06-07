package controller;
import java.util.*;
import java.sql.*;
public class Login {
    try {
        //Les ArrayList = au colonne de la table
        ArrayList<String> lobservateur = new ArrayList<String>();
        ArrayList<String> lobservation = new ArrayList<String>();

        //Création de la requête SQL
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
        Statement s = c.createStatement();
        String query = "SELECT * FROM aobserve";
        ResultSet r = s.executeQuery(query);

        //Remplissage des ArrayList
        while (r.next()) {
            lobservateur.add(r.getString("lobservateur"));
            lobservation.add(r.getString("lobservation"));
            
        }
        //Suppression des virgules
        lobservateur.toString().replaceAll(",", " ");
        lobservation.toString().replaceAll(",", " ");

        //Affichage de la ligne 2
        System.out.println(lobservateur.get(1));
        System.out.println(lobservation.get(1));

        r.close();
        s.close();
        c.close();
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}

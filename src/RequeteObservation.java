import java.util.*;
import java.sql.*;
public class RequeteObservation {
    public static void main(String[] args) {
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
                sexe.add(r.getString("heureObs"));
                temperatureEau.add(r.getString("temperatureEau"));
                typePeche.add(r.getString("typePeche"));

                
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

package modele;
import java.util.*;
import java.sql.*;

/**
 * Class that represents a request to get the top of a species
 */
public class RequeteObseBatracien {

    /**
     * Main method 
     * @param args the arguments
     */
    public static void main(String[] args) {
        try {
            //Les ArrayList = au colonne de la table
            ArrayList<String> obsB = new ArrayList<String>();
            ArrayList<String> espece = new ArrayList<String>();
            ArrayList<String> nombreAdultes = new ArrayList<String>();
            ArrayList<String> nombreAmplexus = new ArrayList<String>();
            ArrayList<String> nombrePonte = new ArrayList<String>();
            ArrayList<String> nombreTetard = new ArrayList<String>();
            ArrayList<String> temperature = new ArrayList<String>();
            ArrayList<String> meteo_ciel = new ArrayList<String>();
            ArrayList<String> meteo_temp = new ArrayList<String>();
            ArrayList<String> meteo_vent = new ArrayList<String>();
            ArrayList<String> meteo_pluie = new ArrayList<String>();
            ArrayList<String> concerne_ZH = new ArrayList<String>();
            ArrayList<String> concernes_vege = new ArrayList<String>();

            //Création de la requête SQL
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            String query = "SELECT * FROM obs_batracien";
            ResultSet r = s.executeQuery(query);

            //Remplissage des ArrayList
            while (r.next()) {
                obsB.add(r.getString("obsB"));
                espece.add(r.getString("espece"));
                nombreAdultes.add(r.getString("nombreAdultes"));
                nombreAmplexus.add(r.getString("nombreAmplexus"));
                nombrePonte.add(r.getString("nombrePonte"));
                nombreTetard.add(r.getString("nombreTetard"));
                temperature.add(r.getString("temperature"));
                meteo_ciel.add(r.getString("meteo_ciel"));
                meteo_temp.add(r.getString("meteo_temp"));
                meteo_vent.add(r.getString("meteo_vent"));
                meteo_pluie.add(r.getString("meteo_pluie"));
                concerne_ZH.add(r.getString("concerne_ZH"));
                concernes_vege.add(r.getString("concernes_vege"));
            }
            //Suppression des virgules
            obsB.toString().replaceAll(",", " ");
            espece.toString().replaceAll(",", " ");
            nombreAdultes.toString().replaceAll(",", " ");
            nombreAmplexus.toString().replaceAll(",", " ");
            nombrePonte.toString().replaceAll(",", " ");
            nombreTetard.toString().replaceAll(",", " ");
            temperature.toString().replaceAll(",", " ");
            meteo_ciel.toString().replaceAll(",", " ");
            meteo_temp.toString().replaceAll(",", " ");
            meteo_vent.toString().replaceAll(",", " ");
            meteo_pluie.toString().replaceAll(",", " ");
            concerne_ZH.toString().replaceAll(",", " ");
            concernes_vege.toString().replaceAll(",", " ");

            //Affichage de la ligne 2
            System.out.println(obsB.get(1));
            System.out.println(espece.get(1));
            System.out.println(nombreAdultes.get(1));
            System.out.println(nombreAmplexus.get(1));
            System.out.println(nombrePonte.get(1));
            System.out.println(nombreTetard.get(1));
            System.out.println(temperature.get(1));
            System.out.println(meteo_ciel.get(1));
            System.out.println(meteo_temp.get(1));
            System.out.println(meteo_vent.get(1));
            System.out.println(meteo_pluie.get(1));
            System.out.println(concerne_ZH.get(1));
            System.out.println(concernes_vege.get(1));

            r.close();
            s.close();
            c.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}


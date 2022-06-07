import java.util.*;
import java.sql.*;
public class RequeteObsGCI {
    public static void main(String[] args) {
        try {
            //Les ArrayList = au colonne de la table
            ArrayList<String> obsG = new ArrayList<String>();
            ArrayList<String> nature = new ArrayList<String>();
            ArrayList<String> nombre = new ArrayList<String>();
            ArrayList<String> presentMaisNonObs = new ArrayList<String>();
            ArrayList<String> leNid = new ArrayList<String>();

            //Création de la requête SQL
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            String query = "SELECT * FROM obs_gci";
            ResultSet r = s.executeQuery(query);

            //Remplissage des ArrayList
            while (r.next()) {
                obsG.add(r.getString("obsG"));
                nature.add(r.getString("nature"));
                nombre.add(r.getString("nombre"));
                presentMaisNonObs.add(r.getString("presentMaisNonObs"));
                leNid.add(r.getString("leNid"));
                
            }
            //Suppression des virgules
            obsG.toString().replaceAll(",", " ");
            nature.toString().replaceAll(",", " ");
            nombre.toString().replaceAll(",", " ");
            presentMaisNonObs.toString().replaceAll(",", " ");
            leNid.toString().replaceAll(",", " ");

            //Affichage de la ligne 2
            System.out.println(obsG.get(1));
            System.out.println(nature.get(1));
            System.out.println(nombre.get(1));
            System.out.println(presentMaisNonObs.get(1));
            System.out.println(leNid.get(1));

            r.close();
            s.close();
            c.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}


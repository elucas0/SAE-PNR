import java.util.*;
import java.sql.*;

public class testConnectDb {
    private static ArrayList<ResultSet> resultat;
    public static void main(String[] args) {
        try {
            resultat = new ArrayList<ResultSet>();
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            String query = "SELECT * FROM nid_gci";
            ResultSet r = s.executeQuery(query);
            while (r.next()) {
                resultat.add(r);
                System.out.println("taille arrayList : " + resultat.size());
                //System.out.println(r.getInt("id_nid") + " " + r.getString("nom_plage"));
            }
            r.close();
            s.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

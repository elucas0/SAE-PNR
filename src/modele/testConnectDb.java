package modele;
import java.sql.*;

public class testConnectDb {
    public static void main(String[] args) {
        try {            
            //Création de la requête SQL
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            String query = "SELECT * FROM nid_gci";
            ResultSet r = s.executeQuery(query);
            
            while (r.next()) {
                System.out.println(r.getInt("idNid") + " " + r.getString("nomPlage"));
            }
            r.close();
            s.close();
            c.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}

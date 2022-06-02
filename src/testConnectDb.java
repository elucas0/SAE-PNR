<<<<<<< HEAD:src/testConnectDb.java
=======

>>>>>>> 6ba22b2845c69bc7efc34819681ac7679a9486a3:testConnectDb.java
import java.sql.*;

public class testConnectDb {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery("SELECT * FROM nid_gci");
            while (r.next()) {
                System.out.println(r.getInt("id_nid") + " " + r.getString("nom_plage"));
            }
            r.close();
            s.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

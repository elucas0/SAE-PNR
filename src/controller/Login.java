package controller;
import java.util.*;
import java.sql.*;

public class Login {
    public static void main(String[] args) {
        try {            
            //Création de la requête SQL
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/connection", "test", "test");
            Statement s = c.createStatement();
            String query = "SELECT * FROM registration";
            ResultSet r = s.executeQuery(query);
            
            while (r.next()) {
                
                //System.out.println(r.getString("full_name") + " " + r.getString("password"));
            }
            r.close();
            s.close();
            c.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}


package controller;
import java.util.ArrayList;
import java.sql.*;
import modele.donnee.*;

public class QueryGet {

    public ArrayList<Observation> getObservations(){

        ArrayList<Observation> ret = new ArrayList<Observation>();

        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        

        return ret;
    }    
}

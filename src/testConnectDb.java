package src;
import java.util.*;
import java.sql.*;

public class testConnectDb {

    private ArrayList<String> nidGCI;
    private ArrayList<String> nomPlage;
    private ArrayList<String> raisonArretObservation;
    private ArrayList<String> nbEnvol;
    private ArrayList<String> protection;
    private ArrayList<String> bagueMale;
    private ArrayList<String> bagueFemelle;
    public static void main(String[] args) {
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void requeteNidGCI(){
        this.nidGCI = new ArrayList<String>();
        this.nomPlage = new ArrayList<String>();
        this.raisonArretObservation = new ArrayList<String>();
        this.nbEnvol = new ArrayList<String>();
        this.protection = new ArrayList<String>();
        this.bagueMale = new ArrayList<String>();
        this.bagueFemelle = new ArrayList<String>();
    }

    public void test(){
        requeteNidGCI();
        int i = 0;
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
        Statement s = c.createStatement();
        String query = "SELECT * FROM nid_gci.COLUMNS";
        ResultSet r = s.executeQuery(query);

        while (r.next()) {
            this.niGCI.add(r.getString("idNid"));
            p[1][i] = r.getString("nomPlage");
            p[2][i] = r.getString("raisonArretObservation");
            p[3][i] = r.getString("nbEnvol");
            p[4][i] = r.getString("protection");
            p[5][i] = r.getString("bagueMale");
            p[6][i] = r.getString("bagueFemelle");
            //resultat.add(r.getString("idNid") + "  " + r.getString("nomPlage") + "  " + r.getString("raisonArretObservation") + "  " + r.getString("nbEnvol") + "  " + r.getString("protection") + "  " + r.getString("bagueMale") + "  " + r.getString("bagueFemelle") + "\n");
            i++;
            
        }

        //System.out.println(resultat.toString().replaceAll(",", " "));
        //System.out.println(resultat.get(26));
        r.close();
        s.close();
        c.close();
    }

    
}

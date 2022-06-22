import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class Compte {


    public static String generermdp(){

        String ret = "";
        Random random = new Random();

        String setOfCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for(int i = 0; i < 6; i++){
            int randomInt = random.nextInt(setOfCharacters.length());
            ret = ret + setOfCharacters.charAt(randomInt);

        }


        return ret;
    }


    public void faireComptes(){


        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            PreparedStatement s = c.prepareStatement("SELECT idObservateur, nom FROM observateur");
            Statement s2 = c.createStatement();
            ResultSet r = s.executeQuery();
            while(r.next()){

                String mdp = Compte.generermdp();
                s2.executeUpdate("INSERT INTO registration VALUES(" + r.getString("idObservateur") + ", '" + r.getString("nom") + "', '" + mdp + "'," + 0 + ");");
   
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
}

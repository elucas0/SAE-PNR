package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ReadInfos {


    /**
     * Get informations in the file and
     * return if the user is and admin
     * @return trur if the user is an admin, false if not
     */
    public static boolean estAdmin(){

        boolean ret = false;


        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr", "base_donnee", "sC32DnE3ae7Y");
            PreparedStatement querry = c.prepareStatement("SELECT administration FROM registration WHERE fullName = ? AND id = ?");
            
            FileReader f;
            try {
                f = new FileReader("infosCompte.txt");
                BufferedReader in = new BufferedReader(f);

                int id = Integer.parseInt(in.readLine());
                String nom = in.readLine();
                querry.setString(1, nom);
                querry.setInt(2, id);
                ResultSet r = querry.executeQuery();
                if(r.next()){
                    
                    int estAdmin = r.getInt("administration");
                    if(estAdmin == 1){
                        ret = true;
                    }else{
                        ret = false;
                    }
                }

                
            } catch (FileNotFoundException e) {

                System.err.println(e.getMessage());
            } catch (NumberFormatException e) {

                System.err.println(e.getMessage());
            } catch (IOException e) {

                System.err.println(e.getMessage());
            }
        
        } catch (SQLException e) {

            System.err.println(e.getMessage());
        }


        return ret;
    }
    

    /**
     * Get the username and the id of the user
     * @return a String containing the username and the id of the user
     */
    public static String getStatus(){

        String ret = null;

        try {

            FileReader file = new FileReader("infosCompte.txt");
            BufferedReader in = new BufferedReader(file);

            String line = in.readLine();
            ret = in.readLine() + " " + line;

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return ret;
    }

    /**
     * Get the user's id
     * @return the user's id
     */
    public static int getId(){

        int ret = -1;

        try {

            FileReader file = new FileReader("infosCompte.txt");
            BufferedReader in = new BufferedReader(file);
            ret = Integer.parseInt(in.readLine());


        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return ret;
    }


 
}

package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadInfos {


    /**
     * Get informations in the file and
     * return if the user is and admin
     * @return trur if the user is an admin, false if not
     */
    public static boolean readAdmin(){

        boolean ret = false;

        try {
            FileReader file = new FileReader("infosCompte.txt");
            BufferedReader in = new BufferedReader(file);

            in.readLine();
            in.readLine();
            String line = in.readLine();
            if(line.equals("1")){

                ret = true;
            }else{

                ret = false;
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
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
            ret = 
            in.readLine();
            ret = ret + " " +in.readLine();

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
    public static String getId(){

        String ret = null;

        try {

            FileReader file = new FileReader("infosCompte.txt");
            BufferedReader in = new BufferedReader(file);

            ret = in.readLine();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return ret;
    }
 
}

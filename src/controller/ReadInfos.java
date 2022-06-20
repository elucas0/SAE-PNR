package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadInfos {

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
    

    public static String getStatus(){

        String ret = null;

        try {
            FileReader f = new FileReader("infosCompte.txt");
            ret = String.valueOf(f.read());
            ret = ret + String.valueOf(f.read());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return ret;
    }
}

package controller;
import java.util.ArrayList;

import modele.donnee.*;

public class test {

    
    public static void main(String[] args){

        QueryGet test = new QueryGet();
        ArrayList<ObsBatracien> test2 = test.getObsBatracien();
        System.out.println(test2.get(0).getId());



    }
    
}

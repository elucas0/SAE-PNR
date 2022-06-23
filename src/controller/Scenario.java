package controller;

import controller.utilitaires.ReadInfos;


/**
 * Some tests about the package utilitaires
 */
public class Scenario {

    
    /**
     * Main method of the class
     * @param args
     */
    public static void main(String[] args){

        //renvoie true avec un compte administrateur, sinon false
        System.out.println(ReadInfos.estAdmin());

        //Renvoie le nom et l'id du compte utilisé
        System.out.println(ReadInfos.getStatus());

        System.out.println(ReadInfos.getMax("Obs_Batracien"));

    }
    
}

import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;

import modele.donnee.*;
import modele.traitement.*;

public class ScenarioTraitement {
    public static void main(String[] args) {
        
        Lieu lieu = new Lieu(48.862725, 2.287592);
        Lieu lieu2 = new Lieu(45.7578137, 4.8320114);

        Sommet sommet = new Sommet(1, lieu, new Date(1), EspeceObservee.LOUTRE);
        Sommet sommet2 = new Sommet(2, lieu2, new Date(1), EspeceObservee.LOUTRE);
        Sommet sommet3 = new Sommet(3, lieu, new Date(1), EspeceObservee.LOUTRE);
        Sommet sommet4 = new Sommet(4, lieu2, new Date(1), EspeceObservee.LOUTRE);
        Sommet sommet5 = new Sommet(5, lieu, new Date(1), EspeceObservee.LOUTRE);
        Sommet sommet6 = new Sommet(6, lieu2, new Date(1), EspeceObservee.LOUTRE);

        HashMap<Sommet, ArrayList<Sommet>> map = new HashMap<Sommet, ArrayList<Sommet>>();

        //Map 1
        map.put(sommet, new ArrayList<Sommet>());
        map.get(sommet).add(sommet2);
        map.get(sommet).add(sommet4);

        map.put(sommet2, new ArrayList<Sommet>());
        map.get(sommet2).add(sommet);
        map.get(sommet2).add(sommet4);

        map.put(sommet3, new ArrayList<Sommet>());
        map.get(sommet3).add(sommet4);

        map.put(sommet4, new ArrayList<Sommet>());
        map.get(sommet4).add(sommet);
        map.get(sommet4).add(sommet2);
        map.get(sommet4).add(sommet3);
        map.get(sommet4).add(sommet6);

        map.put(sommet5, new ArrayList<Sommet>());
        
        map.put(sommet6, new ArrayList<Sommet>());
        map.get(sommet6).add(sommet4);

        Graphe grapheEx = new Graphe(map);
        //Graphe grapheEx2 = grapheEx.clotureTransitive();

        System.out.println("graphEx : ");
        // Test de la méthode nbSommets
        System.out.println("nbSommets() : " + grapheEx.nbSommets());

        // Test de la méthode nbAretes
        System.out.println("nbAretes() : " + grapheEx.nbAretes());

        // Test de la méthode estDansGraphe() avec le sommet 7
        System.out.println("estDansGraphe(7) : " + grapheEx.estDansGraphe(7));

        // Test de la méthode estDansGraphe() avec le sommet 5
        System.out.println("estDansGraphe(5) : " + grapheEx.estDansGraphe(5));

        // Test de la méthode calculDegre() avec le sommet 3
        System.out.println("calculDegre(3) : " + grapheEx.calculDegre(3));

        // Test de la méthode calculDegre() avec le sommet 4
        System.out.println("calculDegre(4) : " + grapheEx.calculDegre(4));

        // Test de la méthode calculDegre() avec le sommet 5
        System.out.println("calculDegre(5) : " + grapheEx.calculDegre(5));
        System.out.println();

        // Test de la méthode calculDegres()
        System.out.println("calculDegres() : ");
        HashMap<Sommet, Integer> mapDegres = grapheEx.calculDegres();
        for (Sommet s : mapDegres.keySet()) {
            System.out.println(s + " : " + mapDegres.get(s));
        }
        System.out.println();

        // Test de la méthode sontVoisins() avec les sommets 3 et 4
        System.out.println("sontVoisins(3, 4) : " + grapheEx.sontVoisins(3, 4));

        // Test de la méthode sontVoisins() avec les sommets 6 et 2
        System.out.println("sontVoisins(6, 2) : " + grapheEx.sontVoisins(6, 2));
        System.out.println();

        // Test de la méthode existeChemin() avec les sommets 5 et 6 : doit retourner FALSE
        System.out.println("existeChemin(5, 6) : " + grapheEx.existeChemin(5, 6));

        // Test de la méthode existeChemin() avec les sommets 6 et 2 : doit retourner TRUE
        System.out.println("existeChemin(6, 2) : " + grapheEx.existeChemin(6, 2));

        // Test de la méthode existeChemin() avec les sommets 3 et 4
        //System.out.println(grapheEx.existeChemin(3, 4));
        System.out.println();

        // Test de la méthode matriceAdjacence()
        System.out.println("Matrice d'adjacence : ");
        int[][] matrice = grapheEx.matriceAdjacence();
        //Print the matrix
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // Test de la méthode estConnexe()
        System.out.println("estConnexe() : " + grapheEx.estConnexe());

        // Test de la méthode composanteConnexe()
        // System.out.println("Composantes connexes : ");
        // ArrayList<Graphe> composantesConnexes = grapheEx.composanteConnexe();
        
        // Test de la méthode distAretes() avec les sommets 6 et 2
        System.out.println("distAretes(6, 2) : " + grapheEx.distAretes(6, 2));
        System.out.println();

        // Test de la méthode excentricite() avec le sommet 6
        System.out.println("excentricite(6) : " + grapheEx.excentricite(6));
        System.out.println();



        //System.out.println("graphEx2 : ");
        // Test de la méthode estConnexe()
        //System.out.println("estConnexe() : " + grapheEx2.estConnexe());

        // Test de la méthode diametre() sur le grapheEx2
        //System.out.println("diametre() : " + grapheEx2.diametre());

        // Test de la méthode rayon()
        //System.out.println("rayon() : " + grapheEx2.rayon());


    }

    
}

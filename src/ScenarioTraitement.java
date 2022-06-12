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


        //New hashmap
        HashMap<Sommet, ArrayList<Sommet>> map = new HashMap<Sommet, ArrayList<Sommet>>();
        //Fill the HashMap map with this list [(1,(2,4)), (2, (1,4)), (3,(4)),(4,(1,2,3,6)),(5,()),(6,(4))]
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

        //Observation obs = new Observation(1, new Date(1), new Time(1), lieu, )
        //sommet.calculeDist(sommet2);

        Graphe grapheEx = new Graphe(map);

        // Test de la méthode nbSommets
        System.out.println(grapheEx.nbSommets());

        // Test de la méthode nbAretes
        System.out.println(grapheEx.nbAretes());

        // Test de la méthode estDansGraphe() avec le sommet 7
        System.out.println(grapheEx.estDansGraphe(7));

        // Test de la méthode estDansGraphe() avec le sommet 5
        System.out.println(grapheEx.estDansGraphe(5));

        //renvoie true
        System.out.println(grapheEx.existeChemin(sommet.getId(), sommet2.getId()));

        //renvoie false
        System.out.println(grapheEx.existeChemin(sommet.getId(), sommet2.getId()));
<<<<<<< HEAD
de
=======

        // Test de la méthode calculDegre() avec le sommet 5
        System.out.println("calculDegre(5) : " + grapheEx.calculDegre(5));
        System.out.println();

        // Test de la méthode calculDegres()
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
        //Print the matrix
        for (int i = 0; i < grapheEx.nbSommets(); i++) {
            for (int j = 0; j < grapheEx.nbSommets(); j++) {
                System.out.print(grapheEx.matriceAdjacence()[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // Test de la méthode estConnexe()
        System.out.println("estConnexe() : " + grapheEx.estConnexe());

        // Test de la méthode composanteConnexe()
        // System.out.println("Composantes connexes : ");
        // ArrayList<Graphe> composantesConnexes = grapheEx.composanteConnexe();
        // for (Graphe g : composantesConnexes) {
        //     System.out.println(g);
        // }
        
>>>>>>> 24ec4fe485662351b25b681eef0a5cf93662c098
    }

    
}

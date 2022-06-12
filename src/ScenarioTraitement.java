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
    }

    
}

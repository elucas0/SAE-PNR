package traitement;
import java.util.HashMap;
import java.util.ArrayList;

public class Graphe {

    private HashMap<Sommet, ArrayList<Sommet>> sommetsVoisins;

    /**
     * Constructor for objects of class Graphe
     * @param sommets vertices of the graph
     * @param dist distance between two vertices
     */
    public Graphe(ArrayList<Sommet> sommets, double dist) {
        if(sommets.size() == 0) {
            throw new IllegalArgumentException("Le graphe doit contenir au moins un sommet.");
        } else if (dist <= 0) {
            throw new IllegalArgumentException("La distance doit être positive.");
        } else {
            this.sommetsVoisins = new HashMap<Sommet, ArrayList<Sommet>>();
            for(Sommet s : sommets) {
                this.sommetsVoisins.put(s, new ArrayList<Sommet>());
            }
            for(Sommet s : sommets) {
                for(Sommet s2 : sommets) {
                    if((s != s2) && (calculDist(s, s2) <= dist)) {
                        this.sommetsVoisins.get(s).add(s2);
                    }
                }
            }
        }
    }

    /**
     * Constructor for Graphe.
     * @param somVoisins HashMap of Sommet and ArrayList of Sommet
     */
    public Graphe(HashMap<Sommet, ArrayList<Sommet>> somVoisins) {
        if(somVoisins.size() == 0) {
            throw new IllegalArgumentException("Le graphe doit contenir au moins un sommet.");
        } else if (somVoisins.containsValue(null)) {
            throw new IllegalArgumentException("Le graphe ne doit pas contenir de sommet sans voisins.");
        } else {
            this.sommetsVoisins = somVoisins;
        }
    }

    /**
     * Constructor for objects of class Graphe
     * @param g Graphe
     */
    public Graphe(Graphe g){
        if(g.sommetsVoisins.size() == 0) {
            throw new IllegalArgumentException("Le graphe doit contenir au moins un sommet.");
        } else if (g.sommetsVoisins.containsValue(null)) {
            throw new IllegalArgumentException("Le graphe ne doit pas contenir de sommet sans voisins.");
        } else {
            this.sommetsVoisins = g.sommetsVoisins;
        }
    }

    /**
     * Returns the number of vertices in the graph.
     * @return
     */
    public int nbSommets(){
        return this.sommetsVoisins.size();
    }

    /**
     * Returns the number of edges in the graph.
     * @return the number of edges in the graph.
     */
    public int nbAretes(){
        int nbAretes = 0;
        for(Sommet s : this.sommetsVoisins.keySet()) {
            nbAretes += this.sommetsVoisins.get(s).size();
        }
        // On enlève le nombre d'arêtes entre chaque sommet et lui-même
        return nbAretes/2;
    }
    
    /**
     * Returns true if the graph contains the given vertex.
     * @param idSom the id of the vertex to check.
     * @return true if the graph contains the given vertex.
     */
    public boolean estDansGraphe(int idSom){
        boolean ret = false;
        for(Sommet s : this.sommetsVoisins.keySet()) {
            if(s.getIdSom() == idSom) {
                ret = true;
            }
        }
        return ret;
    }

    /**
     * Returns the degree of the given vertex.
     * @param idSom the id of the vertex.
     * @return the degree of the given vertex.
     */
    public int calculDegre(int idSom){
        int degre = 0;
        for(Sommet s : this.sommetsVoisins.keySet()) {
            if(s.getIdSom() == idSom) {
                degre = this.sommetsVoisins.get(s).size();
            }
        }
        return degre;
    }
}

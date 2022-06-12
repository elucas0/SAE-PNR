package modele.traitement;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Class generating a graph from a list of observations
 */
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
                    if((s != s2) && (calculeDist(s.getId(), s2.getId()) <= dist)) {
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
            if(s.getId() == idSom) {
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
        if(!estDansGraphe(idSom)){
            throw new IllegalArgumentException("Le sommet n'est pas dans le graphe");
        } else {
            for(Sommet s : this.sommetsVoisins.keySet()) {
                if(s.getId() == idSom) {
                    degre = this.sommetsVoisins.get(s).size();
                }
            }
        }
        return degre;
    }


    /**
     * Get an HashMap<Sommmet, int> wich keys are the vertices
     * of the graph. The values are the degres of each vertex.
     * @return the HashMap<Sommmet, int>
     */
    public HashMap<Sommet, Integer> calculDegres(){

        HashMap<Sommet, Integer> ret = new HashMap<Sommet,Integer>();

        if(this.sommetsVoisins.size() > 0){
            for(Sommet i : this.sommetsVoisins.keySet()){
                ret.put(i, this.sommetsVoisins.get(i).size());
            }

        }else{
            throw new IllegalArgumentException("The graph is empty");
        }

        return ret;
    }


    /**
     * Get the vertex with the maximum degre in the graph
     * @return the vertex with the maximum degre in the graph
     */
    public Sommet somMaxDegre(){

        Sommet ret = null;
        int max = 0;

        for(Sommet sommet : sommetsVoisins.keySet()){

            if(sommetsVoisins.get(sommet).size() > max){
                max = sommetsVoisins.get(sommet).size();
                ret = sommet;
            }
        }
        return ret;
    }


    /**
     * Check if two vertices are neighbours
     * @param idSom1 the first vertex
     * @param idSom2 the second vertex
     * @return true if the vertex are neighbours, false if not
     */
    public boolean sontVoisins(int idSom1, int idSom2){

        boolean ret = false;
        Sommet sommet1 = this.getSommet(idSom1);
        Sommet sommet2 = this.getSommet(idSom2);

        if((sommet1 != null) && (sommet2 != null)){
            ret = (this.sommetsVoisins.get(sommet1)).contains(sommet2);            
        }else{
            throw new IllegalArgumentException("One of the two vertex is not in the graph.");
        }
        return ret;
    }


    /**
     * Check if there is a way to go from a wanted vertex to another one.
     * @param idSom1 the first vertex
     * @param idSom2 the second vertex
     * @return true if a way exists, false is there isn't one
     */
    public boolean existeChemin(int idSom1, int idSom2){

        boolean ret = false;
        ArrayList<Sommet> parcouru = new ArrayList<Sommet>();
        Sommet sommet1 = this.getSommet(idSom1);
        Sommet sommet2 = this.getSommet(idSom2);

        if((sommet1 != null) && (sommet2 != null)){
            ret = DFSrec(sommet1, sommet2, parcouru, this.sommetsVoisins.get(sommet1));            
        }else{
            System.err.println("existeChemin : the two vertex must be in  the graph");
        }
        return ret;
    }

    
    /**
     * Do a DFS of the graph
     * @param som1 the starting vertex
     * @param som2 the vertex we want to find
     * @param parcouru the vertex already travelled
     * @param stack the vertex to search-in
     * @return true if there is a way, false if not
     */
    public boolean DFSrec(Sommet som1, Sommet som2, ArrayList<Sommet> parcouru, ArrayList<Sommet> stack){

        boolean ret = false;

        if(som1 == som2){
            ret = true;
        }else if(stack.size() == 0){
            ret = false;
        }else{
            Sommet departSuivant = stack.get(0);
            parcouru.add(departSuivant);
            stack.remove(departSuivant);

            for(Sommet i : sommetsVoisins.get(departSuivant)){

                if(this.sommetsVoisins.get(i).size() >0){

                    if(!parcouru.contains(i)){
                        stack.add(i);
                        ret = DFSrec(departSuivant, som2, parcouru, stack);
                    }
                }

            }
        }
        return ret;
    }


    /**
     * Get the neighbours of a vertex
     * @param idSom the vertex's id
     * @return the neighbours the vertex. Return null if the vertex does not exists or has no neighbours.
     */
    public ArrayList<Sommet> voisins(int idSom){

        ArrayList<Sommet> ret = new ArrayList<Sommet>();

        if(estDansGraphe(idSom)){
            for(Sommet s : sommetsVoisins.keySet()){
                if(s.getId() == idSom){
                    ret.addAll(sommetsVoisins.get(s));
                }
            }
        } else {
            throw new IllegalArgumentException("The vertex does not exist in the graph");
        }

        return ret;
    }


    /**
     * Add an edge to the graph between two vertex
     * @param idSom1 the first vertex's id
     * @param idSom2 the second vertex's id
     * @return true if the edge has been added, false if not
     */
    public boolean ajouteArrete(int idSom1, int idSom2){

        boolean ret = false;

        if((this.estDansGraphe(idSom1)) && (this.estDansGraphe(idSom2))){
            
            Sommet s1 = this.getSommet(idSom1);
            Sommet s2 = this.getSommet(idSom2);

            if(!this.sommetsVoisins.get(s1).contains(s2)){
                this.sommetsVoisins.get(s1).add(s2);
                ret = true;
            } else {
                throw new IllegalArgumentException("The edge already exists");
            }
        } else {
            throw new IllegalArgumentException("One of the vertices is not in the graph.");
        }
        return ret;
    }


    /**
     * Remove an edge to the graph between two vertex
     * @param idSom1 the first vertex's id
     * @param idSom2 the second vertex's id
     */
    public boolean retireArete(int idSom1, int idSom2){

        boolean ret = false;

        if((this.estDansGraphe(idSom1)) && (this.estDansGraphe(idSom2))){
            if(this.sommetsVoisins.get(this.getSommet(idSom1)).contains(this.getSommet(idSom2))){
                this.sommetsVoisins.get(this.getSommet(idSom1)).remove(this.getSommet(idSom2));
                ret = true;
            } else {
                throw new IllegalArgumentException("The edge does not exist");
            }
        }else{
            throw new IllegalArgumentException("One of the vertices is not in the graph.");
        }
        return ret;

    }

    /**
     * Get the vertex with the corresponding id, if it exists in the graph
     * @param idSom the vertex's id
     * @return the vertex, null if there isn't one with this id
     */
    public Sommet getSommet(int idSom){

        Sommet ret = null;

        if(sommetsVoisins.size() > 0){
            if(idSom >= 0){
                for(Sommet i : sommetsVoisins.keySet()){
                    if(i.getId() == idSom){
                        ret = i;
                    }
                }
            }else{
                System.err.println("getSommet : the vertex's id must be at least equal to 0.");
            }
        }else{
            System.err.println("getSommet : the graph must contain at least one vertex");
        }
        return ret;
    }

    /**
     * Returns the adjacency matrix of the graph where the first row is the vertex's id
     * @return the adjacency matrix of the graph
     */
    public int[][] matriceAdjacence(){

        int[][] ret = new int[nbSommets()][nbSommets()];

        if(sommetsVoisins.size() > 0){
            for(int i = 0; i < this.nbSommets(); i++){
                for(int j = 0; j < this.nbSommets(); j++){
                    if(sontVoisins(i+1,j+1)){
                        ret[i][j] = 1;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("The graph must contain at least one vertex");
        }
        return ret;
    }

    /**
     * Chekcs if the graph is connected
     * @return true if the graph is connected, false if not
     */
    public boolean estConnexe(){
    
        boolean ret = true;
        int[][] matrice = matriceAdjacence();

        for(int i = 0; i < nbSommets(); i++){
            for(int j = 0; j < nbSommets(); j++){
                if(matrice[i][j] == 0){
                    ret = false;
                }
            }
        }
        return ret;
    }
        

    /**
     * Returns the list of connected graph's in the currenct graph
     * @return
     */
    public ArrayList<Graphe> composanteConnexe(){
        ArrayList<Graphe> ret = new ArrayList<Graphe>();
        int[][] matrice = matriceAdjacence();

        if(estConnexe()){
            for(int i = 0; i < nbSommets(); i++){
                for(int j = 0; j < nbSommets(); j++){
                    if(matrice[i][j] == 0){
                        Graphe g = new Graphe(this);
                        g.ajouteArrete(i+1,j+1);
                        ret.add(g);
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("The graph is not connected");
        }

        return ret;
    }

    /**
     * Returns the number of sides between two vertices
     * @param idSom1 the first vertex's id
     * @param idSom2 the second vertex's id
     * @return the number of sides between two vertices
     */
    public int distAretes(int idSom1, int idSom2) {
        int toAdd = 1;
        int nbAretes = 0;

        if((this.estDansGraphe(idSom1)) && (this.estDansGraphe(idSom2))){
            for(Sommet s : sommetsVoisins.keySet()){
                if(s.getId() == idSom1){
                    for(Sommet s2 : sommetsVoisins.get(s)){
                        if(s2.getId() == idSom2){
                            toAdd = 0;
                        }
                        nbAretes+=toAdd;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("One of the vertices is not in the graph.");
        }
        return nbAretes;
    }

    /**
     * Returns the maximal number of sides of the path from the given vertex and the others vertices. If the graph is not connected, returns -1.
     * @param idSom
     * @return
     */
    public int excentricite(int idSom) {
        
        int ret = 0;

        if(this.estConnexe()){
            if(idSom >= 0){
                if(this.estDansGraphe(idSom)){
                    int max = 0;
                    for(Sommet s : sommetsVoisins.keySet()){
                        if(s.getId() != idSom){
                            if(this.distAretes(idSom, s.getId()) > max){
                                max = this.distAretes(idSom, s.getId());
                            }
                        }
                    }
                    ret = max;
                } else {
                    throw new IllegalArgumentException("The vertex is not in the graph.");
                }
            } else {
                throw new IllegalArgumentException("The vertex's id must be at least equal to 0.");
            }
        } else {
            ret = -1;
        }
        return ret;
    }
    
    /**
     * Returns the max excentricity of the graph
     * @return the max excentricity of the graph
     */
    public int diametre(){

        int diametre = 0;

        if(this.estConnexe()){
            int max = 0;
            for(Sommet s : sommetsVoisins.keySet()){
                if(this.excentricite(s.getId()) > max){
                    max = this.excentricite(s.getId());
                }
            }
            diametre = max;
        } else {
            diametre = -1;
        }
        return diametre;
    }

    public int rayon(){
        
        int rayon = 0;
        
        if(this.estConnexe()){
            int min = this.excentricite(0);
            for(Sommet s : sommetsVoisins.keySet()){
                if(this.excentricite(s.getId()) < min){
                    min = this.excentricite(s.getId());
                }
            }
            rayon = min;
        } else {
            rayon = -1;
        }
        return rayon;
    }

    /**
     * Calculates the sum of the distances between two vertices
     * @param idSom1 the first vertex's id
     * @param idSom2 the second vertex's id
     * @return
     */
    public double calculeDist(int idSom1, int idSom2){
        
        double ret = 0;
        
        if(this.estDansGraphe(idSom1) && this.estDansGraphe(idSom2)){
            for(Sommet s : sommetsVoisins.keySet()){
                if(s.getId() == idSom1){
                    for(Sommet s2 : sommetsVoisins.get(s)){
                        if(s2.getId() == idSom2){
                            ret += s.calculeDist(s2);
                        }
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("One of the vertices is not in the graph.");
        }
        return ret;
    }

    /**
     * Returns a String representation of the graph
     * @return a String representation of the graph
     */
    public String toString(){
        String ret = "";
        for(Sommet s : sommetsVoisins.keySet()){
            ret += s.toString();
            for(Sommet s2 : sommetsVoisins.get(s)){
                ret += " " + s2.toString();
            }
            ret += "\n";
        }
        return ret;
    }
}

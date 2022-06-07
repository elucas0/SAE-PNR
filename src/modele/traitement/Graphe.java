package modele.traitement;
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
        for(Sommet s : this.sommetsVoisins.keySet()) {
            if(s.getId() == idSom) {
                degre = this.sommetsVoisins.get(s).size();
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

        HashMap<Sommet, Integer> ret = null;

        if(this.sommetsVoisins.size() > 0){

            for(Sommet i : this.sommetsVoisins.keySet()){

                ret.put(i, this.sommetsVoisins.get(i).size());
            }

        }else{

            System.err.println("calculDegre : there must be at least one value in sommetsVoisins.");
        }

        return ret;
    }


    /**
     * Get the vertex with the maximum degre in the graph
     * @return the vertex with the maximum degre in the graph
     */
    public Sommet somMaxDegre(){

        Sommet ret = null;

        HashMap<Sommet, Integer> degres = this.calculDegres();

        if(degres != null){

            for(Sommet i : degres.keySet()){

                if(ret == null){

                    ret = i;
                }else{

                    if(degres.get(ret) < degres.get(i)){

                        ret = i;
                    }
                }
            }
        }else{

            System.err.println("somMaxDegre : there must be at least one vertex in the graph");
        }

        return ret;
    }


    /**
     * Check if two vertex are neighbours
     * @param idSom1 the first vertex
     * @param idSom2 the second vertex
     * @return true if the vertex are neighbours, false if not
     */
    public boolean sontVoisins(int idSom1, int idSom2){

        boolean ret = false;

        Sommet sommet1 = this.getSommet(idSom1);
        Sommet sommet2 = this.getSommet(idSom2);

        if((sommet1 != null) && (sommet2 != null)){

            ret = this.sommetsVoisins.get(sommet1).contains(sommet2);            
        }else{

            System.err.println("sontVoisins : the two vertex must be in  the graph");
        }

        return ret;       
    }


    /**
     * Verify if a way to go from a wanted vertex to another one exists.
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

            System.err.println("sontVoisins : the two vertex must be in  the graph");
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


        }else{

            Sommet departSuivant = stack.get(0);
            parcouru.add(departSuivant);
            stack.remove(departSuivant);

            for(Sommet i : sommetsVoisins.get(departSuivant)){

                if(!parcouru.contains(i)){

                    stack.add(i);
                    ret = DFSrec(departSuivant, som2, parcouru, stack);
                }
            }
        }
        return ret;

    }


    /**
     * Get the neighbours of a vertex
     * @param idSom1 the vertex's id
     * @return the neighbours the vertex. Return null if the vertex does not exists or has no neighbours.
     */
    public ArrayList<Sommet> voisins(int idSom1){

        ArrayList<Sommet> ret = null;

        if(estDansGraphe(idSom1)){

            ret = sommetsVoisins.get(this.getSommet(idSom1));
        }

        return ret;
    }


    /**
     * Add an edge to the graph between two vertex
     * @param idSom1 the first vertex's id
     * @param idSom2 the second vertex's id
     */
    public boolean ajouteArrete(int idSom1, int idSom2){

        boolean ret = false;

        if((this.estDansGraphe(idSom1)) && (this.estDansGraphe(idSom2))){

            ret = true;
            Sommet sommet1 = this.getSommet(idSom1);
            Sommet sommet2 = this.getSommet(idSom2);

            this.sommetsVoisins.get(sommet1).add(sommet2);
            this.sommetsVoisins.get(sommet2).add(sommet1);

            
        }else{

            System.err.println("ajouteArrete : the two vertex must be in the graph");
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

            ret = true;
            Sommet sommet1 = this.getSommet(idSom1);
            Sommet sommet2 = this.getSommet(idSom2);

            this.sommetsVoisins.get(sommet1).remove(sommet2);
            this.sommetsVoisins.get(sommet2).remove(sommet1);

            
        }else{

            System.err.println("retireArrete : the two vertex must be in the graph");
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

    public int[][] matriceAdjacence(){
        int[][] ret = null;

        if(sommetsVoisins.size() > 0){
            ret = new int[sommetsVoisins.size()][sommetsVoisins.size()];

            for(Sommet i : sommetsVoisins.keySet()){
                for(Sommet j : sommetsVoisins.get(i)){
                    ret[i.getId()][j.getId()] = 1;
                }
            }
        }else{
            System.err.println("matriceAdjacence : the graph must contain at least one vertex");
        }
        return ret;
    }

    public boolean estConnexe(){
        boolean ret = false;

        if(sommetsVoisins.size() > 0){
            int[][] matrice = matriceAdjacence();
            int nbSommets = sommetsVoisins.size();
            int nbSommetsConnexes = 0;
            int[] sommetsConnexes = new int[nbSommets];

            for(int i = 0; i < nbSommets; i++){
                if(sommetsConnexes[i] == 0){
                    sommetsConnexes[i] = 1;
                    nbSommetsConnexes++;
                    for(int j = 0; j < nbSommets; j++){
                        if(matrice[i][j] == 1){
                            sommetsConnexes[j] = 1;
                            nbSommetsConnexes++;
                        }
                    }
                }
            }
            if(nbSommetsConnexes == nbSommets){
                ret = true;
            }
        }else{
            System.err.println("estConnexe : the graph must contain at least one vertex");
        }
        return ret;
    }

    public ArrayList<Graphe> composanteConnexe(){
        ArrayList<Graphe> ret = new ArrayList<Graphe>();

        if(sommetsVoisins.size() > 0){
            int[][] matrice = matriceAdjacence();
            int nbSommets = sommetsVoisins.size();
            int nbSommetsConnexes = 0;
            int[] sommetsConnexes = new int[nbSommets];

            for(int i = 0; i < nbSommets; i++){
                if(sommetsConnexes[i] == 0){
                    sommetsConnexes[i] = 1;
                    nbSommetsConnexes++;
                    for(int j = 0; j < nbSommets; j++){
                        if(matrice[i][j] == 1){
                            sommetsConnexes[j] = 1;
                            nbSommetsConnexes++;
                        }
                    }
                }
            }
            if(nbSommetsConnexes == nbSommets){
                ret = new ArrayList<Graphe>();
                ret.add(this);
            }else{
                int nbSommetsRestants = nbSommets - nbSommetsConnexes;
                int[] sommetsRestants = new int[nbSommetsRestants];
                int nbSommetsRestantsConnexes = 0;
                int[] sommetsRestantsConnexes = new int[nbSommetsRestants];

                for(int i = 0; i < nbSommets; i++){
                    if(sommetsConnexes[i] == 0){
                        sommetsRestants[i] = 1;
                        nbSommetsRestantsConnexes++;
                        for(int j = 0; j < nbSommets; j++){
                            if(matrice[i][j] == 1){
                                sommetsRestantsConnexes[j] = 1;
                                nbSommetsRestantsConnexes++;
                            }
                        }
                    }
                }
            }
        }else{
            System.err.println("composanteConnexe : the graph must contain at least one vertex");
        }
        return ret;
    }

}

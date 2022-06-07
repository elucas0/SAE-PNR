package traitement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe représentant un sommet d'un graphe
 */
public class Graphe {
//cum
    /**
     * Liste des sommets du graphe
     */
    private HashMap<Sommet,ArrayList<Sommet>> sommetsVoisins;

    /**
     * Constructeur de la classe Graphe
     * @param sommets liste des sommets du graphe
     * @param dist liste des distances entre les sommets du graphe
     */
    public Graphe(ArrayList<Sommet> sommets,double dist){

        this.sommetsVoisins = new HashMap<Sommet,ArrayList<Sommet>>();

        for(int i=0;i<sommets.size();i++){
            ArrayList<Sommet> listeVoisins = new ArrayList<Sommet>();
            for(int j=0;j<sommets.size();j++){
                if(i!=j){
                    if(dist<=sommets.get(i).calculeDistance(sommets.get(j))){
                        listeVoisins.add(sommets.get(j));
                    }
                }
            }
            this.sommetsVoisins.put(sommets.get(i),listeVoisins);
        }
    }

    /**
     * Ajoute un sommet au graphe
     * @param somVoisins liste des sommets voisins du sommet
     */
    public Graphe(HashMap<Sommet,ArrayList<Sommet>> somVoisins){

        if(somVoisins == null) {
            throw new IllegalArgumentException("somVoisins ne peut être null");
        }
        this.sommetsVoisins=somVoisins;

    }

    /**
     * Constructeur de la classe graphe (copie)
     * @param g graphe
     */
    public Graphe(Graphe g){

        if(g == null) {
            throw new IllegalArgumentException("g ne peut être null");
        }
        this.sommetsVoisins=g.sommetsVoisins;

    }

    /**
     * Retourne le nombre de sommet du graphe
     * @return nombre de sommet dans le graphe
     */
    public int nbSommets(){
        
        return sommetsVoisins.size();
    }

    /**
     * Retourne le nombre d'arête du graphe
     * @return nombre d'arête dans le graphe
     */
    public int nbAretes(){

        int nbAretes=0;
        for(Sommet s : sommetsVoisins.keySet()){
            nbAretes+=sommetsVoisins.get(s).size();
        }
        return nbAretes/2;

    }

    /**
     * Retourne true si le sommet est dans le graphe
     * @param idSom identifiant du sommet
     * @return true si le sommet est dans le graphe, false sinon
     */
    public boolean estDansGraphe(int idSom){

        for(Sommet s : sommetsVoisins.keySet()){
            if(s.getId() == idSom){
                return true;
            }
        }
        return false;
    }


    /**
     * Calcule le degré du sommet
     * @param idSom identifiant du sommet
     * @return le degré du sommet
     */
    public int calculeDegre(int idSom){

        if(!estDansGraphe(idSom)){
            throw new IllegalArgumentException("Le sommet n'est pas dans le graphe");
        }

        int degre = 0;
        for(Sommet s : sommetsVoisins.keySet()){
            if(s.getId() == idSom){
                degre = sommetsVoisins.get(s).size();
            }
        }
        return degre;
    }


    /**
     * Calcule le degré de tout le graphe
     * @return le degré de tout le graphe
     */
    public HashMap<Sommet,Integer> calculeDegres(){

        HashMap<Sommet,Integer> degre = new HashMap<Sommet,Integer>();

        for(Sommet s : sommetsVoisins.keySet()){
            degre.put(s,sommetsVoisins.get(s).size());
        }

        return degre;
    }

    /**
     * Retourne la somme maximum des degrés du graphe
     * @return somme maximum des degrés du graphe
     */
    public Sommet somMaxDegre(){

        Sommet s = null;
        int max = 0;

        for(Sommet sommet : sommetsVoisins.keySet()){

            if(sommetsVoisins.get(sommet).size() > max){
                max = sommetsVoisins.get(sommet).size();
                s = sommet;
            }
        }

        return s;
    }

    /**
     * Vérifie si deux sommets sont voisins
     * @param idSom1 identifiant du premier sommet
     * @param indSom2 identifiant du deuxième sommet
     * @return true si les sommets sont voisins, false sinon
     */
    public boolean sontVoisins(int idSom1, int indSom2){

        if(!estDansGraphe(idSom1)){
            throw new IllegalArgumentException("Le sommet n'est pas dans le graphe");
        }
        if(!estDansGraphe(indSom2)){
            throw new IllegalArgumentException("Le sommet n'est pas dans le graphe");
        }

        for(Sommet s : sommetsVoisins.keySet()){
            if(s.getId() == idSom1){
                for(Sommet s2 : sommetsVoisins.get(s)){
                    if(s2.getId() == indSom2){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * true si on peut aller du sommet
d’identifiant idSom1 au sommet d’identifiant idSom2 en passant par des arˆetes successives, false sinon.
     * @param indSom1 indice du premier sommet
     * @param indSom2 indice du deuxième sommet
     * @return true si il existe un chemin entre les sommets, false sinon
     */
    public boolean existeChemin(int indSom1, int indSom2){

        boolean ret = false;
        if(!estDansGraphe(indSom1)){
            throw new IllegalArgumentException("Le sommet n'est pas dans le graphe");
        }
        if(!estDansGraphe(indSom2)){
            throw new IllegalArgumentException("Le sommet n'est pas dans le graphe");
        }
        if(indSom1 == indSom2){
            ret = true;
        }
        Sommet tmp=null;
        if(!ret){
            for(Sommet s : sommetsVoisins.keySet()){

                if(s.getId() == indSom1){
                    for(Sommet s2 : sommetsVoisins.get(s)){

                        if(s2.getId() == indSom2){
                            ret = true;
                        }
                        tmp=s2;

                    }
                    if(!ret && tmp != null){
                        ret = existeChemin(tmp.getId(),indSom2);
                    }
                }
            }
        }
        return ret;

    }

    /**
     * Renvoie les voisins d'un sommet
     * @param indSom indice du sommet
     * @return liste des voisins du sommet
     */
    public ArrayList<Sommet> voisins(int indSom){

        if(!estDansGraphe(indSom)){
            throw new IllegalArgumentException("Le sommet n'est pas dans le graphe");
        }

        ArrayList<Sommet> sommets = new ArrayList<Sommet>();

        for(Sommet s : sommetsVoisins.keySet()){
            if(s.getId() == indSom){
                sommets.addAll(sommetsVoisins.get(s));
            }
        }

        return sommets;
    }

    /**
     * Ajoute une arête entre deux sommets
     * @param indSom1 indice du premier sommet
     * @param indSom2 indice du deuxième sommet
     * @return true si l'ajout a réussi, false sinon
     */
    public boolean ajouteArete(int indSom1, int indSom2){

        if(!estDansGraphe(indSom1)){
            throw new IllegalArgumentException("Le sommet n'est pas dans le graphe");
        }
        if(!estDansGraphe(indSom2)){
            throw new IllegalArgumentException("Le sommet n'est pas dans le graphe");
        }

        Sommet s1 = null;
        Sommet s2 = null;

        for(Sommet s : sommetsVoisins.keySet()){
            if(s.getId() == indSom1){
                s1 = s;
            }
            if(s.getId() == indSom2){
                s2 = s;
            }
        }

        if(sommetsVoisins.get(s1).contains(s2)){
            return false;
        }
        else{
            sommetsVoisins.get(s1).add(s2);
            return true;
        }
    }

    /**
     * Retire une arête entre deux sommets
     * @param indSom1 indice du premier sommet
     * @param indSom2 indice du deuxième sommet
     * @return true si la suppression a réussi, false sinon
     */
    public boolean retireArete(int indSom1, int indSom2){

        if(!estDansGraphe(indSom1)){
            throw new IllegalArgumentException("Le sommet n'est pas dans le graphe");
        }
        if(!estDansGraphe(indSom2)){
            throw new IllegalArgumentException("Le sommet n'est pas dans le graphe");
        }

        Sommet s1 = null;
        Sommet s2 = null;

        for(Sommet s : sommetsVoisins.keySet()){
            if(s.getId() == indSom1){
                s1 = s;
            }
            if(s.getId() == indSom2){
                s2 = s;
            }
        }

        if(sommetsVoisins.get(s1).contains(s2)){
            sommetsVoisins.get(s1).remove(s2);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Renvoie la matrice d'adjacence du graphe
     * @return matrice d'adjacence du graphe
     */
    public int[][] matriceAdjacence(){

        int[][] matrice = new int[nbSommets()][nbSommets()];

        for(int i = 0; i < this.nbSommets(); i++){

            for(int j = 0; j < this.nbSommets(); j++){

                if(sontVoisins(i+1,j+1)){

                    matrice[i][j] = 1;
                }
            }
        }

        return matrice;
    }

    /**
     * Vérifie si le graphe est connexe
     * @return true si le graphe est connexe, false sinon
     */
    public boolean estConnexe(){

        int[][] matrice = matriceAdjacence();

        for(int i = 0; i < nbSommets(); i++){

            for(int j = 0; j < nbSommets(); j++){

                if(matrice[i][j] == 0){

                    return false;
                }
            }
        }

        return true;
    }

    /**
     * renvoie la liste des graphes connexes composant le graphe courant
     * @return liste des graphes connexes composant le graphe courant
     */
    public ArrayList<Graphe> composanteConnexe(){

        ArrayList<Graphe> graphes = new ArrayList<Graphe>();

        if(estConnexe()){

            Graphe graphe = new Graphe(this);
            graphes.add(graphe);
        }
        else{

            int[][] matrice = matriceAdjacence();

            for(int i = 0; i < nbSommets(); i++){

                for(int j = 0; j < nbSommets(); j++){

                    if(matrice[i][j] == 0){

                        Graphe graphe = new Graphe(this);
                        graphe.ajouteArete(i+1,j+1);
                        graphes.add(graphe);
                    }
                }
            }
        }

        return graphes;
    }

    /**
     * Renvoie le nombre d'arêtes entre deux sommets
     * @param idSom1 identifiant du premier sommet
     * @param idSom2 identifiant du deuxième sommet
     * @return nombre d'arêtes entre les sommets
     */
    public int distAretes(int idSom1, int idSom2){

        if(!estDansGraphe(idSom1)){
            throw new IllegalArgumentException("Le sommet n'est pas dans le graphe");
        }
        if(!estDansGraphe(idSom2)){
            throw new IllegalArgumentException("Le sommet n'est pas dans le graphe");
        }

        int nbAretes = 0;
        int add=1;

        for(Sommet s : sommetsVoisins.keySet()){

            if(s.getId() == idSom1){

                for(Sommet s2 : sommetsVoisins.get(s)){
                    

                    if(s2.getId() == idSom2){

                        add=0;
                    }
                    nbAretes+=add;
                }
            }
        }

        return nbAretes;
    }

    /**
     * Renvoie le nombre maximal d'arêtes entre deux sommets
     * @param idSom identifiant du sommet
     * @return nombre maximal d'arêtes entre deux sommets
     */
    public int excentricite(int idSom){

        if(idSom < 0) {
            throw new IllegalArgumentException("idSom doit être positif");
        }

        int excentrit = 0;

        for(int i = 0; i < nbSommets(); i++){

            if(distAretes(idSom,i) > excentrit){

                excentrit = distAretes(idSom,i);
            }
        }

        return excentrit;
    }

    /**
     * Renvoie le maximum d'excentrité d'un sommet
     * @return maximum d'excentrité d'un sommet
     */
    public int diametre(){

        int diametre = 0;

        for(int i = 0; i < nbSommets(); i++){

            for(int j = 0; j < nbSommets(); j++){

                if(distAretes(i,j) > diametre){

                    diametre = distAretes(i,j);
                }
            }
        }
        
        return diametre;
    }

    /**
     * Renvoie le minimum d'excentrité d'un sommet
     * @return minimum d'excentrité d'un sommet
     */
    public int rayon(){

        int rayon = 0;

        for(int i = 0; i < nbSommets(); i++){

            if(calculeDegre(i) > rayon){

                rayon = calculeDegre(i);
            }
        }

        return rayon;
    }

    /**
     * Calcule la somme des distances entre deux sommets
     * @param idSom1 identifiant du premier sommet
     * @param idSom2 identifiant du deuxième sommet
     * @return somme des distances entre deux sommets
     */
    public double calculeDist(int idSom1, int idSom2){

        if(!estDansGraphe(idSom1)){
            throw new IllegalArgumentException("Le sommet n'est pas dans le graphe");
        }
        if(!estDansGraphe(idSom2)){
            throw new IllegalArgumentException("Le sommet n'est pas dans le graphe");
        }

        double dist = 0;

        for(Sommet s : sommetsVoisins.keySet()){

            if(s.getId() == idSom1){

                for(Sommet s2 : sommetsVoisins.get(s)){

                    if(s2.getId() == idSom2){

                        dist += s.calculeDistance(s2);
                    }
                }
            }
        }

        return dist;
    }

    /**
     * Renvoie la distance maximale entre un sommet et tout les autres
     * @param idSom identifiant du sommet
     * @return distance maximale entre un sommet et tout les autres
     */
    public double excentriciteDist(int idSom){

        if(idSom < 0) {
            throw new IllegalArgumentException("idSom doit être positif");
        }

        double excentrite = 0;

        for(int i = 0; i < nbSommets(); i++){

            if(i != idSom){

                excentrite += calculeDist(idSom,i);
            }
        }

        return excentrite;
    }

    /**
     * Renvoie le maximum d'excentrité de distance
     * @return maximum d'excentrité de distance
     */
    public double diametreDist(){

        double diametre = 0;

        for(int i = 0; i < nbSommets(); i++){

            for(int j = 0; j < nbSommets(); j++){

                if(calculeDist(i,j) > diametre){

                    diametre = calculeDist(i,j);
                }
            }
        }

        return diametre;
    }

    /**
     * Renvoie le minimum d'excentrité de distance
     * @return minimum d'excentrité de distance
     */
    public double rayonDist(){

        double rayon = 0;

        for(int i = 0; i < nbSommets(); i++){

            if(calculeDegre(i) > rayon){

                rayon = calculeDegre(i);
            }
        }

        return rayon;
    }

    /**
     * Renvoie une matrice de pondération
     * @return matrice de pondération
     */
    public double[][] matricePonderation(){

        double[][] matrice = new double[nbSommets()][nbSommets()];

        for(int i = 0; i < nbSommets(); i++){

            for(int j = 0; j < nbSommets(); j++){

                if(sontVoisins(i,j)){

                    matrice[i][j] = calculeDist(i,j);
                }
            }
        }

        return matrice;
    }

    /**
     * Renvoie un nouveau graphe qui est la clôture transitive du graphe courant
     * @return nouveau graphe qui est la clôture transitive du graphe courant
     */
    public Graphe clotureTransitive(){

        Graphe g = new Graphe(this);

        for(int i = 0; i < nbSommets(); i++){

            for(int j = 0; j < nbSommets(); j++){

                if(g.sontVoisins(i,j)){

                    for(int k = 0; k < nbSommets(); k++){

                        if(g.sontVoisins(j,k)){

                            if(!g.sontVoisins(i,k)){

                                g.ajouteArete(i,k);
                            }
                        }
                    }
                }
            }
        }

        return g;
    }

    public String toString(){

        String s = "";

        for(Sommet sommet : sommetsVoisins.keySet()){

            s += sommet.getId() + " : ";

            for(Sommet sommet2 : sommetsVoisins.get(sommet)){

                s += sommet2.getId() + " ";
            }

            s += "\n";
        }

        return s;
    }
}
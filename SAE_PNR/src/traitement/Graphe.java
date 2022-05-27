package traitement;
import java.util.HashMap;
import java.util.ArrayList;

public class Graphe {

    private HashMap<Sommet, ArrayList<Sommet>> sommetsVoisins;
    

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

        if(this.sommetsVoisins.size() > 0){

            for(Sommet i : this.sommetsVoisins.keySet()){

                if(i.getId() == idSom1){

                    for(Sommet j : this.sommetsVoisins.get(i)){

                        if(j.getId() == idSom2){

                            ret = true;
                        }
                    }
                }
            }
        }

        return ret;       
    }


    public boolean existeChemin(){

        boolean ret = false;


        return ret;
    }


    /**
     * Get the neighbours of a vertex
     * @param idSom1 the vertex's id
     * @return the neighbours the vertex
     */
    public ArrayList<Sommet> voisins(int idSom1){

        ArrayList<Sommet> ret = null;

        boolean trouve = false;

        if(idSom1 >= 0){

            for(Sommet i : this.sommetsVoisins.keySet()){

                if(i.getId() == idSom1){
    
                    ret = this.sommetsVoisins.get(i);
                }
            }

        }else{

            System.err.println("voisins ; idSom1 must be at least 0");
        }

        return ret;
    }

    /**
     * Add an edge to the graph between two vertex
     * @param idSom1 the first vertex's id
     * @param idSom2 the second vertex's id
     */
    public void ajouteArrete(int idSom1, int idSom2){

        if((idSom1 >= 0) && (idSom2 >= 0)){

            if(idSom1 != idSom2){

                Sommet sommet1 = null;
                Sommet sommet2 = null;

                for(Sommet i : this.sommetsVoisins.keySet()){

                    if(i.getId() == idSom1){

                        sommet1 = i;
                    }

                    if(i.getId() == idSom2){

                        sommet2 = i;
                    }
                        
                }

                if((sommet1 != null) && (sommet2 != null)){

                    this.sommetsVoisins.get(sommet1).add(sommet2);
                    this.sommetsVoisins.get(sommet2).add(sommet1);

                }else{

                    System.err.println("ajouteArrete : the two wanted vertex must exists.");
                }
            }


        }else{

            System.err.println("ajouteArrete : idSom1 and idSom2 must be at leats equal to 0.");
        }
    }


    /**
     * Remove an edge to the graph between two vertex
     * @param idSom1 the first vertex's id
     * @param idSom2 the second vertex's id
     */
    public void retireArete(int idSom1, int idSom2){

        if((idSom1 >= 0) && (idSom2 >= 0)){

            if(idSom1 != idSom2){

                Sommet sommet1 = null;
                Sommet sommet2 = null;

                for(Sommet i : this.sommetsVoisins.keySet()){

                    if(i.getId() == idSom1){

                        sommet1 = i;
                    }

                    if(i.getId() == idSom2){

                        sommet2 = i;
                    }
                        
                }

                if((sommet1 != null) && (sommet2 != null)){

                    this.sommetsVoisins.get(sommet1).remove(sommet2);
                    this.sommetsVoisins.get(sommet2).remove(sommet1);

                }else{

                    System.err.println("ajouteArrete : the two wanted vertex must exists.");
                }
            }


        }else{

            System.err.println("ajouteArrete : idSom1 and idSom2 must be at leats equal to 0.");
        }

    }
}
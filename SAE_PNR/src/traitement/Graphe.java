package traitement;
import java.util.HashMap;
import java.util.ArrayList;

public class Graphe {

    private HashMap<Sommet, ArrayList<Sommet>> sommetsVoisins;
    

    public HashMap<Sommet, Integer> calculDegre(){

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
}

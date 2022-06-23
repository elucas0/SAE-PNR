package modele.donnee;

public class Aobserve {
    private int idObservateur;
    private int idObservation;

    public Aobserve(int idObservateur, int idObservation){

        this.idObservateur = idObservateur;
        this.idObservateur = idObservation;

    }

    public int getIdObservateur() {
        return idObservateur;
    }

    public int getIdObservation() {
        return idObservation;
    }
}


package modele.donnee;

public class User {

    private int id;
    private String nomCompte;
    private int admin;

    public User(int id, String nomCompte, int admin){

        this.id = id;
        this.nomCompte = nomCompte;
        this.admin = admin;

    }

    public int getId() {
        return id;
    }

    public String getNomCompte() {
        return nomCompte;
    }

    public int getAdmin() {
        return admin;
    }
}

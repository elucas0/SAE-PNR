package modele.donnee;

/**
 * Class for a user.
 */
public class User {

    /**
     * The user's id
     */
    private int id;

    /**
     * The user's name
     */
    private String nomCompte;

    /**
     * The status of the user (admin or not)
     */
    private int admin;

    /**
     * Constructor of the class User
     * @param id the id of the user
     * @param nomCompte the name of the user
     * @param admin the admin status of the user
     */
    public User(int id, String nomCompte, int admin){

        this.id = id;
        this.nomCompte = nomCompte;
        this.admin = admin;

    }

    /**
     * Returns the id of the user
     * @return id of the user
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the name of the user
     * @return the nomCompte
     */
    public String getNomCompte() {
        return nomCompte;
    }

    /**
     * Returns the admin status of the user
     * @return the admin
     */
    public int getAdmin() {
        return admin;
    }
}

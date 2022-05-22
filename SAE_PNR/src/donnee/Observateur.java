package donnee;
	/**
	 * Class for create an observer
	 * */
public class Observateur{
	/**
	 * Id of the observer
	 * */
	private int idObservateur;
	/**
	 * lastname of the observer
	 **/
	private String nom;
	/**
	 * firstname of the observer
	 **/
	private String prenom;

	/**Constructor of the class Observateur
	 * @param id Id of the observer
	 * @param leNom lastname of the observer
	 * @param lePrenom firstname of the observer*/
	public Observateur(int id,String leNom,String lePrenom){
		if(id<1){
			throw new IllegalArgumentException("Erreur dans l'id ");
		}
		else{
			this.idObservateur=id;
		}
		if(lePrenom==null ){
			throw new IllegalArgumentException("Erreur dans le prenom ");
		}
		else{
			this.prenom=lePrenom;
		}
		if(leNom==null){
			throw new IllegalArgumentException("Erreur dans le nom ");
		}
		else{
			this.nom=leNom;
		}	
	}
	/**Return id of the observer
	 * @return id of observer*/
	public int getId(){
		return this.idObservateur;
	}
	/**Set id of the observer
	 * @param id id of the observer*/
	public void setId(int id){
		this.idObservateur=id;
	}
	/**Return lastname of the observer
	* @return lastname*/
	public String getNom(){
		return this.nom;
	}
	/**Set firstname of the observer
	 * @param leNom lastname of the observer*/
	public void setNom(String leNom){
		this.nom=leNom;
	}
	/**Return firstname of the observer
	 * @return firstname*/
	public String getPrenom(){
		return this.prenom;
	}
	/**Set firstname of the observer
	 * @param lePrenom firstname of the observer*/
	public void setPrenom(String lePrenom){
		this.prenom=lePrenom;
	}
}
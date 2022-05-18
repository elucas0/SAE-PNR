package donnee;
class Observateur{
	//Id of the observer
	private int idObservateur;
	//lastname of the observer
	private String nom;
	//firstname of the observer
	private String prenom;

	/**Constructor of the class Observateur
	 * @param id Id of the observer
	 * @param leNom lastname of the observer
	 * @param lePrenom firstname of the observer*/
	public Observateur(int id,String leNom,String lePrenom){
		if(id<1){
			System.err.println("Erreur dans l'id ");
		}
		else if(lePrenom==null ){
			System.err.println("Erreur dans le prenom ");
		}
		else if(leNom==null){
			System.err.println("Erreur dans le nom ");
		}
		else{
			this.idObservateur=id;
			this.nom=leNom;
			this.prenom=lePrenom;
		}	
	}
	/**Getter et Setter*/
	public int getId(){
		return this.idObservateur;
	}
	public void setCoordX(int id){
		this.idObservateur=id;
	}
	
	public String getNom(){
		return this.nom;
	}
	public void setNom(String leNom){
		this.nom=leNom;
	}

	public String getPrenom(){
		return this.prenom;
	}
	public void setPrenom(String lePrenom){
		this.prenom=lePrenom;
	}
}
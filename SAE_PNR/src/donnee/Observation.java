package donnee;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public  abstract  class Observation {
	//Id of the observer
	protected int idObs;
	//Date of the observation
	protected Date dateObs;
	//Hours of the observation
	protected Time heureObs;
	//Place of the observation (Objet de Lieu.java)
	protected Lieu lieuObs;
	//ArrayList of the observer (List of object from Observateur.java) 
	protected ArrayList<Observateur> lesObservateurs;

	/**Constructor of the class Observation
	 * @param id Id of the observer
	 * @param date Date of the observation
	 * @param heure Hours of the observation
	 * @param lieu Lieu de l'observation
	 * @param observateurs List of the observer
	 * */
	public Observation(int id, Date date, Time heure, Lieu lieu,ArrayList<Observateur> observateurs){
		if(id<1){
			System.err.println("Erreur dans l'id ");
		}
		else{
			this.idObs=id;
		}

		if(date==null ){
			System.err.println("Erreur dans la date ");
		}
		else{
			this.dateObs=date;
		}
		if(heure==null){
			System.err.println("Erreur dans l'heure ");
		}
		else{
			this.heureObs=heure;
		}
		if(lieu==null){
			System.err.println("Erreur dans le lieu ");
		}
		else{
			this.lieuObs=lieu;
		}
		if(observateurs==null){
			System.err.println("Erreur dans la liste des observateurs ");
		}
		else{
			this.lesObservateurs=observateurs;
		}
		

	}
	/**add an observateur to the list lesObservateurs
	 * @param o Object Observateur */
	public void ajouteObservateur(Observateur o){
		this.lesObservateurs.add(o);
	}
	/**Remove an observer of the list lesObservateurs
	 * @param idObservateur Id of the observer*/
	public void retireObservateur(int idObservateur ){
		this.lesObservateurs.remove(idObservateur);
	}

	/**Getter et Setter*/
	public ArrayList<Observateur> getObservateur(){
		return this.lesObservateurs;
	}
	public void setObservateur( ArrayList<Observateur> observateurs){
		if(observateurs==null){
			System.err.println("Erreur dans la liste des observateurs ");
		}
		else{
			this.lesObservateurs=observateurs;
		}
		
	}

	public Lieu getLieu(){
		return this.lieuObs;
	}
	public void setLieu(Lieu lieu){
		if(lieu==null){
			System.err.println("Erreur dans le lieu ");
		}	
		else{
			this.lieuObs=lieu;
		}
	}

	public Time getHeure(){
		return this.heureObs;
	}
	public void setHeure(Time heure){
		if(heure==null){
			System.err.println("Erreur dans l'heure ");
		}
		else{
			this.heureObs=heure;
		}
	}

	public Date getDate(){
		return this.dateObs;
	}
	public void setDate(Date date){
		if(date==null){
			System.err.println("Erreur dans la date ");
		}
		else{
			this.dateObs=date;
		}
	}


	public int getId(){
		return this.idObs;
	}
	public void setId(int id){
		if(id <= 0){
			System.err.println("Erreur dans l'id");
		}
		else{
			this.idObs=id;
		}
	}
	/**Abstract method with the list of possible observation*/
	public  abstract  EspeceObservee especeObs();
}
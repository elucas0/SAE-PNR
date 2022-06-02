
package donnee;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
/**
 * Class for create an observation
 * */
public  abstract  class Observation {
	/**Id of the observer*/
	protected int idObs;
	/**Date of the observation*/
	protected Date dateObs;
	/**Hours of the observation*/
	protected Time heureObs;
	/**Place of the observation (Objet de Lieu.java)*/
	protected Lieu lieuObs;
	/**ArrayList of the observer (List of object from Observateur.java) */
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
			throw new IllegalArgumentException("Erreur dans l'id ");
		}
		else{
			this.idObs=id;
		}

		if(date==null ){
			throw new IllegalArgumentException("Erreur dans la date ");
		}
		else{
			this.dateObs=date;
		}
		if(heure==null){
			throw new IllegalArgumentException("Erreur dans l'heure ");
		}
		else{
			this.heureObs=heure;
		}
		if(lieu==null){
			throw new IllegalArgumentException("Erreur dans le lieu ");
		}
		else{
			this.lieuObs=lieu;
		}
		if(observateurs==null){
			throw new IllegalArgumentException("Erreur dans la liste des observateurs ");
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
	/**Return List of Observateurs
	 * @return list of observers*/
	public ArrayList<Observateur> getObservateur(){
		return this.lesObservateurs;
	}
	/**Set a list of observateur
	 * @param observateurs arraylist observateurs*/ 
	public void setObservateur( ArrayList<Observateur> observateurs){
		if(observateurs==null){
			System.err.println("Erreur dans la liste des observateurs ");
		}
		else{
			this.lesObservateurs=observateurs;
		}
		
	}
	/**Return Object Lieu (Coordinate x,y)
	 * @return Place of the obsrvation*/
	public Lieu getLieu(){
		return this.lieuObs;
	}
	/**Set Object Lieu (Coordinate x,y)
	 * @param lieu place of observation*/
	public void setLieu(Lieu lieu){
		if(lieu==null){
			System.err.println("Erreur dans le lieu ");
		}	
		else{
			this.lieuObs=lieu;
		}
	}
	/**Return the hour of the observation
	 * @return hour of the obsrvation*/
	public Time getHeure(){
		return this.heureObs;
	}
	/**Set the hour of the observation
	 * @param heure hour of observation*/
	public void setHeure(Time heure){
		if(heure==null){
			System.err.println("Erreur dans l'heure ");
		}
		else{
			this.heureObs=heure;
		}
	}
	/**Return the date of the observation
	 * @return date of the obsrvation*/
	public Date getDate(){
		return this.dateObs;
	}
	/**Set the date of the observation 	
	 * @param date date of observation
	*/
	public void setDate(Date date){
		if(date==null){
			System.err.println("Erreur dans la date ");
		}
		else{
			this.dateObs=date;
		}
	}

	/**Return the id of the observation
	 * @return id of the observation*/
	public int getId(){
		return this.idObs;
	}
	/**Set the id of the observation
	 *  @param id id of observation
	 * */
	public void setId(int id){
		if(id<1){
			System.err.println("Erreur dans l'id");
		}
		else{
			this.idObs=id;
		}
	}
	/**Abstract method with the list of possible observation
	 * @return a specie*/
	public  abstract  EspeceObservee especeObs();
}
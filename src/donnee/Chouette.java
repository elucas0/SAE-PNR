package donnee;
import java.util.ArrayList;
import java.lang.IllegalAccessException;


/**
 * Create an Observed owl. Conatin informations about his gender, type of the Observation,
 * his sepcie and his id.
 */
public class Chouette implements lObs<ObsChouette>{


	/**
	 * The owl's gender
	 */
	private Sexe sexe;

	/**
	 * The observations about the owl
	 */
	private ArrayList<ObsChouette> lesObservations;

	/**
	 * The owl's specie
	 */
	private EspeceChouette espece;

	/**
	 * The owl's id
	 */
	private String idChouette;

	/**
	 * Create an observed owl.
	 * @param id the owl's id number
	 * @param leSexe the owl's gender
	 * @param lEspece the owl's specie
	 * @throws IllegalAccessException
	 */
	public Chouette(String id, Sexe leSexe, EspeceChouette lEspece) throws IllegalAccessException {
		if(id != null){

			this.idChouette = id;
		}else{

			throw new IllegalAccessException("Chouette : id must not be null");
		}

		if(leSexe != null){

			this.sexe = leSexe;
		}else{

			throw new IllegalAccessException("Chouette : leSexe must not be null");
		}

		if(lEspece != null){

			this.espece = lEspece;
		}else{

			throw new IllegalAccessException("Chouette : lEspece must not be null");
		}

		this.lesObservations = new ArrayList<ObsChouette>();
	}


	/**
	 * Get the owl's gender
	 * @return the owl's gender
	 */
	public Sexe getSexe() {
		return sexe;
	}


	/**
	 * Set the owl's gender to a wanted one
	 * @param sexe the wanted gender
	 */
	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}


	/**
	 * Get the type of Observation
	 * @return
	 */
	public ArrayList<ObsChouette> getLesObservations() {
		return lesObservations;
	}
	

	/**
	 * Set the observation's type to a wanted one
	 * @param lesObservations the wanted observation type
	 */
	public void setLesObservations(ArrayList<ObsChouette> lesObservations) {
		if(lesObservations != null){

			this.lesObservations = lesObservations;
		}else{

			System.err.println("setLesObservations : lesObservations must not be null");
		}
	}


	/**
	 * Get the owl's specie
	 * @return the owl's specie
	 */
	public EspeceChouette getEspece() {
		return espece;
	}


	/**
	 * Set the owl's specie to a wanted one
	 * @param espece the wanted specie
	 */
	public void setEspece(EspeceChouette espece) {
		this.espece = espece;
	}



	/**
	 * Add an observation to the list
	 */
	public void ajoutePlsObs(ArrayList<ObsChouette> obs) {
		if(obs != null){

			for(ObsChouette i : obs){

				this.lesObservations.add(i);
			}
		}else{

			System.err.println("ajoutePlsObs : obs must not be null");
		}
	}


	/**
	 * Remove all the Observations
	 */
	public void videObs() {
		this.lesObservations = new ArrayList<ObsChouette>();
		
	}


	/**
	 * Return if the information was verified
	 * @param idObs the wanted Observation
	 */
	public boolean retireObs(int idObs) {

		boolean ret = false;

		if(this.lesObservations.size() > 0){
			if((idObs >= 0) && (idObs < this.lesObservations.size())){

				ret = true;
			}else{
	
				ret = false;
			}

		}
		return ret;


	}


	/**
	 *Get the number of observations
	 * @return the number of observations
	 */
	public int nbObs() {

		return this.lesObservations.size();
	}



	/**
	 * Add a wanted observation to the list
	 * @param obs the wanted observation
	 */
	public void ajouteObs(ObsChouette obs) {

		if(obs != null){

			lesObservations.add(obs);
		}else{

			System.err.println("ajouteObs : obs must not be null");
		}
		
	}


	/**
	 * 
	 * @return
	 */
	public String getIdChouette() {
		return idChouette;
	}


	public void setIdChouette(String idChouette) {
		this.idChouette = idChouette;
	}

}
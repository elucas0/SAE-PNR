package modele.donnee;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;

/**
 * Create an observation about an owl
 */
public class ObsChouette extends Observation {

	/**
	 * The observation's type
	 */
	private TypeObservation typeObs;



	/**
	 * Create the observation.
	 * @param id id of the observation
	 * @param date date of the observation
	 * @param heure time of the observation
	 * @param lieu location of the observation
	 * @param observateur list of the observers
	 * @param type the observation's type
	 */
	public ObsChouette(int id, Date date, Time heure, Lieu lieu, ArrayList<Observateur> observateur, TypeObservation type) {
		super(id, date, heure, lieu, observateur);
		if(type !=null){

			this.typeObs = type;
		}else{

			throw new IllegalArgumentException("ObsChouette : type must not be null");
		}
		
	}


	/**
	 * Get the observation's type
	 * @return the observation's type
	 */
	public TypeObservation getTypeObs() {
		return typeObs;
	}

	/**
	 * Set the observation's type to a wanted one.
	 * @param typeObs the wanted observation's type
	 */
	public void setTypeObs(TypeObservation typeObs) {
		this.typeObs = typeObs;
	}

	/**
	 * Get the observed specie
	 */
	public EspeceObservee especeObs() {

		return EspeceObservee.CHOUETTE;
	}


}
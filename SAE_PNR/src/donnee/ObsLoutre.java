package donnee;
import java.util.ArrayList;
import java.sql.Time;
import java.sql.Date;

/**
 * 
 */
public class ObsLoutre extends Observation {

	private IndiceLoutre indice;

	/**
	 * Create the observed otter
	 * @param id id of the observation
	 * @param date date of the observation
	 * @param heure time of the observation
	 * @param lieu location of the observation
	 * @param observateur list of the observers
	 * @param indice the state of the place(not visited, with otter, or without otter)
	 */
	public ObsLoutre(int id, Date date, Time heure, Lieu lieu, ArrayList<Observateur> observateur, IndiceLoutre indice) {
		super(id, date, heure, lieu, observateur);

		if(indice != null){

			this.indice = indice;
		}else{

			throw new UnsupportedOperationException("ObsLoutre : indice must not be null");
		}

	}

	/**
	 * Get the specie
	 */
	public EspeceObservee especeObs() {
		return EspeceObservee.LOUTRE;
	}


}
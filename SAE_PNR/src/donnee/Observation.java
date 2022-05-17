package donnee;
import java.sql.Time;
import java.sql.Date;
import java.util.*;

public abstract class Observation {

	protected Lieu lieuObs;
	protected Collection<Observateur> lesObservateurs;
	protected int idObs;
	protected java.sql.Date dateObs;
	protected java.sql.Time heureObs;

	/**
	 * 
	 * @param id
	 * @param date
	 * @param heure
	 * @param lieu
	 * @param observateur
	 */
	public Observation(int id, Date date, Time heure, Lieu lieu, ArrayList<Observateur> observateur) {
		// TODO - implement Observation.Observation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param o
	 */
	public void ajouteObservateur(Observateur o) {
		// TODO - implement Observation.ajouteObservateur
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idObservateur
	 */
	public void retireObservateur(int idObservateur) {
		// TODO - implement Observation.retireObservateur
		throw new UnsupportedOperationException();
	}

	public abstract EspeceObservee especeObs();

}
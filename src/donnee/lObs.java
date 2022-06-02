package donnee;
import java.util.ArrayList;

/**
 * 
 */
public interface lObs<T> {

	/**
	 * Adds an observation to the list of observations.
	 * @param obs the observation to add
	 */
	void ajouteObs(T obs);

	/**
	 * Adds a list of observations to the list of observations.
	 * @param obs the list of observations to add
	 */
	void ajoutePlsObs(ArrayList<T> obs);

	/**
	 * Removes all observations from the list of observations.
	 */
	void videObs();

	/**
	 * Deletes an observation from the list of observations.
	 * @param idObs the id of the observation to delete
	 */
	boolean retireObs(int idObs);

	/**
	 * Returns the number of observations in the list of observations.
	 */
	int nbObs();

}
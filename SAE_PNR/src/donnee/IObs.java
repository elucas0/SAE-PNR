package donnee;

public interface IObs<T> {

	/**
	 * AEs
	 * @param obs
	 */
	void ajouteObs(T obs);

	/**
	 * 
	 * @param obs
	 */
	void ajoutePlsObs(ArrayList<T> obs);

	void videObs();

	/**
	 * 
	 * @param idObs
	 */
	boolean retireObs(int idObs);

	int nbObs();

}
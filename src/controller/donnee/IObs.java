package controller.donnee;
import java.util.*;

public interface IObs<T> {

	/**
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
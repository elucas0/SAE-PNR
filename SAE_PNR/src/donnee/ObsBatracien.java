package donnee;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;

/**
 * Create an observation about a batracian
 */
public class ObsBatracien extends Observation {

	/**
	 * the batracian's specie
	 */
	private EspeceBatracien espece;

	/**
	 * The number of adults
	 */
	private int nombreAdultes;

	/**
	 * The number of Amplexus
	 */
	private int nombreAmplexus;

	/**
	 * The number of tadpole
	 */
	private int nombreTetard;

	/**
	 * Get the number of laying
	 */
	private int nombrePonte;

	/**
	 * Generate a battracian observed
	 * @param id id of the observation
	 * @param date date of the observation
	 * @param heure time of the observation
	 * @param lieu location of the observation
	 * @param observateur list of the observers
	 */
	public ObsBatracien(int id, Date date, Time heure, Lieu lieu, ArrayList<Observateur> observateurs, int[] resObs, EspeceBatracien lEspece) {
		super(id, date, heure, lieu, observateurs);

		if((resObs == null)){
			throw new IllegalArgumentException("ObsBatracien : resObs should not be null");
		}else{

			this.nombreAdultes = resObs[0];
			this.nombreAmplexus = resObs[1];
			this.nombreTetard = resObs[2];
			this.nombrePonte = resObs[3];
		}

		if(lEspece != null){

			this.espece = lEspece;
		}else{

			throw new IllegalArgumentException("ObsBatracien : lEspece should not be null");
		}
	}

	/**
	 * return the specie of the observation ()
	 */
	public EspeceObservee especeObs() {
		return EspeceObservee.BATRACIEN;
	}

	/**
	 * Get the batracian's specie
	 * @return the batracian's specie
	 */
	public EspeceBatracien getEspece() {
		return espece;
	}

	/**
	 * Set the batracian's specie to a wanted one
	 * @param espece the wanted specie
	 */
	public void setEspece(EspeceBatracien espece) {

		if(espece != null){
			this.espece = espece;
		}else{

			System.err.println("setEspece : espece must not be null");
		}
	}


	/**
	 * Get the number of adults
	 * @return the number of adults
	 */
	public int getNombreAdultes() {
		return nombreAdultes;
	}


	/**
	 * Set the number of adults to a wanted number
	 * @param nombreAdultes the wanted number of adults
	 */
	public void setNombreAdultes(int nombreAdultes) {

		if(nombreAdultes >= 0){

			this.nombreAdultes = nombreAdultes;
		}else{

			System.err.println("setNombreAdultes : nombreAdultes must be at least 0.");
		}
	}


	/**
	 * Get the number of Amplexus
	 * @return the number of Amplexus
	 */
	public int getNombreAmplexus() {
		return nombreAmplexus;
	}


	/**
	 * Set the number of amplexus to a wanted one
	 * @param nombreAmplexus the wanted number of Amplexus
	 */
	public void setNombreAmplexus(int nombreAmplexus) {
		if(nombreAmplexus >= 0){

			this.nombreAmplexus = nombreAmplexus;
		}else{

			System.err.println("setNombreAdmplexus : nombreAmplexus must be at least 0.");
		}
	}


	/**
	 * Get the number of tadpole
	 * @return
	 */
	public int getNombreTetard() {
		return nombreTetard;
	}


	/**
	 * Set the number of tadpole to a wanted one
	 * @param nombreTetard the wanted number of tadpole
	 */
	public void setNombreTetard(int nombreTetard) {
		if(nombreTetard >= 0){

			this.nombreTetard = nombreTetard;
		}else{

			System.err.println("setNombreTetard : nombreTetard must be at least 0.");
		}
	}


	/**
	 * Get the number of laying
	 * @return the number of laying
	 */
	public int getNombrePonte() {
		return nombrePonte;
	}

	/**
	 * Set the number of laying to a wanter one
	 * @param nombrePonte the wanted number of laying
	 */
	public void setNombrePonte(int nombrePonte) {
		if(nombrePonte >= 0){

			this.nombrePonte = nombrePonte;
		}else{

			System.err.println("setNombrePonte : nombrePonte must be at least 0.");
		}
	}





}
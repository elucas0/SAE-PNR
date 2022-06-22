package modele.donnee;
import java.sql.Date;
import java.sql.Time;

/**
 * Create an observation about a batracian
 */
public class Batracien  {

	/**
	 * the batracian's specie
	 */
	private String espece;

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

	private int id;
	private Date date;
	private Time heure;
	private Lieu lieu;
	private int observateurs;
	private double coordX;
	private double coordY;

	/**
	 * Generate a battracian observed
	 * @param id id of the observation
	 * @param date date of the observation
	 * @param heure time of the observation
	 * @param lieu location of the observation
	 * @param observateur list of the observers
	 * @param resObs  contain the number of adults(resObs[0]), 
	 * of amplexus (resObs[1]), of tadpoles (resObs[2])
	 * and of egg-layings (resObs[3]).
	 * @param lEspece the frogg' specie
	 */
	public Batracien(int id, Date date, Time heure, double coordX, double coordY,  int observateurs, String espece, int adulte, int amplexus, int ponte,  int tetard) {
		this.id=id;
		this.date=date;
		this.heure=heure;
		this.coordX = coordX;
		this.coordY = coordY;
		this.observateurs=observateurs;
		this.nombreTetard = tetard;
		this.nombreAdultes = adulte;
		this.nombrePonte = ponte;
		this.nombreAmplexus = amplexus;
		this.espece = espece;
	
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
	public String getEspece() {
		return espece;
	}

	/**
	 * Set the batracian's specie to a wanted one
	 * @param espece the wanted specie
	 */
	public void setEspece(String espece) {

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

	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public Time getHeure() {
		return heure;
	}

	public Lieu getLieu() {
		return lieu;
	}

	public int getObservateurs() {
		return observateurs;
	}





}
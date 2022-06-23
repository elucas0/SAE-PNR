package modele.donnee;

import java.sql.Date;
import java.sql.Time;

/**
 * Create an observation about an owl
 */
public class OChouette {

	/**
	 * The observation's type
	 */
	private int id;


	/**
	 * parameter for the protocol 
	 */
	private int protocole;
	/**
	 * parameter for the date
	 */
	private Date date;
	/**
	 * parameter for the hour
	 */
	private Time heure;
	/**
	 * parameter for the observation type
	 */
	private String typeObs;
	/**
	 * parameter for X coordinate
	 */
	private Double coordx;
	/**
	 * paramter for Y coordinate
	 */
	private Double coordy;
	/**
	 * paramter for the number indivudual
	 */
	private String lenumIndividu;
	/**
	 * parameter for the sex
	 */
	private String sexe;
	/**
	 * parameter for the species
	 */
	private String espece;

	/**
	 * Create the observation.
	 * @param id id of the observation
	 * @param date date of the observation
	 * @param heure time of the observation
	 * @param coordx X coordinate
	 * @param coordy Y coordinate
	 * @param protocole protocole for the observation
	 * @param typeObs observation type
	 * @param lenumIndividu number for the observation
	 * @param espece species of the observation
	 * @param sexe sex of the observation
	 */
	public OChouette(int id, Date date, Time heure,  Double coordx ,Double coordy,int protocole, String typeObs,String lenumIndividu,String espece,String sexe) {
		this.id=id;
		this.date=date;
		this.heure=heure;
		this.coordx=coordx;
		this.coordy=coordy;
		this.protocole=protocole;
		this.typeObs=typeObs;
		this.lenumIndividu=lenumIndividu;
		this.espece=espece;
		this.sexe=sexe;
	}


	/**
	 * Get the observation's type
	 * @return the observation's type
	 */
	public String getTypeObs() {
		return typeObs;
	}

	/**
	 * Set the observation's type to a wanted one.
	 * @param typeObs the wanted observation's type
	 */
	public void setTypeObs(String typeObs) {
		this.typeObs = typeObs;
	}

	/**
	 * Get the observed specie
	 * @return the species
	 */
	public EspeceObservee especeObs() {

		return EspeceObservee.CHOUETTE;
	}

	/**
	 * Get the observation id 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get the observation protocole
	 * @return the protocole
	 */
	public int getProtocole() {
		return protocole;
	}

	/**
	 * Get the observation Date
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Get the observation time
	 * @return the time
	 */
	public Time getHeure() {
		return heure;
	}

	/**
	 * Get the x coordinate 
	 * @return the x coordinate
	 */
	public Double getCoordx() {
		return coordx;
	}

	/**
	 * Get the Y coordinate
	 * @return the Y coordinate
	 */
	public Double getCoordy() {
		return coordy;
	}

	/**
	 * Get the indvidual number
	 * @return the individual number
	 */
	public String getLenumIndividu() {
		return lenumIndividu;
	}

	/**
	 * Get the individual sex
	 * @return the individual sex
	 */
	public String getSexe() {
		return sexe;
	}

	/**
	 * Get the species
	 * @return the species
	 */
	public String getEspece() {
		return espece;
	}


}
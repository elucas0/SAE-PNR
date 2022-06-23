package modele.donnee;

import java.sql.Date;
import java.sql.Time;

public class Nid_Gci {

	private int nbEnvols;
    private int idNid;
    private int protection;
	private String plage;
	private String raisonArretObservation;
	private String bagueMale;
	private String bagueFemelle;
    private Date date;
    private Time heure;
    private double coordX;
    private double coordY;
	private int observateur;



	/**
	 * Generate an ObsGCI
	 * @param id id of the observation
	 * @param nomPlage name of the beach
	 * @param heure time of the observation
	 * @param raisonArretObservation reason why the observation
	 * @param nbEnvols number of flight
	 * @param protection protection
	 * @param bagueMale male ring
	 * @param bagueMale female ring
	 */
	public Nid_Gci(int id, String nomPlage,  String raisonArretObservation, int nbEnvols, int protection,String bagueMale,String bagueFemelle) {

		this.idNid = id;
		this.date = date;
		this.heure = heure;
		this.coordX = coordX;
		this.coordY = coordY;
		this.observateur = observateur;
		this.nbEnvols = nbEnvols;
		this.protection = protection;
		this.raisonArretObservation = raisonArretObservation;
		this.bagueMale = bagueMale;
		this.bagueFemelle = bagueFemelle;
		this.plage = nomPlage;
	}


	/**
	 * Get the date of observation
	 * @return date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * Get the hour of observation
	 * @return time
	 */
	public Time getHeure() {
		return heure;
	}
	/**
	 * Get the coordx of observation
	 * @return coordx
	 */
	public double getCoordX() {
		return coordX;
	}
	/**
	 * Get the coordx of observation
	 * @return coordy
	 */
	public double getCoordY() {
		return coordY;
	}
	/**
	 * Get the observateur of observation
	 * @return coordx
	 */
	public int getObservateur() {
		return observateur;
	}


	/**
	 * Get the flights numbers
	 * @return number
	 */
	public int getNbEnvols() {
		return nbEnvols;
	}


	/**
	 * Get the nest id
	 * @return nest id
	 */
	public int getIdNid() {
		return idNid;
	}


	/**
	 * Get the protection
	 * @return number of the protection
	 */
	public int getProtection() {
		return protection;
	}


	/**
	 * Get the beach name
	 * @return beach name
	 */
	public String getNomPlage() {
		return plage;
	}


	/**
	 * Get the reason of the stop of observation
	 * @return reason
	 */
	public String getRaisonArretObservation() {
		return raisonArretObservation;
	}



	public String getBagueMale() {
		return bagueMale;
	}



	public String getBagueFemelle() {
		return bagueFemelle;
	}



	public String getPlage() {
		return plage;
	}

}

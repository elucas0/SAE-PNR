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
	 * @param date date of the observation
	 * @param heure time of the observation
	 * @param lieu location of the observation
	 * @param observateur list of the observers
	 * @param nature nature of the observation
	 * @param leNombre number of the observation
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



	public Date getDate() {
		return date;
	}

	public Time getHeure() {
		return heure;
	}

	public double getCoordX() {
		return coordX;
	}

	public double getCoordY() {
		return coordY;
	}

	public int getObservateur() {
		return observateur;
	}



	public int getNbEnvols() {
		return nbEnvols;
	}



	public int getIdNid() {
		return idNid;
	}



	public int getProtection() {
		return protection;
	}



	public String getNomPlage() {
		return plage;
	}



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

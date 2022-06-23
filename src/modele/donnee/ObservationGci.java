package modele.donnee;

import java.sql.Date;
import java.sql.Time;

public class ObservationGci {

    String natureObs;
	private int nombre;
    private int obsG;
    private int presentMaisNonObs;
    private int leNid;
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
	 * @param coordX location x of the observation
	 * @param coordY location y of the observation
	 * @param observateur list of the observers
	 * @param nature nature of the observation
	 * @param leNombre number of the observation
	 * @param leNid number of the observation
	 * @param presentMaisNonObs number of the observation
	 */
	public ObservationGci(int id, Date date, Time heure, double coordX, double coordY, int observateur, String nature, int leNombre, int leNid, int presentMaisNonObs) {

		this.obsG = id;
		this.date = date;
		this.heure = heure;
		this.coordX = coordX;
		this.coordY = coordY;
		this.observateur = observateur;
		this.natureObs = nature;
		this.nombre = leNombre;
		this.leNid = leNid;
		this.presentMaisNonObs = presentMaisNonObs;

	}

	//Getters and setters
	public String getNatureObs() {
		return natureObs;
	}

	public void setNatureObs(String natureObs) {
		this.natureObs = natureObs;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return obsG;
	}


	public int getObsG() {
		return obsG;
	}

	public int getPresentMaisNonObs() {
		return presentMaisNonObs;
	}

	public int getLeNid() {
		return leNid;
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




    
}

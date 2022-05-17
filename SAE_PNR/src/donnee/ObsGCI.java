package donnee;

import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;

public class ObsGCI extends Observation {

	ContenuNid natureObs;
	private int nombre;

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
	public ObsGCI(int id, Date date, Time heure, Lieu lieu, ArrayList<Observateur> observateur, ContenuNid nature, int leNombre) {
		super(id, date, heure, lieu, observateur);

		if (nature == null) {
			System.err.println("ObsGCI : nature should not be null");
		} else {
			this.natureObs = nature;
		}

		if (leNombre < 0) {
			System.err.println("ObsGCI : leNombre should not be negative");
		} else {
			this.nombre = leNombre;
		}
	}

	//Getters and setters
	public ContenuNid getNatureObs() {
		return natureObs;
	}

	public void setNatureObs(ContenuNid natureObs) {
		this.natureObs = natureObs;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return idObs;
	}

	public Date geDate() {
		return dateObs;
	}

	@Override
	public EspeceObservee especeObs() {
		// TODO Auto-generated method stub
		return null;
	}

}
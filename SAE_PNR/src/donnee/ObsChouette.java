package donnee;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;


public class ObsChouette extends Observation {


	private TypeObservation typeObs;



	/**
	 * 
	 * @param id
	 * @param date
	 * @param heure
	 * @param lieu
	 * @param observateur
	 * @param type
	 */
	public ObsChouette(int id, Date date, Time heure, Lieu lieu, ArrayList<Observateur> observateur, TypeObservation type) {
		super(id, date, heure, lieu, observateur);
		
	}

	public TypeObservation getTypeObs() {
		return typeObs;
	}

	public void setTypeObs(TypeObservation typeObs) {
		this.typeObs = typeObs;
	}


}
package donnee;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;


public class ObsBatracien extends Observation {

	private EspeceBatracien espece;
	private int nombreAdultes;
	private int nombreAmplexus;
	private int nombreTetard;
	private int nombrePonte;

	/**
	 * Generate an 
	 * @param id
	 * @param date
	 * @param heure
	 * @param lieu
	 * @param observateurs
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
		// TODO Auto-generated method stub
		return EspeceObservee.BATRACIEN;
	}





}
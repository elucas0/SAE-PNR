package modele.donnee;
import java.util.ArrayList;
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
	private int protocole;
	private Date date;
	private Time heure;
	private String typeObs;
	private Double coordx;
	private Double coordy;
	private String lenumIndividu;
	private String sexe;
	private String espece;

	/**
	 * Create the observation.
	 * @param id id of the observation
	 * @param date date of the observation
	 * @param heure time of the observation
	 * @param lieu location of the observation
	 * @param observateur list of the observers
	 * @param type the observation's type
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
	 */
	public EspeceObservee especeObs() {

		return EspeceObservee.CHOUETTE;
	}


}
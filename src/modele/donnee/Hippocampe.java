package modele.donnee;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;


/**
 * Create an observation about a seahorse
 */
public class Hippocampe{


	/**
	 * The fishing's type
	 */
	private int id;
	private Date date;
	private Time heure;
	private String peche;
	private Double coordx;
	private Double coordy;
	/**
	 * The specie
	 */
	private String espece;

	/**
	 * The gender
	 */
	private String sexe;

	private int eau;

	/**
	 * The height
	 */
	private double taille;

	/**
	 * If the seahorse is pregnant
	 */
	private boolean estGestant;
	private int gestant;
	/**
	 * Constructor that create the observation about the seahorse
	 * @param id id of the observation
	 * @param date date of the observation
	 * @param heure time of the observation
	 * @param lieu location of the observation
	 * @param observateur list of the observers
	 * @param laTaille the seahorse's height
	 * @param leTypePeche the fishing's type
	 * @param lEspece the seahorse's specie
	 * @param leSexe the seahorse's gender
	 */
	public Hippocampe(int id, Date date, Time heure,  Double x,Double y, String lEspece,  String leSexe,int eau, String peche,double taille,int gestant) {

		this.id=id;
		this.date=date;
		this.heure=heure;
		this.coordx=x;
		this.coordy=y;
		this.taille = taille;
		this.peche = peche;
		this.espece = lEspece;
		this.sexe = leSexe;
		this.eau=eau;
		this.gestant=gestant;
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


	public Double getCoordx() {
		return coordx;
	}


	public Double getCoordy() {
		return coordy;
	}


	public int getEau() {
		return eau;
	}


	public int getGestant() {
		return gestant;
	}


	/**
	 * Methode pour avoir l'espece de l'hippocampes
	 * @return l'espece de l'hippocampes
	 */
	public String getEspece() {
		return espece;
	}


	/**
	 * Methode pour avoir le sexe de l'hihppocampes
	 * @return le sexe de l'hippocampes
	 */
	public String getSexe() {
		return sexe;
	}


	/**
	 * Methode pour avoir la taille de l'ihppocampes
	 * @return la taille de l'hippocampes
	 */
	public double getTaille() {
		return taille;
	}


	/**
	 * Methode pour avoir le type de peche de l'hippocampes
	 * @return le type de peche
	 */
	public String getPeche() {
		return peche;
	}


	/**
	 * Methode pour savoir si l'hippocampes est gestant
	 * @return true si gestant, false sinon
	 */
	public boolean getEstGestant(){
		return estGestant;
	}


	/**
	 * Methode pour changer l'espece de l'hippocampe
	 * @param espece la nouvelle espece
	 */
	public void setEspece(String espece) {
		if(espece != null){
			this.espece = espece;
		}
		else{
			System.err.println("setEspece : paramètre erroné.");
		}
	}


	/**
	 * Methode pour changer le sexe de l'hippocampes
	 * @param sexe le nouveau sexe
	 */
	public void setSexe(String sexe) {
		if(sexe != null){
			this.sexe = sexe;
		}
		else{
			System.err.println("setSexe : paramètre erroné.");
		}
	}


	/**
	 * Methode pour changer la taille de l'hippocampes
	 * @param taille la nouvelle taille
	 */
	public void setTaille(double taille) {
		if(taille > 0){
			this.taille = taille;
		}
		else{
			System.err.println("setTaille : paramètre erroné.");
		}
	}


	/**
	 * Methode pour changer le type de peche
	 * @param typePeche le nouveau type de peche
	 */
	public void setTypePeche(String typePeche) {
		if(typePeche != null){
			this.typePeche = typePeche;
		}
		else{
			System.err.println("setTypePeche : paramètre erroné");
		}
	}


	/**
	 * Methode pour changer l'etat de gestation de l'hippocampes
	 * @param gestant le nouvelle etat
	 */
	public void setEstGestant(boolean gestant){
		if(sexe == "MALE"){
			if(gestant){
				this.estGestant = true;
			}
			else{
				this.estGestant = false;
			}
		}
		else if(sexe == "FEMELLE"){
			if(gestant){
				System.out.println("Erreur : un hippocampe femelle ne peut être gestant");
			}
			else{
				this.estGestant = false;

			}
		}
		else{
			if(gestant){
				this.estGestant = true;
				this.sexe = "MALE";
            }

		}
	}
	

	/**
	 * Get the class' specie
	 */
	public EspeceObservee especeObs() {
		return EspeceObservee.HIPPOCAMPE;
	}
}



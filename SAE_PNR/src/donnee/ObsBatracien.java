package donnee;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;


/**Class pour crée les observations des batraciens */
public class ObsBatracien extends Observation {
	/**Parametre pour les especes de Batraciens */
	EspeceBatracien espece;
	/**Parametre pour le nombre d'adultes */
	private int nombreAdultes;
	/**Parametre pour le nombre d'amplexus */
	private int nombreAmplexus;
	/**Parametre pour le nombre de tétard */
	private int nombreTetard;
	/**Parametre pour le nombre de ponte */
	private int nombrePonte;

	/**
	 * Constructeur pour crée les observations des batraciens
	 * @param id l'id de observation
	 * @param date date de l'observation
	 * @param heure heure de l'observation
	 * @param lieu lieu de l'observation
	 * @param observateurs nom des observateurs
	 * @param resObs 
	 * @param lEspece espece de l'observation
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


	/**
	 * Methode pour avoir l'espece du batracien
	 * @return l'espece de l'animal
	 */
	public EspeceBatracien getEspece() {
		return espece;
	}
	/**
	 * Methode pour avoir le nombre d'adultes
	 * @return le nombre d'adulte
	 */
	public int getNombreAdultes() {
		return nombreAdultes;
	}
	/**
	 * Methode pour avoir le nombre d'amplexus
	 * @return le nombre d'amplexus
	 */
	public int getNombreAmplexus() {
		return nombreAmplexus;
	}
	/**
	 * Methode pour avoir le nombre de ponte
	 * @return le nombre de ponte
	 */
	public int getNombrePonte() {
		return nombrePonte;
	}
	/**
	 * Methode pour avoir le nombre de tetard
	 * @return le nombre de tetard
	 */
	public int getNombreTetard() {
		return nombreTetard;
	}

	/**
	 * Methode pour changer l'espece des batraciens
	 * @param espece la nouvelle espece
	 */
	public void setEspece(EspeceBatracien espece) {
		if(espece != null){
			this.espece = espece;
		}
		else{
			System.err.println("setEspece : paramètre érroné.");
		}
	}
	/**
	 * Methode pour changer le nombre d'adulte
	 * @param nombreAdultes le nouveau nombre d'adulte
	 */
	public void setNombreAdultes(int nombreAdultes) {
		if(nombreAdultes >= 0){
			this.nombreAdultes = nombreAdultes;
		}
		else{
			System.err.println("setNombreAdultes : paramètre érroné.");
		}
	}
	/**
	 * Methode pour changer le nombre d'amplexus
	 * @param nombreAmplexus le nouveau nombre d'amplexus
	 */
	public void setNombreAmplexus(int nombreAmplexus) {
		if(nombreAmplexus >= 0){
			this.nombreAmplexus = nombreAmplexus;
		}
		else{
			System.err.println("setNombreAmplexus : paramètre érroné.");
		}
	}
	/**
	 * Methode pour changer le nombre de ponte
	 * @param nombrePonte le nouveau nombre de ponte
	 */
	public void setNombrePonte(int nombrePonte) {
		if(nombrePonte >= 0){
			this.nombrePonte = nombrePonte;
		}
		else{
			System.out.println("setNombrePonte : paramètre érroné.");
		}
	}
	/**
	 * Methode pour changer le nombre de tetard
	 * @param nombreTetard le nouveau nombre de tetard
	 */
	public void setNombreTetard(int nombreTetard) {
		if(nombreTetard >= 0){
			this.nombreTetard = nombreTetard;
		}
		else{
			System.err.println("setNombreTetard : paramètre érroné.");
		}
	}

	
	@Override
	public Date getDateObs() {
		return super.getDateObs();
	}
	@Override
	public Time getHeureObs() {
		return super.getHeureObs();
	}
	@Override
	public int getIdObs() {
		return super.getIdObs();
	}
	@Override
	public Collection<Observateur> getLesObservateurs() {
		return super.getLesObservateurs();
	}
	@Override
	public Lieu getLieuObs() {
		return super.getLieuObs();
	}

	@Override
	public void setDateObs(Date dateObs) {
		if(dateObs != null){
			super.setDateObs(dateObs);
		}
		else{
			System.err.println("setDateObs : paramètre érroné.");
		}
	}
	@Override
	public void setHeureObs(Time heureObs) {
		if(heureObs != null){
			super.setHeureObs(heureObs);
		}
		else{
			System.err.println("setHeureObs : paramètre érroné.");
		}
	}
	@Override
	public void setIdObs(int idObs) {
		if(idObs >= 0){
			super.setIdObs(idObs);
		}
		else{
			System.err.println("setIdObs : paramètre érroné.");
		}
	}
	@Override
	public void setLesObservateurs(Collection<Observateur> lesObservateurs) {
		if(lesObservateurs != null){
			super.setLesObservateurs(lesObservateurs);
		}
		else{
			System.err.println("setLesObservateur : paramètre érroné.");
		}
	}
	@Override
	public void setLieuObs(Lieu lieuObs) {
		if(lieuObs != null){
			super.setLieuObs(lieuObs);
		}
		else{
			System.err.println("setLieuObs : paramètre érroné.");
		}
	}




}
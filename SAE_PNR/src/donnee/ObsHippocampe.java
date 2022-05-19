package donnee;

public class ObsHippocampe extends Observation {

	private Peche typePeche;
	private EspeceHippocampe espece;
	private Sexe sexe;
	private double taille;
	private boolean estGestant;
	private int attribute;

	/**
	 * 
	 * @param id
	 * @param date
	 * @param heure
	 * @param lieu
	 * @param observateur
	 * @param laTaille
	 * @param leTypePeche
	 * @param lEspece
	 * @param leSexe
	 */
	public ObsHippocampe(int id, Date date, Time heure, Lieu lieu, ArrayList<Observateur> observateurs, double laTaille, Peche leTypePeche, EspeceHippocampe lEspece, Sexe leSexe) {
		super(id, date, heure, lieu, observateurs);

		if (laTaille > 0 && leTypePeche != null && lEspece != null && leSexe != null){
			this.taille = laTaille;
			this.typePeche = leTypePeche;
			this.espece = lEspece;
			this.sexe = leSexe;
		}
		else{
			System.err.println("ObsHippocampe : paramètre erroné.");
		}		
        throw new UnsupportedOperationException();
	

	}
	/**
	 * Methode pour avoir l'espece de l'hippocampes
	 * @return l'espece de l'hippocampes
	 */
	public EspeceHippocampe getEspece() {
		return espece;
	}
	/**
	 * Methode pour avoir le sexe de l'hihppocampes
	 * @return le sexe de l'hippocampes
	 */
	public Sexe getSexe() {
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
	public Peche getTypePeche() {
		return typePeche;
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
	public void setEspece(EspeceHippocampe espece) {
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
	public void setSexe(Sexe sexe) {
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
	public void setTypePeche(Peche typePeche) {
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
		if(sexe == MALE){
			if(gestant){
				this.estGestant = true;
			}
			else{
				this.estGestant = false;
			}
		}
		else if(sexe==FEMELLE){
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
				this.sexe = MALE;
            }

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
			System.err.println("setDateObs : paramètre erroné.");
		}
	}
	@Override
	public void setHeureObs(Time heureObs) {
		if(heureObs != null){
			super.setHeureObs(heureObs);
		}
		else{
			System.err.println("setHeureObs : paramètre erroné.");
		}
	}
	@Override
	public void setIdObs(int idObs) {
		if(idObs >= 0){
			super.setIdObs(idObs);
		}
		else{
			System.err.println("setIdObs : paramètre erroné.");
		}
	}
	@Override
	public void setLesObservateurs(Collection<Observateur> lesObservateurs) {
		if(lesObservateurs != null){
			super.setLesObservateurs(lesObservateurs);
		}
		else{
			System.err.println("setLesObservateur : paramètre erroné.");
		}
	}
	@Override
	public void setLieuObs(Lieu lieuObs) {
		if(lieuObs != null){
			super.setLieuObs(lieuObs);
		}
		else{
			System.err.println("setLieuObs : paramètre erroné.");
		}
	}
}



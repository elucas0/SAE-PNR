package donnee;
import java.sql.Date;
import java.sql.Time;
import java.util.*;

public class ObsLoutre extends Observation {

	private IndiceLoutre indice;

	/**
	 * 
	 * @param id
	 * @param date
	 * @param heure
	 * @param lieu
	 * @param observateurs
	 */
	public ObsLoutre(int id, Date date, Time heure, Lieu lieu, ArrayList<Observateur> observateurs, IndiceLoutre indice) {
		super(id, date, heure, lieu, observateurs);
		if(indice != null){
			this.indice = indice;
		}
		else{
			System.err.println("ObsLoutre : paramètre érroné");
		}
		throw new UnsupportedOperationException();
	}
	/**
	 * Methode pour avoir l'indice
	 * @return l'inice
	 */
	public IndiceLoutre getIndice() {
		return indice;
	}
	/**
	 * Methode pour changer l'indice
	 * @param indice le nouvel indice
	 */
	public void setIndice(IndiceLoutre indice) {
		if(indice != null){
			this.indice = indice;
		}
		else{
			System.err.println("setIndice : paramètre érroné");
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
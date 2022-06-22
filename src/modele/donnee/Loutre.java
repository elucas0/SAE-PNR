package modele.donnee;
import java.sql.Date;
import java.sql.Time;
import java.util.*;
/**Classe pour cree les observations des loutres */
public class Loutre {
	/**Parametre pour les indices des loutres */
	//private IndiceLoutre indice;
	private int id;
	private Date date;
	private Time heure;
	private Double coordx;
	private Double coordy;
	private String commune;
	private String lieudit;
	private String indice;
	/**
	 * Constructeur pour crée les observations des batraciens
	 * @param id l'id de observation
	 * @param date date de l'observation
	 * @param heure heure de l'observation
	 * @param lieu lieu de l'observation
	 * @param observateurs nom des observateurs
	 */
	public Loutre(int id, Date date, Time heure, Double x,Double y,String commune,String lieudit,String indice) {
		this.id=id;
		this.date=date;
		this.heure=heure;
		this.coordx=x;
		this.coordy=y;
		this.commune=commune;
		this.lieudit=lieudit;
		this.indice=indice;
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
	public String getCommune() {
		return commune;
	}
	public String getLieudit() {
		return lieudit;
	}
	public String getIndice() {
		return indice;
	}

}
package donnee;

import java.util.*;

public class NidGCI implements lObs {

	private Collection<ObsGCI> lesObservations;
	private int idNid;
	private int nbEnvol;
	private String nomPlage;

	/**
	 * 
	 * @param id
	 * @param plage
	 */
	public NidGCI(int id, String plage) {
		if(id<0)
			throw new IllegalArgumentException("id nidGCI < 0");
		else if (plage == null)
			throw new NullPointerException("plage null");
		else {
			this.idNid = id;
			this.nomPlage = plage;
			this.lesObservations = new ArrayList<ObsGCI>();
			this.nbEnvol = 0;
		}
	}

	/**
	 * Returns the date at wich the observation began
	 * @return the date at wich the observation began
	 */
	public Date dateDebutObs() {
		if (this.lesObservations.isEmpty())
			return null;
		else {
			Date d = this.lesObservations.iterator().next().getDate();
			for (ObsGCI o : this.lesObservations) {
				if (o.getDate().before(d))
					d = o.getDate();
			}
			return d;
		}	
	}

	/**
	 * Returns the date at wich the observation ended
	 * @return the date at wich the observation ended
	 */
	public Date dateFinObs() {
		if (this.lesObservations.isEmpty())
			return null;
		else {
			Date d = this.lesObservations.iterator().next().getDate();
			for (ObsGCI o : this.lesObservations) {
				if (o.getDate().after(d))
					d = o.getDate();
			}
			return d;
		}	
	}

	//Getters and setters
	public int getIdNid() {
		return idNid;
	}

	public void setIdNid(int idNid) {
		if(idNid > 0)
			this.idNid = idNid;
	}

	public int getNbEnvol() {
		return nbEnvol;
	}

	public void setNbEnvol(int nbEnvol) {
		if(nbEnvol > 0)
			this.nbEnvol = nbEnvol;
	}

	public String getNomPlage() {
		return nomPlage;
	}

	public void setNomPlage(String nomPlage) {
		if(nomPlage != null)
			this.nomPlage = nomPlage;
	}

	public Collection<ObsGCI> getLesObservations() {
		return lesObservations;
	}

	public void setLesObservations(Collection<ObsGCI> lesObservations) {
		if(lesObservations != null)
			this.lesObservations = lesObservations;
	}

	public void retireObservation(ObsGCI obs) {
		if(obs != null)
			this.lesObservations.remove(obs);
	}

	public boolean retireObs(int idObs) {
		boolean ret = false;
		Iterator<ObsGCI> it = this.lesObservations.iterator();
		while(it.hasNext() && !ret) {
			ObsGCI obs = it.next();
			if(obs.getId() == idObs) {
				it.remove();
				ret = true;
			}
		}
		return ret;
	}

	public int nbObs() {
		return this.lesObservations.size();
	}	

	public void videObs() {
		this.lesObservations.clear();
	}

	public void ajouteObs(Object obs) {
		if(obs instanceof ObsGCI) {
			this.lesObservations.add((ObsGCI) obs);
		}
	}

	/**
	 * Adds a list of observations to the list of observations.
	 */
	public void ajoutePlsObs(ArrayList obs) {
		if(obs != null)
			this.lesObservations.addAll(obs);
	}
}
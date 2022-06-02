package modele.traitement;
import java.sql.Date;

import modele.donnee.*;

/**
 * Create one top for an observation
 */
public class Sommet {

    /**id of the top */
    private int id;
    /**coordinates of the top */

    private Lieu coordLieu;

    /**Date of the top */
    private Date date;
    
    /**species of the top */
    private EspeceObservee espece;

    /**
     * Constructor of the class Sommet
     * @param id the id of the vertex
     * @param coord the coordinates of the vertex
     * @param date the date of the observation
     * @param espece the species of the observation
     */
    public Sommet(int id, Lieu coord, Date date, EspeceObservee espece){
        //The id must be over 0
        if(id >= 1){
            this.id = id;
        } else {
            throw new IllegalArgumentException("Sommet : Erreur dans l'id");
        }
        
        //The coordLieu must be not null
        if(coord != null){
            this.coordLieu = coord;
        } else {
            throw new IllegalArgumentException("Sommet : coord should not be null");
        }

        //The date must be not null
        if(date != null){
            this.date = date;
        } else{
            throw new IllegalArgumentException("Sommet : date should not be null");
        }

        //The espece must be not null
        if(espece != null){
            this.espece = espece;
        } else {
            throw new IllegalArgumentException("Sommet : espece should not be null");
        }
    }

    /**
     * Constructor of the class Sommet with an Observation
     * @param obs the Observation
     */
    public Sommet(Observation obs){
        if(obs != null){
            new Sommet(obs.getId(), obs.getLieu(), obs.getDate(), espece);
        }
        else{
            throw new IllegalArgumentException("Sommet : obs should not be null");
        }
        
    }

    /**
     * Calculate the distance between two vertices
     * @param som the second vertex
     * @return the distance between the two vertices
     */
    public double calculeDist(Sommet som){
        final int R = 6371; // Radious of the earth

        Double lat1 = this.getCoordLieu().getCoordX();
        Double lon1 = this.getCoordLieu().getCoordY();

        Double lat2 = som.getCoordLieu().getCoordX();
        Double lon2 = som.getCoordLieu().getCoordY();

        Double latDistance = toRad(lat2-lat1);
        Double lonDistance = toRad(lon2-lon1);

        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        Double resultat = R * c;
        
        
        System.out.println("The distance between two lat and long is::" + resultat);
        return resultat;
    }

    /**
     * Convert a degree to radian
     * @param value
     * @return
     */
    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }

    /**
     * Get the date of the observation
     * @return the date of the observation
     */
    public Date getDate() {
        return date;
    }

    /**
     * Get the id of the vertex
     * @return the id of the vertex
     */
    public int getId(){
        return this.id;
    }

    /**
     * Get the coordinates of the vertex, the place where the observation was made
     * @return the coordinates of the vertex
     */
    public Lieu getCoordLieu() {
        return coordLieu;
    }

    /**
     * Get the species of the observation
     * @return the species of the observation
     */
    public EspeceObservee getEspece() {
        return espece;
    }

    /**
     * Set the coordinates of the vertex, the place where the observation was made
     * @param coordLieu the coordinates of the vertex
     */
    public void setCoordLieu(Lieu coordLieu) {
        if (coordLieu != null) {
            this.coordLieu = coordLieu;
        } else {
            throw new IllegalArgumentException("Sommet : coordLieu should not be null");
        }
    }
    
    /**
     * Set the date of the observation
     * @param date the date of the observation
     */
    public void setDate(Date date) {
        if (date != null) {
            this.date = date;
        } else {
            throw new IllegalArgumentException("Sommet : date should not be null");
        }
    }

    /**
     * Set the species of the observation
     * @param espece the species of the observation
     */
    public void setEspece(EspeceObservee espece) {
        if (espece != null) {
            this.espece = espece;
        } else {
            throw new IllegalArgumentException("Sommet : espece should not be null");
        }
    }

    /**
     * Set the id of the vertex
     * @param id the id of the vertex
     */
    public void setId(int id) {
        if (id >= 1) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("Sommet : id should be over 0");
        }
    }
}

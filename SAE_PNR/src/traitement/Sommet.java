package traitement;
import java.sql.Date;
import donnee.*;

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
     * Generate a top
     * @param id id of the top
     * @param coord coordinates of the top
     * @param date date of the top
     * @param espece species of the top
     */
    public Sommet(int id, Lieu coord, Date date, EspeceObservee espece){
        if(id >= 1){
            this.id = id;
        }
        else{
            throw new IllegalArgumentException("Sommet : Erreur dans l'id");
        }
        
        if(coord != null){
            this.coordLieu = coord;
        }
        else{
            throw new IllegalArgumentException("Sommet : coord should not be null");
        }

        if(date != null){
            this.date = date;
        }
        else{
            throw new IllegalArgumentException("Sommet : date should not be null");
        }

        if(espece != null){
            this.espece = espece;
        }
        else{
            throw new IllegalArgumentException("Sommet : espece should not be null");
        }

    }

    /**
     * generate a top with an observation
     * @param obs observation wwith wich create the top
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
     * Method to calculate the distance between two tops 
     * @param som the top with wich calculate the distance
     * @return the distance between the two tops
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
     * Method to calculate the distance
     * @param value double value with wich the method calculate the distance
     * @return the distance
     */
    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }



    /**
     * Return the date of the top
	 * @return date of the top
     */
    public Date getDate() {
        return date;
    }
    /**
     * Return the id of the top
	 * @return id of the top
     */
    public int getId(){
        return this.id;
    }
    /**
     * Return the coordinates of the top
     * @return coordinates of the top
     */
    public Lieu getCoordLieu() {
        return coordLieu;
    }
    /**
     * Return the species of the top
     * @return species of the top
     */
    public EspeceObservee getEspece() {
        return espece;
    }

    /**
     * Set the coordinates of the top
     * @param coordLieu coordinates of the top
     */
    public void setCoordLieu(Lieu coordLieu) {
        this.coordLieu = coordLieu;
    }
    /**
     * Set the date of the top 	
	 * @param date date of the top
	 */
    public void setDate(Date date) {
        this.date = date;
    }
    /**
     * Set the species for the top
     * @param espece species of the top
     */
    public void setEspece(EspeceObservee espece) {
        this.espece = espece;
    }
    /**
     * Set the id of the top
	 *  @param id id of the top
	 */
    public void setId(int id) {
        this.id = id;
    }
}

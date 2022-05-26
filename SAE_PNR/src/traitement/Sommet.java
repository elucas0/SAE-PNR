package traitement;
import java.sql.Date;
import donnee.*;


public class Sommet {
    private int id;
    private Lieu coordLieu;
    private Date date;
    private EspeceObservee espece;

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

    public Sommet(Observation obs){
        if(obs != null){
            new Sommet(obs.getId(), obs.getLieu(), obs.getDate(), espece);
        }
        else{
            throw new IllegalArgumentException("Sommet : obs should not be null");
        }
        
    }

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

    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }




    public Date getDate() {
        return date;
    }
    public int getId(){
        return this.id;
    }
    public Lieu getCoordLieu() {
        return coordLieu;
    }
    public EspeceObservee getEspece() {
        return espece;
    }

    public void setCoordLieu(Lieu coordLieu) {
        this.coordLieu = coordLieu;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setEspece(EspeceObservee espece) {
        this.espece = espece;
    }
    public void setId(int id) {
        this.id = id;
    }
}

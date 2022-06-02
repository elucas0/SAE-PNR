package modele.donnee;
/**
 * Class for create a location with coordinate
 * */
public class Lieu{
	
	/**
	 * Longitude coordinate
	 **/
	private double xCoord;

	/**
	 * Latitude coordinate
	 **/

	private double yCoord;

	/**Constructor dof the class Lieu
	 * @param x Longitude coordinate
	 * @param y Latitude coordinate*/

	public Lieu(double x, double y){
		if (x==0){
			throw new IllegalArgumentException("Erreur dans la longitude ");
		}
		else{
			this.xCoord=x;
		}
		if (y==0){
			throw new IllegalArgumentException("Erreur dans la longitude ");
		}
		else{
			this.yCoord=y;
		}
	}
	/**Getter et Setter*/

	/**Return x coord
	 * @return x coord*/
	public double getCoordX(){
		return this.xCoord;
	}
	/**Set x coord
	 * @param x Longitude*/
	public void setCoordX(double x){
		this.xCoord=x;
	}
	/**return y coord 
	 * @return y coord*/
	public double getCoordY(){
		return this.yCoord;
	}
	/**Set y coord
	 * @param y Latitude*/
	public void setCoordY(double y){
		this.yCoord=y;
	}
}
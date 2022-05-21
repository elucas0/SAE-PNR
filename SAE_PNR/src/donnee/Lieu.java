package donnee;
public class Lieu{
	//Longitude coordinate
	private double xCoord;
	//Latitude coordinate
	private double yCoord;
	/**Constructor dof the class Lieu
	 * @param x Longitude coordinate
	 * @param y Latitude coordinate*/
	public Lieu(double x, double y){
		this.xCoord=x;
		this.yCoord=y;
	}

	/**
	 * Get the x coordinate 
	 * @return the x coordinate 
	 */
	public double getCoordX(){
		return this.xCoord;
	}

	public void setCoordX(double x){
		this.xCoord=x;
	}

	/**
	 * Get the y coordinate 
	 * @return the y coordinate 
	 */
	public double getCoordY(){
		return this.yCoord;
	}

	/**
	 * Set the y coordinate to a wanted one
	 * @param y the wanted y coordinate
	 */
	public void setCoordY(double y){
		this.yCoord=y;
	}
}
package donnee;
class Lieu{
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
	/**Getter et Setter*/
	public double getCoordX(){
		return this.xCoord;
	}
	public void setCoordX(double x){
		this.xCoord=x;
	}

	public double getCoordY(){
		return this.yCoord;
	}
	public void setCoordY(double y){
		this.yCoord=y;
	}
}
package fourmisses;

abstract public class Vector extends Pos{

	double speedX;
	double speedY;
	
	/////CONSTRUCTOR/////
	public Vector(double x, double y, double speedX, double speedY) {
		super(x, y);
		this.speedX = speedX;
		this.speedY = speedY;
	}
	
	/////METHODS/////
	public double getSpeedX() {
		return speedX;
	}
	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}
	public double getSpeedY() {
		return speedY;
	}
	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}
	
	
}

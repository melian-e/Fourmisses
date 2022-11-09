package fourmisses;

abstract public class Vector extends Pos{

	int speedX;
	int speedY;
	
	/////CONSTRUCTOR/////
	public Vector(int x, int y, int speedX, int speedY) {
		super(x, y);
		this.speedX = speedX;
		this.speedY = speedY;
	}
	
	/////METHODS/////
	public int getSpeedX() {
		return speedX;
	}
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
	public int getSpeedY() {
		return speedY;
	}
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
	
	
}

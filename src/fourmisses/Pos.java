package fourmisses;

abstract public class Pos {

	double x;
	double y;
	
	/////CONSTRUCTOR/////
	public Pos(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
	/////METHODS/////
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

	
}

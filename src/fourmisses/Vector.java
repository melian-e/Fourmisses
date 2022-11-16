package fourmisses;

abstract public class Vector extends Pos{

	double vecX;
	double vecY;
	
	/////CONSTRUCTOR/////
	public Vector(int x, int y, double vecX, double vecY) {
		super(x, y);
		this.vecX = vecX;
		this.vecY = vecY;
	}
	
	/////METHODS/////
	public double getVecX() {
		return vecX;
	}
	public void setVecX(double vecX) {
		this.vecX = vecX;
	}
	public double getVecY() {
		return vecY;
	}
	public void setVecY(double vecY) {
		this.vecY = vecY;
	}
	
	
}

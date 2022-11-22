package fourmisses;

public abstract class Pos {

	int x;
	int y;
	
	/////CONSTRUCTOR/////
	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
	/////METHODS/////
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public double dist(Pos obj) {
		
		return x;
	}

	
}


package fourmisses;

public class Food extends Obstacle{

	int stock;
	int decreaseValue = 20;
	
	public Food(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public int decrease() {
		stock -= decreaseValue;
		return decreaseValue;
	}
}

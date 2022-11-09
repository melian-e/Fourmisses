
package fourmisses;

public class Food extends Obstacle{

	int stock;
	int decreaseValue = 20;
	
	public int decrease() {
		stock -= decreaseValue;
		return decreaseValue;
	}
}

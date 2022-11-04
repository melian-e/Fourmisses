package fourmisses;

public class food extends obstacle{

	int stock;
	int decreaseValue = 20;
	
	public int decrease() {
		stock -= decreaseValue;
		return decreaseValue;
	}
}

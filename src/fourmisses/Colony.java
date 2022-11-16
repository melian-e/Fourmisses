package fourmisses;

public class Colony extends Obstacle{

	
	int health = 5000;
	
	/////CONSTRUCTOR/////
	public Colony(int x, int y, int health) {
		super(x,y);
		this.health = health;
	}

	
	/////METHODS////
	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	//fonctions à implémenter
		//      formation de fourmis par exemple
	
	
}

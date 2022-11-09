package fourmisses;

public class Controler {
	
	/*initialisation  obstacles, nourriture, class player*/

	Player player1;
	Player player2;
	Obstacle obstacle;
	
	

	public Controler() {
		// les variables eront calculées par des méthodes auparavant (symétrie notamment)
		int coordColony1[] = {40,40};
		//création obstacle et bouffe
		
		//symétrie
		this.player1 = new Player( 0, 3, 0, 5, 1, coordColony1[0], coordColony1[1]);
		this.player2 = new Player(0, 3, 0, 5, 1, 5, 5);
	}
}

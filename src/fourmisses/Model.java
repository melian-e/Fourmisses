package fourmisses;

import java.util.ArrayList;
import java.util.List;

public class Model {

	
	/*initialisation  obstacles, nourriture, class player*/

	Player player1;
	Player player2;
	List<Obstacle> tabObstacle;
	
	
	

	public Model() {
		// les variables eront calculées par des méthodes auparavant (symétrie notamment)
		int coordColony1[] = {40,40};
		//création obstacle et bouffe
		List<List<Integer>> tabCoords = new ArrayList<List<Integer>>();
		for(int i = 0; i<100; i++) {
			int randomx = (int)Math.random();
			int randomy = (int)Math.random();
			List<Integer> tmp = new ArrayList<Integer>();
			tmp.add(randomx);
			tmp.add(randomy);
			tabCoords.add(tmp);
		}
		//symétrie
		this.player1 = new Player( 0, 3, 0, 5, 1, coordColony1[0], coordColony1[1]);
		this.player2 = new Player(0, 3, 0, 5, 1, 5, 5);
	}
}

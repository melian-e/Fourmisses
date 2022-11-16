package fourmisses;

import java.util.ArrayList;
import java.util.List;

public class Model {

	
	/*initialisation  obstacles, nourriture, class player*/

	Player player1;
	Player player2;
	int[] gameHeightWidth = {1900, 1000};
	List<Obstacle> tabObstacle;
	
	
	

	public Model() {
		// les variables seront calculées par des méthodes auparavant (symétrie notamment)
		int totalObstacle = 30;
		
		//création coordonnées colony, obstacle et bouffe
		double coordColony1[] = {40,40};
		List<double[]> tabCoordsObstacle = new ArrayList<double[]>();
		for(int i = 0; i<totalObstacle/2; i++) {
			double randomx = Math.random()*gameHeightWidth[0];
			double randomy = Math.random()*gameHeightWidth[1];
			double tmp[] = {randomx,randomy};
			tabCoordsObstacle.add(tmp);
		}
		
		//symétrie
		double coordColony2[] = {gameHeightWidth[0] - coordColony1[0], gameHeightWidth[1] - coordColony1[1]};
		for(int i = 0; i<totalObstacle/2; i++) {
			double[] tmp = tabCoordsObstacle.get(i);
			tmp[0] = gameHeightWidth[0] - tmp[0];
			tmp[1] = gameHeightWidth[1] - tmp[1];
			tabCoordsObstacle.add(tmp);
		}
		
		
		
		//création des instances
		this.player1 = new Player( 0, 3, 0, 5, 1, coordColony1[0], coordColony1[1]);
		this.player2 = new Player(0, 3, 0, 5, 1, coordColony2[0], coordColony2[1]);
	}
}

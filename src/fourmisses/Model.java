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
		int coordColony1[] = {40,40};
		List<int[]> tabCoordsObstacle = new ArrayList<int[]>();
		for(int i = 0; i<totalObstacle/2; i++) {
			int randomx = (int)(Math.random()*gameHeightWidth[0]);
			int randomy = (int)(Math.random()*gameHeightWidth[1]);
			int tmp[] = {randomx,randomy};
			tabCoordsObstacle.add(tmp);
		}
		
		//symétrie
		int coordColony2[] = {gameHeightWidth[0] - coordColony1[0], gameHeightWidth[1] - coordColony1[1]};
		for(int i = 0; i<totalObstacle/2; i++) {
			int[] tmp = tabCoordsObstacle.get(i);
			tmp[0] = gameHeightWidth[0] - tmp[0];
			tmp[1] = gameHeightWidth[1] - tmp[1];
			tabCoordsObstacle.add(tmp);
		}
		
		
		
		//création des instances
		this.player1 = new Player( 0, 3, 0, 5, 1, coordColony1[0], coordColony1[1]);
		this.player2 = new Player(0, 3, 0, 5, 1, coordColony2[0], coordColony2[1]);
	}
}

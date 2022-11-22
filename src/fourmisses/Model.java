package fourmisses;

import java.util.ArrayList;
import java.util.List;

public class Model {
	Player player1;
	Player player2;
	int[] gameHeightWidth = new int[2];
	List<Obstacle> tabObstacle;
	List<Food> tabFood;

	/*initialisation  obstacles, nourriture, class player*/	
	public Model(int Height, int Width) {
		// les variables seront calculées par des méthodes auparavant (symétrie notamment)
		int totalObstacle = 30;
		this.gameHeightWidth[0] = Height;
		this.gameHeightWidth[1] = Width;
		
		//création coordonnées colony, obstacle et bouffe
		int coordColony1[] = {40,40};
		List<int[]> tabCoordsObstacle = new ArrayList<int[]>();
		for(int i = 0; i<totalObstacle/2; i++) {
			int randomx = (int)(Math.random()*this.gameHeightWidth[0]);
			int randomy = (int)(Math.random()*this.gameHeightWidth[1]);
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

		this.tabObstacle.add(player1.getColony());
		this.tabObstacle.add(player2.getColony());
		for(int i = 0; i<totalObstacle; i++) {
			this.tabObstacle.addAll(wallCreation(tabCoordsObstacle.get(i)[0],tabCoordsObstacle.get(i)[1])) ;
		}
	}
	
	public List<Wall> wallCreation(int x, int y){//créations des obstacles, potentiellement une usine à gaz
		int radius = (int)(5+Math.random()*10);//largeur max obstacle : 15 
		List<Wall> tabWall = new ArrayList<Wall>();
		int xtmp = (int)(Math.cos(0)*Math.sqrt(radius));
		int ytmp = (int)(Math.sin(0)*Math.sqrt(radius));
		tabWall.add(new Wall(xtmp, ytmp));
		double pas = Math.PI/20;
		for(double i = pas; i < Math.PI/2; i=i+pas) {
			xtmp = (int)(Math.cos(i)*Math.sqrt(radius));
			ytmp = (int)(Math.sin(i)*Math.sqrt(radius));
			if(tabWall.get(tabWall.size()-1).getX()!=xtmp || tabWall.get(tabWall.size()-1).getY()!=ytmp) {
				tabWall.add(new Wall(x+xtmp, y+ytmp));
			};
		}
		for(int i = 0; i < tabWall.size(); i++) {
			xtmp=tabWall.get(i).getX();
			ytmp=tabWall.get(i).getY();
			tabWall.add(new Wall(x-xtmp, y-ytmp));
			tabWall.add(new Wall(x-xtmp, y+ytmp));
			tabWall.add(new Wall(x+xtmp, y-ytmp));
		}
		
		return tabWall;
	}
	
	void nextIteration() {
		
		
		//calcul prochaine pos fourmis
		Ant[][] tabAnt = this.player1.gettabAnt();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < tabAnt[i].length; j++) {
				Ant ant = tabAnt[i][j];
				switch(i) {
					case 0:
						if(ant.isOnTrack()) {
							if(true) {
								
							}
							else {
								ant.followTrack();								
							}
						}						
						break;
					case 1:
						
						break;
					case 2:
						
						break;
				}
				

				
			}
		}
		this.player1.settabAnt(tabAnt);
		//calcul prochaine pos fourmis player2
		
		//
		
	}
}

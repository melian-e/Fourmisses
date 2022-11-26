package fourmisses;

import java.util.ArrayList;
import java.util.List;

public class Model {
	Player player1;
	Player player2;
	int[] gameHeightWidth = new int[2];
	List<Obstacle> tabObstacle = new ArrayList<Obstacle>();
	List<Food> tabFood = new ArrayList<Food>();
	int decompoTrackTot;
	int stockFoodInit = 300;
	int totalObstacleFood = 2;
	
	
	/*initialisation  obstacles, nourriture, class player*/	
	public Model(int Height, int Width) {
		// initialisation : les variables seront calculées par des méthodes auparavant (symétrie notamment)
		this.gameHeightWidth[0] = Height;
		this.gameHeightWidth[1] = Width;
		
		//création coordonnées colony, obstacle et bouffe
		double coordColony1[] = {40,40};
		List<double[]> tabCoordsObstacle = new ArrayList<double[]>();
		for(int i = 0; i<totalObstacleFood/2; i++) {
			double randomx = (Math.random()*this.gameHeightWidth[0]);
			double randomy = (Math.random()*this.gameHeightWidth[1]);
			double tmp[] = {randomx,randomy};
			tabCoordsObstacle.add(tmp);
		}
		
		//symétrie
		double coordColony2[] = {gameHeightWidth[0] - coordColony1[0], gameHeightWidth[1] - coordColony1[1]};
		for(int i = 0; i<totalObstacleFood/2; i++) {
			double[] tmp = tabCoordsObstacle.get(i);
			tmp[0] = gameHeightWidth[0] - tmp[0];
			tmp[1] = gameHeightWidth[1] - tmp[1];
			tabCoordsObstacle.add(tmp);
		}
		
		//création des instances
		this.player1 = new Player( 0, 3, 0, 5, 1, coordColony1[0], coordColony1[1]);
		this.player2 = new Player(0, 3, 0, 5, 1, coordColony2[0], coordColony2[1]);

		this.tabObstacle.add(player1.getColony());
		this.tabObstacle.add(player2.getColony());
		
		for(int i = 0; i<tabCoordsObstacle.size()/2; i++) {
			List<Wall> wall = this.wallCreation(tabCoordsObstacle.get(i)[0],tabCoordsObstacle.get(i)[1]);
			tabObstacle.addAll(wall);
		}
		for(int i = tabCoordsObstacle.size()/2; i<tabCoordsObstacle.size(); i++) {
			List<Food> food = foodCreation(tabCoordsObstacle.get(i)[0],tabCoordsObstacle.get(i)[1], stockFoodInit);
			tabFood.addAll(food);
		}
	}
	
	public List<Wall> wallCreation(double x, double y){//créations des obstacles, potentiellement une usine à gaz
		int radius = (int)(1+Math.random()*2);//largeur max obstacle : 15 
		List<Wall> tabWall = new ArrayList<Wall>();
		
		double xtmp = (Math.cos(0)*Math.sqrt(radius));
		double ytmp = (Math.sin(0)*Math.sqrt(radius));
		tabWall.add(new Wall(x+xtmp, y+ytmp));
		tabWall.add(new Wall(x-xtmp, y-ytmp));
		tabWall.add(new Wall(x-xtmp, y+ytmp));
		tabWall.add(new Wall(x+xtmp, y-ytmp));
		
		double pas = 0.2;
		for(double i = pas; i < Math.PI/2; i=i+pas) {
			xtmp = Math.cos(i)*Math.sqrt(radius);
			ytmp = Math.sin(i)*Math.sqrt(radius);
			
			tabWall.add(new Wall(x-xtmp, y-ytmp));
			tabWall.add(new Wall(x-xtmp, y+ytmp));
			tabWall.add(new Wall(x+xtmp, y-ytmp));			
			tabWall.add(new Wall(x+xtmp, y+ytmp));
		}
		return tabWall;
	}
	
	public List<Food> foodCreation(double x, double y, int stockFoodInit){//créations des obstacles, potentiellement une usine à gaz
		int radius = (int)(1+Math.random()*2);//largeur max obstacle : 15 
		List<Food> tabFood = new ArrayList<Food>();
		
		double xtmp = (Math.cos(0)*Math.sqrt(radius));
		double ytmp = (Math.sin(0)*Math.sqrt(radius));
		tabFood.add(new Food(x+xtmp, y+ytmp,stockFoodInit));
		
		double pas = 0.2;
		for(double i = pas; i < Math.PI/2; i=i+pas) {
			xtmp = Math.cos(i)*Math.sqrt(radius);
			ytmp = Math.sin(i)*Math.sqrt(radius);
			
			tabFood.add(new Food(x-xtmp, y-ytmp,stockFoodInit));
			tabFood.add(new Food(x-xtmp, y+ytmp,stockFoodInit));
			tabFood.add(new Food(x+xtmp, y-ytmp,stockFoodInit));			
			tabFood.add(new Food(x+xtmp, y+ytmp,stockFoodInit));
		}
		return tabFood;
	}
	
	public ArrayList<Track> TrackCreation(int x, int y, int speedX, int speedY, boolean type, int decomposition){
		
		ArrayList<Track> track = new ArrayList<Track>();
		track.add(new Track(x, y, speedX, speedY, type, decomposition));
		
		
		return track;
	}
	
	void nextIteration() {
		//calcul prochaine pos fourmis
		player1.dispatchWorker();
		
		//calcul prochaine pos fourmis player2
		player2.dispatchWorker();
		
		//

	}
	
	void updateView() {
		
		//envoie des coords des obstacles
		List<double[]> tabCoordsObstacle = new ArrayList<double[]>();
		for(int i = 0; i<tabObstacle.size(); i++) {
			double tmpx = this.tabObstacle.get(i).getX();
			double tmpy = this.tabObstacle.get(i).getY();
			double tmp[] = {tmpx,tmpy};
			
			tabCoordsObstacle.add(tmp);
		}
		//envoie des coords de la bouffe et la quantité
		List<double[]> tabCoordsFood = new ArrayList<double[]>();
		for(int i = 0; i<tabFood.size(); i++) {
			double tmpx = this.tabFood.get(i).getX();
			double tmpy = this.tabFood.get(i).getY();
			double purcentage = (this.tabFood.get(i).getStock()/stockFoodInit)*100;
			double tmp[] = {tmpx,tmpy,purcentage};
			
			tabCoordsFood.add(tmp);
		}
		
	
		for(int i = 0; i<tabObstacle.size(); i++) {
			System.out.print(tabCoordsObstacle.get(i)[0]);
			System.out.print(" ");
			System.out.print(tabCoordsObstacle.get(i)[1]);
			System.out.print("\n");
		}
	}
}

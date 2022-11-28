package com.fourmisses.fourmies;

import java.util.ArrayList;
import java.util.List;

public class Model {
	Player player1;
	Player player2;
	double[] gameHeightWidth = new double[2];
	List<Obstacle> tabObstacle = new ArrayList<Obstacle>();
	List<Food> tabFood = new ArrayList<Food>();
	int decompoTrackTot;
	int stockFoodInit = 300;
	int totalObstacleFood = 1000;
	
	
	/*initialisation  obstacles, nourriture, class player*/	
	public Model(double Height, double Width) {
		// initialisation : les variables seront calculées par des méthodes auparavant (symétrie notamment)
		this.gameHeightWidth[0] = Height;
		this.gameHeightWidth[1] = Width;
		
		//création coordonnées colony, obstacle et bouffe
		double coordColony1[] = {40,40};
		List<double[]> tabCoordsObstacle = new ArrayList<double[]>();
		for(int i = 0; i<totalObstacleFood/2; i++) {
			double randomx = (Math.random()*this.gameHeightWidth[0]);
			double randomy = (Math.random()*this.gameHeightWidth[1]/2);
			double tmp[] = {randomx,randomy};
			tabCoordsObstacle.add(tmp);
		}
		
		//symétrie
		double coordColony2[] = {gameHeightWidth[0] - coordColony1[0], gameHeightWidth[1] - coordColony1[1]};
		for(int i = 0; i<totalObstacleFood/2; i++) {
			double randomx = gameHeightWidth[0] - tabCoordsObstacle.get(i)[0];
			double randomy = gameHeightWidth[1] - tabCoordsObstacle.get(i)[1];
			double tmp[] = {randomx,randomy};
			tabCoordsObstacle.add(tmp);
		}
		
		//création des instances
		this.player1 = new Player( 0, 3, 0, 5, 1, coordColony1[0], coordColony1[1]);
		this.player2 = new Player(0, 3, 0, 5, 1, coordColony2[0], coordColony2[1]);

//		this.tabObstacle.add(player1.getColony());
//		this.tabObstacle.add(player2.getColony());
		
		for(int i = 0; i<tabCoordsObstacle.size(); i+=2) {
			List<Wall> wall = this.wallCreation(tabCoordsObstacle.get(i)[0],tabCoordsObstacle.get(i)[1]);
			tabObstacle.addAll(wall);
		}
		for(int i = 1; i<tabCoordsObstacle.size(); i+=2) {
			List<Food> food = foodCreation(tabCoordsObstacle.get(i)[0],tabCoordsObstacle.get(i)[1], stockFoodInit);
			tabFood.addAll(food);
		}
	}
	
	public List<Wall> wallCreation(double x, double y){//créations des obstacles, potentiellement une usine à gaz
		int radius = (int)(5+Math.random()*10);//largeur max obstacle : 15
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
		int radius = (int)(5+Math.random()*10);//largeur max obstacle : 15
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
	
	void nextIteration(int tick) {
		//calcul prochaine pos fourmis
		player1.dispatchWorker();
		
		//calcul prochaine pos fourmis player2
		player2.dispatchWorker();

		if(tick%100 == 0) {
			player1.createTrack(tabFood);
			player2.createTrack(tabFood);
		}
	}
	
	List<double[]>[] updateView() {
		//envoie des coords des fourmis rouges
		List<double[]> tabCoordsRouge = new ArrayList<double[]>();
		for(int i = 0; i<player1.getTabAnt().size(); i++) {
			for(int j = 0; j<player1.getTabAnt().get(i).size(); j++) {
				double tmpx = player1.getTabAnt().get(i).get(j).getX();
				double tmpy = player1.getTabAnt().get(i).get(j).getY();
				double tmp[] = {tmpx,tmpy};
				tabCoordsRouge.add(tmp);
			}
		}

		//envoie des coords des fourmis bleues
		List<double[]> tabCoordsBleu = new ArrayList<double[]>();
		for(int i = 0; i<player2.getTabAnt().size(); i++) {
			for(int j = 0; j<player2.getTabAnt().get(i).size(); j++) {
				double tmpx = player2.getTabAnt().get(i).get(j).getX();
				double tmpy = player2.getTabAnt().get(i).get(j).getY();
				double tmp[] = {tmpx,tmpy};
				tabCoordsBleu.add(tmp);
			}
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

		//envoie des coords des obstacles
		List<double[]> tabCoordsObstacles = new ArrayList<double[]>();
		for(int i = 0; i<tabObstacle.size(); i++) {
			double tmpx = this.tabObstacle.get(i).getX();
			double tmpy = this.tabObstacle.get(i).getY();
			double tmp[] = {tmpx,tmpy};
			
			tabCoordsObstacles.add(tmp);
		}

		List<double[]> colony1 = new ArrayList<double[]>();
		for(int i = 0; i<1; i++) {
			double tmpx = this.player1.getColony().getX();
			double tmpy = this.player1.getColony().getY();
			double tmp[] = {tmpx,tmpy};
			colony1.add(tmp);
		}

		List<double[]> colony2 = new ArrayList<double[]>();
		for(int i = 0; i<1; i++) {
			double tmpx = this.player1.getColony().getX();
			double tmpy = this.player1.getColony().getY();
			double tmp[] = {tmpx,tmpy};
			colony2.add(tmp);
		}

//		for(int i = 0; i<tabCoordsFood.size(); i++) {
//			System.out.print(tabCoordsFood.get(i)[0]);
//			System.out.print(" ");
//			System.out.print(tabCoordsFood.get(i)[1]);
//			System.out.print("\n");
//		}

		List<double[]>[] data = new List[6];
		data[0] = tabCoordsBleu;
		data[1] = tabCoordsRouge;
		data[2] = tabCoordsFood;
		data[3] = tabCoordsObstacles;
		data[4] = colony1;
		data[5] = colony2;
		return data;
	}
}

package com.fourmisses.fourmies;

import java.util.ArrayList;
import java.util.List;

public class Player {


	int globalFood;
	Colony colony;
	int nbAntType = 3;	// Worker = 1  (id 0) / Warrior = 2 (id 1) / Explorer = 3 (id 2) 
	
	int nbWarrior; // nombre de guerrieres
	int nbWorker;	// nombre d'ouvrières
	int nbExplorer;	// nombre d'exploratrices
	List<ArrayList<Ant>> tabAnt = new ArrayList<ArrayList<Ant>>();	//tableau qui contient toutes les fourmis
	List<ArrayList<Track>> tabTracks = new ArrayList<ArrayList<Track>>();
	List<Integer> tabWorkerOnTracks = new ArrayList<Integer>();
	int decompoTrackTot = 1;
	
	/////CONSTRUCTOR/////
	public Player(int globalFood, int nbAntType, int nbWarrior, int nbWorker, int nbExplorer,double coordColony1, double coordColony12) {
		super();
		this.globalFood = globalFood;
		this.nbAntType = nbAntType;
		this.nbWarrior = nbWarrior;
		this.nbWorker = nbWorker;
		this.nbExplorer = nbExplorer;
		this.colony = new Colony(coordColony1, coordColony12, 1800);

		this.tabAnt.add(new ArrayList<Ant>());
		for(int i = 0; i < nbWorker; i++) {
			this.tabAnt.get(0).add(new Worker(colony.getX(), colony.getY(), 0,0,false,this.tabAnt.size(),100,100));
		}
		this.tabAnt.add(new ArrayList<Ant>());
		for(int i = 0; i < nbWarrior; i++) {
			this.tabAnt.get(1).add(new Warrior(colony.getX(), colony.getY(), 0,0,false,this.tabAnt.size(),100,100));
		}
		this.tabAnt.add(new ArrayList<Ant>());
		for(int i = 0; i < nbExplorer; i++) {
			this.tabAnt.get(2).add(new Explorer(colony.getX(), colony.getY(), 0,0,false,this.tabAnt.size(),100,100));
		}
	}
	
	
	/////METHODS/////
	/**
	 * @return the globalFood
	 */
	public int getGlobalFood() {
		return globalFood;
	}
	
	
	/**
	 * @param globalFood the globalFood to set
	 */
	public void setGlobalFood(int globalFood) {
		this.globalFood = globalFood;
	}
	
	
	/**
	 * @return the nbWarrior
	 */
	public int getNbWarrior() {
		return nbWarrior;
	}
	
	
	/**
	 * @param nbWarrior the nbWarrior to set
	 */
	public void setNbWarrior(int nbWarrior) {
		this.nbWarrior = nbWarrior;
	}
	
	
	/**
	 * @return the nbWorker
	 */
	public int getNbWorker() {
		return nbWorker;
	}
	
	
	/**
	 * @param nbWorker the nbWorker to set
	 */
	public void setNbWorker(int nbWorker) {
		this.nbWorker = nbWorker;
	}
	
	
	/**
	 * @return the nbExplorer
	 */
	public int getNbExplorer() {
		return nbExplorer;
	}
	
	
	/**
	 * @param nbExplorer the nbExplorer to set
	 */
	public void setNbExplorer(int nbExplorer) {
		this.nbExplorer = nbExplorer;
	}
	
	
	/**
	 * @return the tabAnt
	 */
	public List<ArrayList<Ant>> getTabAnt() {
		return tabAnt;
	}
	
	
	/**
	 * @param tabAnt the tabAnt to set
	 */
	public void setTabAnt(List<ArrayList<Ant>> tabAnt) {
		this.tabAnt = tabAnt;
	}
	
	
	/**
	 * @return the nbAntType
	 */
	public int getnbAntType() {
		return nbAntType;
	}


	public Colony getColony() {
		return colony;
	}


	public List<ArrayList<Track>> getTabTracks() {
		return tabTracks;
	}


	public void setTabTracks(List<ArrayList<Track>> tabTracks) {
		this.tabTracks = tabTracks;
	}

	public void addWorker() {
		nbWorker+=1;
		this.tabAnt.get(0).add(new Worker(colony.getX(), colony.getY(), 0,0,false,this.tabAnt.size(),100,100));
	}
	public int getDecompoTrackTot() {
		this.decompoTrackTot = 1;

		for(int j = 0; j < tabTracks.size(); j++) {
			this.decompoTrackTot += this.tabTracks.get(j).get(0).getDecompo();
		}
		return this.decompoTrackTot;
	}
	
	public void dispatchWorker() {
		this.getDecompoTrackTot();
		for(int j = 0; j < tabAnt.get(0).size(); j++) {
			Ant ant = tabAnt.get(0).get(j);
			if(ant.isOnTrack()) {
				ant.followTrack();
			}
			else {
				if(tabTracks.size()>0){
					double min = (tabWorkerOnTracks.get(0)/tabAnt.get(0).size())-(tabTracks.get(0).get(0).getDecompo()/decompoTrackTot);
					int IDMin = 0;
					for(int i = 1; i < tabTracks.size(); i++) {
						if((tabWorkerOnTracks.get(i)/tabAnt.get(0).size())-(tabTracks.get(i).get(0).getDecompo()/decompoTrackTot)<min) {
							min = (tabWorkerOnTracks.get(i)/tabAnt.get(0).size())-(tabTracks.get(i).get(0).getDecompo()/decompoTrackTot);
							IDMin = i;
						}
					}

					ant.startTrack(tabTracks.get(IDMin));
					int worker = this.tabWorkerOnTracks.get(IDMin);
					worker++;
				}
			}
		}
	}

	public void createTrack(List<Food> tabFood){

		double minVal = this.colony.dist(tabFood.get(0));
		int id = 0;
		for(int i = 1; i < tabFood.size(); i++){
			if(this.colony.dist(tabFood.get(i)) < minVal)
				minVal = this.colony.dist(tabFood.get(i));
			id = i;
		}

		this.tabTracks.add(TrackCreation(tabFood.get(id).getX(),tabFood.get(id).getY()));
		this.tabWorkerOnTracks.add(0);
	}
	public ArrayList<Track> TrackCreation(double x, double y){
		System.out.println("Nouvelle track");
		ArrayList<Track> track = new ArrayList<Track>();

		double tmpx = this.colony.getX();
		double tmpy = this.colony.getY();

		double tmpvecx = 10;
		double tmpvecy = 0;

		if(tmpx > x) {
			while(tmpx > x) {
				track.add(new Track(tmpx, tmpy, tmpvecx, tmpvecy, false, 100));
				tmpx -= tmpvecx;
			}
			track.get(track.size()-1).setX(x);
		}
		else {
			while(tmpx < x) {
				track.add(new Track(tmpx, tmpy, tmpvecx, tmpvecy, false, 100));
				tmpx += tmpvecx;
			}
			track.get(track.size()-1).setX(x);
		}

		tmpvecx = 0;
		tmpvecy = 10;

		if(tmpy > y) {
			while(tmpy > y) {
				track.add(new Track(tmpx, tmpy, tmpvecx, tmpvecy, false, 100));
				tmpy-=tmpvecy;
			}
			track.get(track.size()-1).setY(y);
		}
		else {
			while(tmpy < y) {
				track.add(new Track(tmpx, tmpy, tmpvecx, tmpvecy, false, 100));
				tmpy+=tmpvecy;
			}
			track.get(track.size()-1).setY(y);
		}

		double tmpx2 = this.colony.getX();
		double tmpy2 = this.colony.getY();

		tmpvecx = 10;
		tmpvecy = 0;

		if(tmpx > tmpx2) {
			while(tmpx > tmpx2) {
				track.add(new Track(tmpx, tmpy, tmpvecx, tmpvecy, false, 100));
				tmpx -= tmpvecx;
			}
			track.get(track.size()-1).setX(tmpx2);
		}
		else {
			while(tmpx < tmpx2) {
				track.add(new Track(tmpx, tmpy, tmpvecx, tmpvecy, false, 100));
				tmpx += tmpvecx;
			}
			track.get(track.size()-1).setX(tmpx2);
		}

		tmpvecx = 0;
		tmpvecy = 10;

		if(tmpy > tmpy2) {
			while(tmpy > tmpy2) {
				track.add(new Track(tmpx, tmpy, tmpvecx, tmpvecy, false, 100));
				tmpy-=tmpvecy;
			}
			track.get(track.size()-1).setY(tmpy2);
		}
		else {
			while(tmpy < tmpy2) {
				track.add(new Track(tmpx, tmpy, tmpvecx, tmpvecy, false, 100));
				tmpy+=tmpvecy;
			}
			track.get(track.size()-1).setY(tmpy2);
		}

		return track;
	}
}
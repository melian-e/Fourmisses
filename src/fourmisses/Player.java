package fourmisses;

import java.util.ArrayList;
import java.util.List;

public class Player {


	int globalFood;
	Colony colony;
	int nbAntType = 3;	// Worker = 1  (id 0) / Warrior = 2 (id 1) / Explorer = 3 (id 2) 
	
	int nbWarrior; // nombre de guerrieres
	int nbWorker;	// nombre d'ouvrières
	int nbExplorer;	// nombre d'exploratrices
	Ant[][] tabAnt = new Ant[nbAntType][];	//tableau qui contient toutes les fourmis
	List<ArrayList<Track>> tabTracks = new ArrayList<ArrayList<Track>>();
	List<Integer> tabWorkerOnTracks = new ArrayList<Integer>();
	int decompoTrackTot = 0;
	
	/////CONSTRUCTOR/////
	public Player(int globalFood, int nbAntType, int nbWarrior, int nbWorker, int nbExplorer,double coordColony1, double coordColony12) {
		super();
		this.globalFood = globalFood;
		this.nbAntType = nbAntType;
		this.nbWarrior = nbWarrior;
		this.nbWorker = nbWorker;
		this.nbExplorer = nbExplorer;
		this.colony = new Colony(coordColony1, coordColony12, 1800);
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
	public Ant[][] gettabAnt() {
		return tabAnt;
	}
	
	
	/**
	 * @param tabAnt the tabAnt to set
	 */
	public void settabAnt(Ant[][] tabAnt) {
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


	public int getDecompoTrackTot() {
		for(int j = 0; j < tabTracks.size(); j++) {
			this.decompoTrackTot += this.tabTracks.get(j).get(0).getDecompo();
		}
		return this.decompoTrackTot;
	}
	
	public void dispatchWorker() {
		for(int j = 0; j < tabAnt[0].length; j++) {
			Ant ant = tabAnt[0][j];
			if(ant.isOnTrack()) {
				if(true) {
					ant.followTrack();										
				}
			}
			else {
				if(tabTracks.size() > 1) {
					
				}
				else if(tabTracks.size() == 1) {
					
				}
			}
		}
	}
}
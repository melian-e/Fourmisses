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


	public int getDecompoTrackTot() {
		for(int j = 0; j < tabTracks.size(); j++) {
			this.decompoTrackTot += this.tabTracks.get(j).get(0).getDecompo();
		}
		return this.decompoTrackTot;
	}
	
	public void dispatchWorker() {
		for(int j = 0; j < tabAnt.get(0).size(); j++) {
			Ant ant = tabAnt.get(0).get(j);
			if(ant.isOnTrack()) {
				if(true) {
					ant.followTrack();										
				}
			}
			else {
				double min = (tabWorkerOnTracks.get(0)/tabAnt.get(0).size())-(tabTracks.get(0).get(0).getDecompo()/decompoTrackTot);
				int IDMin = 0;
				for(int i = 1; i < tabTracks.size(); i++) {
					if((tabWorkerOnTracks.get(i)/tabAnt.get(i).size())-(tabTracks.get(i).get(0).getDecompo()/decompoTrackTot)<min) {
						min = (tabWorkerOnTracks.get(i)/tabAnt.get(i).size())-(tabTracks.get(i).get(0).getDecompo()/decompoTrackTot);
						IDMin = i;
					}
				}
				ant.startTrack(tabTracks.get(IDMin));					
			}
		}
	}
}
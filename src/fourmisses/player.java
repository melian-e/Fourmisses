package fourmisses;

public class player {
	int globalFood;
	
	int nbAntType = 3;	// Worker = 1  (id 0) / Warrior = 2 (id 1) / Explorer = 3 (id 2) 
	
	int nbWarrior; // nombre de guerrieres
	int nbWorker;	// nombre d'ouvrières
	int nbExplorer;	// nombre d'exploratrices
	int[][] tabAnt = new int[nbAntType - 1][];	//tableau qui contient toutes les fourmis
	
	
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
	public int[][] gettabAnt() {
		return tabAnt;
	}
	
	
	/**
	 * @param tabAnt the tabAnt to set
	 */
	public int[][] settabAnt(int[][] tabAnt, antType, nb ) {
		switch(antType) {
		case 0 :
			this.tabAnt[0][nbWarrior] = tabAnt[0][nb];
			break;
			return tabAnt;
			
		case 1 :
			this.tabAnt[0][nbWorker] = tabAnt[0][nb];
			break;
			return tabAnt;
			
		case 2 : 
			this.tabAnt[2][nbExplorer] = tabAnt[2][nb];
			break;
			return tabAnt;
		} 
		
	}
	
	
	/**
	 * @return the nbAntType
	 */
	public int getnbAntType() {
		return nbAntType;
	}
	
	
}
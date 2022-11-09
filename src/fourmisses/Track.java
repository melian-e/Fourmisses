package fourmisses;

public class Track extends Vector{
	
	//au moment de l'initialisation va etre un vecteur avec une norme et direction
	
	//deux types de track
	// 0 pour nourriture
	// 1 pour ennemi
	boolean type;
	
	//décomposition de la trace chaque tour
	//quand decomposition vaut 0 la trace est détruite
	int decomposition;
	
	//fonction qui réactualise la valeur de "decomposition"
	//sera appelée chaque tour
	public void decompo (Track track) {
		track.decomposition -= 1; //1 est une valeur arbitraire pour l'instant / sujet à changement
	}
	
	//public void decompo (track tracks[]) {
		
		//on parcourt l'ensemble des traces sur la map
	//	for (int i = 0; i< tracks.length; i++) {
	//		tracks[i].decomposition -= 1; //1 est une valeur arbitraire pour l'instant / sujet à changement
	//	}
	//}
	
	//fonction pour augmenter l'importance de la trace
	//public void valuation(track track) {
	//	  this.decomposition += 1; // 1 est une valeur arbitraire / sujet à changement
	//}
}

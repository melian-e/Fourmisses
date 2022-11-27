package fourmisses;

import java.util.ArrayList;
import java.util.List;

public class Ant extends Vector {
	

	Boolean onTrack = false;
	
	int IDOnTrack;
	ArrayList<Track> currentTrack;
	int id;
	int health = 100;
	int food = 100;
	
	/////CONSTRUCTOR/////
	public Ant(int x, int y, double speedX, double speedY, Boolean onTrack, int lastTrackX, int lastTrackY, int lastTrackVecX,
			int lastTrackVecY, int id, int health, int food) {
		super(x, y, speedX, speedY);
		this.onTrack = onTrack;
		
		this.id = id;
		this.health = health;
		this.food = food;
	}
	
	Boolean consumeFood() {
		if(this.food > 0) {
			this.food -= 1;
		}
		else {
			this.health -= 1;
		}
		
		return true;
	}
	
	Boolean followTrack() {
		
		return true;
	}
	
	Boolean isOnTrack() {
		return this.onTrack;
	}
	
	void startTrack(ArrayList<Track> track) {
		this.currentTrack = track;
		this.IDOnTrack = 0;
	}
	
	Boolean returnToTrack() { // " si le retour à la trace marche pas, c'est ICI que ça bloque " - Iemelian 02/11/2022 11:50
		int diffX = (int) (this.currentTrack.get(IDOnTrack).getX() - this.x);
		int diffY = (int) (this.currentTrack.get(IDOnTrack).getY() - this.y);
		
		double angle = Math.atan(diffX/diffY);
		
		this.vecX = 10 * Math.sin(angle);
		this.vecY = 10 * Math.cos(angle);
		
		return true;
	}
}

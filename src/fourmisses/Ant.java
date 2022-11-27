package fourmisses;

import java.util.ArrayList;
import java.util.List;

abstract class Ant extends Vector {
	

	private Boolean onTrack = false;
	
	private int IDOnTrack;
	private ArrayList<Track> currentTrack;
	private int id;
	private int health = 100;
	private int food = 100;
	
	/////CONSTRUCTOR/////
	protected Ant(int x, int y, double speedX, double speedY, Boolean onTrack, int lastTrackX, int lastTrackY, int lastTrackVecX,
			int lastTrackVecY, int id, int health, int food) {
		super(x, y, speedX, speedY);
		this.onTrack = onTrack;
		
		this.id = id;
		this.health = health;
		this.food = food;
	}
	
	protected Boolean consumeFood() {
		if(this.food > 0) {
			this.food -= 1;
		}
		else {
			this.health -= 1;
		}
		
		return true;
	}
	
	protected Boolean followTrack() {
		
		return true;
	}
	
	protected Boolean isOnTrack() {
		return this.onTrack;
	}
	
	protected void startTrack(ArrayList<Track> track) {
		this.currentTrack = track;
		this.IDOnTrack = 0;
	}
	
	protected Boolean returnToTrack() { // " si le retour à la trace marche pas, c'est ICI que ça bloque " - Iemelian 02/11/2022 11:50
		int diffX = (int) (this.currentTrack.get(IDOnTrack).getX() - this.x);
		int diffY = (int) (this.currentTrack.get(IDOnTrack).getY() - this.y);
		
		double angle = Math.atan(diffX/diffY);
		
		this.vecX = 10 * Math.sin(angle);
		this.vecY = 10 * Math.cos(angle);
		
		return true;
	}
}

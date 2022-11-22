package fourmisses;

public class Ant extends Vector {
	

	Boolean onTrack = false;
	
	int lastTrackX;
	int lastTrackY;
	double lastTrackVecX;
	double lastTrackVecY;
	int id;
	int health = 100;
	int food = 100;
	
	/////CONSTRUCTOR/////
	public Ant(int x, int y, double speedX, double speedY, Boolean onTrack, int lastTrackX, int lastTrackY, int lastTrackVecX,
			int lastTrackVecY, int id, int health, int food) {
		super(x, y, speedX, speedY);
		this.onTrack = onTrack;
		this.lastTrackX = lastTrackX;
		this.lastTrackY = lastTrackY;
		this.lastTrackVecX = lastTrackVecX;
		this.lastTrackVecY = lastTrackVecY;
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
		this.lastTrackX = this.x;
		this.lastTrackY = this.y;
		
		int nextX = (int)(this.x + this.lastTrackVecX);
		int nextY = (int)(this.y + this.lastTrackVecY);
		
		this.vecX = this.lastTrackVecX;
		this.vecY = this.lastTrackVecY;
		
		return true;
	}
	
	Boolean isOnTrack() {
		return this.onTrack;
	}
	
	Boolean returnToTrack() { // " si le retour à la trace marche pas, c'est ICI que ça bloque " - Iemelian 02/11/2022 11:50
		int diffX = this.lastTrackX - this.x;
		int diffY = this.lastTrackY - this.y;
		
		double angle = Math.atan(diffX/diffY);
		
		this.vecX = (int)(10 * Math.sin(angle)); 
		this.vecY = (int)(10 * Math.cos(angle)); 
		
		return true;
	}
}

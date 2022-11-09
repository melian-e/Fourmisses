package fourmisses;

public class Ant extends Vector{
	Boolean onTrack = false;
	
	int lastTrackX;
	int lastTrackY;
	int lastTrackVecX;
	int lastTrackVecY;
	int id;
	int health = 100;
	int food = 100;
	
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
		
		int nextX = this.x + this.lastTrackVecX;
		int nextY = this.y + this.lastTrackVecY;
		
		this.speedX = this.lastTrackVecX;
		this.speedY = this.lastTrackVecY;
		
		return true;
	}
	
	Boolean isOnTrack() {
		
		return true;
	}
	
	Boolean returnToTrack() { // " si le retour à la trace marche pas, c'est ICI que ça bloque " - Iemelian 02/11/2022 11:50
		int diffX = this.lastTrackX - this.x;
		int diffY = this.lastTrackY - this.y;
		
		double angle = Math.atan(diffX/diffY);
		
		this.speedX = (int)(10 * Math.sin(angle)); 
		this.speedY = (int)(10 * Math.cos(angle)); 
		
		return true;
	}
}

package fourmisses;

public class Worker extends Ant{
	
	int stock;
	
	/////CONSTRUCTOR/////
	public Worker(int x, int y, int speedX, int speedY, Boolean onTrack, int lastTrackX, int lastTrackY,
			int lastTrackVecX, int lastTrackVecY, int id, int health, int food, int stock) {
		super(x, y, speedX, speedY, onTrack, lastTrackX, lastTrackY, lastTrackVecX, lastTrackVecY, id, health, food);
		this.stock = stock;
	}

	
	Boolean gather(Food Food) {
		this.stock += Food.decrease();
		
		this.returnToTrack();
		
		return true;
	}
	
	int dropFood(Colony Colony) {
		int tmp = this.stock;
		this.stock = 0;
		System.out.println('test');
		
		return tmp;
	}
}

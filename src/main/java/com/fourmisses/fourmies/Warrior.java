package fourmisses;

public class Warrior extends Ant{

	Boolean isFighting = false;
	int targetFlagX;
	int targetFlagY;
	
	/////CONSTRUCTOR/////
	public Warrior(int x, int y, int speedX, int speedY, Boolean onTrack, int lastTrackX, int lastTrackY,
			int lastTrackVecX, int lastTrackVecY, int id, int health, int food, Boolean isFighting, int targetFlagX,
			int targetFlagY) {
		super(x, y, speedX, speedY, onTrack, lastTrackX, lastTrackY, lastTrackVecX, lastTrackVecY, id, health, food);
		this.isFighting = isFighting;
		this.targetFlagX = targetFlagX;
		this.targetFlagY = targetFlagY;
	}
	
	Boolean orderFight(int targetX, int targetY) {
		isFighting = true;
		this.targetFlagX = targetX;
		this.targetFlagY = targetY;
		
		return true;
	}
	
	//orderDontFight
	Boolean orderDontFight(int targetX, int targetY) {
		isFighting = false;
		this.targetFlagX = targetX;
		this.targetFlagY = targetY;
		
		return true;
	}
	
}
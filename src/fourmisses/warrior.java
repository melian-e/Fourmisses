package fourmisses;

public class Warrior extends Ant{
	Boolean isFighting = false;
	int targetFlagX;
	int targetFlagY;
	
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
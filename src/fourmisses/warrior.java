package fourmisses;

public class warrior extends ant{
	Boolean isFighting = false;
	int targetX;
	int targetY;
	
	Boolean orderFight(int targetX, int targetY) {
		isFighting = true;
		this.targetX = targetX;
		this.targetY = targetY;
		
		return true;
	}
	
	//orderDontFight
	
}
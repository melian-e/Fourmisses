package fourmisses;

public class worker extends ant{
	int stock;
	
	Boolean gather(food Food) {
		this.stock += Food.decrease();
		
		this.returnToTrack();
		
		return true;
	}
	
	int dropFood(colony Colony) {
		int tmp = this.stock;
		this.stock = 0;
		
		return tmp;
	}
}

package com.fourmisses.fourmies;

public class Explorer extends Ant{

	public Explorer(int x, int y, double speedX, double speedY, Boolean onTrack, int lastTrackX, int lastTrackY,
			int lastTrackVecX, int lastTrackVecY, int id, int health, int food) {
		super(x, y, speedX, speedY, onTrack, lastTrackX, lastTrackY, lastTrackVecX, lastTrackVecY, id, health, food);
		// TODO Auto-generated constructor stub
	}
	
	Explorer(){
        super(0,0,1,1,false,2,2,3,2,4,100,100);
    }

}

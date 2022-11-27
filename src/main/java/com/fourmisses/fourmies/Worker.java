package com.fourmisses.fourmies;

public class Worker extends Ant{
    int stock;

    Boolean gather(Food Food) {
        this.stock += Food.decrease();

        this.returnToTrack();

        return true;
    }

    int dropFood(Colony Colony) {
        int tmp = this.stock;
        this.stock = 0;

        return tmp;
    }
}

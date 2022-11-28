package com.fourmisses.fourmies;

import java.util.List;

class BackGround extends Thread {
    private Model model = new Model(View.getScreenHeight()-75, View.getScreenWidth());
    private int tick = 0;
    public BackGround(){}
    @Override
    public void run() {
        while (true) {
            try {
                this.tick++;
                model.nextIteration(tick);
                List<double[]>[] rtrn = model.updateView();
                View.displayEverything(rtrn[0], rtrn[1], rtrn[2], rtrn[3]);
                Thread.sleep( 1000 );
            } catch ( InterruptedException e ) {}
        }
    }

    public int getTick() {
        return tick;
    }
}

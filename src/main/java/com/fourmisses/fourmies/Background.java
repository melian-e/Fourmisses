package com.fourmisses.fourmies;

import java.util.List;

class BackGround extends Thread {
    private Model model = new Model(View.getScreenHeight(), View.getScreenWidth());
    public BackGround(){}
    @Override
    public void run() {
        while (true) {
            try {
                List<double[]>[] rtrn = model.updateView();
                View.displayEverything(rtrn[0], rtrn[1], rtrn[2], rtrn[3]);
                Thread.sleep( 1000 );
            } catch ( InterruptedException e ) {}
        }
    }
}

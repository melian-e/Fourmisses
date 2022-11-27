package com.fourmisses.fourmies;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<double[]> bleu = new ArrayList<double[]>();
    private static List<double[]> rouge = new ArrayList<double[]>();
    private static List<double[]> obstacle = new ArrayList<double[]>();
    private static List<double[]> food = new ArrayList<double[]>();

    public static void main(String[] args) {
        View view = new View();
        Model model = new Model(view.getScreenHeight(),view.getScreenWidth());
        
        model.updateView(view);
    }
}

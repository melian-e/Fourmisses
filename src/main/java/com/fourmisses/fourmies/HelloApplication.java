package com.fourmisses.fourmies;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Screen;

import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {

    private static final double screenWidth = Screen.getPrimary().getBounds().getWidth();
    private static final double screenHeight = Screen.getPrimary().getBounds().getHeight();
    private static final Canvas canvas = new Canvas(screenWidth, screenHeight-75);
    private static final GraphicsContext gc =  canvas.getGraphicsContext2D();

    private static List<double[]> bleu = new ArrayList<double[]>();
    private static List<double[]> rouge = new ArrayList<double[]>();

    public double getScreenWidth(){
        return screenWidth;
    }

    public double getScreenHeight(){
        return screenHeight;
    }

    @Override
    public void start(Stage stage) {
        initUI(stage);
    }

    private static void initLists() {
        bleu.add(new double[]{170.0, 50.0});
    }

    private void initUI(Stage stage) {

        var root = new Pane();
        root.getChildren().add(canvas);

        var scene = new Scene(root, screenWidth, screenHeight-75, Color.DARKGRAY);

        stage.setTitle("Fourmisses");
        stage.setScene(scene);
        stage.show();
    }

    public static void displayEverything(List<double[]> bleu, List<double[]> rouge) {

        gc.beginPath();
        for (double[] doubles : bleu) {
            gc.moveTo(doubles[0], doubles[1]);
            gc.lineTo(doubles[0], doubles[1]);
        }
        for (double[] doubles : rouge) {
            gc.moveTo(doubles[0], doubles[1]);
            gc.lineTo(doubles[0], doubles[1]);
        }
        gc.stroke();
    }

    public static void main(String[] args) {
        initLists();
        displayEverything(bleu, rouge);
        System.out.println(bleu);
        launch(args);
    }
}
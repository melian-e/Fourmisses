package com.fourmisses.fourmies;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class View extends Application {

    private static final double screenWidth = Screen.getPrimary().getBounds().getWidth();
    private static final double screenHeight = Screen.getPrimary().getBounds().getHeight();
    private static final Canvas canvas = new Canvas(screenWidth, screenHeight-75);
    private static final GraphicsContext gc =  canvas.getGraphicsContext2D();

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

//    private static void initLists() {
//        bleu.add(new double[]{170.0, 50.0});
//        rouge.add(new double[]{50.0, 50.0});
//    }

    private void initUI(Stage stage) {

        var root = new Pane();
        root.getChildren().add(canvas);

        var scene = new Scene(root, screenWidth, screenHeight-75, Color.WHITE);

        stage.setTitle("Fourmisses");
        stage.setScene(scene);
        stage.show();
    }

    public static void displayEverything(List<double[]> bleu, List<double[]> rouge, List<double[]> food, List<double[]> obstacles) {

        gc.beginPath();
        gc.setFill(Color.BLUE);
        for (double[] coo : bleu) {
            gc.fillRect(coo[0], coo[1], 4, 4);
        }
        gc.setFill(Color.RED);
        for (double[] coo : rouge) {
            gc.fillRect(coo[0], coo[1], 4, 4);
        }
        gc.setFill(Color.GREEN);
        for (double[] coo : food) {
            gc.fillRect(coo[0], coo[1], 4, 4);
        }
        gc.setFill(Color.GRAY);
        for (double[] coo : obstacles) {
            gc.fillRect(coo[0],coo[1], 4, 4);
        }
        gc.stroke();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

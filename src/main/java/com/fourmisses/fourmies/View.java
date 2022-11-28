package com.fourmisses.fourmies;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.List;

public class View extends Application {

    private static final double screenWidth = Screen.getPrimary().getBounds().getWidth();
    private static final double screenHeight = Screen.getPrimary().getBounds().getHeight();
    private static final Canvas canvas = new Canvas(screenWidth, screenHeight-75);
    private static final GraphicsContext gc =  canvas.getGraphicsContext2D();

    public static double getScreenWidth(){
        return screenWidth;
    }

    public static double getScreenHeight(){
        return screenHeight;
    }

    @Override
    public void start(Stage stage) {
        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new Pane();
        root.getChildren().add(canvas);

        var scene = new Scene(root, screenWidth, screenHeight-75, Color.BLACK);

        stage.setTitle("Fourmisses");
        stage.setScene(scene);
        stage.show();
    }

    public static void displayEverything(List<double[]> bleu, List<double[]> rouge, List<double[]> food, List<double[]> obstacles) {

        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.beginPath();
        gc.setFill(Color.BLUE);
        for (double[] coo : bleu) {
            gc.fillRect(coo[1], coo[0], 1, 1);
        }
        gc.setFill(Color.RED);
        for (double[] coo : rouge) {
            gc.fillRect(coo[1], coo[0], 1, 1);
        }
        gc.setFill(Color.GREEN);
        for (double[] coo : food) {
            gc.fillRect(coo[1], coo[0], 1, 1);
        }
        gc.setFill(Color.GRAY);
        for (double[] coo : obstacles) {
            gc.fillRect(coo[1],coo[0], 1, 1);
        }
        gc.stroke();
    }
    public static void main(String[] args) {
        BackGround test = new BackGround();
        test.start();
        launch(args);
        System.out.println("Starting");
    }
}

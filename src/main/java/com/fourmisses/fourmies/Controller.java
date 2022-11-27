package com.fourmisses.fourmies;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    Timeline timeline = new Timeline(

            new KeyFrame(Duration.seconds(1000),
                    e -> {
                            System.out.println("coucou");
//                        model.updateView(view);
                    }));
    @Override
    public void initialize( URL location, ResourceBundle resources) {
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}

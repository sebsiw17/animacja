package org.example.animacja;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RotateTransitionExample extends Application {
    private RotateTransition rotateTransition;
    public Polygon hexagon;

    @Override
    public void start(Stage stage) {
        // Creating a hexagon
        Polygon hexagon = new Polygon();

        hexagon.getPoints().addAll(new Double[]{
                200.0, 100.0,
                250.0, 50.0,
                300.0, 100.0,
                350.0, 50.0,
                400.0, 100.0,
                350.0, 150.0,
                400.0, 200.0,
                350.0, 250.0,
                300.0, 200.0,
                250.0, 250.0,
                200.0, 200.0,
                250.0, 150.0,
        });
        hexagon.setFill(Color.PURPLE);

        // Creating a rotate transition
        rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(1000));
        rotateTransition.setNode(hexagon);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.setAutoReverse(false);

        // Creating buttons
        Button startButton = new Button("Start");
        startButton.setOnAction(e -> rotateTransition.play());

        Button stopButton = new Button("Stop");
        stopButton.setOnAction(e -> {
            rotateTransition.pause();
            rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        });

        Button stepButton = new Button("Step");
        stepButton.setOnAction(e -> {
            rotateTransition.stop();
            hexagon.setRotate(hexagon.getRotate()+45);
        });

        // Creating a Group object
        Group root = new Group(hexagon, startButton, stopButton, stepButton);

        // Positioning buttons
        startButton.setLayoutX(10);
        startButton.setLayoutY(320);

        stopButton.setLayoutX(70);
        stopButton.setLayoutY(320);

        stepButton.setLayoutX(140);
        stepButton.setLayoutY(320);

        // Creating a scene object
        Scene scene = new Scene(root, 600, 400);

        // Setting title to the Stage
        stage.setTitle("Rotate transition example ");

        // Adding scene to the stage
        stage.setScene(scene);

        // Displaying the contents of the stage
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}

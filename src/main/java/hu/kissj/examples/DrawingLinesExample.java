package hu.kissj.examples;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DrawingLinesExample implements ExampleBuilder {
    @Override
    public void build(final Stage stage) {
        stage.setTitle("Chapter 2 Drawing Lines");
        final Group root = new Group();
        final Scene scene = new Scene(root, 300, 150, Color.GRAY);

        final Line redLine = new Line(10, 10, 200, 10);

        redLine.setStroke(Color.RED);
        redLine.setStrokeWidth(10);
        redLine.setStrokeLineCap(StrokeLineCap.BUTT);
// creating a dashed pattern
        redLine.getStrokeDashArray().addAll(10d, 5d, 15d, 5d, 20d);
        redLine.setStrokeDashOffset(0);
        root.getChildren().add(redLine);
// White line
        final Line whiteLine = new Line(10, 30, 200, 30);
        whiteLine.setStroke(Color.WHITE);
        whiteLine.setStrokeWidth(10);
        whiteLine.setStrokeLineCap(StrokeLineCap.ROUND);
        root.getChildren().add(whiteLine);
// Blue line
        final Line blueLine = new Line(10, 50, 200, 50);
        blueLine.setStroke(Color.BLUE);
        blueLine.setStrokeWidth(10);
        root.getChildren().add(blueLine);
// slider min, max, and current value
        final Slider slider = new Slider(0, 100, 0);
        slider.setLayoutX(10);
        slider.setLayoutY(95);
// bind the stroke dash offset property
        redLine.strokeDashOffsetProperty().bind(slider.valueProperty());
        root.getChildren().add(slider);
        final Text offsetText = new Text("Stroke Dash Offset: 0.0");
        offsetText.setX(10);
        offsetText.setY(80);
        offsetText.setStroke(Color.WHITE);
// display stroke dash offset value
        slider.valueProperty().addListener((ov, curVal, newVal) -> offsetText.setText("Stroke Dash Offset: " + slider.getValue()));
        root.getChildren().add(offsetText);
        stage.setScene(scene);
        stage.show();
    }
}

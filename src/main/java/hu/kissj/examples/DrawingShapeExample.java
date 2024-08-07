package hu.kissj.examples;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

public class DrawingShapeExample implements ExampleBuilder {
    @Override
    public void build(final Stage primaryStage) {
        primaryStage.setTitle("Chapter 2 Drawing Shapes");
        final Group root = new Group();
        final Scene scene = new Scene(root, 306, 550, Color.WHITE);
// Sine wave
        final CubicCurve cubicCurve = new CubicCurve(
                50, // start x point
                75, // start y point
                80, // control x1 point
                -25, // control y1 point
                110, // control x2 point
                175, // control y2 point
                140, // end x point
                75); // end y point
        cubicCurve.setStrokeType(StrokeType.CENTERED);
        cubicCurve.setStroke(Color.BLACK);
        cubicCurve.setStrokeWidth(3);
        cubicCurve.setFill(Color.WHITE);
        root.getChildren().add(cubicCurve);
// Ice cream cone
        final Path path = new Path();
        path.setStrokeWidth(3);
// create top part beginning on the left
        final MoveTo moveTo = new MoveTo();
        moveTo.setX(50);
        moveTo.setY(150);
// curve ice cream (dome)
        final QuadCurveTo quadCurveTo = new QuadCurveTo();
        quadCurveTo.setX(150);
        quadCurveTo.setY(150);
        quadCurveTo.setControlX(100);
        quadCurveTo.setControlY(50);
// cone rim
        final LineTo lineTo1 = new LineTo();
        lineTo1.setX(50);
        lineTo1.setY(150);
// left side of cone
        final LineTo lineTo2 = new LineTo();
        lineTo2.setX(100);
        lineTo2.setY(275);
// right side of cone
        final LineTo lineTo3 = new LineTo();
        lineTo3.setX(150);
        lineTo3.setY(150);
        path.getElements().addAll(moveTo, quadCurveTo, lineTo1, lineTo2, lineTo3);
        path.setTranslateY(30);
        root.getChildren().add(path);
// A smile
        final QuadCurve quad = new QuadCurve(
                50, // start x point
                50, // start y point
                125,// control x point
                150,// control y point
                150,// end x point
                50);// end y point
        quad.setTranslateY(path.getBoundsInParent().getMaxY());
        quad.setStrokeWidth(3);
        quad.setStroke(Color.BLACK);
        quad.setFill(Color.WHITE);
        root.getChildren().add(quad);
// outer donut
        final Ellipse bigCircle = new Ellipse(
                100, // center x
                100, // center y
                50, // radius x
                75 / 2); // radius y
        bigCircle.setStrokeWidth(3);
        bigCircle.setStroke(Color.BLACK);
        bigCircle.setFill(Color.WHITE);
// donut hole
        Ellipse smallCircle = new Ellipse(
                100, // center x
                100, // center y
                35 / 2, // radius x
                25 / 2); // radius y
// make a donut
        final Shape donut = Path.subtract(bigCircle, smallCircle);
        donut.setStrokeWidth(1.8);
        donut.setStroke(Color.BLACK);
        donut.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> System.out.println("Donut is clicked"));
// orange glaze
        donut.setFill(Color.rgb(255, 200, 0));
// add drop shadow
        final DropShadow dropShadow = new DropShadow(
                5, // radius
                2.0f, // offset X
                2.0f, // offset Y
                Color.rgb(50, 50, 50, .588));
        donut.setEffect(dropShadow);
// move slightly down
        donut.setTranslateY(quad.getBoundsInParent().getMinY() + 30);
        root.getChildren().add(donut);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

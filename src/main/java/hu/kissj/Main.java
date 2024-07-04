package hu.kissj;

import hu.kissj.examples.DrawingLinesExample;
import hu.kissj.examples.DrawingShapeExample;
import hu.kissj.examples.ExampleBuilder;
import hu.kissj.examples.HelloWorldExample;
import hu.kissj.examples.PaintingColorsExample;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(final Stage stage) throws Exception {
        final ExampleBuilder exampleBuilder =
                //new HelloWorldExample();
                //new DrawingLinesExample();
                //new DrawingShapeExample();
                new PaintingColorsExample();

        exampleBuilder.build(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
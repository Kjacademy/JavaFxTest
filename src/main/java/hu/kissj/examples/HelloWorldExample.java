package hu.kissj.examples;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HelloWorldExample implements ExampleBuilder {
    @Override
    public void build(final Stage stage) {
        stage.setTitle("First Test");
        final Group root = new Group();
        final Scene scene = new Scene(root, 300, 250);
        final Button btn = new Button();
        btn.setLayoutX(100);
        btn.setLayoutY(80);
        btn.setText("Hello World");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("Hello World");
            }
        });
        root.getChildren().add(btn);

        stage.setScene(scene);
        stage.show();
    }
}

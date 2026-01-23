package gerspach.superttt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SimpleTTT_Test extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainPane = new BorderPane();

        mainPane.setCenter(simpleGrid);
        stage.setScene(new Scene(mainPane));
        stage.setTitle("Simple TTT Test");
        stage.setMinHeight(300);
        stage.setMinWidth(400);
        stage.show();
    }

    BuildGrid simpleGrid = new BuildGrid();

}

package gerspach.superttt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;

public class SimpleTTT_Test extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainPane = new BorderPane();
        BuildGrid simpleGrid = new BuildGrid();
        mainPane.setCenter(simpleGrid);
        mainPane.setLeft(new Label(simpleGrid.getArrayData()));
        stage.setScene(new Scene(mainPane));
        stage.setTitle("Simple TTT Test");
        stage.setMinHeight(300);
        stage.setMinWidth(400);
        stage.show();
    }





}

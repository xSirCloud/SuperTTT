package gerspach.superttt;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Gui extends Application {

    private final MainGrid mainGrid = new MainGrid();

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainPane = new BorderPane();

        // Create Main Pane
        mainPane.setTop(paneSetTop());
        mainPane.setRight(mainGrid.buildMainGrid());
        mainPane.setStyle("-fx-background-color: #ffffff;");

        stage.setScene(new Scene(mainPane));
        stage.setTitle("SuperTTT");
        stage.setMinHeight(500);
        stage.setMinWidth(900);
        stage.show();
    }

    Node paneSetTop() {
        Label label = new Label("MAIN PANE");
        return label;
    }

}

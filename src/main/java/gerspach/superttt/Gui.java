package gerspach.superttt;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gui extends Application {

    GameController game = new GameController();
    private final MainGrid mainGrid = new MainGrid(game);

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainPane = new BorderPane();

        mainPane.setRight(mainGrid.buildMainGrid());
        mainPane.setStyle("-fx-background-color: #ffffff;");

        stage.setScene(new Scene(mainPane));
        stage.setTitle("SuperTTT");
        stage.setMinHeight(500);
        stage.setMinWidth(900);
        stage.show();
    }

}


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
    private final FieldClickValueTest fieldClickValueTest = new FieldClickValueTest();

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainPane = new BorderPane();

        // Create Main Pane
        mainPane.setRight(mainGrid.buildMainGrid());
        fieldClickValueTest.register(game);
        mainPane.setStyle("-fx-background-color: #ffffff;");

        stage.setScene(new Scene(mainPane));
        stage.setTitle("SuperTTT");
        stage.setMinHeight(500);
        stage.setMinWidth(900);
        stage.show();
    }

//    private Node controlPanel() {
//        VBox vBox = new VBox();
//        Button test = new Button("GetValue 1,4");
//        Label info = new Label();
//        test.setOnAction(event -> info.setText(game.getFieldValue()));
//
//        vBox.getChildren().addAll(test, info);
//        return vBox;
//    }

}


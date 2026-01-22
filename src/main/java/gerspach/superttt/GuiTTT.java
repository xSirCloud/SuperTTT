package gerspach.superttt;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.xml.transform.Source;

public class GuiTTT extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainPane = new BorderPane();

        // Create Main Pane
        mainPane.setTop(paneSetTop());
        mainPane.setRight(createSourceGrid());

       // mainPane.setRight(new BuildGrid(new GridPane()));
        mainPane.setStyle("-fx-background-color: #ffffff;");

        stage.setScene(new Scene(mainPane));
        stage.setTitle("SuperTTT");
        stage.setMinHeight(400);
        stage.setMinWidth(600);
        stage.show();
    }

    private Node createSourceGrid() {
        GridPane SourceGrid = new GridPane();
        for(int i = 1; i <= 9; i++){
            SourceGrid.add(new BuildGrid(), ((i-1)%3), (((i-1)/3)%3));
        }
        SourceGrid.setGridLinesVisible(true);
        SourceGrid.setPadding(new Insets(10,50,10,10));
        return SourceGrid;
    }

    private Node paneSetTop() {
        Label label = new Label("MAIN PANE");
        return label;
    }
}

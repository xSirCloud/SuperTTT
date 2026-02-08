package gerspach.superttt;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class SubGrid extends Pane {

    int subGrid_ID;
    GameController game;
    GridPane subGrid = new GridPane();

    public SubGrid(GameController game, int subGrid_ID) {
        this.game = game;
        this.getChildren().add(createTTTGrid(subGrid));
        this.subGrid_ID = subGrid_ID;
    }

    private Node createTTTGrid(GridPane subGrid){
        int x, y, field_ID;
        for (int i = 0; i < 9; i++) {
            field_ID = i;
            subGrid.add(new SubGridField(game, field_ID), x = (i % 3), y = (i / 3));
        }

        subGrid.setPadding(new Insets(10,10,10,10));
        subGrid.setGridLinesVisible(true);

        return subGrid;
    }

    public int getSubGrid_ID(){
        return subGrid_ID;
    }
}



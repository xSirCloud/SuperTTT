package gerspach.superttt;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubGrid extends Pane {

    int subGrid_ID;
    GameController game;
    GridPane subGrid = new GridPane();

 // Hier eine Liste von SubGridField
    private final List<SubGridField> fields = new ArrayList<>(Collections.nCopies(9,null));

    public SubGrid(GameController game, int subGrid_ID) {
        this.game = game;
        this.getChildren().add(createTTTGrid(subGrid));
        this.subGrid_ID = subGrid_ID;
    }

    private Node createTTTGrid(GridPane subGrid){
        for (int i = 0; i < 9; i++) {
            int field_ID = i;
            SubGridField field = new SubGridField(game, field_ID);

            fields.set(field_ID, field);
            subGrid.add(field, i % 3, i / 3);

            // subGrid.add(new SubGridField(game, field_ID), x = (i % 3), y = (i / 3));
        }

        subGrid.setPadding(new Insets(10,10,10,10));
        subGrid.setGridLinesVisible(true);

        return subGrid;
    }

    public int getSubGrid_ID(){
        return subGrid_ID;
    }
}



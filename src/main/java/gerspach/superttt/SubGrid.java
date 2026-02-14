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


    private final List<SubGridField> gridFields = new ArrayList<>(Collections.nCopies(9,null));

    public SubGrid(GameController game, int subGrid_ID) {
        this.game = game;
        this.subGrid_ID = subGrid_ID;
        this.getChildren().add(createTTTGrid(subGrid));
    }

    private Node createTTTGrid(GridPane subGrid){
        for (int i = 0; i <= 8; i++) {
            int field_ID = i;
            SubGridField field = new SubGridField(game, subGrid_ID, field_ID);

            gridFields.set(field_ID, field);
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

    public SubGridField getField(int field_ID) {
        return gridFields.get(field_ID);
    }
}




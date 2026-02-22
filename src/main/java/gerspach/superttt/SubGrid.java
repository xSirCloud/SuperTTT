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
    boolean gridWinStatus = false;
    boolean playable = true;
    FieldState gridWinner = FieldState.EMPTY;

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
        }
        subGrid.setPadding(new Insets(10,10,10,10));
        subGrid.setGridLinesVisible(true);
        return subGrid;
    }

    public List<SubGridField> getGridFields() {
        return gridFields;
    }

    public SubGridField getField(int field_ID) {
        return gridFields.get(field_ID);
    }

    public void setGridWinStatus(boolean status){
        gridWinner = game.getCurrentPlayer();
        gridWinStatus = status;
    }

    public void highlighter() {
        if(gridWinStatus)
            if (gridWinner == FieldState.CROSS)
                subGrid.setStyle("-fx-background-color: rgba(245,39,39); -fx-border-color: #F52727; -fx-border-width: 2;");
            else
                subGrid.setStyle("-fx-background-color: rgba(39,80,245); -fx-border-color: #2750F5; -fx-border-width: 2;");
        else if (!playable)
            subGrid.setStyle("-fx-background-color: rgba(43,43,43); -fx-border-color: #2B2B2B; -fx-border-width: 2;");
        else
            subGrid.setStyle("");
    }

    public void playable(boolean status){
        playable = status;
    }

}





package gerspach.superttt;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class BuildGrid extends Pane {
    GridPane coordGrid = new GridPane();
    public BuildGrid() {
        this.getChildren().add(createTTTGrid(coordGrid));
    }

    private int[] gridArray = new int[9];

    private Node createTTTGrid(GridPane gridTTT){
        for (int i = 0; i < gridArray.length; i++) {
            gridTTT.add(new Button(""+(i + 1)), i % 3, i / 3);
            gridArray[i] = i;
        }

        gridTTT.setPadding(new Insets(10,10,10,10));
        gridTTT.setGridLinesVisible(true);
        return gridTTT;
    }

    public String getArrayData() {
        String output = "";
        for (int i = 0; i < gridArray.length; i++){
            output = output + "" + (gridArray[i]);
        }
        return output;
    }


//        gamePane.add(new Button("1"), 1, 0);
//        gamePane.add(new Button("2"), 2, 0);
//        gamePane.add(new Button("3"), 3, 0);
//
//        gamePane.add(new Button("4"), 1, 1);
//        gamePane.add(new Button("5"), 2, 1);
//        gamePane.add(new Button("6"), 3, 1);
//
//        gamePane.add(new Button("7"), 1, 2);
//        gamePane.add(new Button("8"), 2, 2);
//        gamePane.add(new Button("9"), 3, 2);
}

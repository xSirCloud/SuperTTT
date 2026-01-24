package gerspach.superttt;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class SubGrid extends Pane {

    GameController game;
    GridPane subGrid = new GridPane();

    public SubGrid(GameController game) {
        this.getChildren().add(createTTTGrid(subGrid));
        this.game = game;
    }

    private int[] subGirdArray = new int[9];

    private Node createTTTGrid(GridPane subGrid){
        int x, y;
        for (int i = 0; i < subGirdArray.length; i++) {
            subGrid.add(new SubGridField(game), x = (i % 3), y = (i / 3));
            subGirdArray[i] = i;
        }

        subGrid.setPadding(new Insets(10,10,10,10));
        subGrid.setGridLinesVisible(true);
        return subGrid;
    }


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


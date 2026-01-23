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

    private static Node createTTTGrid(GridPane coordGrid){
        for(int i = 1; i <= 9; i++){
            coordGrid.add(new Button(""+i), ((i-1)%3), (((i-1)/3)%3));

        }
        coordGrid.setPadding(new Insets(10,10,10,10));
        coordGrid.setGridLinesVisible(true);
        return coordGrid;
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

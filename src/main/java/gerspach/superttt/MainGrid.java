package gerspach.superttt;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class MainGrid {

    private final GameController game;

    public MainGrid(GameController game) {
        this.game = game;
    }

    Node buildMainGrid() {
        GridPane mainGrid = new GridPane();
        for (int i = 0; i < 9; i++) {
            int subGrid_ID = i;
            SubGrid subGrid = new SubGrid(game, subGrid_ID);

            game.registerSubGrid(subGrid_ID, subGrid);
            mainGrid.add(subGrid, i % 3, i / 3);


           // mainGrid.add(new SubGrid(game), x = (i % 3), y = (i / 3));
        }

        mainGrid.setGridLinesVisible(true);
        mainGrid.setPadding(new Insets(10, 50, 10, 10));
        return mainGrid;
    }

}
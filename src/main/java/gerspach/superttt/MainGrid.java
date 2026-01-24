package gerspach.superttt;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class MainGrid {

    private int[] mainGridArray = new int[9];

    Node buildMainGrid() {
        GridPane mainGrid = new GridPane();
        int x, y;
        for (int i = 0; i < mainGridArray.length; i++) {
            mainGrid.add(new SubGrid(), x = (i % 3), y = (i / 3));
            mainGridArray[i] = i;
        }
        mainGrid.setGridLinesVisible(true);
        mainGrid.setPadding(new Insets(10, 50, 10, 10));
        return mainGrid;
    }
}
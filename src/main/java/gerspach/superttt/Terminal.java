package gerspach.superttt;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Terminal {
    public static Node buildTerminal(GameController game) {
        VBox vBox = new VBox();
        Label label = new Label("Active Turn: " + game.getCurrentPlayer());

        vBox.getChildren().add(label);
        return vBox;
    }
}

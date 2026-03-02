package gerspach.superttt;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Terminal {
    static Label label = new Label();

    public static Node buildTerminal(GameController game) {
        VBox vBox = new VBox();

        if(game.getCurrentPlayer() == FieldState.CIRCLE)
            label.setText("Active Player: \t" + "O");
        else if (game.getCurrentPlayer() == FieldState.CROSS)
            label.setText("Active Player: \t" + "X");
        label.setFont((Font.font(label.getFont().getFamily(), FontWeight.BOLD,  30)));




        vBox.getChildren().add(label);
        return vBox;
    }
}

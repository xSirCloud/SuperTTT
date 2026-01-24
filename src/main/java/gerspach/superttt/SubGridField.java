package gerspach.superttt;

import javafx.scene.control.Button;

public class SubGridField extends Button {

    GameController game;
    FieldState fieldState = FieldState.EMPTY;


    public SubGridField(GameController game){
        this.game = game;

        setText(fieldState.getDisplayText());
        setPrefSize(50,50);
        setOnAction(e -> handleClick());
    }

    private void handleClick() {
        if(!fieldState.isOccupied()){
            if (game.getCurrentPlayer().getPlayerID() == 1)
                setFieldState(FieldState.CROSS);
            else if(game.getCurrentPlayer().getPlayerID() == 2)
            setFieldState(FieldState.CIRCLE);
    }
}

    private void setFieldState(FieldState state) {
        this.fieldState = state;
        setText(state.getDisplayText());
    }

    public FieldState getFieldState(){
        return fieldState;
    }


}

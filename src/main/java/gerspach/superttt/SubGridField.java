package gerspach.superttt;

import javafx.scene.control.Button;

public class SubGridField extends Button {

    int field_ID;
    GameController game;
    FieldState fieldState = FieldState.EMPTY;

    public SubGridField(GameController game, int field_ID){
        this.game = game;
        this.field_ID = field_ID;
        setText(fieldState.getDisplayText());
        setPrefSize(50,50);
        setOnAction(e -> handleClick());
    }

    private void handleClick() {
        if(!fieldState.isOccupied()){
            if (game.getCurrentPlayer().getPlayerID() == 1){
                setFieldState(FieldState.CROSS);
                game.nextPlayer();
            }
            else if(game.getCurrentPlayer().getPlayerID() == 2){
                setFieldState(FieldState.CIRCLE);
                game.nextPlayer();
            }
    }
}

    private void setFieldState(FieldState state) {
        this.fieldState = state;
        setText(state.getDisplayText());
    }

    public FieldState getFieldState(){
        return fieldState;
    }

    public int getField_ID(){
        return field_ID;
    }



}

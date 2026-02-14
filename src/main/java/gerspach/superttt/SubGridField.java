package gerspach.superttt;

import javafx.scene.control.Button;

public class SubGridField extends Button {

    int subGrid_ID;
    int field_ID;
    GameController game;
    FieldState fieldState = FieldState.EMPTY;

    public SubGridField(GameController game, int subGrid_ID, int field_ID){
        this.game = game;
        this.subGrid_ID = subGrid_ID;
        this.field_ID = field_ID;
        setText(fieldState.getDisplayText());
        setPrefSize(50,50);
        setOnAction(e -> game.handleFieldClick(subGrid_ID, field_ID));
    }
//    private void handleClick() {
//        if(!fieldState.isOccupied()){
//            if (game.getCurrentPlayer().getPlayerID() == 1){
//                setFieldState(FieldState.CROSS);
//                game.nextPlayer();
//            }
//            else if(game.getCurrentPlayer().getPlayerID() == 2){
//                setFieldState(FieldState.CIRCLE);
//                game.nextPlayer();
//            }
//    }
    protected void setFieldState(FieldState state) {
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





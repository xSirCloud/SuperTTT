package gerspach.superttt;

import java.util.List;

public class BasicLogic {


    // receives FieldState argument to switch the currentPlayer
    public static FieldState nextPlayer(FieldState currentPlayer){
        return (currentPlayer == FieldState.CROSS)
                ? FieldState.CIRCLE : FieldState.CROSS;
    }

    public static boolean setFieldValue(SubGridField field, GameController game){
        if(field == null || field.getFieldState().isOccupied())
            return false;
        if(game.getCurrentPlayer() == FieldState.CROSS)
            field.setFieldState(FieldState.CROSS);
        else
            field.setFieldState(FieldState.CIRCLE);
        return true;
    }

    public static boolean winCheck(GameController game, List<SubGridField> gridFields) {
        for(int i = 0; i < 3; i++){

        }
    }

}

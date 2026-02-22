package gerspach.superttt;

import java.util.List;

public class BasicLogic {


    // receives FieldState argument to switch the currentPlayer
    public static FieldState nextPlayer(FieldState currentPlayer){
        return (currentPlayer == FieldState.CROSS)
                ? FieldState.CIRCLE : FieldState.CROSS;
    }
    // set the played FieldValue equivalent to the active player
    public static boolean setFieldValue(SubGridField field, GameController game){
        if(field == null || field.getFieldState().isOccupied())
            return false;
        if(game.getCurrentPlayer() == FieldState.CROSS)
            field.setFieldState(FieldState.CROSS);
        else
            field.setFieldState(FieldState.CIRCLE);
        return true;
    }
    // check if the given subGrid is won by the given Player
    public static boolean subWinCheck(List<SubGridField> gridFields) {
        if(gridFields == null || gridFields.size() != 9){
            return false;
        }
        int[][] winConditions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // col
                {0, 4, 8}, {6, 4, 2}
        };
        for(int[] condition : winConditions){
            FieldState a = gridFields.get(condition[0]).getFieldState();
            FieldState b = gridFields.get(condition[1]).getFieldState();
            FieldState c = gridFields.get(condition[2]).getFieldState();

            if(a != FieldState.EMPTY && a == b && b == c){
                return true;
            }
        }
        return false;
    }

    public static boolean checkPlayability(List<SubGridField> gridFields){
        for(SubGridField field : gridFields){
            if (field.getFieldState() == FieldState.EMPTY)
                return true;
        }
        return false;
    }
}

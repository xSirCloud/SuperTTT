package gerspach.superttt;

import java.lang.reflect.Field;

public class GameController {
    private FieldState curentPlayer = FieldState.CROSS;

    public FieldState getCurrentPlayer(){
        return getCurrentPlayer();
    }

    public void nextPlayer(){
        curentPlayer = (curentPlayer == FieldState.CROSS)
                ? FieldState.CIRCLE : FieldState.CROSS;
    }




}

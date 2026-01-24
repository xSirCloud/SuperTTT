package gerspach.superttt;


public class GameController {
    private FieldState curentPlayer = FieldState.CROSS;

    public FieldState getCurrentPlayer(){
        return curentPlayer;
    }

    public void nextPlayer(){
        curentPlayer = (curentPlayer == FieldState.CROSS)
                ? FieldState.CIRCLE : FieldState.CROSS;
    }




}

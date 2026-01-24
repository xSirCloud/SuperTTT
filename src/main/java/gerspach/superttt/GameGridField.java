package gerspach.superttt;

import javafx.scene.control.Button;

public class GameGridField extends Button {

    CellState cellState;
    int currentPlayer = 1;

    public GameGridField(){
        super("");
        this.cellState = CellState.EMPTY;
        setText(cellState.getDisplayText());

        setPrefSize(50,50);

        setOnAction(e -> handleClick());
    }

    private void handleClick() {
        if(cellState.isOccupied()){
            if (currentPlayer == 1)
                setCellState(CellState.CROSS);
            else if(currentPlayer == 2)
            setCellState(CellState.CIRCLE);
    }
        currentPlayer = (currentPlayer == 1) ? 2 : 1;

}

    private void setCellState(CellState state) {
        this.cellState = state;
        setText(state.getDisplayText());
    }

    public CellState getCellState(){
        return cellState;
    }


}

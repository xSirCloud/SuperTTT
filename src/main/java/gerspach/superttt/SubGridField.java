package gerspach.superttt;

import javafx.scene.control.Button;

public class SubGridField extends Button {

    FieldState fieldState;
    int currentPlayer = 1;

    public SubGridField(){
        super("");
        this.fieldState = FieldState.EMPTY;
        setText(fieldState.getDisplayText());

        setPrefSize(50,50);

        setOnAction(e -> handleClick());
    }

    private void handleClick() {
        if(fieldState.isOccupied()){
            if (currentPlayer == 1)
                setFieldState(FieldState.CROSS);
            else if(currentPlayer == 2)
            setFieldState(FieldState.CIRCLE);
    }
        currentPlayer = (currentPlayer == 1) ? 2 : 1;

}

    private void setFieldState(FieldState state) {
        this.fieldState = state;
        setText(state.getDisplayText());
    }

    public FieldState getFieldState(){
        return fieldState;
    }


}

package gerspach.superttt;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameController {
    private static FieldState currentPlayer = FieldState.CROSS;
/*
    Datasave architektur über Listen: GameController hält List "subGrids" erzeugt in MainGrid < SubGrid hält seine eigene 3x3 Liste "fields" erzeugt in SubGrid
    Liste an Subgrids mit vordefinierter Länge um in den For-schleifen direkt mit settern zu arbeiten.
    Evlt. nochmal genauer nachlesen...
    Erster Parameter von nCopies: Definiert die Anzahl der Kopien in der Liste
    Zweiter Parameter von nCopies: Ist das Objekt, dass in der Liste gesichert wird
*/
    private final List<SubGrid> subGrids = new ArrayList<>(Collections.nCopies(9,null));

    public void registerSubGrid(int subGrid_ID, SubGrid subGrid) {
        subGrids.set(subGrid_ID, subGrid);
    }

    public void handleClick(int subGrid_ID, int field_ID){
        // specified field, located via ID's in subGrid- & fields List's.
        SubGridField field = getField(subGrid_ID, field_ID);
        SubGrid subGrid = getSubGrid(subGrid_ID);

        // set desired fieldvalue based on the current player, with correct move validation.
        boolean moveValidation = BasicLogic.setFieldValue(field, this);
        if (!moveValidation) {
            return;
        }
        // Check if the made move led to a subGridWin, set the Winstatus true & highlight grid
        if(BasicLogic.subWinCheck(subGrid.getGridFields())){
            subGrid.setGridWinStatus(true);
        }
        subGrid.playable(BasicLogic.checkPlayability(subGrid.getGridFields()));
        subGrid.highlighter();
        currentPlayer = BasicLogic.nextPlayer(currentPlayer);


    }

    public SubGrid getSubGrid(int subGrid_ID) {
        return subGrids.get(subGrid_ID);
    }

    public SubGridField getField(int subGrid_ID, int field_ID){
        SubGrid subGrid = getSubGrid(subGrid_ID);
        if(subGrid == null)
            throw new IllegalStateException("Subgrid: "+ subGrid_ID + " is not initialized!");
        return subGrid.getField(field_ID);
    }

    public FieldState getCurrentPlayer(){
        return currentPlayer;
    }
}



package gerspach.superttt;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameController {
    private FieldState curentPlayer = FieldState.CROSS;

    // Datasave architektur über Listen: GameController hält List "subGrids" erzeugt in MainGrid < SubGrid hält seine eigene 3x3 Liste "fields" erzeugt in SubGrid
    // Liste an Subgrids mit vordefinierter Länge um in den Forschleifen direkt mit settern zu arbeiten.
    // Evlt. nochmal genauer nachlesen...
    // Erster Parameter von nCopies: Definiert die Anzahl der Kopien in der Liste
    // Zweiter Parameter von nCopies: Ist das Objekt dass in der Liste gesichert wird

    private final List<SubGrid> subGrids = new ArrayList<>(Collections.nCopies(9,null));

    public void registerSubGrid(int subGrid_ID, SubGrid subGrid) {
        subGrids.set(subGrid_ID, subGrid);
    }

    public void nextPlayer(){
        curentPlayer = (curentPlayer == FieldState.CROSS)
                ? FieldState.CIRCLE : FieldState.CROSS;
    }

    public SubGridField getField(int subGrid_ID, int field_ID){
        SubGrid subGrid = getSubGrid(subGrid_ID);
        if(subGrid == null)
            throw new IllegalStateException("Subgrid: "+ subGrid_ID + " is not initialized!");
        return subGrid.getField(field_ID);
    }

    public boolean handleFieldClick(int subGrid_ID, int field_ID){
        SubGridField field = getField(subGrid_ID, field_ID);
        if (field == null || field.getFieldState().isOccupied())
            return false;

        if (getCurrentPlayer() == FieldState.CROSS)
            field.setFieldState(FieldState.CROSS);
        else
            field.setFieldState(FieldState.CIRCLE);
        nextPlayer();





        return true;
    }

    public SubGrid getSubGrid(int subGrid_ID) {
        return subGrids.get(subGrid_ID);
    }

    public FieldState getCurrentPlayer(){
        return curentPlayer;
    }
}



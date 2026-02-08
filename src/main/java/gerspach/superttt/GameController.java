package gerspach.superttt;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameController {
    private FieldState curentPlayer = FieldState.CROSS;

    // Liste an Subgrids mit vordefinierter Länge um in den Forschleifen direkt mit settern zu arbeiten.
    // Evlt. nochmal genauer nachlesen...
    // Erster Parameter von nCopies: Definiert die Anzahl der Kopien in der Liste
    // Zweiter Parameter von nCopies: Ist das Objekt dass in der Liste gesichert wird
    private final List<SubGrid> subGrids = new ArrayList<>(Collections.nCopies(9,null));

    public FieldState getCurrentPlayer(){
        return curentPlayer;
    }

    public void nextPlayer(){
        curentPlayer = (curentPlayer == FieldState.CROSS)
                ? FieldState.CIRCLE : FieldState.CROSS;
    }

    public void registerSubGrid(int subGridId, SubGrid subGrid) {
        subGrids.set(subGridId,subGrid);
    }
}


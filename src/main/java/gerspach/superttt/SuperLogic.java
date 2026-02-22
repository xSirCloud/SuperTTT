package gerspach.superttt;

import java.util.List;

/*
TO-DO:
- SubGridSelector() -Active Subgrid = set Field im letzten Zug
- FieldBlocker() - Blockt inaktive Felder nach SubGridSelector()
- WinCheck() - Checkt alle SubGrids um BigWin festzustellen (siehe BasicLogic.winCheck())
 */
public class SuperLogic {

    // Sets the selection Mode based on validation if the desired SubGrid is playable or not
    private static SelectionMode selectionMode(int field_ID, List<SubGrid> subGrids) {
        if(subGrids == null){
            throw new IllegalArgumentException("provided SubGrid is null!");
        }
        if(field_ID < 0 || field_ID >= subGrids.size()){
            throw new IllegalArgumentException("Field_ID out of range! Field ID: " + field_ID);
            }
        SubGrid target = subGrids.get(field_ID);
        if(target == null){
            throw new IllegalStateException("Target SubGrid is null, initialized by field_ID: " + field_ID);
        }

        boolean playable = BasicLogic.checkPlayability(target.getGridFields());
        boolean won = BasicLogic.subWinCheck(target.getGridFields());

        return (playable && !won) ? SelectionMode.FORCED_MOVE : SelectionMode.FREE_CHOICE;
    }

    // Selects the active subGrid that needs to be played next, based on the last played Field
    private static SubGrid subGridSelector(int field_ID, List<SubGrid> subGrids){
        SubGrid target = subGrids.get(field_ID);
        if(target == null)
            throw new IllegalStateException("Target SubGrid is null initialized by field_ID: " + field_ID);
        return target;
    }

    // Blocks all other Subgrids that are != desired SubGrid, or grants access to all playable grids if desired grid != playable
    public static void fieldBlocker(int field_ID, List<SubGrid> subGridList){
        SelectionMode mode = selectionMode(field_ID, subGridList);
        SubGrid forcedSubGrid = subGridSelector(field_ID, subGridList);

        for (SubGrid grid : subGridList) {
            if (grid == null) {
                continue;
            }

            boolean gridEnabled;
            if(mode == SelectionMode.FORCED_MOVE){
                gridEnabled = (grid == forcedSubGrid);
            } else {
                gridEnabled = BasicLogic.checkPlayability(grid.getGridFields())
                        && !BasicLogic.subWinCheck(grid.getGridFields());
            }

            for(SubGridField field : grid.getGridFields()){
                field.setDisable(!gridEnabled || field.getFieldState().isOccupied());
            }
            grid.playable(gridEnabled);
            grid.highlighter();
        }
    }

    public static FieldState bigWinCheck(List<SubGrid> subGrids){
        if (subGrids == null || subGrids.size() != 9) {
            throw new IllegalArgumentException("subGrids must contain exactly 9 entries");
        }

        FieldState[] mainBoard = new FieldState[9];

        for (int i = 0; i < 9; i++) {
            SubGrid grid = subGrids.get(i);
            if (grid == null) {
                throw new IllegalStateException("SubGrid at index " + i + " is null");
            }

            List<SubGridField> fields = grid.getGridFields();
            if (fields == null || fields.size() != 9) {
                throw new IllegalStateException("SubGrid fields invalid at index " + i);
            }

            mainBoard[i] = resolveSubGridWinner(fields);
        }

        int[][] winConditions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {6, 4, 2}
        };

        for (int[] condition : winConditions) {
            FieldState a = mainBoard[condition[0]];
            FieldState b = mainBoard[condition[1]];
            FieldState c = mainBoard[condition[2]];

            if (a != FieldState.EMPTY && a == b && b == c) {
                return a;
            }
        }

        return FieldState.EMPTY;
    }

    public static boolean hasPlayableSubGrids(List<SubGrid> subGrids) {
        if (subGrids == null) {
            return false;
        }

        for (SubGrid grid : subGrids) {
            if (grid == null) {
                continue;
            }
            if (BasicLogic.checkPlayability(grid.getGridFields())
                    && !BasicLogic.subWinCheck(grid.getGridFields())) {
                return true;
            }
        }
        return false;
    }

    private static FieldState resolveSubGridWinner(List<SubGridField> fields) {
        int[][] winConditions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {6, 4, 2}
        };

        for (int[] condition : winConditions) {
            FieldState a = fields.get(condition[0]).getFieldState();
            FieldState b = fields.get(condition[1]).getFieldState();
            FieldState c = fields.get(condition[2]).getFieldState();

            if (a != FieldState.EMPTY && a == b && b == c) {
                return a;
            }
        }

        return FieldState.EMPTY;
    }

    public static void gameOverBlocker(List<SubGrid> subGrids) {
        if (subGrids == null) {
            throw new IllegalArgumentException("subGrids must not be null");
        }

        for (SubGrid grid : subGrids) {
            if (grid == null) {
                continue;
            }

            for (SubGridField field : grid.getGridFields()) {
                if (field == null) {
                    continue;
                }
                field.setDisable(true);
            }

            grid.playable(false);
            grid.highlighter();
        }
    }
}


package gerspach.superttt;

public enum FieldState {
    EMPTY("", true, 0),
    CROSS("X", false, 1),
    CIRCLE("O", false, 2);

    private final String displayText;
    private final boolean occupied;
    private final int playerID;

    FieldState(String displayText, boolean occupied, int playerID){
        this.displayText = displayText;
        this.occupied = occupied;
        this.playerID = playerID;
    }
    public String getDisplayText(){
        return displayText;
    }

    public boolean isOccupied(){
        return occupied;
    }
    public int getPlayerID(){
        return playerID;
    }
}

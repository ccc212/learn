package src;

import java.io.Serializable;

public class Room implements Serializable {
    private int row;
    private int column;

    public Room(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}


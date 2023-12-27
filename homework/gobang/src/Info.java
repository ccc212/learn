package src;

import java.awt.*;
import java.io.Serializable;

public class Info implements Serializable {
    private Room room;
    private Point point;
    private String string;
    private boolean currentPlayer;

    public Room getRoom() {
        return room;
    }

    public Point getPoint() {
        return point;
    }

    public String getString() {
        return string;
    }

    public Info(Room room, Point point, String string, boolean currentPlayer) {
        this.room = room;
        this.point = point;
        this.string = string;
        this.currentPlayer = currentPlayer;
    }

    public Info(Point point,boolean currentPlayer) {
        this(null,point,null,currentPlayer);
    }

    public Info(String string) {
        this(null,null,string,false);
    }
}

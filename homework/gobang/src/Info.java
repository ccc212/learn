package src;

import java.awt.*;
import java.io.Serializable;

public class Info implements Serializable {
    private Room room;
    private Point point;
    private String string;
    private boolean player;

    public boolean getPlayer() {
        return player;
    }

    public void setPlayer(boolean player) {
        this.player = player;
    }

    public Room getRoom() {
        return room;
    }

    public Point getPoint() {
        return point;
    }

    public String getString() {
        return string;
    }

    public Info(Room room, Point point, String string) {
        this.room = room;
        this.point = point;
        this.string = string;
    }

    public Info(Room room) {
        this(room,null,null);
    }
    public Info(Point point) {
        this(null,point,null);
    }
    public Info(String string) {
        this(null,null,string);
    }
}

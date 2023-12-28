package src;

import java.awt.*;
import java.io.Serializable;

public class Info implements Serializable {
    private Room room;
    private Point point;
    private String string;
    private boolean clickEnable = false;
    private String address;

    public boolean getClickEnable() {
        return clickEnable;
    }

    public void setClickEnable(boolean clickEnable) {
        this.clickEnable = clickEnable;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

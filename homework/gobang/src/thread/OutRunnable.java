package src.thread;

import src.Info;
import src.Logic;
import src.Player;
import src.UI.Game;

import java.awt.*;
import java.io.*;
import java.net.Socket;

public class OutRunnable implements Runnable{
    private final Socket socket;
    public static ObjectOutputStream oos;
    private Point lastSentClickPoint = null;
    public OutRunnable(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            Logic.leave(Game.instance.getChessBoard(), Player.isRoomOwner());
            e.printStackTrace();
        }
        while(true) {
            Point lastClickPoint = Game.instance.getChessBoard().getLastClickPoint();
            try {
                if (lastClickPoint != null && !lastClickPoint.equals(lastSentClickPoint)) {
                    Game.instance.setChessBoardClickable(false);

                    Info info = new Info(lastClickPoint);
                    info.setClickEnable(true);

                    oos.writeObject(info);
                    oos.flush();

                    lastSentClickPoint = lastClickPoint;
                }
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
                Logic.leave(Game.instance.getChessBoard(), Player.isRoomOwner());
                break;
            }
        }
    }
}

package src.thread;

import src.Info;
import src.Logic;
import src.Player;
import src.UI.Game;

import java.awt.*;
import java.io.*;
import java.net.Socket;

public class OutRunnable implements Runnable{
    private Socket socket;
    public static ObjectOutputStream oos;
    public static boolean currentPlayer = false;
    public OutRunnable(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        while(true) {
            Point lastClickPoint = Game.getChessBoard().getLastClickPoint();
            try {
//                synchronized (Game.instance.getLock()) {
                if(lastClickPoint != null) {
                    oos.writeObject(new Info(lastClickPoint));
                    oos.flush();
                }
//                    Game.instance.getLock().notify();
//                }
                Thread.sleep(10);
            } catch (Exception e) {
                Logic.leave(Game.getChessBoard(), Player.isRoomOwner());
                break;
            }
        }
    }
}

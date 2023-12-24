package src.thread;

import src.Logic;
import src.Player;
import src.UI.Game;

import java.awt.*;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class InRunnable implements Runnable {
    private Socket socket;
    private Game game;
    private Point point;
    private InputStream is;
    private ObjectInputStream ois;

    public InRunnable(Socket socket, Game game){
        this.socket = socket;
        this.game = game;
    }
    @Override
    public void run() {
        try {
            is = socket.getInputStream();
            while (true) {
                try {
                    ois = new ObjectInputStream(is);
//                    if(ois.readObject().equals("对方已离开")){
//                        Logic.leave(game.getChessBoard(), Player.isRoomOwner());
//                        break;
//                    }
                    point = (Point) ois.readObject();
                } catch (Exception e) {
//                System.out.println("有异常");
                    continue;
                }
                if (point != null && game.getChessBoard().judge(point.x,point.y) == true) {
                    game.getChessBoard().click(point.x, point.y);
                }
                Thread.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package src.thread;

import src.UI.ChessBoard;
import src.UI.Game;

import java.awt.*;
import java.io.*;
import java.net.Socket;

public class GameRunnable implements Runnable{
    private Socket socket;
    private Game game;
    public GameRunnable(Socket socket,Game game){
        this.socket = socket;
        this.game = game;
    }
    @Override
    public void run() {
        OutputStream os;
        ObjectOutputStream oos = null;
        try {
            os = socket.getOutputStream();
            oos = new ObjectOutputStream(os);
        } catch (Exception e) {

        }
        while(true) {
            // 获取上一次点击的坐标
            Point lastClickPoint = game.getChessBoard().getLastClickPoint();
            System.out.println("上一次点击坐标: " + lastClickPoint);

            try {
                oos.writeObject(lastClickPoint);
                oos.flush();
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}

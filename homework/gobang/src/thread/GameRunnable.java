package src.thread;

import src.UI.ChessBoard;
import src.UI.Game;

import java.awt.*;
import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class GameRunnable implements Runnable{
    private Socket socket;
    private ChessBoard chessBoard;
    public GameRunnable(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        // 获取上一次点击的坐标
//        Point lastClickPoint = chessBoard.getLastClickPoint();

        // 在这里执行你的逻辑，例如打印坐标
//        System.out.println("Last Click Point: " + lastClickPoint);

        // 休眠一段时间，避免无限循环过快
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

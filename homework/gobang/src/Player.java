package src;

import src.UI.ChessBoard;
import src.UI.Game;
import src.thread.GameRunnable;

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Player {
    private Game game;
    private Point point;
    public Player(int port,int row,int column) throws Exception {
        Socket socket = new Socket("127.0.0.1", port);
        game = new Game(row,column);

        ThreadPoolExecutor pool = new ThreadPoolExecutor(12 * 2, 12 * 2, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(8) , Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        pool.execute(new GameRunnable(socket,game));

        InputStream is = socket.getInputStream();
        while (true) {
            Thread.sleep(10);
            int availableBytes = is.available();
            if (availableBytes > 0) {
                byte[] buffer = new byte[availableBytes];
                int bytesRead = is.read(buffer);
                if (bytesRead > 0) {
                    ByteArrayInputStream byteStream = new ByteArrayInputStream(buffer);
                    ObjectInputStream ois = new ObjectInputStream(byteStream);
                    point = (Point) ois.readObject();
                    if (point != null && game.getChessBoard().judge(point.x,point.y) == true) {
//                        System.out.println(point.x + "," + point.y);
                        game.getChessBoard().click(point.x, point.y);
                    }
                }
            }

        }
    }

    public static void main(String[] args) throws Exception {
        new Player(8080,6,6);
    }
}

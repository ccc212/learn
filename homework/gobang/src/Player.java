package src;

import src.UI.Game;
import src.UI.Menu;
import src.thread.InRunnable;
import src.thread.OutRunnable;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.*;

public class Player {
    private Game game;

    private static Socket socket;
    private static boolean isRoomOwner;
    public Player(int port,int row,int column,boolean isRoomOwner) throws Exception {
        this.isRoomOwner = isRoomOwner;

        socket = new Socket("127.0.0.1", port);

        game = new Game(row,column);

        ExecutorService pool = new ThreadPoolExecutor(12 * 2, 12 * 2, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(8) , Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        Future<?>f1 = pool.submit(new OutRunnable(socket,game));
        Future<?>f2 = pool.submit(new InRunnable(socket,game));

        pool.shutdown();
    }

    public static void closeSocket() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new Player(8080,15,15,false);
    }


    public static Socket getSocket() {
        return socket;
    }

    public static boolean isRoomOwner() {
        return isRoomOwner;
    }

}


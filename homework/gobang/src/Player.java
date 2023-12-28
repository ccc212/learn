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
    private static Socket socket;
    private static boolean isRoomOwner;
    private String name;
    public Player(int port,int row,int column,boolean isRoomOwner) throws Exception {
        this.isRoomOwner = isRoomOwner;
        this.name = Menu.instance.name;

        socket = new Socket("127.0.0.1", port);
        System.out.println(socket);

        new Game(row,column);

        ExecutorService pool = new ThreadPoolExecutor(12 * 2, 12 * 2, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(8) , Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        pool.submit(new OutRunnable(socket));
        pool.submit(new InRunnable(socket));

        pool.shutdown();
    }

    private void test1(){}

    public static void closeSocket() {
        try {
            if (Player.socket != null && !Player.socket.isClosed()) {
                Player.socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new Player(8080,15,15,false);
    }


    public Socket getSocket() {
        return socket;
    }

    public String getName() {
        return name;
    }

    public static boolean isRoomOwner() {
        return isRoomOwner;
    }


}


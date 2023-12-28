package src;

import src.UI.Game;
import src.UI.Menu;
import src.thread.OutRunnable;
import src.thread.InRunnable;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.*;

public class Player {
    private static Socket socket;
    private static boolean isRoomOwner;
    private String name;
    public static boolean clickEnable;
    public Player(int port,int row,int column,boolean isRoomOwner) throws Exception {
        this.isRoomOwner = isRoomOwner;
        this.name = Menu.instance.name;

        clickEnable = isRoomOwner;

        socket = new Socket("127.0.0.1", port);
//        System.out.println(socket);

        Game.instance = new Game(row,column);
        Game.instance.setChessBoardClickable(clickEnable);

        ExecutorService pool = new ThreadPoolExecutor(12 * 2, 12 * 2, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(8) , Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        pool.submit(new OutRunnable(socket));
        pool.submit(new InRunnable(socket));

        pool.shutdown();
    }

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


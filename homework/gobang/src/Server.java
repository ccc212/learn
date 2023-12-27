package src;

import src.UI.Creat;
import src.UI.Menu;
import src.UI.Result;
import src.thread.ServerThread;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Server {
    public static List<Socket> onLineSockets = new ArrayList<>(2);
    public static int port;
    private static ServerSocket serverSocket;
    public static AtomicBoolean connect = new AtomicBoolean(false);
    public Server(int port) throws Exception {
        this.port = port;
        System.out.println("-----房间已创建-------");
        serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                break;
            }
            onLineSockets.add(socket);
            System.out.println("有人上线了：" + socket.getRemoteSocketAddress());
            new ServerThread(socket).start();
            System.out.println(Menu.instance.roomInfoSocket);
            try {
                if(socket != Server.onLineSockets.get(0)) {
                    broadcastRoomInfo(socket);
//                    System.out.println(socket);
//                    System.out.println(Server.onLineSockets.get(0));
//                    System.out.println(Server.onLineSockets.get(1));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void close() {
        try {
            onLineSockets.remove(serverSocket);

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcastRoomInfo(Socket newSocket) {
//        System.out.println("发送房间信息");
        Info info = new Info(Creat.getRoom(),null,Menu.instance.name,false);
        if(info.getRoom() == null)return;
        try {
            ObjectOutputStream oos = new ObjectOutputStream(newSocket.getOutputStream());
            oos.writeObject(info);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new Server(8080);
    }
}

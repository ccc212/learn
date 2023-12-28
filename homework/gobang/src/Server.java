package src;

import src.UI.Create;
import src.UI.Menu;
import src.thread.ServerThread;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static List<Socket> onLineSockets = new ArrayList<>(2);
    public static int port;
    private static ServerSocket serverSocket;

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
            try {
                if(socket != Server.onLineSockets.get(0)) {
                    broadcastRoomInfo(socket);
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
        Info info = new Info(Create.getRoom(),null,Menu.instance.name);
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

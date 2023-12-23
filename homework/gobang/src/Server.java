package src;

import src.UI.Creat;
import src.UI.Menu;
import src.thread.ServerThread;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server {
    public static List<Socket> onLineSockets = new ArrayList<>(2);
    public static int port;
    private static ServerSocket serverSocket;
    public Server(int port) throws Exception {
        this.port = port;
        System.out.println("-----房间已创建-------");
        serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
//            if(Menu.roomInfoSocket != null) {
//                System.out.println("socket:" + socket.getRemoteSocketAddress());
//                System.out.println("room:" + Menu.roomInfoSocket.getLocalSocketAddress());
//            }
//            if(Menu.roomInfoSocket != null && socket.getRemoteSocketAddress() == Menu.roomInfoSocket.getLocalSocketAddress()){
//                System.out.println(1);
//                socket.close();
//                continue;
//            }
            onLineSockets.add(socket);
            System.out.println("有人上线了：" + socket.getRemoteSocketAddress());
            new ServerThread(socket).start();
            try {
                if(socket != Server.onLineSockets.get(0)) {
                    ServerThread.broadcastRoomInfo(port,socket);
                }
            } catch (Exception e) {
                System.out.println(1);
            }
        }
    }

    public static void close() {
        try {
            onLineSockets.remove(serverSocket);
            System.out.println("房主已离开");
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new Server(8080);
    }
}

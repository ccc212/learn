package src;

import src.thread.ServerThread;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static List<Socket> onLineSockets = new ArrayList<>();
    public Server(int port) throws Exception {
        System.out.println("-----服务端启动成功-------");
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            onLineSockets.add(socket);
            System.out.println("有人上线了：" + socket.getRemoteSocketAddress());
            new ServerThread(socket).start();
        }
    }

    public static void main(String[] args) throws Exception {
        new Server(8080);
    }
}

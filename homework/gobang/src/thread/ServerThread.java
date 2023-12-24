package src.thread;

import src.Room;
import src.Server;
import src.UI.Creat;
import src.UI.Game;

import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerThread extends Thread{
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    public ServerThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            while (true){
                try {
                    Point point = (Point) ois.readObject();
                    if(point != null) {
                        sendToAll(point);
                    }
                } catch (IOException e) {
                    System.out.println("有人下线了：" + socket.getRemoteSocketAddress());
                    Server.onLineSockets.remove(socket);
                    ois.close();
                    socket.close();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Socket socket = Server.onLineSockets.get(0);
            try {
                oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject("对方已离开");
                oos.flush();
//                oos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void sendToAll(Point point) throws IOException {
        for (Socket onLineSocket : Server.onLineSockets) {
            if(onLineSocket != socket) {
                ObjectOutputStream oos = new ObjectOutputStream(onLineSocket.getOutputStream());
                oos.writeObject(point);
                oos.flush();
                break;
            }
        }
    }
}



package src.thread;

import src.Room;
import src.Server;
import src.UI.Game;

import java.awt.*;
import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket socket;
    public ServerThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            while (true){
                try {
                    Point point = (Point) ois.readObject();
                    Server.rooms.put(Server.port,new Room(point.x,point.y));
                    if(point != null) {
                        sendMsgToAll(point);
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
        }
    }

    private void sendMsgToAll(Point point) throws IOException {
        for (Socket onLineSocket : Server.onLineSockets) {
            ObjectOutputStream oos = new ObjectOutputStream(onLineSocket.getOutputStream());
            oos.writeObject(point);
            oos.flush();
        }
    }
}

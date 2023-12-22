package src.thread;

import src.Room;
import src.Server;
import src.UI.Game;

import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerThread extends Thread{
    private static Map<Integer, Room> portToRoomMap = new HashMap<>();
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
            Socket socket = Server.onLineSockets.get(0);
            try {
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject("对方已离开");
                oos.flush();
                oos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
//            e.printStackTrace();
        }
    }

    public static void broadcastRoomInfo(int port, int row, int column, Socket newSocket) {
        Room room = new Room(row,column);
        portToRoomMap.put(port,room);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(newSocket.getOutputStream());
            oos.writeObject(room);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Room getRoomInfo(int port) {
        return portToRoomMap.get(port);
    }

    private void sendMsgToAll(Point point) throws IOException {
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



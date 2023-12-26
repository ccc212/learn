package src.thread;

import src.Info;
import src.Player;
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
                    Info info = (Info) ois.readObject();
                    if(info.getPoint() != null || info.getString() != null) {
                        sendToAll(info);
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
            if(socket != Server.onLineSockets.get(1)) {
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
            Server.onLineSockets.remove(socket);
        }
    }

    private void sendToAll(Info info) throws IOException, InterruptedException {
        for (Socket onLineSocket : Server.onLineSockets) {
//            if(onLineSocket != Player.getSocket()) {
                ObjectOutputStream oos = new ObjectOutputStream(onLineSocket.getOutputStream());
                oos.writeObject(info);
                oos.flush();
//                break;
//            }
        }
    }
}



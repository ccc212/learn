package src.thread;

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
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            while (true){
                try {
                    Point point = (Point) ois.readObject();
                    if(point != null) {
                        String msg = point.x + "," + point.y;
                        System.out.println(msg);
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
            OutputStream os = onLineSocket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(point);
            oos.flush();
        }
    }
}

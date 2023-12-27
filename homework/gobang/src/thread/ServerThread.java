package src.thread;

import src.Info;
import src.Server;
import java.io.*;
import java.net.Socket;
import java.util.Iterator;

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
            if(socket != Server.onLineSockets.get(2)) {
                Socket socket = Server.onLineSockets.get(0);
                try {
//                    System.out.printf("对方已离开");
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

    private void sendToAll(Info info) throws IOException{
        Iterator<Socket> iterator = Server.onLineSockets.iterator();
        while (iterator.hasNext()) {
            Socket onLineSocket = iterator.next();
            if (onLineSocket == socket) {
                continue;
            }
            try {
                ObjectOutputStream oos = new ObjectOutputStream(onLineSocket.getOutputStream());
                oos.writeObject(info);
                oos.flush();
            } catch (IOException e) {
                System.out.println("无法发送消息到：" + onLineSocket.getRemoteSocketAddress());
                iterator.remove();
            }
        }
    }
}



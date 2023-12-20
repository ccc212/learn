package src.thread;

import src.UI.Game;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class ChatThread extends Thread{
    private Socket socket;
    public ChatThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while (true){
                try {
                    String msg = dis.readUTF();
                    System.out.println(msg);
                } catch (Exception e) {
                    System.out.println("自己下线了：" + socket.getRemoteSocketAddress());
                    dis.close();
                    socket.close();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

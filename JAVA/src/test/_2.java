package test;


import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class _2 {
    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动成功");
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket=serverSocket.accept();
        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String rs=dis.readUTF();
        System.out.println(rs);
        System.out.println(socket.getRemoteSocketAddress());
        dis.close();
        socket.close();
    }
}

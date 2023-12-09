package homework;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//编写基于TCP的服务器端程序，读取并显示来自客户端的对象信息。
public class shiyan8_2 {
    public static void main(String[] args) throws Exception {
        System.out.println("-----服务端启动成功-------");
        ServerSocket serverSocket=new ServerSocket(8080);
        Socket socket=serverSocket.accept();
        InputStream is=socket.getInputStream();
        DataInputStream dis=new DataInputStream(is);
        while (true){
            try {
                // 5、使用数据输入流读取客户端发送过来的消息
                String rs = dis.readUTF();
                System.out.println(rs);
            } catch (Exception e) {
                dis.close();
                socket.close();
                break;
            }
        }
    }
}

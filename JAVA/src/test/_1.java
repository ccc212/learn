package test;


import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class _1 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.7.7.1",8888);
        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("hello world");
        dos.close();
        socket.close();
    }
}

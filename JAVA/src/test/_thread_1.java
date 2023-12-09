package test;


import java.io.*;
import java.net.Socket;

public class _thread_1 extends Thread{
    private Socket socket;
    public _thread_1(Socket socket) {
        this.socket=socket;
    }
    @Override
    public void run() {
        try {
            OutputStream os=socket.getOutputStream();
            PrintStream ps=new PrintStream(os);
            ps.println("HTTP/1.1 200 =OK");
            ps.println("Content_Type:text/html;charset=UTF-8");
            ps.println();
            ps.println("<div style='color:red;font-size:120px;text-align:center'>hello</div>");
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendMsgToAll(String msg) throws IOException {
        for (Socket onLineSocket : _2.onlineSockets) {
            OutputStream os = onLineSocket.getOutputStream();
            DataOutputStream dos=new DataOutputStream(os);
            dos.writeUTF(msg);
            dos.flush();
        }
    }
}

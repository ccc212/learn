package test;


import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class _1 {
    public static void main(String[] args) throws Exception {
        Socket socket=new Socket("127.0.0.1",8888);
        new _thread_2(socket).start();
        OutputStream os=socket.getOutputStream();
        DataOutputStream dos=new DataOutputStream(os);
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("请说:");
            String msg=sc.nextLine();
            if("exit".equals(msg)){
                System.out.println("欢迎下次光临");
                dos.close();
                socket.close();
                break;
            }
            dos.writeUTF(msg);
            dos.flush();
        }

    }
}

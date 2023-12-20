package src;

import src.thread.GameRunnable;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Player {
    public Player(int port) throws Exception {
        Socket socket = new Socket("127.0.0.1", port);

        ThreadPoolExecutor pool = new ThreadPoolExecutor(12 * 2, 12 * 2, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(8) , Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        pool.execute(new GameRunnable(socket));

//        new ChatThread(socket).start();
//        OutputStream os = socket.getOutputStream();
//        DataOutputStream dos = new DataOutputStream(os);
//        Scanner sc = new Scanner(System.in);
//        while (true) {


//            System.out.println("请说：");
//            String msg = sc.nextLine();
//            if("exit".equals(msg)){
//                System.out.println("欢迎您下次光临！退出成功！");
//                dos.close();
//                socket.close();
//                break;
//            }
//            dos.writeUTF(msg);
//            dos.flush();
//        }
    }

    public static void main(String[] args) throws Exception {
        new Player(8080);
    }
}

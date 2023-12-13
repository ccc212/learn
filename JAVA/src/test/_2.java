package test;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class _2 {
    public static List<Socket>onlineSockets=new ArrayList<>();
    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动成功");
        ServerSocket serverSocket=new ServerSocket(8888);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(16 * 2, 16 * 2, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(8), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        while(true){
            Socket socket=serverSocket.accept();
            onlineSockets.add(socket);
            System.out.println("有人上线了:"+socket.getRemoteSocketAddress());
            new _thread_1(socket).start();
        }
    }
}

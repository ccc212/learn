package day7.buffer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedStreamDemo2 {
    /*
        字节缓冲流输入流, 读取数据的过程
     */
    public static void main(String[] args) throws IOException  {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\C.txt"));
        int i = bis.read();
        System.out.println(i);
        bis.close();
    }
}


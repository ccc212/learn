package day7._output;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo2 {
    /*
        流对象使用完毕后需要关闭
     */
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\B.txt");

        fos.write("abc".getBytes());

        fos.close();

        while (true) {}
    }
}

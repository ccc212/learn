package day7._input;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo1 {
    /*
        字节流读取数据

            public int read() : 读取单个字节
     */
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("D:\\A.txt");

        int i;
        while ((i = fis.read()) != -1) {
            System.out.println((char) i);
        }

        fis.close();

    }
}

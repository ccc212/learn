package day7._input;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileInputStreamDemo2 {
    /*
        字节流读取数据

            public int read(byte[] bys) : 读取一个字节数组

                    - 将读取到的字节, 存入数组容器, 返回读取到的有效字节个数
     */
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("D:\\A.txt");

        // 准备菜篮子, 用于装(字节)
        byte[] bys = new byte[2];

        int len;
        while( (len = fis.read(bys)) != -1 ){
            String s = new String(bys, 0, len);
            System.out.print(s);
        }

        fis.close();

    }
}

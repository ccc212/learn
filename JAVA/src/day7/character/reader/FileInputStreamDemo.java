package day7.character.reader;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    /**
     * 使用字节流读取纯文本文件
     */
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\A.txt");

        byte[] bys = new byte[3];

        int i;
        while((i = fis.read(bys)) != -1){
            String s = new String(bys);
            System.out.println(s);
        }

        fis.close();
    }
}

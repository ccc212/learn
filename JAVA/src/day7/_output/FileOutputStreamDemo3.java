package day7._output;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo3 {
    /*
        IO流的异常处理方式: jdk7版本之前
     */
    public static void main(String[] args) {

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("D:\\B.txt");
            fos.write("abc".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

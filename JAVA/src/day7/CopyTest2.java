package day7;

import java.io.*;

public class CopyTest2 {
    /*
        D:\00-课程介绍.mp4   146MB

        拷贝的效率测试:

            1. 普通流单个字节拷贝            361719毫秒
            2. 普通流 + 自定义数组拷贝        146毫秒
            3. 缓冲流单个字节拷贝            2055毫秒
            4. 缓冲流 + 自定义数组拷贝        148毫秒
     */
    public static void main(String[] args) throws IOException {

        long start = System.currentTimeMillis();

        copyFile2();

        long end = System.currentTimeMillis();

        System.out.println(end - start);

    }

    public static void copyFile1() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\00-课程介绍.mp4");
        FileOutputStream fos = new FileOutputStream("E:\\copy1.mp4");

        int i;
        while ((i = fis.read()) != -1) {
            fos.write(i);
        }

        fis.close();
        fos.close();
    }

    public static void copyFile2() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\00-课程介绍.mp4");
        FileOutputStream fos = new FileOutputStream("E:\\copy2.mp4");

        byte[] bys = new byte[8192];
        int len;
        while ((len = fis.read(bys)) != -1) {
            fos.write(bys, 0, len);
        }

        fis.close();
        fos.close();
    }

    public static void copyFile3() throws IOException {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\00-课程介绍.mp4"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\copy3.mp4"));

        int i;
        while ((i = bis.read()) != -1) {
            bos.write(i);
        }

        bis.close();
        bos.close();

    }

    public static void copyFile4() throws IOException {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\00-课程介绍.mp4"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\copy4.mp4"));

        int len;
        byte[] bys = new byte[1024];
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }

        bis.close();
        bos.close();

    }
}

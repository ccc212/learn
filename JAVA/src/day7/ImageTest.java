package day7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ImageTest {
    /*
        图片文件加密解密

            加密思路：改变原始文件中的字节，就无法打开了
                    字节 ^ 2
            解密思路：将文件中的字节还原成原始字节即可
                    字节 ^ 2

     */
    public static void main(String[] args) throws IOException {
        // 1. 创建字节输入流对象, 关联要加密的图片
        FileInputStream fis = new FileInputStream("D:\\A.jpg");
        // 2. 创建一个容器, 用来存储读取到的字节
        ArrayList<Integer> list = new ArrayList<>();
        // 3. 循环读取文件中的字节, 并存入集合
        int i;
        while((i = fis.read()) != -1){
            list.add(i);
        }
        // 4. 关闭输入流对象
        fis.close();

        // 5. 创建输出流对象, 关联图片文件.
        FileOutputStream fos = new FileOutputStream("D:\\A.jpg");
        // 6. 遍历集合, 从集合中取出字节, 并写出
        for (Integer myByte : list) {
            fos.write(myByte ^ 2);
        }

        // 7. 关闭输出流对象
        fos.close();

    }
}

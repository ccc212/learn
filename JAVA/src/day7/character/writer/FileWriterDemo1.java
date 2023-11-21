package day7.character.writer;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo1 {
    /*
        FileWriter字符输出流写出数据 :

        构造方法:
                FileWriter(String fileName):                         字符输出流关联文件，路径以字符串形式给出
                FileWriter(String fileName, boolean append):         参数2: 追加写入的开关
                FileWriter(File file):                               字符输出流关联文件，路径以File对象形式给出
                FileWriter(File file, boolean append):               参数2: 追加写入的开关

        成员方法:
                public void write(int c)                             写出单个字符
                public void write(char[] cbuf)                       写出一个字符数组
                public void write(char[] cbuf, int off, int len)     写出字符数组的一部分
                public void write(String str)                        写出字符串
                public void write(String str, int off, int len)      写出字符串的一部分
     */
    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("D:\\C.txt");

        char[] chs = {'a','b','c'};

        fw.write('a');
        fw.write(chs);
        fw.write(chs, 0, 2);
        fw.write("你好你好~");
        fw.write("哈哈哈哈哈", 0, 2);

        fw.close();


    }
}

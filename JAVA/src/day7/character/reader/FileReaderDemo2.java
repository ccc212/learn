package day7.character.reader;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo2 {
    /**
     * Debug查看读取过程
     */
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\B.txt");

        int i1 = fr.read();
        int i2 = fr.read();
        int i3 = fr.read();
        int i4 = fr.read();

        fr.close();
    }
}

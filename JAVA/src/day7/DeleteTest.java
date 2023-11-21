package day7;

import java.io.File;

public class DeleteTest {
    /*
        需求: 键盘录入一个文件夹路径, 删除这个文件夹
     */
    public static void main(String[] args) {

        File dir = new File("D:\\test");

        deleteDir(dir);

    }

    // 方法的参数: 接收到的肯定是文件夹
    public static void deleteDir(File dir) {

        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                // 文件直接删
                file.delete();
            } else {
                // 文件夹, 进入文件夹删除文件
                if (file.listFiles() != null) {
                    deleteDir(file);
                }
            }
        }

        // 循环如果结束, 说明这个文件夹已经操作完毕, 就是空的文件夹了
        // 删除空文件夹
        dir.delete();

    }
}

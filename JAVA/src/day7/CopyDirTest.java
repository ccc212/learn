package day7;

import java.io.*;

public class CopyDirTest {
    /*
        拷贝一个文件夹, 考虑子文件夹

        将D:\\test文件夹, 拷贝到E:\\
     */
    public static void main(String[] args) throws IOException {
        File src = new File("E:\\test");
        File dest = new File("D:\\");

        if (src.equals(dest)) {
            System.out.println("目标文件夹是源文件夹的子文件夹");
        } else {
            copyDir(src, dest);
        }


    }

    public static void copyDir(File src, File dest) throws IOException {

        File newDir = new File(dest, src.getName());
        newDir.mkdirs();

        // 从数据源中获取数据(File对象)
        File[] files = src.listFiles();
        // 遍历数组, 获取每一个文件或文件夹对象
        for (File file : files) {
            // 判断当前对象是否是文件
            if (file.isFile()) {
                // 是的话直接拷贝
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(new File(newDir, file.getName()));

                int len;
                byte[] bys = new byte[1024];
                while ((len = fis.read(bys)) != -1) {
                    fos.write(bys, 0, len);
                }

                fis.close();
                fos.close();

            } else {
                // 如果是文件夹, 递归调用方法
                copyDir(file, newDir);
            }
        }
    }
}

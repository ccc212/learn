package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FolderUtils {

    /**
     * 将源文件夹复制到目标位置，并覆盖同名文件夹
     * @param sourceFolderPath 源文件夹路径
     * @param destinationFolderPath 目标文件夹路径
     * @throws IOException 如果复制过程中发生错误
     */
    public static void copyFolder(String sourceFolderPath, String destinationFolderPath) throws IOException {
        File sourceFolder = new File(sourceFolderPath);
        File destinationFolder = new File(destinationFolderPath);

        if (!sourceFolder.exists() || !sourceFolder.isDirectory()) {
            throw new IllegalArgumentException("源文件夹不存在或不是一个文件夹！");
        }

        if (destinationFolder.exists()) {
            // 如果目标文件夹存在，则先删除
            deleteFolder(destinationFolder);
        }

        // 复制源文件夹到目标位置
        Files.copy(sourceFolder.toPath(), destinationFolder.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    // 递归删除文件夹及其内容
    public static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteFolder(file);
                } else {
                    file.delete();
                }
            }
        }
        folder.delete();
    }

    public static boolean isFolderEmpty(File folder) {
        // 获取文件夹中所有文件和文件夹
        File[] files = folder.listFiles();

        // 如果文件夹不存在或者文件夹为空，则返回true，否则返回false
        return files == null || files.length == 0;
    }
}

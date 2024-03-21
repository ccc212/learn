package org.example;

import java.io.*;
import java.nio.file.Files;

public class FolderUtils {
    public static void copyFolder(File sourceFolder, File destFolder) throws IOException {
        if (!destFolder.exists()) {
            destFolder.mkdirs(); // 创建目标文件夹
        }

        if (sourceFolder.isFile()) {
            copyFile(sourceFolder, new File(destFolder, sourceFolder.getName()));
        }

        // 获取源文件夹下所有文件和文件夹
        File[] files = sourceFolder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // 如果是文件夹，则递归拷贝文件夹内的内容
                    copyFolder(file, new File(destFolder, file.getName()));
                } else {
                    // 如果是文件，则直接拷贝文件内容
                    copyFile(file, new File(destFolder, file.getName()));
                }
            }
        }
    }

    public static void copyFile(File sourceFile, File destFile) throws IOException {
        try (InputStream input = Files.newInputStream(sourceFile.toPath());
             OutputStream output = Files.newOutputStream(destFile.toPath())) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        }
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

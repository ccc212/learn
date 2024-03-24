package com.ccc212;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

    private static final int BUFFER_SIZE = 2 * 1024;
    /**
     * 压缩成ZIP 公共方法
     *
     * @param sourceFile 压缩文件夹路径
     * @param out        压缩文件输出流
     * @throws RuntimeException 压缩失败会抛出运行时异常
     */
    public static void Zip(File sourceFile, File out) throws RuntimeException {
        ZipOutputStream zos = null;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(out);
            zos = new ZipOutputStream(fos);
            compress(sourceFile, zos, sourceFile.getName());
        } catch (Exception e) {
            throw new RuntimeException("zip error from ZipUtils", e);
        } finally {
            if (zos != null) {
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 递归压缩方法
     *
     * @param sourceFile 源文件
     * @param zos        zip输出流
     * @param name       压缩后的名称
     * @throws Exception e
     */
    private static void compress(File sourceFile, ZipOutputStream zos, String name) throws Exception {
        byte[] buf = new byte[BUFFER_SIZE];
        if (sourceFile.isFile()) {
            zos.putNextEntry(new ZipEntry(name));
            int len;
            FileInputStream in = new FileInputStream(sourceFile);
            while ((len = in.read(buf)) != -1) {
                zos.write(buf, 0, len);
            }
            zos.closeEntry();
            in.close();
        } else {
            File[] listFiles = sourceFile.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                zos.putNextEntry(new ZipEntry(name + "/"));
                zos.closeEntry();
            } else {
                for (File file : listFiles) {
                    compress(file, zos, name + "/" + file.getName());
                }
            }
        }
    }

    /**
     * 解压缩ZIP文件
     * @param zipFile ZIP文件
     * @param destDir 目标路径
     */
    @SuppressWarnings("all")
    public static void UnZip(File zipFile, File destDir) {
        byte[] buffer = new byte[1024];
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry entry = zis.getNextEntry();
            while (entry != null) {
                File file = new File(destDir, entry.getName());
                if (entry.isDirectory()) {
                    file.mkdirs();
                } else {
                    File parent = file.getParentFile();
                    if (!parent.exists()) {
                        parent.mkdirs();
                    }
                    // 如果目标文件已存在，则先删除
                    if (file.exists()) {
                        file.delete();
                    }
                    try (FileOutputStream fos = new FileOutputStream(file)) {
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                }
                entry = zis.getNextEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

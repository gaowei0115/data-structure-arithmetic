package com.mmc.data.structure.system.disk;

import java.io.File;

/**
 * @packageName：com.mmc.data.structure.system.disk
 * @desrciption: 递归打印磁盘文件
 * @author: gaowei
 * @date： 2018-02-24 15:55
 * @history: (version) author date desc
 */
public class PrintDiskFileTest {

    public static void main(String[] args) {
        String rootPath = "D:\\迅雷下载\\";

        File rootFile = new File(rootPath);
        printFile(rootFile);
    }

    public static void printFile(File file) {
        if (file.isDirectory()) {
            System.out.println("directory: " + file.getName());
            File[] files = file.listFiles();
            if (files == null || files.length == 0) {
                return;
            }
            for (File f : files) {
                printFile(f);
            }
        } else {
            printString(file);
        }
    }

    public static void printString(File file) {
        System.out.println("file: " + file.getName());
    }

}

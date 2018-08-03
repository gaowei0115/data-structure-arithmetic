package com.mmc.data.structure.system.tree.example;

import java.io.File;

/**
 * @packageName：com.mmc.data.structure.system.tree.example
 * @desrciption: 罗列指定目录下的所有文件及大小
 * @author: gaowei
 * @date： 2018-05-23 10:09
 * @history: (version) author date desc
 */
public class FileList {

    public static void list(String rootPath, int count) {
        if (rootPath == null || rootPath.isEmpty()) {
            System.out.println("路径为空！");
            return;
        }

        try {
            File rootFile = new File(rootPath);
            if (rootFile != null) {
                File[] files = rootFile.listFiles();
                for (File f : files) {
                    if (f.isDirectory()) {
                        StringBuffer sb = new StringBuffer();
                        int temp = count + 1;
                        for (int i = 0; i < temp; i++ ) {
                            sb.append("-");
                        }
                        System.out.println(sb.toString() + "" + f.getName());
                        list(f.getPath(), temp);
                    } else {
                        StringBuffer sb = new StringBuffer();
                        int temp = count + 1;
                        for (int i = 0; i < temp; i++ ) {
                            sb.append("-");
                        }
                        System.out.println(sb.toString() + "" + f.getName());
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String rootPath = "D:\\gw\\mmc\\装修\\";
        list(rootPath, 0);
    }
}

package com.mmc.data.structure.tableStackQueue.system.analyze;

import java.io.*;
import java.util.Random;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.analyze
 * @desrciption: 随机产生数据，并写入文件中
 * @author: gaowei
 * @date： 2018-01-25 13:49
 * @history: (version) author date desc
 */
public class RandomAccessFile {

    public static int sum = 1000000;

    /**
     * 写入文件
     * @param fileName
     */
    public static void writeFile(String fileName) {
        try {
            System.out.println(RandomAccessFile.class.getClassLoader().getResource("//").getPath());
            String localPath = RandomAccessFile.class.getClassLoader().getResource("//").getPath() + fileName;
            File file = new File(localPath);
            if (!file.exists()) {
                file.createNewFile();
            }

            Random random = new Random();
            FileWriter fw = new FileWriter(file);
            for (int i = 1; i <= sum; i++) {
                if (i % 3 != 0) {
                    fw.write("" + random.nextInt(99999999));
                } else {
                    fw.write("-" + random.nextInt(99999999));
                }
                if (i != sum) {
                    fw.write(",");
                }
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取文件
     * @param fileName
     * @return
     */
    public static int[] readFile(String fileName) {
        try {
            String localPath = RandomAccessFile.class.getClassLoader().getResource("//").getPath() + fileName;
            File file = new File(localPath);
            if (!file.exists()) {
                throw new IllegalArgumentException("file not exist...");
            }
            int[] arr = new int[sum];
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str ;
            while ((str = br.readLine()) != null) {
                String[] arrStr = str.split(",");
                for (int i = 0; i < arrStr.length; i++) {
                    arr[i] = Integer.parseInt(arrStr[i]);
                }
            }
            return arr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
       String fileName = "file.txt";
       writeFile(fileName);
    }
}

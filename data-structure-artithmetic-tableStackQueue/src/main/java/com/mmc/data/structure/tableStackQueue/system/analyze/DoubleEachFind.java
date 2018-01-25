package com.mmc.data.structure.tableStackQueue.system.analyze;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.analyze
 * @desrciption: 双层循环查找文件存在两个数值之和为0
 * @author: gaowei
 * @date： 2018-01-25 14:22
 * @history: (version) author date desc
 */
public class DoubleEachFind {

    /**
     *
     * @param arr
     */
    public static void each(int[] arr) {
        Stopwatch stopwatch = new Stopwatch();
        int len = arr.length;
        int count = 0;
        for (int i = 0; i < len - 1; i++) {
            int before = arr[i];
            for (int j = i; j < len; j++) {
                int after = arr[j];
                if (before + after == 0) {
                    System.out.println("(arr[" + i + "]=" + before + " ) == (arr[" + j + "]=" + after + ")");
                    count++;
                }
            }
        }
        System.out.println("共：" + count + " 个");
        System.out.println("cost time : " + stopwatch.stop() + " s");
    }

    public static void main(String[] args) {
        String fileName = "doubleeach.txt";
        System.out.println("write file data....");
        RandomAccessFile.writeFile(fileName);

        System.out.println("read file data....");
        int[] arr = RandomAccessFile.readFile(fileName);

        each(arr);

    }
}

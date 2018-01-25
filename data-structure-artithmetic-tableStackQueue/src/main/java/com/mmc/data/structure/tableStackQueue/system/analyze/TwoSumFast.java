package com.mmc.data.structure.tableStackQueue.system.analyze;

import java.util.Arrays;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.analyze
 * @desrciption: 使用二分查找方式实现对文件中相等数据的比对
 * @author: gaowei
 * @date： 2018-01-25 14:54
 * @history: (version) author date desc
 */
public class TwoSumFast {


    /**
     *
     * @param arr
     * @return
     */
    public static int count(int[] arr) {
        Stopwatch stopwatch = new Stopwatch();
        Arrays.sort(arr);
        int n = arr.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int j = 0;
            if ((j = BinarySearch.search(-arr[i], arr)) > i) {
                System.out.println("(arr[" + i + "]=" + arr[i] + " ) == (arr[" + j + "]=" + arr[j] + ")");
                cnt++;
            }
        }
        System.out.println("cost time: " + stopwatch.stop() + " s");
        return cnt;
    }

    public static void main(String[] args) {
        String fileName = "doubleeach.txt";
//        System.out.println("write file data....");
//        RandomAccessFile.writeFile(fileName);

        System.out.println("read file data....");
        int[] arr = RandomAccessFile.readFile(fileName);

        int count = count(arr);
        System.out.println("count: " + count);
    }
}

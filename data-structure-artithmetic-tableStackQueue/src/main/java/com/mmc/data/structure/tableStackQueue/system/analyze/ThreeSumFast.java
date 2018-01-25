package com.mmc.data.structure.tableStackQueue.system.analyze;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.analyze
 * @desrciption: 三组运算
 * @author: gaowei
 * @date： 2018-01-25 16:47
 * @history: (version) author date desc
 */
public class ThreeSumFast {

    /**
     *
     * @param arr
     */
    public static void count(int[] arr) {
        Stopwatch stopwatch = new Stopwatch();
        int n = arr.length;
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int z = 0;
                if ((z = BinarySearch.search(-arr[i]-arr[j], arr)) > j) {
                    System.out.println("(arr[" + i + "]=" + arr[i] + " ) + (arr[" + j + "]=" + arr[j] + ") == " + "(arr[" + z + "]=" + arr[z] + ")");
                    cnt++;
                }
            }
        }
        System.out.println("count: " + cnt);
        System.out.println("cost time: " + stopwatch.stop() + " s");
    }

    public static void main(String[] args) {
        String fileName = "doubleeach.txt";
        System.out.println("read file data....");
        int[] arr = RandomAccessFile.readFile(fileName);

        count(arr);
    }
}

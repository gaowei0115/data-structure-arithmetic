package com.mmc.data.structure.tableStackQueue.system.analyze;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.analyze
 * @desrciption: 二分查找
 * @author: gaowei
 * @date： 2018-01-25 14:56
 * @history: (version) author date desc
 */
public class BinarySearch {

    /**
     * 二分查找
     * @param param
     * @param arr
     * @return
     */
    public static int search(int param, int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            int temp = arr[mid];
            if (temp == param) {
               return mid;
            } else if (param > temp) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

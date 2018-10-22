package com.mmc.data.structure.system.binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName：com.mmc.data.structure.system.binarySearch
 * @desrciption: 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。

                    示例 1:
                    输入: [1,2,3,4,5], k=4, x=3
                    输出: [1,2,3,4]

                    示例 2:
                    输入: [1,2,3,4,5], k=4, x=-1
                    输出: [1,2,3,4]

                    说明:
                        k 的值为正数，且总是小于给定排序数组的长度。
                        数组不为空，且长度不超过 104
                        数组里的每个元素与 x 的绝对值不超过 104
 * @author: gaowei
 * @date： 2018-10-22 9:59
 * @history: (version) author date desc
 */
public class SearchNearElements {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 4;
        int x = 3;
        List<Integer> result = findClosestElements(arr, k, x);
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }


    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();

        if (arr == null || arr.length == 0) {
            return list;
        }

        int low = 0;
        int high = arr.length - k;
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        for (int i = low; i < low + k; i++) {
            list.add(arr[i]);
        }
        return list;
    }


}

package com.mmc.data.structure.system;

/**
 * @packageName：com.mmc.data.structure.system
 * @desrciption: 排序工具类
 * @author: gaowei
 * @date： 2018-10-15 9:40
 * @history: (version) author date desc
 */
public class SortUtils {


    public static void main(String[] args) {
        int[] array = new int[]{7, 5, 3, 9, 10, 17, 14, 8, 11, 6, 4, 1, 19, 2};

        System.out.print("original data : ");
        print(array);

        array = new int[]{7, 5, 3, 9, 10, 17, 14, 8, 11, 6, 4, 1, 19, 2};
        System.out.println("bubble sort : ");
        sortBubble(array);
        print(array);

        array = new int[]{7, 5, 3, 9, 10, 17, 14, 8, 11, 6, 4, 1, 19, 2};
        System.out.println("select sort : ");
        sortSelect(array);
        print(array);

        array = new int[]{7, 5, 3, 9, 10, 17, 14, 8, 11, 6, 4, 1, 19, 2};
        System.out.println("insert sort : ");
        sortInsert(array);
        print(array);
    }

    /**
     * 打印数组
     * @param array
     */
    public static void print(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i] + "");
            }
        }
        System.out.print("}");
        System.out.println();
    }

    /**
     * 冒泡排序
     * @param array
     */
    public static void sortBubble(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            int temp = array[i];
            for (int j = i + 1; j < len; j++) {
                if (temp > array[j]) {
                    temp = array[j];
                    swap(i, j, array);
                }
            }
        }
    }

    /**
     * 选择排序
     * @param array
     */
    public static void sortSelect(int[] array) {

        if (array == null || array.length == 0) {
            return;
        }

        int len = array.length;
        int k = 0;
        for (int i = 0; i < len - 1; i++) {
            k = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[k]) {
                    k = j;
                }
            }
            swap(i, k, array);
        }
    }


    /**
     * 插入排序
     * @param array
     */
    public static void sortInsert(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int len = array.length;
        int i;
        int j;
        for (i = 1; i < len; i++) {
            int temp = array[i];
            j = i;
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    /**
     * 交换位置
     * @param start
     * @param end
     * @param array
     */
    private static void swap(int start, int end, int[] array) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }
}

package com.mmc.data.structure.system.heap;

/**
 * @packageName：com.mmc.data.structure.system.heap
 * @desrciption:
 * @author: gaowei
 * @date： 2018-09-10 16:55
 * @history: (version) author date desc
 */
public class HeapUtils {


    /**
     * 打印堆信息
     * @param arrays
     * @param <T>
     */
    public static <T> void displayHeap(T[] arrays) {
        int currentSize = arrays.length;
        System.out.print("heapArray: ");
        for (int i = 0; i < currentSize; i++) {
            if (arrays[i] != null) {
                System.out.print(arrays[i] + " ");
            } else {
                System.out.print("--");
            }
        }

        System.out.println();

        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = ".................................";
        System.out.println(dots + dots);

        while (currentSize > 0) {
            if (column == 0) {
                for (int i = 0; i < nBlanks; i++) {
                    System.out.print(" ");
                }
            }
            System.out.print(arrays[j]);
            if (++j == currentSize) {
                break;
            }
            if (++column == itemsPerRow) {
                nBlanks = nBlanks / 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else {
                for (int k = 0; k < nBlanks * 2 - 2; k++) {
                    System.out.print(" ");
                }
            }
        }
        System.out.println("\n" + dots + dots);
    }
}

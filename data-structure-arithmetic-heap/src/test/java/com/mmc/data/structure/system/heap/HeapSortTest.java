package com.mmc.data.structure.system.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * @packageName：com.mmc.data.structure.system.heap
 * @desrciption:
 * @author: gaowei
 * @date： 2018-09-10 14:29
 * @history: (version) author date desc
 */
public class HeapSortTest {

    public static void main(String[] args) {
        HeapSort<Integer> heapSort = new HeapSort<>();

        int size;
        int j;
        System.out.print("Enter number of items : ");
        size = getInt();
        for (j = 0; j < size; j++) {
            Integer r = (int) (Math.random() * 100);
            heapSort.addHeap(j, r);
            heapSort.incrementSize();
        }

        System.out.println("Random display : ");
        heapSort.dispayArrays();

        for (j = size / 2 - 1; j >= 0; j--) {
            heapSort.trickleDown(j);
        }

        System.out.println("heap: ");
        heapSort.displayHeap();

        for (j = size - 1; j >= 0; j--) {
            Integer ele = heapSort.remove();
            heapSort.addHeap(j, ele);
        }

        System.out.println("Sorted : ");
        heapSort.dispayArrays();

    }

    /**
     *
     * @return
     */
    private static int getInt() {
        try {
            String re = getStr();
            return Integer.parseInt(re);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    private static String getStr() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String result = br.readLine();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

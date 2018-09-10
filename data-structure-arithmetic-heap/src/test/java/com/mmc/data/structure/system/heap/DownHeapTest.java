package com.mmc.data.structure.system.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @packageName：com.mmc.data.structure.system.heap
 * @desrciption:
 * @author: gaowei
 * @date： 2018-09-10 16:57
 * @history: (version) author date desc
 */
public class DownHeapTest {

    public static void main(String[] args) {

        System.out.print("Enter heap items : ");
        int size = getInt();

        DownHeap<Integer> heap = new DownHeap<>(size);

        for (int i = 0; i < size; i++) {
            Integer r = (int) (Math.random() * 100);
            heap.add(r);
        }

        heap.displayHeap();

        heap.remove();

        heap.displayHeap();
    }

    public static int getInt() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String r = br.readLine();
            return Integer.parseInt(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}

package com.mmc.data.structure.system.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @packageName：com.mmc.data.structure.system.heap
 * @desrciption:
 * @author: gaowei
 * @date： 2018-09-05 14:40
 * @history: (version) author date desc
 */
public class MockHeapTest {

    public static void main(String[] args) {
        MockHeap<Integer> heap = new MockHeap<>();
        heap.add(34);
        heap.add(23);
        heap.add(40);
        heap.add(37);
        heap.add(50);
        heap.add(10);
        heap.add(70);
        heap.add(20);
        heap.add(65);

        while (true) {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, remove, change : ");

            char c = getChar();
            switch (c) {
                case 's':
                    heap.displayHeap();
                    break;
                case 'i':
                    System.out.print("Enter value of insert : ");
                    Integer data = getInt();
                    heap.add(data);
                    break;
                case 'r':
                    if (!heap.isEmpty()) {
                        Integer r = heap.remove();
                        System.out.println("remove ele : " + r);
                    } else {
                        System.out.println("can't remove, heap isEmpty! ");
                    }
                    break;
                case 'c':
                    System.out.print("Enter current index of : ");
                    int index = getInt();
                    System.out.print("Enter new value : ");
                    int newValue = getInt();
                    heap.change(index, newValue);
                    break;
                default:
                    System.out.println("Invalid entry \n");
            }

        }
    }


    private static Integer getInt() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try {
            String s = br.readLine();
            if (s != null && !"".equals(s)) {
                return Integer.parseInt(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    /**
     *
     * @return
     */
    private static char getChar() {
        InputStreamReader isr = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(isr);
        try {
            String s = br.readLine();
            return s.charAt(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}

package com.mmc.data.structure.system.test.sort;

import com.mmc.data.structure.system.sort.ArrayBubbleSort;
import org.junit.Test;

/**
 * @packageName：com.mmc.data.structure.system.test.sort
 * @desrciption:
 * @author: gaowei
 * @date： 2017/12/11 22:32
 * @history: (version) author date desc
 */
public class ArrayBubbleSortTest {

    @Test
    public void test() {
        ArrayBubbleSort<Long> abs = new ArrayBubbleSort<Long>(3);
        abs.insert(10L);
        abs.insert(50L);
        abs.insert(30L);
        abs.insert(40L);
        abs.insert(20L);

        abs.display();

        System.out.println(abs.get(1));

        abs.delete(2);

        abs.display();
    }

    @Test
    public void testSort() {
        ArrayBubbleSort<Long> abs = new ArrayBubbleSort<Long>(3);
        abs.insert(10L);
        abs.insert(50L);
        abs.insert(30L);
        abs.insert(40L);
        abs.insert(20L);

        abs.display();

        System.out.println("排序后：");
        abs.bubbleSort();
        abs.display();
    }

    @Test
    public void testBubbleSort() {
        long[] datas = new long[10];
        // 组织数据
        datas[0] = 7L;
        datas[1] = 14L;
        datas[2] = 2L;
        datas[3] = 30L;
        datas[4] = 702L;
        datas[5] = 120L;
        datas[6] = 21L;
        datas[7] = 73L;
        datas[8] = 1L;
        datas[9] = 25L;
        System.out.println("排序之前：");
        display(datas);
        long temp ;
        for (int i = 0; i < datas.length - 1; i++) {
            for (int j = 0; j < datas.length - i - 1; j++) {
                if (datas[j] > datas[j + 1]) {
                    temp = datas[j];
                    datas[j] = datas[j + 1];
                    datas[j + 1] = temp;
                }
            }
        }
        System.out.println("排序之后：");
        display(datas);
    }

    public void display(long[] datas) {
        System.out.print("[");
        for (int i = 0; i < datas.length; i++) {
            System.out.print(datas[i]);
            if (i != datas.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();
    }
}

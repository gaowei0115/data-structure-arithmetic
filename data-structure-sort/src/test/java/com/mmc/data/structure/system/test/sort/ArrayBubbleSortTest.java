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
}

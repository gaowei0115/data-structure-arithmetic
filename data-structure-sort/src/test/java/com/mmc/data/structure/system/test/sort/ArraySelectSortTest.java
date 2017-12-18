package com.mmc.data.structure.system.test.sort;

import com.mmc.data.structure.system.sort.ArrayBubbleSort;
import com.mmc.data.structure.system.sort.ArraySelectSort;
import org.junit.Test;

/**
 * @packageName：com.mmc.data.structure.system.test.sort
 * @desrciption: 选择排序测试
 * @author: gaowei
 * @date： 2017/12/16 15:50
 * @history: (version) author date desc
 */
public class ArraySelectSortTest {

    @Test
    public void testSelectSort() {
        ArraySelectSort<Long> abs = new ArraySelectSort<Long>(3);
        abs.insert(10L);
        abs.insert(50L);
        abs.insert(30L);
        abs.insert(40L);
        abs.insert(20L);
        System.out.println("排序前：");
        abs.display();
        System.out.println("排序后：");
        abs.selectSort();
        abs.display();
    }
}

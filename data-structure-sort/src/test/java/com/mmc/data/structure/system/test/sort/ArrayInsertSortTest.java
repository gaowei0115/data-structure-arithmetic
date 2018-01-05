package com.mmc.data.structure.system.test.sort;

import com.mmc.data.structure.system.sort.ArrayInsertSort;
import com.mmc.data.structure.system.sort.ArraySelectSort;
import org.junit.Test;

/**
 * @packageName：com.mmc.data.structure.system.test.sort
 * @desrciption: 插入排序测试
 * @author: gaowei
 * @date： 2017/12/16 19:59
 * @history: (version) author date desc
 */
public class ArrayInsertSortTest {

    @Test
    public void testInsertSort() {
        ArrayInsertSort<Long> abs = new ArrayInsertSort<Long>(3);
        abs.add(10L);
        abs.add(50L);
        abs.add(30L);
        abs.add(40L);
        abs.add(20L);
        System.out.println("排序前：");
        abs.display();
        System.out.println("排序后：");
        abs.insertSort();
        abs.display();
    }
}

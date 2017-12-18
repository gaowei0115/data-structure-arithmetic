package com.mmc.data.structure.system.test.sort;

import com.mmc.data.structure.system.entity.OrderSortEntity;
import com.mmc.data.structure.system.sort.ArrayObjectSort;
import org.junit.Test;

/**
 * @packageName：com.mmc.data.structure.system.test.sort
 * @desrciption:
 * @author: gaowei
 * @date： 2017/12/18 21:33
 * @history: (version) author date desc
 */
public class ArrayObjectSortTest {

    @Test
    public void test() {

        // 模拟数据
        OrderSortEntity entity1 = new OrderSortEntity(1001, "param1", "desc1");
        OrderSortEntity entity2 = new OrderSortEntity(1004, "param4", "desc4");
        OrderSortEntity entity3 = new OrderSortEntity(1002, "param2", "desc2");
        OrderSortEntity entity4 = new OrderSortEntity(1008, "param8", "desc8");
        OrderSortEntity entity5 = new OrderSortEntity(1005, "param5", "desc5");
        OrderSortEntity entity6 = new OrderSortEntity(1007, "param7", "desc7");
        OrderSortEntity entity7 = new OrderSortEntity(1003, "param3", "desc3");
        OrderSortEntity entity8 = new OrderSortEntity(1006, "param6", "desc6");

        ArrayObjectSort<OrderSortEntity> arrays = new ArrayObjectSort<OrderSortEntity>(4);
        arrays.add(entity1);
        arrays.add(entity2);
        arrays.add(entity3);
        arrays.add(entity4);
        arrays.add(entity5);
        arrays.add(entity6);
        arrays.add(entity7);
        arrays.add(entity8);

        System.out.println("排序前：");
        arrays.display();

//        System.out.println("插入排序后：");
//        arrays.insertSort();
//        arrays.display();

//        System.out.println("选择排序后：");
//        arrays.selectSort();
//        arrays.display();


        System.out.println("冒泡排序后：");
        arrays.bubbleSort();
        arrays.display();
    }
}

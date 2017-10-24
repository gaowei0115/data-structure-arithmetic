package com.mmc.data.structure.tableStackQueue.system.train;

import com.mmc.data.structure.tableStackQueue.system.javaApi.AutoLinkedList;
import org.junit.Before;
import org.junit.Test;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.train
 * 类 名: TrainSeason33
 * 描 述: 表、栈、队列编程题
 * 作 者: GW
 * 创 建： 2017-10-24 10:10
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class TrainSeason33 {

    /**
     * 实现自定义链表的contains方法 参见：AutoLinkedList
     */

    private AutoLinkedList<String> linkedList;
    private String validate = "22222";

    @Before
    public void setUp() {
        linkedList = new AutoLinkedList<String>();
        linkedList.add("11111");
        linkedList.add("22222");
        linkedList.add("33333");
        String val = "22222";
    }

    @Test
    public void test() {
        System.out.println("是否包含 " + validate + " : " + linkedList.contains(validate));
    }


    @Test
    public void test01() {
        validate = "222221";
        System.out.println("是否包含 " + validate + " : " + linkedList.contains(validate));
    }
}

package com.mmc.data.structure.tableStackQueue.system.train;

import com.mmc.data.structure.tableStackQueue.system.linked.DoubleLinkedList;
import com.mmc.data.structure.tableStackQueue.system.linked.SingleLinkedList;
import org.junit.Test;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.train
 * 类 名: TrainSeason32
 * 描 述: 表、栈、队列编程题
 * 作 者: GW
 * 创 建： 2017-10-23 15:55
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class TrainSeason32 {

    /**
     * 通过调整链（不是调整数据）来交换两个相邻的元素，
     * 使用：单链表
     *       双链表
     */


    /**
     * 单链表交换实现
     */
    @Test
    public void test01() {
        SingleLinkedList<String> singleLinked = new SingleLinkedList<String>();
        singleLinked.push("1111");
        singleLinked.push("2222");
        singleLinked.push("3333");
        singleLinked.push("4444");
        singleLinked.push("5555");



        singleLinked.swap(3);

        while(!singleLinked.isEmpty()) {
            System.out.println(singleLinked.poll());
        }
    }

    /**
     * 双向链表交换实现
     */
    @Test
    public void test02() {
        DoubleLinkedList<String> doubleLinkedList = new DoubleLinkedList<String>();
        doubleLinkedList.push("1111");
        doubleLinkedList.push("2222");
        doubleLinkedList.push("3333");
        doubleLinkedList.push("4444");
        doubleLinkedList.push("5555");



        doubleLinkedList.swap(1);

        System.out.println(doubleLinkedList);

        while (!doubleLinkedList.isEmpty()) {
            System.out.println(doubleLinkedList.pollFirst());
//            System.out.println(doubleLinkedList.pollLast());
        }
    }
}

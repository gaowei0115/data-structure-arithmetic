package com.mmc.data.structure.tableStackQueue.system.train;

import com.mmc.data.structure.tableStackQueue.system.linked.SingleLinkedList;
import org.junit.Test;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.train
 * 类 名: TrainSeason312
 * 描 述: 表、栈、队列编程
 * 作 者: GW
 * 创 建： 2017-10-30 13:34
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class TrainSeason312 {


    /**
     * 单链表排序
     */

    @Test
    public void test() {
        SingleLinkedList<Integer> l = new SingleLinkedList<Integer>();
        l.push(10);
        l.push(12);
        l.push(8);
        l.push(9);
        l.push(14);
        l.push(18);
        l.push(1);
        l.push(6);
        l.sort();
        while(!l.isEmpty()) {
            System.out.println(l.poll());
        }
    }
}

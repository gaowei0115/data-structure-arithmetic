package com.mmc.data.structure.tableStackQueue.system.train;

import com.mmc.data.structure.tableStackQueue.system.linked.SingleLinkedList;
import org.junit.Before;
import org.junit.Test;
import static java.lang.System.out;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.train
 * 类 名: TrainSeason311
 * 描 述: 表、队列、栈编程
 * 作 者: GW
 * 创 建： 2017-10-26 17:09
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class TrainSeason311 {

    /**
     * 实现单链表，实现输出链表大小、打印链表节点、验证是否包含某个节点，添加如果不包含就添加元素方法
     * 添加删除方法：如果存在节点删除
     */

    private SingleLinkedList<Integer> l1 = new SingleLinkedList<Integer>();

    @Before
    public void setUp() {
        for (int i = 0; i < 10; i++) {
            l1.push(i + 1);
        }
    }

    /**
     * 链表大小
     */
    @Test
    public void test() {
        System.out.println(l1.size());
    }

    /**
     * 打印链表节点
     */
    @Test
    public void test01() {
        l1.print();
    }

    /**
     * 验证是否包含某个节点
     */
    @Test
    public void test02() {
        out.println(l1.contain(1000002));
    }

    /**
     * 如果不存在添加元素
     */
    @Test
    public void test03() {
        l1.print();
        l1.putIfAbsract(10);
        l1.print();
    }

    /**
     * 如果存在元素则删除
     */
    @Test
    public void test04() {
        l1.print();
        l1.removeIfAbstract(6);
        l1.print();
    }

}

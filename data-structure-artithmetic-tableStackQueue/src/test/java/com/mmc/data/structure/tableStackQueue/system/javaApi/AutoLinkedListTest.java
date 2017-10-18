package com.mmc.data.structure.tableStackQueue.system.javaApi;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.javaApi
 * 类 名: AutoLinkedListTest
 * 描 述:
 * 作 者: GW
 * 创 建： 2017-10-18 16:45
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class AutoLinkedListTest {


    @Test
    public void test() {
        AutoLinkedList<String> autoLinkedList = new AutoLinkedList<String>();
        autoLinkedList.add("1111");
        autoLinkedList.add("2222");
        System.out.println(autoLinkedList);
        Iterator<String> iter = autoLinkedList.iterator();
        while(iter.hasNext()) {
            System.out.println(">>>" + iter.next());
        }
        for (String p : autoLinkedList) {
            System.out.println(p);
        }
    }
}

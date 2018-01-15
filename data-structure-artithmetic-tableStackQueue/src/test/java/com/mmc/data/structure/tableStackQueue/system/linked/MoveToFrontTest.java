package com.mmc.data.structure.tableStackQueue.system.linked;

import org.junit.Test;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.linked
 * @desrciption: 前移编码测试
 * @author: gaowei
 * @date： 2018-01-15 11:04
 * @history: (version) author date desc
 */
public class MoveToFrontTest {

    /**
     *
     */
    @Test
    public void test() {
        MoveToFront<String> moveLinked = new MoveToFront<String>();
        moveLinked.put("moveLinked-01");
        moveLinked.put("moveLinked-02");
        moveLinked.put("moveLinked-03");
        moveLinked.put("moveLinked-04");
        moveLinked.put("moveLinked-05");
        moveLinked.put("moveLinked-06");

        moveLinked.put("moveLinked-03");

        System.out.println(moveLinked);
    }
}

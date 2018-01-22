package com.mmc.data.structure.tableStackQueue.system.stack;

import org.junit.Test;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.stack
 * @desrciption:
 * @author: gaowei
 * @date： 2018-01-22 10:58
 * @history: (version) author date desc
 */
public class StackBufferTest {

    @Test
    public void test() {
        StackBuffer  stackBuffer = new StackBuffer();
        stackBuffer.insert('a');
        stackBuffer.insert('b');
        stackBuffer.insert('c');
        stackBuffer.insert('d');
        stackBuffer.insert('e');
        stackBuffer.insert('f');
        stackBuffer.insert('g');
        stackBuffer.insert('h');
        stackBuffer.insert('i');
        System.out.println("原数据：");
        stackBuffer.display();
        System.out.println();

        System.out.println("删除缓存区光标位置数据");
        stackBuffer.delete();
        stackBuffer.display();
        System.out.println();

        System.out.println("光标左移5位：");
        stackBuffer.left(5);
        stackBuffer.display();
        System.out.println();

        System.out.println("光标再次左移5位：");
        stackBuffer.left(5);
        stackBuffer.display();
        System.out.println();


        System.out.println("光标右移五位：");
        System.out.println("移动前缓存区大小：" + stackBuffer.getSize());
        stackBuffer.right(5);
        stackBuffer.display();
        System.out.println();
        System.out.println("移动后缓存区大小：" + stackBuffer.getSize());
        System.out.println();
    }
}

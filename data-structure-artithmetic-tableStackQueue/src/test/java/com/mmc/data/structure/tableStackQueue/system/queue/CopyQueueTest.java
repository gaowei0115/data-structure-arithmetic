package com.mmc.data.structure.tableStackQueue.system.queue;

import org.junit.Test;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.queue
 * @desrciption:
 * @author: gaowei
 * @date： 2018-01-15 13:44
 * @history: (version) author date desc
 */
public class CopyQueueTest {


    @Test
    public void test() {
        CopyQueue<String> copyQueue = new CopyQueue<String>();
        copyQueue.push("copy-01");
        copyQueue.push("copy-02");
        copyQueue.push("copy-03");
        copyQueue.push("copy-04");
        copyQueue.push("copy-05");

        CopyQueue<String> copy = new CopyQueue<String>(copyQueue);

        copy.push("copy-c-001");


        System.out.println("copy before : ");
        int cSize = copyQueue.getSize();
        int i = 0;
        System.out.print("[");
        while (!copyQueue.isEmpty()) {
            System.out.print(copyQueue.poll());
            if (cSize - 1 != i) {
                System.out.print(",");
            }
        }
        System.out.print("]");

        System.out.println("");

        System.out.println("copy after : ");
        cSize = copy.getSize();
        i = 0;
        System.out.print("[");
        while (!copy.isEmpty()) {
            System.out.print(copy.poll());
            if (cSize - 1 != i) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    @Test
    public void test01() {
        String str = "ceshi";
        System.out.println("before : " + str);
        change(str);
        System.out.println("after : " + str);
    }

    public void change(String str) {
        str = "ceshi-01";
    }

    @Test
    public void test02() {
        TestQuote q1 = new TestQuote();
        q1.param = 2;
        TestQuote.change1(q1);

//        TestQuote q2 = new TestQuote();
//        q2.param = 20;
//
//        q1 = q2;

        System.out.println(q1.param);
    }

    @Test
    public void test03() {
        CopyQueue<String> copyQueue = new CopyQueue<String>();
        copyQueue.push("test-01");
        copyQueue.push("test-02");
        System.out.println(copyQueue.poll());
        copyQueue.push("test-03");
        System.out.println(copyQueue.poll());
    }

}

/**
 *
 */
class TestQuote {

    public int param = 0;

    public void change(TestQuote quote) {
        TestQuote q2 = new TestQuote();
        q2.param = 20;
        quote = q2;
        System.out.println("change : " + quote.param);
//            quote.param = 20;
    }

    public static void change1(TestQuote quote) {
        TestQuote q2 = new TestQuote();
        q2.param = 20;
        quote = q2;
        System.out.println("change : " + quote.param);
    }
}

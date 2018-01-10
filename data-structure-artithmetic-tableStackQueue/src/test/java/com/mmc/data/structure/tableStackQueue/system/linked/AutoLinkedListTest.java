package com.mmc.data.structure.tableStackQueue.system.linked;

import org.junit.Test;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.linked
 * @desrciption:
 * @author: gaowei
 * @date： 2018-01-09 15:26
 * @history: (version) author date desc
 */
public class AutoLinkedListTest {


    /**
     * 链表测试
     */
    @Test
    public void test01() {
        AutoLinkedList<String> linkedList = new AutoLinkedList<String>();
        linkedList.add("linked-01");
        linkedList.add("linked-02");
        linkedList.add("linked-03");
        linkedList.add("linked-04");
        linkedList.add("linked-05");
        linkedList.add("linked-06");

        System.out.println("链表头部插入：");
        System.out.print("[");

        while (!linkedList.isEmpty()) {
            System.out.print(linkedList.pollFirst());
            System.out.print("-->");
        }
        System.out.print("]");
        System.out.println();

        linkedList = new AutoLinkedList<String>();
        linkedList.addLast("linked-01");
        linkedList.addLast("linked-02");
        linkedList.addLast("linked-03");
        linkedList.addLast("linked-04");
        linkedList.addLast("linked-05");
        linkedList.addLast("linked-06");

        System.out.println("链表尾部插入：");
        System.out.print("[");

        while (!linkedList.isEmpty()) {
            System.out.print(linkedList.pollFirst());
            System.out.print("-->");
        }
        System.out.print("]");
        System.out.println();
    }

    /**
     * 删除尾部节点
     */
    @Test
    public void test02() {
        AutoLinkedList<String> linked = new AutoLinkedList<String>();
        linked.addLast("linked-0a");
        linked.addLast("linked-0b");
        linked.addLast("linked-0c");
        linked.addLast("linked-0d");
        linked.addLast("linked-0e");
        linked.addLast("linked-0f");

        System.out.println("删除尾部节点");
        String reS = linked.removeSingleLast();
        System.out.println("--> " + reS);

        System.out.println("链表尾部插入：");
        System.out.print("[");

        while (!linked.isEmpty()) {
            System.out.print(linked.pollFirst());
            System.out.print("-->");
        }
        System.out.print("]");
        System.out.println();
    }

    /**
     * 删除指定位置的节点
     */
    @Test
    public void test03() {
        AutoLinkedList<String> linked1 = new AutoLinkedList<String>();
        linked1.addLast("linked-11");
        linked1.addLast("linked-12");
        linked1.addLast("linked-13");
        linked1.addLast("linked-14");
        linked1.addLast("linked-15");
        linked1.addLast("linked-16");

        System.out.println("删除指定位置节点");
        linked1.removeIndex(2);

        System.out.println("链表尾部插入：");
        System.out.print("[");

        while (!linked1.isEmpty()) {
            System.out.print(linked1.pollFirst());
            System.out.print("-->");
        }
        System.out.print("]");
        System.out.println();
    }


    /**
     * 查找元素
     */
    @Test
    public void test04() {
        AutoLinkedList<String> autoLinked = new AutoLinkedList<String>();
        autoLinked.addLast("first-00");
        autoLinked.addLast("second-00");
        autoLinked.addLast("threed-00");

        boolean result = autoLinked.find("threed-01");
        System.out.println("验证结果是会否存在：" + result);
    }

    /**
     * 删除某个节点后续节点
     */
    @Test
    public void test05() {
        AutoLinkedList<String> removeAfterLinked = new AutoLinkedList<String>();
        removeAfterLinked.addLast("remove-01");
        removeAfterLinked.addLast("remove-02");
        removeAfterLinked.addLast("remove-03");
        removeAfterLinked.addLast("remove-04");
        removeAfterLinked.addLast("remove-05");

        System.out.println("原数据：");
        System.out.print("[");
        while (!removeAfterLinked.isEmpty()) {
            System.out.print(removeAfterLinked.pollFirst());
            System.out.print("-->");
        }
        System.out.print("]");
        System.out.println();

        removeAfterLinked.addLast("remove-01");
        removeAfterLinked.addLast("remove-02");
        removeAfterLinked.addLast("remove-03");
        removeAfterLinked.addLast("remove-04");
        removeAfterLinked.addLast("remove-05");
        String remove = "remove-01";
        System.out.println("删除节点：" + "remove-01");
        removeAfterLinked.removeAfter("remove-04");
        System.out.println("删除后数据：");
        while (!removeAfterLinked.isEmpty()) {
            System.out.print(removeAfterLinked.pollFirst());
            System.out.print("-->");
        }
        System.out.print("]");
    }

    /**
     * 在节点后面插入节点
     */
    @Test
    public void test06() {
        AutoLinkedList<String> insertLinked = new AutoLinkedList<String>();
        insertLinked.addLast("insert-01");
        insertLinked.addLast("insert-02");
        insertLinked.addLast("insert-03");
        insertLinked.addLast("insert-04");
        insertLinked.addLast("insert-05");


        System.out.println("原数据：");
        System.out.print("[");
        while (!insertLinked.isEmpty()) {
            System.out.print(insertLinked.pollFirst());
            System.out.print("-->");
        }
        System.out.print("]");
        System.out.println();

        String before = "insert-03";
        String after = "insert-after";

        insertLinked.addLast("insert-01");
        insertLinked.addLast("insert-02");
        insertLinked.addLast(before);
        insertLinked.addLast("insert-04");
        insertLinked.addLast("insert-05");

        String remove = "remove-01";
        System.out.println("在 " + before + " 节点之后追加 " + after + " 节点");
        insertLinked.intertAfter(before, after);
        System.out.println("追加后数据：");
        while (!insertLinked.isEmpty()) {
            System.out.print(insertLinked.pollFirst());
            System.out.print("-->");
        }
        System.out.print("]");
    }

    /**
     *
     */
    @Test
    public void testRemoveAll() {
        AutoLinkedList<String> removeAllKey = new AutoLinkedList<String>();
        String key = "remove-all-02";
        removeAllKey.addLast("remove-all-01");
        removeAllKey.addLast("remove-all-03");
        removeAllKey.addLast(key);
        removeAllKey.addLast("remove-all-04");
        removeAllKey.addLast("remove-all-05");
        removeAllKey.addLast(key);

        System.out.println("原数据：");
        System.out.print("[");
        while (!removeAllKey.isEmpty()) {
            System.out.print(removeAllKey.pollFirst());
            System.out.print("-->");
        }
        System.out.print("]");
        System.out.println();


        removeAllKey.addLast("remove-all-01");
        removeAllKey.addLast("remove-all-03");
        removeAllKey.addLast(key);
        removeAllKey.addLast("remove-all-04");
        removeAllKey.addLast("remove-all-05");
        removeAllKey.addLast(key);

        System.out.println("删除所有key" + key);

        removeAllKey.removeAllKey(key);
        System.out.println("删除后结果：");
        System.out.print("[");
        while (!removeAllKey.isEmpty()) {
            System.out.print(removeAllKey.pollFirst());
            System.out.print("-->");
        }
        System.out.print("]");
        System.out.println();

    }

    /**
     * 查找链表中最大值
     */
    @Test
    public void testMaxNode() {
        AutoLinkedList<Integer> linkedList = new AutoLinkedList<Integer>();
        linkedList.addLast(14);
        linkedList.addLast(21);
        linkedList.addLast(31);
        linkedList.addLast(9);
        linkedList.addLast(56);
        linkedList.addLast(2);

        Integer max = linkedList.maxNode();
        if (max == null) {
            System.out.println("链表不存在...");
        } else {
            System.out.println("链表中最大值：" + max.intValue());
        }
    }

    /**
     * 查找链表中最大值（递归查找）
     */
    @Test
    public void testRecursionMaxNode() {
        AutoLinkedList<Integer> linkedList = new AutoLinkedList<Integer>();
        linkedList.addLast(89);
        linkedList.addLast(10);
        linkedList.addLast(23);
        linkedList.addLast(56);
        linkedList.addLast(321);
        linkedList.addLast(90);

        int max = linkedList.maxNode(linkedList.getFirst(), 0);
        System.out.println("递归查询链表中最大值：" + max);
    }

    public boolean isEquals(String str1, String str2) {
        if (str1 == str2) {
            return true;
        }
        if (str1 != null && str2 != null) {
            if (str1.equals(str2)) {
                return true;
            }
        }
        return false;
    }
}

package com.mmc.data.structure.tableStackQueue.system.linked;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.linked
 * @desrciption:
 * @author: gaowei
 * @date： 2018-01-09 15:13
 * @history: (version) author date desc
 */
public class AutoLinkedList<T extends Comparable<T>> {

    /**
     * 首节点
     */
    private Node<T> first;
    /**
     * 尾节点
     */
    private Node<T> last;

    /**
     * 长度
     */
    private int size;

    public AutoLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * 增加节点
     * @param data
     */
    public void add(T data) {
        final Node<T> node = new Node<T>(data, first);
        addFirst(node);
    }

    /**
     * 首部插入节点
     * @param node
     */
    public void addFirst(final Node<T> node) {
        Node<T> f = first;
        first = node;
        if (f == null) {
            last = node;
        }
        node.next = f;
        size++;
    }

    /**
     * 尾部插入节点
     * @param data
     */
    public void addLast(T data) {
        final Node<T> newNode = new Node<T>(data, null);
        Node<T> l = last;
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        this.size++;
    }

    /**
     * 头部弹出节点
     * @return
     */
    public T pollFirst() {
        final Node<T> f = first;
        if (f == null) {
            return null;
        }
        first = f.next;
        if (first == null) {
            last = null;
        }
        this.size--;
        return f.data;
    }

    /**
     * 删除指定第key个元素
     * @param key
     */
    public void removeIndex(int key) {
        Node<T> current = first;
        int i = 1;
        if (key < 1 || key > size) {
            throw new IllegalArgumentException("查找位置不存在");
        }
        if (key == i) {
            first = current.next;
        } else {
            while (current != null) {
                if (i == key - 1) {
                    break;
                }
                current = current.next;
            }
            current.next = current.next.next;
        }
        this.size--;
    }

    /**
     * 查找元素是否存在
     * @param data
     * @return
     */
    public boolean find(T data) {
        Node<T> current = first;
        while (current != null) {
            if (current.data.equals(data)) {
                break;
            }
            current = current.next;
        }
        if (current != null) {
            return true;
        }
        return false;
    }

    /**
     * 查找元素是否存在
     * @param data
     * @return
     */
    public Node<T> node(T data) {
        Node<T> current = first;
        while (current != null) {
            if (current.data.equals(data)) {
                break;
            }
            current = current.next;
        }
        if (current != null) {
            return current;
        }
        return null;
    }

    /**
     * 删除尾部节点(单向链表)
     * @return
     */
    public T removeSingleLast() {
        final Node<T> l = last;
        if (l == null) {
            return null;
        }
        /**
         * 由于是单向链表，需要查找
         */
        Node<T> current = first;
        Node<T> lastB = first;
        Node<T> temp = null;
        while (current != null) {
            temp = current.next;
            if (temp != null && temp.data.equals(last.data)) {
                lastB = current;
                current.next = null;
            }
            current = current.next;
        }
        last = lastB;
        this.size--;
        return l.data;
    }

    /**
     * 删除数据节点的某个节点
     * @param data
     */
    public void removeAfter(T data) {
        final Node<T> node = node(data);
        if (node == null) {
            System.out.println("节点不存在，不执行操作.....");
            return;
        }
        if (node.next == null) {
            System.out.println("节点后续节点不存在，不执行操作....");
            return;
        }
        removeAfterNode(node);
    }

    /**
     * 删除某个节点的后续节点
     *      如果此节点为空或者后续节点为空，则不做任何操作
     * @param node
     * @return
     */
    public void removeAfterNode(final Node<T> node) {
//        Node<T> current = first;
//        Node<T> temp = current;
//        while (current != null) {
//            temp = current.next;
//            if (temp.data.equals(node.data)) {
//                break;
//            }
//            current = current.next;
//        }
//        current.next = node.next;
        Node<T> next = node.next;
        node.next = next.next;
        next = null;
        this.size--;
    }

    /**
     * 
     * @param before
     * @param after
     */
    public void intertAfter(T before, T after) {
        final Node<T> beforeNode = node(before);
        final Node<T> afterNode = new Node<T>(after, null);
        if (before== null || after == null) {
            System.out.println("节点存在空,不执行操作....");
            return;
        }
        Node<T> beforeNext = beforeNode.next;
        afterNode.next = beforeNext;
        beforeNode.next = afterNode;
        this.size++;
    }

    public void removeAllKey(T key) {
        Node<T> newFirst = new Node<T>(null, null);
        newFirst.next = first;
        Node<T> current = newFirst;
        int i = 0;
        while (current.next != null) {
            if (current.next.data.equals(key)) {
                current.next = current.next.next;
                i++;
            } else {
                current = current.next;
            }
        }
        this.size = this.size - i;
    }

    /**
     *
     * @return
     */
    public T maxNode() {
        T maxValue = null;
        if (first == null) {
            return null;
        } else {
            maxValue = first.data;
        }

        Node<T> current = first;
        T temp = null;
        while (current != null) {
            temp = current.data;
            if (temp.compareTo(maxValue) > 0) {
                maxValue = temp;
            }
            current = current.next;
        }
        return maxValue;
    }

    /**
     * 采用递归方式查找链表最大节点
     * @param node
     * @return
     */
    public T maxNode(Node<T> node, T maxValue) {
        if (node == null) {
            return maxValue;
        } else {
            T data = node.data;
            if (data.compareTo(maxValue) > 0) {
                maxValue = data;
            }
           return maxNode(node.next, maxValue);
        }
    }

    /**
     *
     * @return
     */
    public boolean isEmpty() {
        return (this.size == 0);
    }

    public Node<T> getFirst() {
        return first;
    }

    public Node<T> getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }

    /**
     * 链表节点
     */
    class Node<T> {
        private T data;
        private Node<T> next;

        /**
         *
         * @param data
         * @param node
         */
        public Node(T data, Node<T> node) {
            this.data = data;
            this.next = next;
        }
    }
}

package com.mmc.data.structure.tableStackQueue.system.linked;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.linked
 * 类 名: SingleLinkedList
 * 描 述: 单链表实现
 * 作 者: GW
 * 创 建： 2017-10-23 15:59
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class SingleLinkedList<T> {

    /**
     * 单向链表
     *
     */

    private int size;
    private Node<T> first;

    /**
     * 链表节点
     * @param <T>
     */
    private static class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 弹出元素
     * @return
     */
    public T poll() {
        final Node<T> f = first;
        T data = null;
        if (f != null) {
            first = f.next;
            f.next = null;
            data = f.data;
            f.data = null;
            size--;
        }

        return data;
    }

    /**
     * 交换两个相邻元素
     * @param index
     */
    public void swap(int index) {
        Node<T> n = node(index);
        if (n == null) {
            System.out.println("交换异常，中止");
            return;
        }
        Node<T> next = n.next;
        if (next == null) {
            System.out.println("尾部元素，向前交换");
            Node<T> n1 =  node(index - 1);
            if (n1 != null) {
                // 查找n1的前一个元素
                Node<T> n2 = node(index - 2);
                if (n2 == null) {
                    n1.next = n.next;
                    n.next = n1;
                } else {
                    n2.next = n;
                    n1.next = n.next;
                    n.next = n1;
                }

            } else {
                System.out.println("交互参数不够，交换失败");
            }
        } else {
           Node<T> pre = node(index - 1);
           if (pre == null) {
               n.next = next.next;
               next.next = n;
           } else {
               pre.next = next;
               n.next = next.next;
               next.next = n;
           }
        }
    }

    /**
     * 不包含则添加元素
     * @param data
     */
    public void putIfAbsract(T data) {
        if (!contain(data)) {
            push(data);
        }
    }

    /**
     *
     * @param data
     */
    public void removeIfAbstract(T data) {
        int position = -1;
        Node<T> current = first;
        boolean isExist = false;
        if (data == null) {
            while (current != null) {
                position++;
                if (current.data == null) {
                    isExist = true;
                    break;
                }
                current = current.next;
            }
        } else {
            while (current != null) {
                position++;
                if (data.equals(current.data)) {
                    isExist = true;
                    break;
                }
                current = current.next;
            }
        }
        if (position >= 0 && isExist) {
            if (position == 0) {
                Node<T> c = first;
                first = first.next;
                c.next = null;
                c.data = null;
            } else {
                Node<T> pre = node(position - 1);
                pre.next = current.next;
                current.next = null;
                current.data = null;
            }
            size--;
        }
    }

    /**
     * 是否包含节点
     * @param data
     * @return
     */
    public boolean contain(T data) {
        return node(data) != null;
    }

    /**
     * 验证节点是否存在
     * @param data
     * @return
     */
    public Node<T> node(T data) {
        Node<T> current = first;
        if (data == null) {
            while (current != null) {
                if (current.data == null) {
                    return current;
                }
                current = current.next;
            }
        } else {
            while (current != null) {
                if (data.equals(current.data)) {
                    return current;
                }
                current = current.next;
            }
        }
        return null;
    }

    /**
     * 获取对应节点
     * @param index
     * @return
     */
    public Node<T> node(int index) {
        if (size < index || index < 0) {
            throw new IllegalArgumentException();
        }
        Node<T> current = first;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * 添加元素
     * @param element
     */
    public void push(T element) {
        final Node<T> f = first;
        final Node<T> newNode = new Node<T>(element, f);
        first = newNode;
        if (f != null) {
            first.next = f;
        }
        size++;
    }

    /**
     * 打印节点
     */
    public void print() {
        StringBuffer sb = new StringBuffer();
        Node<T> current = first;
        sb.append("nodes [");
        int i = 0;
        while (current != null) {
            sb.append(current.data);
            if (i != size - 1) {
                sb.append(", ");
            }
            i++;
            current = current.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public int size() {
        return size;
    }

    /**
     * is empty
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }
}

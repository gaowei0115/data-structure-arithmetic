package com.mmc.data.structure.system.hash.link;

import java.math.BigInteger;

/**
 * @packageName：com.mmc.data.structure.system.hash.link
 * @desrciption:
 * @author: gaowei
 * @date： 2018-08-06 17:34
 * @history: (version) author date desc
 */
public class LinkedHashTable {

    private MyLinkedList<LinkedInfo>[] elements;

    private final static int DEFAULT_SIZE = 100;
    private int size;

    public LinkedHashTable() {
        this(DEFAULT_SIZE);
    }

    public LinkedHashTable(int size) {
        this.size = size;
        this.elements = new MyLinkedList[size];
    }

    public void insert(LinkedInfo info) {
        int hashValue = hashValue(info.key);
        MyLinkedList linkedList = elements[hashValue];
        if (linkedList == null) {
            linkedList = new MyLinkedList();
        }
        linkedList.insert(info);
        elements[hashValue] = linkedList;
    }

    public LinkedInfo find(String key) {
        int hashValue = hashValue(key);
        MyLinkedList<LinkedInfo> linkedList = elements[hashValue];
        if (linkedList != null) {
            return linkedList.get(key);
        }
        return null;
    }


    public void delete(String key) {
        int hashValue = hashValue(key);
        MyLinkedList<LinkedInfo> linkedList = elements[hashValue];
        if (linkedList != null) {
            linkedList.delete(key);
        }
    }

    public int hashValue(String key) {
        BigInteger hashValue = new BigInteger("0");
        BigInteger pow27 = new BigInteger("1");
        int len = key.length();
        for (int i = len - 1; i >= 0; i--) {
            int letter = key.charAt(i) - 96;
            BigInteger letterBig = new BigInteger(String.valueOf(letter));
            hashValue = hashValue.add(letterBig.multiply(pow27));
            pow27 = pow27.multiply(new BigInteger("27"));
        }
        return hashValue.mod(new BigInteger(String.valueOf(size))).intValue();
    }

}

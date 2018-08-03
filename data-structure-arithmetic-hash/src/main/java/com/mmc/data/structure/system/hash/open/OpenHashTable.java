package com.mmc.data.structure.system.hash.open;

import java.math.BigInteger;

/**
 * @packageName：com.mmc.data.structure.system.hash.open
 * @desrciption:
 * @author: gaowei
 * @date： 2018-08-03 15:46
 * @history: (version) author date desc
 */
public class OpenHashTable {

    private OpenHashVo[] elements;
    private int size;
    private static final int DEFAULT_SIZE = 100;

    public OpenHashTable() {
        this(DEFAULT_SIZE);
    }

    public OpenHashTable(int size) {
        this.size = size;
        elements = new OpenHashVo[size];
    }

    public void insert(OpenHashVo info) {
        String key = info.getKey();
        int hash = hash(key);
        OpenHashVo v = elements[hash];
        while (v != null && v.getValue() != null) {
            hash++;
            hash = hash % size;
        }
        elements[hash] = info;
    }

    public OpenHashVo get(String key) {
        int hash = hash(key);
        while (elements[hash] != null) {
            if (key.equals(elements[hash])) {
                break;
            }
            hash++;
            hash = hash % size;
        }
        return elements[hash(key)];
    }


    public OpenHashVo delete(String key) {
        int hash = hash(key);
        OpenHashVo re = null;
        while (elements[hash] != null) {
            if (elements[hash].getKey().equals(key)) {
                re = elements[hash];
                elements[hash] = null;
            }
            hash++;
            hash = hash % size;
        }
        return re;
    }

    public int hash(String key) {
        BigInteger hashValue = new BigInteger("0");
        BigInteger pow27 = new BigInteger("1");
        int len = key.length();
        for (int i = 0; i < len; i++) {
            int letter = key.charAt(i) - 96;
            BigInteger letterBig = new BigInteger(String.valueOf(letter));
            hashValue = hashValue.add(letterBig.multiply(pow27));
            pow27 = pow27.multiply(new BigInteger("27"));
        }
        return hashValue.mod(new BigInteger(String.valueOf(size))).intValue();
    }

    public static void main(String[] args) {
        OpenHashTable openHashTable = new OpenHashTable();
        int hash = openHashTable.hash("abc");
        System.out.println(hash);
    }
}

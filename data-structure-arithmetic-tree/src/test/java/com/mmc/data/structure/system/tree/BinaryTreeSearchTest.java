package com.mmc.data.structure.system.tree;

import com.mmc.data.structure.system.tree.binary.BinaryTreeSearch;

/**
 * @packageName：com.mmc.data.structure.system.tree
 * @desrciption:
 * @author: gaowei
 * @date： 2018-03-01 17:37
 * @history: (version) author date desc
 */
public class BinaryTreeSearchTest {

    public static void main(String[] args) {
        BinaryTreeSearch<Integer> binaryTreeSearch = new BinaryTreeSearch<>();
        binaryTreeSearch.insert(10);
        binaryTreeSearch.insert(12);
        binaryTreeSearch.insert(11);
        binaryTreeSearch.insert(40);
        binaryTreeSearch.insert(30);
        binaryTreeSearch.insert(23);
        binaryTreeSearch.insert(37);
        binaryTreeSearch.insert(8);
        binaryTreeSearch.insert(50);

        System.out.println("min : " + binaryTreeSearch.findMin());
        System.out.println("max : " + binaryTreeSearch.findMax());

        System.out.println("remove: " + binaryTreeSearch.remove(40));
    }
}

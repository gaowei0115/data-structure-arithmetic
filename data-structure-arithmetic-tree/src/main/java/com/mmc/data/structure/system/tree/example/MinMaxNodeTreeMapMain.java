package com.mmc.data.structure.system.tree.example;

/**
 * @packageName：com.mmc.data.structure.system.tree.example
 * @desrciption:
 * @author: gaowei
 * @date： 2018-07-04 15:20
 * @history: (version) author date desc
 */
public class MinMaxNodeTreeMapMain {

    public static void main(String[] args) {

        MinMaxNodeTreeMap<Integer> map = new MinMaxNodeTreeMap<>();

        map.insert(10);
        map.insert(5);
        map.insert(8);
        map.insert(7);
        map.insert(6);
        map.insert(9);
        map.insert(3);
        map.insert(4);
        map.insert(2);
        map.insert(1);

        map.insert(15);
        map.insert(18);
        map.insert(17);
        map.insert(16);
        map.insert(19);
        map.insert(13);
        map.insert(14);
        map.insert(12);
        map.insert(11);
        map.insert(20);


        map.printTree();

        System.out.println("--------------------------------------------------------");

        MinMaxNodeTreeMap.MinMaxNodeTreeMapIterator iterator = (MinMaxNodeTreeMap.MinMaxNodeTreeMapIterator) map.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

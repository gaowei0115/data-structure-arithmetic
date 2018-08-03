package com.structure.arithmetic.api.genericjava4.exam;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.exam
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-07 17:27
 * @history: (version) author date desc
 */
public class GenericSequence<E> {

    private List<E> list = new ArrayList<>();
    private int next = 0;

    public GenericSequence(List<E> list) {
        this.list = list;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(Integer.toString(i));
        }

        GenericSequence<String> gs = new GenericSequence<>(list);
        GenericSequence.SequenceSelector selector = gs.selector();
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
    }

    public void add(E ele) {
        list.add(ele);
    }

    public SequenceSelector selector() {
        return new SequenceSelector();
    }

    class SequenceSelector implements Selector {

        private int i = 0;

        @Override
        public boolean end() {
            return i == list.size();
        }

        @Override
        public Object current() {
            return list.get(i);
        }

        @Override
        public void next() {
            if (i < list.size()) {
                i++;
            }
        }
    }
}

interface Selector {
    boolean end();
    Object current();
    void next();
}

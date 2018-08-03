package com.structure.arithmetic.api.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName：com.structure.arithmetic.api.generic
 * @desrciption: 泛型通配符上界
 * @author: gaowei
 * @date： 2018-06-07 13:46
 * @history: (version) author date desc
 */
public class TopBoundedGeneric {

    public void readBook(List<? extends Book> list) {
        for (Book b : list) {
            b.read();
        }
    }

    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        list.add(new ITBook());
        list.add(new JavaITBook());
        list.add(new HistoryBook());

        new TopBoundedGeneric().readBook(list);
    }
}

interface Book {
    void read();
}

class ITBook implements Book {

    @Override
    public void read() {
        System.out.println("read IT Book ...");
    }
}

class JavaITBook extends ITBook {

    @Override
    public void read() {
        System.out.println("read Java IT Book ...");
    }
}

class HistoryBook implements Book {

    @Override
    public void read() {
        System.out.println("read history Book ...");
    }
}

package com.structure.arithmetic.api.genericjava4.inner;

import com.structure.arithmetic.api.genericjava4.method.Generators;

import java.util.*;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.inner
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-12 16:25
 * @history: (version) author date desc
 */
public class BankTeller {

    public static void serve(Teller teller, Customer c) {
        System.out.println(teller + " servers " + c);
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        Queue<Customer> queue = new LinkedList<>();
        Generators.fill(queue, Customer.generator(), 15);

        List<Teller> list = new ArrayList<>();
        Generators.fill(list, Teller.generator(), 15);

        for (Customer c : queue) {
            serve(list.get(random.nextInt(list.size())), c);
        }
    }
}

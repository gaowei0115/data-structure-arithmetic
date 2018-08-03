package com.structure.arithmetic.api.genericjava4.method;

import java.util.EnumSet;
import java.util.Set;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.method
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-12 14:58
 * @history: (version) author date desc
 */
public class WatercolorSets {

    public static void main(String[] args) {
        Set<Watercolors> set1 = EnumSet.range(Watercolors.BRILLANT_RED, Watercolors.VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(Watercolors.CERULEAN_BLUE_HUE, Watercolors.BURNT_UMBER);
        print("set1: ", set1);
        print("set2: ",  set2);

        System.out.println("-------------------union-----------------------");
        print("union(set1, set2): ", MathSetUtils.union(set1, set2));
        System.out.println("-------------------interSelect-----------------");
        Set<Watercolors> subset = MathSetUtils.interSelect(set1, set2);
        print("interSelect(set1, set2): ", subset);
        System.out.println("-------------------diff1------------------------");
        print("diff(set1, subset): ", MathSetUtils.diff(set1, subset));
        System.out.println("-------------------diff2------------------------");
        print("diff(set2, subset): ", MathSetUtils.diff(set2, subset));
        System.out.println("-------------------complement-------------------");
        print("complement(set1, set2): ", MathSetUtils.complement(set1, set2));
    }

    public static void print(String subfix, Set<Watercolors> sets) {
        System.out.print(subfix + " [ ");

        int i = 0;
        for (Watercolors wc : sets) {
            System.out.print(wc);
            if (i != sets.size() - 1) {
                System.out.print(", ");
            }
            i++;
        }
        System.out.print("]");
        System.out.println();
    }
}

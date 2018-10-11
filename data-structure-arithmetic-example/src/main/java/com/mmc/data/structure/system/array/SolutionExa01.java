package com.mmc.data.structure.system.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName：com.mmc.data.structure.system.array
 * @desrciption:
 * @author: gaowei
 * @date： 2018-09-11 14:29
 * @history: (version) author date desc
 */
public class SolutionExa01 {

    public static void main(String[] args) {
        System.out.print("Entery items : ");
        int[] arraysInt = getInts();
        moveZeroes(arraysInt);

        System.out.print("sort result : [");
        for (int i : arraysInt) {
            System.out.print(i + " ");
        }
        System.out.println("]");
    }


    private static int[] getInts() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String rline = br.readLine();
            String[] arrays = rline.split(",");
            int[] intArrays = new int[arrays.length];
            int i = 0;
            for (String s : arrays) {
                intArrays[i++] = Integer.parseInt(s);
            }
            return intArrays;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void moveZeroes(int[] nums) {
        int countZero = 0;
        int length = nums.length;
        int j = 0;
        for (int i = 0;i < length; i++) {
            int temp = nums[i];
            if (temp == 0) {
                countZero++;
            } else {
                nums[j++] = nums[i];
            }
        }

        // sort
        for (int i = 1; i < length - countZero; i++) {
            for (int k = i; k > 0; k--) {
                int temp = nums[k];
                if (temp < nums[k-1]) {
                    nums[k] = nums[k - 1];
                    nums[k - 1] = temp;
                }
            }
        }

        // add zero
        for (int i = 0; i < countZero; i++) {
            nums[j++] = 0;
        }
    }
}

package com.mmc.data.structure.system.binarySearch;

import java.util.Arrays;

/**
 * @packageName：com.mmc.data.structure.system.binarySearch
 * @desrciption:  给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
                    数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
                    示例:
                    输入:
                    letters = ["c", "f", "j"]
                    target = "a"
                    输出: "c"
                    输入:
                    letters = ["c", "f", "j"]
                    target = "c"
                    输出: "f"
                    输入:
                    letters = ["c", "f", "j"]
                    target = "d"
                    输出: "f"
                    输入:
                    letters = ["c", "f", "j"]
                    target = "g"
                    输出: "j"
                    输入:
                    letters = ["c", "f", "j"]
                    target = "j"
                    输出: "c"
                    输入:
                    letters = ["c", "f", "j"]
                    target = "k"
                    输出: "c"
                    注:
                    letters长度范围在[2, 10000]区间内。
                    letters 仅由小写字母组成，最少包含两个不同的字母。
                    目标字母target 是一个小写字母。
 * @author: gaowei
 * @date： 2018-10-23 10:43
 * @history: (version) author date desc
 */
public class NextGreatestLetter {

    public static void main(String[] args) {
        System.out.println('a' > 'z');

        char[] letters = new char[]{'a', 'e', 'g', 'f', 'j', 'm'};
        letters = new char[]{'c', 'f', 'j'};
//        letters = new char[]{'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n', 'n'};
        char target = 'j';
        char result;
//        char result = nextGreatestLetter(letters, target);
        result = nextGreatesLetterRec(letters, target);
        System.out.println("letters : " + Arrays.toString(letters) + ", target : " + target + " >> result : " + result);



    }


    public static char nextGreatesLetterRec(char[] letters, char target) {
        if (letters == null || letters.length == 0) {
            return '0';
        }

        int start = 0;
        int end = letters.length - 1;
        return nextGreatestLetterRecursion(letters, target, start, end);
    }

    /**
     * 二分递归思想
     * @param letters
     * @param target
     * @param start
     * @param end
     * @return
     */
    public static char nextGreatestLetterRecursion(char[] letters, char target, int start, int end) {
        if (start >= end) {
            return letters[0];
        }

        int mid = start + (end - start) / 2;
        if (letters[mid] == target) {
            if (letters[mid + 1] == target) {
                return nextGreatestLetterRecursion(letters, target, mid + 1, end);
            } else {
                return letters[mid + 1];
            }
        } else if (letters[mid] > target) {
            if (letters[mid - 1] < target) {
                return letters[mid];
            } else {
                return nextGreatestLetterRecursion(letters, target, start, mid);
            }
        } else {
            return nextGreatestLetterRecursion(letters, target, mid + 1, end);
        }
    }

    /**
     * 直接二分查找思想
     * @param letters
     * @param target
     * @return
     */
    public static char nextGreatestLetter(char[] letters, char target) {
        if (letters == null || letters.length == 0) {
            return '0';
        }

        int low = 0;
        int high = letters.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (letters[mid] == target && mid < letters.length - 1) {
                low = mid + 1;
                while (low < letters.length && letters[low] == target) {
                    low++;
                }
                if (low == letters.length) {
                    break;
                }
                return letters[low];
            } else if (letters[mid] > target) {
                for (int i = mid; i >= low; i--) {
                    if (letters[i] <= target) {
                        return letters[i + 1];
                    }
                }
                return letters[low];
            } else {
                low = mid + 1;
            }
        }
        if (low == letters.length) {
            return letters[0];
        }
        return '0';
    }
}

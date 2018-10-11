package com.mmc.data.structure.system.array;

/**
 * @packageName：com.mmc.data.structure.system.array
 * @desrciption: 反转字符串中元音字母
 *                  26字母中元音 a e i o u
 * @author: gaowei
 * @date： 2018-10-11 10:07
 * @history: (version) author date desc
 */
public class ReverseVowels {


    public static void main(String[] args) {
        String s = "Aa";
        System.out.println("before : " + s);
        s = reverseVowels(s);
        System.out.println("after : " + s);
    }

    /**
     *
     * @param s
     */
    public static String reverseVowels(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        while (start < end) {
            char startC = s.charAt(start);
            char endC = s.charAt(end);
            boolean startB = (startC == 'a' || startC == 'e' || startC == 'i' || startC == 'o' || startC == 'u' || startC == 'A' || startC == 'E' || startC == 'I' || startC == 'O' || startC == 'U');
            boolean endB = (endC == 'a' || endC == 'e' || endC == 'i' || endC == 'o' || endC == 'u' || endC == 'u' || endC == 'A' || endC == 'E' || endC == 'I' || endC == 'O' || endC == 'U');

            if (!startB) {
                start++;
                continue;
            }
            if (!endB) {
                end--;
                continue;
            }
            if (start < end) {
                chars[start] = endC;
                chars[end] = startC;
                start++;
                end--;
            }
        }
        return new String(chars);
    }

}

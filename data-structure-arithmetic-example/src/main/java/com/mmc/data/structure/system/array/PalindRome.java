package com.mmc.data.structure.system.array;

/**
 * @packageName：com.mmc.data.structure.system.array
 * @desrciption: 验证回文串
 * @author: gaowei
 * @date： 2018-10-10 17:33
 * @history: (version) author date desc
 */
public class PalindRome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome(s);
        System.out.println("验证回文串结果：" + result);

        System.out.println("---------------------------");
        s = "hello 1 hehe,.*****, hehe:><>] eheheheh 1 olle h";
        result = isPalindrome(s);
        System.out.println("验证回文串结果：" + result);


        System.out.println("---------------------------");
        s = "1Q";
        result = isPalindrome(s);
        System.out.println("验证回文串结果：" + result);


        System.out.println((int)'Z' - (int)'a');
        System.out.println((int)'z'  - (int)'a');
        System.out.println((int)'0');
        System.out.println((int)'P');
    }


    public static boolean isPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char startC = s.charAt(start);
            char endC = s.charAt(end);
            boolean startB = (startC >= 'A' && startC <= 'Z') || (startC >= 'a' && startC <= 'z') || (startC >= '0' && startC <= '9');
            boolean endB = (endC >= 'A' && endC <= 'Z') || (endC >= 'a' && endC <= 'z') || (endC >= '0' && endC <= '9');

            if (startB && endB) {
                int va = startC - endC;
                if (va < 0) {
                    va = endC - startC;
                }
                if ((startC >= 'A' || startC >= 'a') && (endC >= 'A' || endC >= 'a')) {
                    if (va == 0 || va == 32) {
                        start++;
                        end--;
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    if ((startC >= '0' && startC <= '9') && (endC >= '0' && endC <= '9')) {
                        if (va != 0) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }

                start++;
                end--;
            } else {
                if (!startB && endB) {
                    start++;
                } else if (startB && !endB) {
                    end--;
                } else {
                    start++;
                    end--;
                }
            }
        }
        return true;
    }
}

package com.mmc.data.structure.system.binarySearch;

import java.util.Arrays;

/**
 * @packageName：com.mmc.data.structure.system.binarySearch
 * @desrciption:
                寻找重复数
                给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
                示例 1:
                输入: [1,3,4,2,2]
                输出: 2
                示例 2:
                输入: [3,1,3,4,2]
                输出: 3
                说明：
                不能更改原数组（假设数组是只读的）。
                只能使用额外的 O(1) 的空间。
                时间复杂度小于 O(n2) 。
                数组中只有一个重复的数字，但它可能不止重复出现一次。
 * @author: gaowei
 * @date： 2018-10-26 9:40
 * @history: (version) author date desc
 */
public class FindDuplicate {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2, 2};
        nums = new int[]{1,2,4,3,1};
//        nums = new int[]{1,1,3,4,2};
        int re = findDuplicate(nums);
        re = findDoublePointElement(nums);
        System.out.println("nums = " + Arrays.toString(nums) + " duplicate : " + re);
    }

    /**
     *
     * 1, 3, 4, 2, 2
     *
     * 数组组成：有 n + 1 个元素组成，其中存在 n 个不同元素，存在一个元素与其它 n 个元素相同的。
     *
     * 二分查找原理
     题目给了我们一个nums array， 让我们找到其中的重复数字。因为这一题有4个条件，所以有难度。1. 要求我们不能改动array；2. 只能用O(1)空间；3. 时间要小于O(n^2)；4. 只有一个重复的数字，但是它可以出现最少1次。

     　　方法1：O(logn * n)

     　　　　利用binary search。

     　　　　题目给的数字是在 [1, n] 之间， array 的size 是 n+1。所以肯定有一个数字会至少出现2次。

     　　　　分析一下：　　

     　　　　　　如果n 是5，那么就会有1 2 3 4 5 一共5个数字的可能，而array size 是6，那么其中一个数字肯定会至少出现两次。

     　　　　　　如果没有重复的数字，小于等于1的数字 出现的次数 等于 1；

     　　　　　　　　　　　　　　　　小于等于2的数字 出现的次数 等于 2；

     　　　　　　　　　　　　　　　   ... 同理3；4；5。

     　　　　　　如果有重复的数字，如果重复的是1，那么 小于等于1的数字 出现的次数 肯定大于1；

     　　　　　　基于这个理论，我们可以在1 2 3 4 5 选出一个 mid， 遍历array来count 小于等于mid 的数字个数 小于等于 它自己mid 还是 大于 mid？

     　　　　　　　　　　如果count 小于等于mid， 说明 1 到 mid 这些数字 没有重复项， 重复项在 右半边 mid 到n， 所以缩小到右半边继续搜索；

     　　　　　　　　　　如果count 大于mid， 说明  1 到 mid 这些数字中 有重复项，缩小到 左半边继续搜索。
     *
     *
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 2) {
            return nums[0];
        }

        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    /**
     *O(n)，利用slow 和fast 双指针，这个方法太巧妙了，有好几个点比较难理解。
     　　　　利用slow 和 fast 指针，经历两次 相遇，来找到重复的数字。
     　　　　相遇1： slow 一次走一步；fast 一次走两步。
     　　　　　　　　当它们相遇的时候，让slow 保留在相遇的点上。
     　　　　相遇2：让fast 从起点开始走，一次走一步；slow 在上一次相遇的点上开始走，一次走一步。
     　　　　　　　　当它们相遇的时候，相遇的点就是重复的数字。
     如何让slow fast 走步呢，利用slow = nums[slow]; fast = nums[nums[fast]]. 把index 所指的数字值 替换index 来模仿走步数。
     * @param nums
     * @return
     */
    public static int findDoublePointElement(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = 0;

        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

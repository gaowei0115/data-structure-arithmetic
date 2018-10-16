package com.mmc.data.structure.system.binarySearch;

import java.util.Random;

/**
 * @packageName：com.mmc.data.structure.system.binarySearch
 * @desrciption: 猜数字游戏
 * @author: gaowei
 * @date： 2018-10-16 9:49
 * @history: (version) author date desc
 */
public class GuessGame {

    /**
     *
     */
    private volatile int pick;
    /**
     * 随机数
     */
    private Random random = new Random(100);

    public GuessGame() {
        int n = random.nextInt(100);
        while(n == 0) {
            n = random.nextInt(100);
        }
        pick = 1702766719;
    }


    /**
     * 传入数字与种子数比较
     * @param n
     * @return
     *      -1 : 我的数字比较小
            1 : 我的数字比较大
            0 : 恭喜！你猜对了！
     */
    public int getNum(int n) {
        if (n == pick) {
            return 0;
        } else if (n > pick) {
            return 1;
        } else {
            return -1;
        }
    }

    public int getPick() {
        return pick;
    }
}

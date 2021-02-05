package com.github.mo_ink.eoc.utils;

import java.util.Random;

public class RandomCreator {
    /**
     * 生成 0 - end 的 int 型整数
     */
    public static int randomTenth(int end) {
        return (int) (new Random().nextInt(10) / 9.0 * end);
    }
}

package com.github.mo_ink.eoc.utils;

import java.util.Random;

public class RandomCreator {
    public static int randomPrecent(int chance) {
        return (int) (new Random().nextInt(10) / 9.0 * chance);
    }
}

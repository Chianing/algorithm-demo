package com.chianing.test.util;

public class ArrayUtil {

    private static final int[] INT_ARR_SORTED = {1, 3, 4, 5, 7, 9, 11};
    private static final int[] INT_ARR_UNSORTED = {1, 5, 2, 8, 7, 15, 11};

    public static int[] getSortedArr() {
        return INT_ARR_SORTED;
    }

    public static int[] getUnsortedArr() {
        return INT_ARR_UNSORTED;
    }

}

package com.chianing.test.math;

public class Sqrt {

    public static void main(String[] args) {
        System.out.printf("%s get sqrt result is %s%n", 2, getSqrt(2));
        System.out.printf("%s get sqrt result is %s%n", 4, getSqrt(4));
        System.out.printf("%s get sqrt result is %s%n", 8, getSqrt(8));
        System.out.printf("%s get sqrt result is %s%n", 9, getSqrt(9));
    }

    /**
     * 获取一个数的平方根整数位
     */
    public static int getSqrt(int target) {
        if (target < 0) {
            throw new IllegalArgumentException("target must be positive");
        }
        if (target <= 1) {
            return target;
        }

        int start = 0, end = target, mid, result = -1;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (target / mid >= mid) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;

    }
}

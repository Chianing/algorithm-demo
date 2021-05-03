package com.chianing.test.array.search.solution;

/**
 * 二分查找
 */
public class BinarySearchSolution {

    public static int binSearch(int[] arr, int target) {
        if (arr.length == 0 || arr[arr.length - 1] < target) {
            return -1;
        }

        int start = 0, end = arr.length - 1, mid;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;

    }


}

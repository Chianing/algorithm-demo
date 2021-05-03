package com.chianing.test.array.sort.solution;

/**
 * 快排
 * https://segmentfault.com/a/1190000014105591
 */
public class QuickSort {

    public static void sortArr(int[] arr) {
        sortArr(arr, 0, arr.length - 1);
    }

    private static void sortArr(int[] arr, int start, int end) {
        if (arr.length < 2 || start > end) {
            return;
        }

        int startCopy = start;
        int endCopy = end;
        int target = arr[startCopy];

        while (startCopy < endCopy) {
            while (arr[endCopy] > target && startCopy < endCopy) {
                endCopy--;
            }
            if (startCopy < endCopy) {
                arr[startCopy] = arr[endCopy];
                startCopy++;
            }
            while (arr[startCopy] < target && startCopy < endCopy) {
                startCopy++;
            }
            if (startCopy < endCopy) {
                arr[endCopy] = arr[startCopy];
                endCopy--;
            }
        }
        arr[startCopy] = target;

        sortArr(arr, start, startCopy - 1);
        sortArr(arr, startCopy + 1, end);

    }

}

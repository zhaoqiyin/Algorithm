package class01;

import java.util.Arrays;

/**
 * 插入排序 时间复杂度最差情况O(N^2) 最好情况复杂度为O(N) 空间复杂度为O(1) 具有稳定性
 */
public class Code03_InsertionSort {
//    public static void main(String[] args) {
//        int[] arr = {1,2,9,3,5,6,4,7,8};
//        insertionSort(arr);
//        for (int i: arr) {
//            System.out.print(i + " ");
//        }
//    }

    private static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0~0 有序的
        // 0～i 想有序
        for(int i = 1; i < arr.length; i++) { // 0 ～ i 做到有序
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j --) {
                swap(arr, j , j + 1);
            }
        }
    }

    // 交换arr的i和j位置上的值 这个方法执行的前提是i位置一定不等于j位置
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j]; // 异或 还可以理解为无进。位相加
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random() -> [0,1) 所有的小数，等概率返回一个
        // Math.random() -> [0,N) 所有小数，等概率返回一个
        // (int)(Math.random() -> [0,N)) -> [0,N-1] 所有小数，等概率返回一个

        int[] arr = new int[(int)((maxSize + 1) * Math.random())]; // 长度随机
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random() - maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            insertionSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                // 打印arr1
                // 打印arr2
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        insertionSort(arr);
        printArray(arr);
    }
}

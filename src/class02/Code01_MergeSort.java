package class02;

import java.util.Arrays;

// 归并排序
public class Code01_MergeSort {
    public static void main(String[] args) {
        int[] arr = {1,2,9,3,5,6,4,7,8};
        mergeSort(arr);
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1]; // 辅助空间
        int i = 0;
        int p1 = L;
        int p2 = M + 1; // 右侧的数组是从M+1开始的
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }

    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

}

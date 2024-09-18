package class02;

/**
 * 小和问题
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。
 */
public class Code02_SmallSum {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        System.out.println(mergeSort(arr));
    }

    public static int mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    // arr[L..R]既要排好序，也要求小和
    private static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return process(arr, L, mid) + // 左侧小和的数量
        process(arr, mid + 1, R)+ // 右侧小和的数量
        merge(arr, L, mid, R); // merge过程中产生小和的数量
    }

    private static int merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1]; // 辅助空间
        int i = 0;
        int p1 = L;
        int p2 = M + 1; // 右侧的数组是从M+1开始的
        int res = 0;
        while (p1 <= M && p2 <= R) {
            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
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
        return res;
    }
}

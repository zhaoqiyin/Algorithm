package class01;

/**
 * 冒泡排序 时间复杂度O(N^2) 空间复杂度O(1) 具有稳定性
 */
public class Code02_BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,2,9,3,5,6,4,7,8};
        bubbleSort(arr);
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }

    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e >0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    // 交换arr的i和j位置上的值 这个方法执行的前提是i位置一定不等于j位置
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j]; // 异或 还可以理解为无进。位相加
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}

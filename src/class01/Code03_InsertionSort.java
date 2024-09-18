package class01;

/**
 * 插入排序 时间复杂度最差情况O(N^2) 最好情况复杂度为O(N) 空间复杂度为O(1) 具有稳定性
 */
public class Code03_InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1,2,9,3,5,6,4,7,8};
        insertionSort(arr);
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }

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
}

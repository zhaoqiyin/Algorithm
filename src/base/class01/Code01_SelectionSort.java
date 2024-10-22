package base.class01;

/**
 * 选择排序 时间复杂度O(N^2) 空间复杂度O(1) 不具有稳定性
 */
public class Code01_SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1,2,9,3,5,6,4,7,8};
        selectionSort(arr);
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }

    private static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) { // i ~ N - 1
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) { // i ~ N - 1 上最小值的下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int L, int R) {
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }
}

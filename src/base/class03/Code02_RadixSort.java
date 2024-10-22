package base.class03;

/**
 * 基数排序
 */
public class Code02_RadixSort {
    
    // only for no-negative value
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxBit(arr));
    }
    
    public static int maxBit(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    // arr[begin..end]排序
    public static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        // 有多少个数准备多少个辅助空间，  一般对数组进行全排序，那就是准备跟arr一样长的空间
        int[] bucket = new int[R - L + 1];
        for (int d = 1; d < digit; d++) { // 有多少位就进出几次
            // 10个空间 因为radix是写死的十进制
            // count[0] 当前位（d位）是0的数字有多少个
            // count[1] 当前位（d位）是（0和1）的数字有多少个
            // count[2] 当前位（d位）是（0、1和2）的数字有多少个
            // count[i] 当前位（d位）是（0～i）的数字有多少个
            int[] count = new int[radix];
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = L, j = 0; j <= R; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    public static int getDigit(int x, int d) {
        // pow幂次方函数，10的d-1次方
        return ((x / ((int)Math.pow(10, d - 1))) % 10);
    }
}

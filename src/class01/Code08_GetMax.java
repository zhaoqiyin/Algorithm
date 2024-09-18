package class01;

public class Code08_GetMax {
    public static void main(String[] args) {
        int[] arr = {1,2,9,3,5,6,4,7,8};
        int result = getMax(arr);
        System.out.println(result);
    }

    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    // arr[L..R]范围上求最大值
    private static int process(int[]arr, int L, int R) {
        if (L == R) { // arr[L..R]范围上只有一个树，直接返回，base case
            return arr[L];
        }
        int mid = L + ((R - L) >> 1); // 中点 右移一位等于除2
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
}

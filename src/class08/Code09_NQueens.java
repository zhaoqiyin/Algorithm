package class08;

/**
 * N皇后问题是指在N*N的棋盘上要摆N个皇后，要求任何两个皇后不同行、不同列，
 * 也不在同一条斜线上。
 * 给定一个数n，返回n皇后的摆法有多少种。
 * n=1，返回1.
 * n = 2或者3，2皇后和3皇后问题无论怎么摆都不行，返回0
 * n=8，返回92
 */
public class Code09_NQueens {

    public static int num1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n]; // record[i] -> i行的皇后，放在了第几列
        return process1(0, record, n);
    }

    // 潜台词：record[0..i-1]的皇后，任何两个皇后一定不共行、不共列、不共斜线
    // i表示来到了第几行
    // record[0..i-1]表示之前的行，放过的皇后位置
    // n表示整体一共有多少行
    // 返回值是，摆完所有的皇后，合理的摆法有多少种
    public static int process1(int i, int[] record, int n) {
        if (i == n) { // 终止行，最后一行在往下一行的位置
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) { // 当前行在i行，尝试i行所有的列 -> j
            // 当前i行的皇后，放在j列，会不会和之前（0..i-1）的皇后，共行共列或者共斜线
            // 如果是，认为有效
            // 如果不是，认为无效
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    // record[0..i-1]你需要看，record[i...]不需要看
    // 返回i行皇后，放在了j列，是否有效
    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) { // 之前的某个k行的皇后
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    // 请不要超过32皇后问题
    public static int num2(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit, 0, 0 ,0);
    }

    // colLim 列的限制，1的位置不能放皇后，0的位置可以
    // leftDiaLim 左斜线的限制，1的位置不能放皇后，0的位置可以
    // rightDiaLim 右斜线的限制，1的位置不能放皇后，0的位置可以
    public static int process2(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == limit) {
            return 1;
        }
        int pos = 0;
        int mostRightOne = 0;

        // 所有候选皇后的位置，都在pos上
        pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int res = 0;
        while (pos != 0) {
            // 把一个二进制数中最右侧的数提取出来 <<< 右移
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process2(limit, colLim | mostRightOne, (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }



    public static void main(String[] args) {
        int n = 14;
        long start = System.currentTimeMillis();
        System.out.println(num2(n));
        long end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println(num1(n));
        end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + "ms");
    }
}

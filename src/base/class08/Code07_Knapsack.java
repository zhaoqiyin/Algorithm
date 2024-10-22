package base.class08;

/**
 * 给定两个长度都为N的数组weights和values，weights[i]和values[i]分别代表i号物品的重量和价值。给定一个正数bag，
 * 表示一个载重bag的袋子，你装的物品不能超过这个重量。返回你能装下最多的价值是多少？
 */
public class Code07_Knapsack {

    public static int maxValue1(int[] weights, int[] values, int bag) {
        return process1(weights, values, 0 ,0, bag);
    }

    // i... 的货物自由选择，形成的最大价值返回
    // 重量永远不要超过bag
    // 之前做的决定，所达到的重量，alreadyweight
    public static int process1(int[] weights, int[] values, int i, int alreadyweight, int bag) {
        if (alreadyweight > bag) {
            return 0;
        }
        if (i == weights.length) {
            return 0;
        }
        return Math.max(process1(weights, values, i + 1, alreadyweight, bag),

                values[i] + process1(weights, values, i + 1, alreadyweight + weights[i], bag));
    }

    public static int maxValues2(int[] c, int[] p, int bag) {
        int[][] dp = new int[c.length + 1][bag + 1];
        for (int i = c.length - 1; i >= 0; i--) {
            for (int j = bag; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + c[i] <= bag) {
                    dp[i][j] = Math.max(dp[i][j], p[i] + dp[i + 1][j + c[i]]);
                }
            }
        }
        return dp[0][0];
    }

}

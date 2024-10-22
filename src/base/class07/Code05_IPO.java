package base.class07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入：
 * 正数数组costs
 * 正数数组profits
 * 正数k
 * 正数m
 * 含义：
 * cost[i]表示i号项目的花费
 * profits[i]表示i号项目在扣除花费之后还能挣到的钱（利润）
 * k表示你只能串行的最多坐k个项目
 * m表示你初始的资金
 * 说明：
 * 你没做完一个项目，马上获得的收益，可以支持你去做下一个项目
 * 输出：
 * 你最后获得的最大钱数
 */
public class Code05_IPO {

    public static class Node {
        public int p; // 利润
        public int c; // 花费

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    public static class MaxCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }

    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxCostComparator());

        // 所有项目扔到被锁池中，花费组织的小根堆
        for (int i = 0; i < Profits.length; i++) {
            minCostQ.add(new Node(Profits[i], Capital[i]));
        }

        for (int i = 0; i < k; i++) { // 进行K轮
            // 能力所及的项目，全解锁
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return W;
            }
            W += maxProfitQ.poll().p;
        }

        return W;
    }
}

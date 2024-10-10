package class06;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 最小生成数 prim算法
 * 适用范围：要求无向图
 * 先任意选出一个点A，然后找到最小的边对应的点B，B放入A的集合中，然后在这个点B所对应的边和之前的边中在找一个最新的值C，看有没有在集合里，
 * 没有就加入集合，再找最小的边，依次类推
 */
public class Code05_Prim {

    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> primMST(Graph graph) {

        // 解锁的边进入小根堆
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());

        HashSet<Node> set = new HashSet<>();

        Set<Edge> result = new HashSet<>(); // 依次挑选的边在result里

        // 如果整个图都是连通的，可以省略掉这个for循环
        for (Node node : graph.nodes.values()) { // 随便挑了一个点
            // node 是开始点
            if (!set.contains(node)) {
                set.add(node);
                for (Edge edge : node.edges) { // 由一个点，解锁所有相连的边
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll(); // 弹出解锁的边中，最小的边
                    Node toNode = edge.to; // 可能的一个新的点
                    if (!set.contains(toNode)) { // 不含有的时候，就是新的点
                        set.add(toNode);
                        result.add(edge);
                        for (Edge nextEdge : toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return result;
    }
}

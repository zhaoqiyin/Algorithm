package class06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Dijkstra算法
 * 适用范围：不能有权值累加和为负数的环
 *
 * 改进后的Dijkstra算法可以实现一个小根堆，然后修改值后，再变成小根堆，这个时候需要自己手动实现小根堆，不能用系统实现的小根堆
 * 因为系统实现的小根堆只能添加和弹出，不能改变一个值然后弹出
 */
public class Code06_Dijkstra {

    public static HashMap<Node, Integer> dijkstra1(Node head) {
        // 从head出发到所有点的最小距离
        // key: 从head出发到达key
        // value: 从head出发到达key的最小距离
        // 如果在表中，没有T的记录，含义是从head出发到T这个点的距离为正无穷
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        // 已经求过距离的节点，存在selectedNodes中，以后再也不碰
        HashSet<Node> selectedNodes = new HashSet<>();
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                }
                distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> touchedNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!touchedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }


}

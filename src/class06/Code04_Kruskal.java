package class06;

import java.util.*;

/**
 * 最小生成数 K算法
 * 从最小的边开始考虑，每加一次最小的边，看有没有形成环，没有，就加，有环就跳过
 * 如何判断形成环，可以先把所有的点单独看成一个集合，如果节点A所在的集合并不在节点B所在的集合中，则节点A与节点B并没有形成环,
 * 然后把节点A所在的集合与节点B所在的集合合并成一个集合
 * undirected graph only
 */
public class Code04_Kruskal {

    public static class MySets {
        public HashMap<Node, List<Node>> setMap;

        public MySets(List<Node> nodes) {
            for (Node cur : nodes) {
                List<Node> set = new ArrayList<>();
                set.add(cur);
                setMap.put(cur, set);
            }
        }

        public boolean isSameSet(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        // 把from所在的集合与to所在的集合合并成一个集合
        public void union(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            // 把to中所有的node都加到from中
            for (Node toNode : toSet) {
                fromSet.add(toNode);
                setMap.put(toNode, fromSet);
            }
        }
    }


    // Union-Find Set 并查集结构
    public static class UnionFind {
        // key 某一个节点，value key节点往上的节点
        private HashMap<Node, Node> fatherMap;
        // key 某一个集合的代表节点，vale key所在集合的节点个数
        private HashMap<Node, Integer> sizeMap;

        public UnionFind() {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }

        public void makeSets(Collection<Node> nodes) {
            fatherMap.clear();
            sizeMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        private Node findFather(Node n) {
            Stack<Node> path = new Stack<>();
            while (n != fatherMap.get(n)) {
                path.add(n);
                n = fatherMap.get(n);
            }
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), n);
            }
            return n;
        }

        public boolean isSameSet(Node a, Node b) {
            return findFather(a) == findFather(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aDai = findFather(a);
            Node bDai = findFather(b);
            if (aDai != bDai) {
                int aSetSize = sizeMap.get(aDai);
                int bSetSize = sizeMap.get(bDai);
                if (aSetSize <= bSetSize) {
                    fatherMap.put(aDai, bDai);
                    sizeMap.put(bDai, aSetSize + bSetSize);
                    sizeMap.remove(aDai);
                } else {
                    fatherMap.put(bDai, aDai);
                    sizeMap.put(aDai, aSetSize + bSetSize);
                    sizeMap.remove(bDai);
                }
            }
        }
    }

    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> kruskalMST(Graph graph) {
        UnionFind unionFind = new UnionFind();
        unionFind.makeSets(graph.nodes.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for (Edge edge : graph.edges) { // M 条边
            priorityQueue.add(edge); // O(logM)
        }
        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()) { // M 条边
            Edge edge = priorityQueue.poll(); // O(logM)
            if (!unionFind.isSameSet(edge.from, edge.to)) { // O(1)
                result.add(edge);
                unionFind.union(edge.from, edge.to);
            }
        }
        return result;
    }
}

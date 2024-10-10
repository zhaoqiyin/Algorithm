package class06;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    public HashMap<Integer, Node> nodes; // 点集 key是点的编号，value是实际的点
    public HashSet<Edge> edges; // 边集

    public Graph() {
        this.nodes = new HashMap<Integer, Node>();
        this.edges = new HashSet<Edge>();
    }
}

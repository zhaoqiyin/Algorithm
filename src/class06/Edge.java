package class06;

public class Edge {
    public int weight; // 权值 常见的算法是距离的意思
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}

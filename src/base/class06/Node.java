package base.class06;

import java.util.ArrayList;

public class Node {
    public int value;
    public int in; // 入度 有多少个点指向它
    public int out; // 出度 它指向多少个点
    public ArrayList<Node> nexts; // 发散出去的点有哪些，即它的直接邻居
    public ArrayList<Edge> edges; // 发散出去对应的边

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}

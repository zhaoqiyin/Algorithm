package class05;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定两个二叉树的节点node1和node2，找到他们的最低公共祖先节点
 *
 * 两种情况：
 * 1. o1是o2的LCA，或o2是o1的LCA
 * 2. o1与o2不互为LCA，向上汇聚才找到LCA
 */
public class Code07_LowestCommonAncestor {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node lca(Node head, Node o1, Node o2) {
        HashMap<Node, Node> fatherMap = new HashMap<>();
        fatherMap.put(head, head);
        process(head, fatherMap);
        HashSet<Node> set1 = new HashSet<>();

        Node cur = o1;
        // 只有头节点的fatherMap彩视自己
        while (cur != fatherMap.get(cur)) {
            set1.add(cur);
            cur = fatherMap.get(cur);
        }
        set1.add(head);
        Node cur2 = o2;
        while (cur2 != fatherMap.get(cur2)) {
            if (set1.contains(cur2)) {
                return cur2;
            }
            cur2 = fatherMap.get(cur2);
        }
        return head;
    }

    public static void process(Node head, HashMap<Node, Node> fatherMap) {
        if (head == null) {
            return;
        }
        fatherMap.put(head.left, head);
        fatherMap.put(head.right, head);
        process(head.left, fatherMap);
        process(head.right, fatherMap);
    }

    // o1 o2一定属于head为头的树
    public static Node lowestAncestor(Node head, Node o1, Node o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }

        Node left = lowestAncestor(head.left, o1, o2);
        Node right = lowestAncestor(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }
}

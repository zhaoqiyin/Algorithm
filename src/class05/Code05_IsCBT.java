package class05;

import java.util.LinkedList;

/**
 * 是否是完全二叉树
 * 判断方法： 宽度优先遍历
 * 1. 任一节点有右无左，直接返回false
 * 2. 在1）不违规情况下，如果遇到了第一个左右子子树不全的情况，后续节点必须都为叶节点，
 * 否则不是完全二叉树
 * complete binary tree
 */
public class Code05_IsCBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        // 是否遇到到左右两个孩子不双全的节点
        boolean leaf = false;
        Node left = null;
        Node right = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            left = head.left;
            right = head.right;
            if (
                    // 如果遇到了不双全的节点之后，又发现当前及节点居然有孩子
                    (leaf && (left != null || right != null)) ||
                    (left == null && right != null)) {
                return false;
            }
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            if (left == null && right == null) {
                leaf = true;
            }
        }
        return true;
    }
}

package class05;

import java.util.Stack;

/**
 * 测试是否是搜索二叉树 方法：中序遍历升序
 */
public class TestBST {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int preValue = Integer.MIN_VALUE;

    public static boolean checkBST(Node head) {
        if (head == null) {
            return true;
        }
        boolean isLeftBst = checkBST(head.left);
        if (!isLeftBst) {
            return false;
        }
        // 左树是搜索二叉树的情况下，如果左树的最大值比根节点大，false，否则，根节点就成了新的最大值，再用这个值判断右树
        if (head.value <= preValue) {
            return false;
        } else {
            preValue = head.value;
        }
        return checkBST(head.right);
    }

    public static boolean checkBST2(Node head) {
        if (head != null) {
            int preValue = Integer.MIN_VALUE;
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    if (head.value <= preValue) {
                        return false;
                    } else {
                        preValue = head.value;
                    }
                    head = head.right;
                }
            }
        }
        return true;
    }
}

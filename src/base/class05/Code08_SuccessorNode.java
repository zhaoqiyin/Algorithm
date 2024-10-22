package base.class05;

/**
 * 在二叉树中找到一个节点的后继节点
 *
 * 在二叉树的中序遍历的序列中，node的下一个节点叫做node的后继节点。
 * 假设每一个节点都可以指向自己的父节点。
 *
 * 解法：
 * 1. x有右树的时候，后继节点是右树上的最左节点
 * 2. x无右树，往上看，是不是父节点的左子树，不是，接着往上找，如果是，该父节点就是后继节点，最后一个节点的后继节点是空
 */
public class Code08_SuccessorNode {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return getLeftMost(node.right);
        } else { // 无右子树
            Node parent = node.parent;
            while (parent != null && parent.left != node) { // 当前节点是其父亲节点的右孩子
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}

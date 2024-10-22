package base.class05;

/**
 * 是否是平衡二叉树
 * 方法：
 * 1. 左子树是平衡二叉树
 * 2. 右子树是平衡二叉树
 * 3. 左右子树的高度差不超过1
 */
public class Code06_IsBalancedTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // 是否是满二叉树
    public static boolean isFull(Node head) {
        ReturnData allInfo = p(head);
        return ( 1 << allInfo.height - 1) == allInfo.nums;
    }

    public static ReturnData p(Node x) {
        if (x == null) {
            return new ReturnData(0, 0);
        }
        ReturnData leftData = p(x.left);
        ReturnData rightData = p(x.right);

        int height = Math.max(leftData.height, rightData.height) + 1;

        int nums = leftData.nums + rightData.nums + 1;
        return new ReturnData(height, nums);
    }

    public static class ReturnData {
        public int height;
        public int nums;

        public ReturnData(int height, int nums) {
            this.height = height;
            this.nums = nums;
        }
    }

    public static boolean isBalanced(Node head) {
        return process(head).isBalanced;
    }

    public static class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static ReturnType process(Node x) {
        if (x == null) {
            return new ReturnType(true, 0);
        }
        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);

        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced &&
                Math.abs(leftData.height - rightData.height) < 2;
        return new ReturnType(isBalanced, height);
    }
}

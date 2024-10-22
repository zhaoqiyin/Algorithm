package base.class05;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 求一颗二叉树的最大宽度
 * 宽度优先遍历
 * 有一个不需要Hash表的方法，利用双指针curEnd, nextEnd
 * 第一个入队列的根节点，既是curEnd,也是nextEnd
 * 在每次入队列时，记录下最后一个入队列的点是nextEnd，
 * 出队列时，记录着一层的个数，再与最大值比较得出最大值，如果遇到curEnd，这一层结束
 * 然后，将nextEnd值赋给curEnd, nextEnd = null
 */
public class Code03_TreeMaxWidth {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // 宽度优先遍历
    public static int widthTraversalAndMaxWidth(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        HashMap<Node, Integer> levelMap = new HashMap<>(); // 记录每一个节点所在的层数
        levelMap.put(head, 1);
        int curLevel = 1;
        int curLevelNodeNum = 0; // 当前层级的节点数
        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if (curNodeLevel == curLevel) {
                curLevelNodeNum++;
            } else {
                max = Math.max(max, curLevelNodeNum);
                curLevel++;
                curLevelNodeNum = 1;
            }
            System.out.println(cur.value);
            if (cur.left != null) {
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }
        }
        return max;
    }


}

package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode02_twoPlus {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseListNode(ListNode node) {
        ListNode head = null;

        // 首先链表逆序
        while (node != null) {
            ListNode temp = node.next;
            node.next = head;
            head = node;
            node = temp;
        }
        return head;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(9, new ListNode(9));
//
//        ListNode l2 = new ListNode(9);
//        l2.next = new ListNode(6, new ListNode(4));

        List<Integer> list1 = List.of(6);
        List<Integer> list2 = List.of(9, 9, 9);
        int size1 = list1.size();
        int size2 = list2.size();
        int size = 0;
        boolean list1Big = false;
        if (size1 < size2) {
            size = size1;
            list1Big = false;
        } else {
            list1Big = true;
        }

        List<Integer> list = new ArrayList<>();
        int jinWei = 0;
        // 如果list1位数多
        if (list1Big) {
            for (int i = 0; i < size2; i++) {
                int sum = list1.get(i) + list2.get(i) + jinWei;
                if (sum >= 10) {
                    sum = sum % 10;
                    jinWei = 1;
                } else {
                    jinWei = 0;
                }
                list.add(sum);
            }
            for (int i = size2; i < size1; i++) {
                int sum = list1.get(i) + jinWei;
                if (sum >= 10) {
                    sum = sum % 10;
                    jinWei = 1;
                } else {
                    jinWei = 0;
                }
                list.add(sum);
            }
        } else {
            for (int i = 0; i < size1; i++) {
                int sum = list1.get(i) + list2.get(i) + jinWei;
                if (sum >= 10) {
                    sum = sum % 10;
                    jinWei = 1;
                } else {
                    jinWei = 0;
                }
                list.add(sum);
            }
            for (int i = size1; i < size2; i++) {
                int sum = list2.get(i) + jinWei;
                if (sum >= 10) {
                    sum = sum % 10;
                    jinWei = 1;
                } else {
                    jinWei = 0;
                }
                list.add(sum);
            }
        }

        if (jinWei > 0) {
            list.add(jinWei);
        }

        System.out.println(list);

        ListNode node = null;
        for (Integer integer : list) {
            ListNode temp = new ListNode(integer);
            temp.next = node;
            node = temp;
        }
        node = reverseListNode(node);


        System.out.println(node.val);
        while (node.next != null) {
            System.out.println(node.next.val);
            node = node.next;
        }

//        System.out.println(list1);
//
//        l1 = reverseListNode(l1);










//        System.out.println(l1.val);
//
//        while (l1.next != null) {
//            System.out.println(l1.next.val);
//            l1 = l1.next;
//        }
//
//        l2 = reverseListNode(l2);
//        int num2 = l2.val;
//
//        System.out.println(l2.val);
//        while (l2.next != null) {
//            num2 = num2 * 10 + l2.next.val;
//            System.out.println(l2.next.val);
//            l2 = l2.next;
//        }
//        System.out.println(num2);
//        int num = num1 + num2;
//        System.out.println(num);
//
//        ListNode node = null;
////        if (num == 0) {
////            return new ListNode(0);
////        }
//        while (num > 0) {
//            ListNode temp = new ListNode(num % 10);
//            temp.next = node;
//            node = temp;
//            num = num / 10;
//        }
//        if (node != null) {
//            System.out.println(node.val);
//            while (node.next != null) {
//                System.out.println(node.next.val);
//                node = node.next;
//            }
//        }


    }
}

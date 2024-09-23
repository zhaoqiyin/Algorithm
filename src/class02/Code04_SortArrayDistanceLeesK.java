package class02;

import java.util.PriorityQueue;

/**
 * 堆排序扩展题目
 * 已知一个几乎有序的数组，几乎与有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k
 * 并且k相对于数组来说比较小。请选择一个合适的排序算法针对这个数据进行排序
 */
public class Code04_SortArrayDistanceLeesK {

    public static void sortedArrDistanceLessK(int[] arr, int k) {
        // 默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (; index <= Math.min(arr.length - 1, k); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }

    public static void main(String[] args) {

    }
}
